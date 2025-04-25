/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.daoImplementaciones.*;
import modelo.daoInterfaces.*;
import modelo.dominio.*;
import modelo.nodos.*;
import vistas.PrestamosDevoluciones;

/**
 *
 * @author Mi PC
 */
public class ControladorPrestamosDevoluciones implements ActionListener{
    
    private PrestamosDevoluciones prestamosDevoluciones;

    DAOListaLibros listaLibros = DAOListLibrosImpl.getListaLibros();
    DAOListaPersonas listaPersona = DAOListPersonasImpl.getListaPersonas();
    DAOListaPrestamos listaPrestamos = DAOListPrestamosImpl.getListaPrestamos();

    public ControladorPrestamosDevoluciones(PrestamosDevoluciones prestamosDevoluciones){
        this.prestamosDevoluciones = prestamosDevoluciones;

        this.prestamosDevoluciones.getBtn_prestar().addActionListener(this);
        this.prestamosDevoluciones.getBtn_devolver().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource() == prestamosDevoluciones.getBtn_prestar()){
            prestar();
        }else{
            if(evento.getSource() == prestamosDevoluciones.getBtn_devolver()){
                devolver();
            }
        }
    }

    private void guardarInfoPrestamos(NodoPrestamos nodo){
        int codigoPrestamo = Integer.parseInt(prestamosDevoluciones.getTxt_codigoPrestamo().getText());
        int idUsuario = Integer.parseInt(prestamosDevoluciones.getTxt_idUsuario().getText());
        int codigoLibro = Integer.parseInt(prestamosDevoluciones.getTxt_codigoLibro().getText());
        LocalDate fechaPrestamo = LocalDate.now(); //Se obtiene la fecha en la que se realiza el prestamo
        
        Prestamos prestamos = new Prestamos();
        prestamos.setIdPersona(idUsuario);
        prestamos.setIdLibro(codigoLibro);
        prestamos.setCodigo(codigoPrestamo);
        prestamos.setFechaPrestamos(fechaPrestamo);
        prestamos.setActivo(true);

        nodo.setPrestamos(prestamos);
    }

    private void prestar(){
        try {
            int idUsuario = Integer.parseInt(prestamosDevoluciones.getTxt_idUsuario().getText());
            int codigoLibro = Integer.parseInt(prestamosDevoluciones.getTxt_codigoLibro().getText());

            //Instancia de los Nodos
            NodoPersonas nodoPersonas = listaPersona.buscar(idUsuario);
            NodoLibros nodoLibros = listaLibros.buscarPorCodigo(codigoLibro);
            NodoPrestamos nodoPrestamos;
            NodoPrestamos nodoVerificar = listaPrestamos.buscarPrestamos(codigoLibro, idUsuario);
            
            if(nodoVerificar != null){
                if(nodoVerificar.getPrestamos().getActivo() == true){
                    JOptionPane.showMessageDialog(null, "Ya se encontro este prestamos activo para este usuario", null, JOptionPane.ERROR_MESSAGE);
                }else{
                    if (nodoPersonas != null && nodoLibros != null) {
                        int cantLibros = nodoLibros.getLibros().getCantidad();
        
                        if(cantLibros > 0){
                            nodoPrestamos = new NodoPrestamos();
                            int nuevaCantidad;
        
                            guardarInfoPrestamos(nodoPrestamos);
                            listaPrestamos.agregarNodo(nodoPrestamos);
        
                            nuevaCantidad = cantLibros - 1;
                            nodoLibros.getLibros().setCantidad(nuevaCantidad);
        
                            JOptionPane.showMessageDialog(null, "Se ha realizado el prestamo del libro " + nodoLibros.getLibros().getTitulo() + " al usuario " + nodoPersonas.getPersona().getNombre(), null, JOptionPane.INFORMATION_MESSAGE);
        
                            prestamosDevoluciones.limpiarCampos();
                        }else{
                            JOptionPane.showMessageDialog(null, "Este libro no esta disponible para prestar, Espere que otro usuario lo devuelva", null, JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro el usuario con esta identificacion o el libro con ese codigo", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }else{
                if (nodoPersonas != null && nodoLibros != null) {
                    int cantLibros = nodoLibros.getLibros().getCantidad();

                    if(cantLibros > 0){
                        nodoPrestamos = new NodoPrestamos();
                        int nuevaCantidad;

                        guardarInfoPrestamos(nodoPrestamos);
                        listaPrestamos.agregarNodo(nodoPrestamos);

                        nuevaCantidad = cantLibros - 1;
                        nodoLibros.getLibros().setCantidad(nuevaCantidad);

                        JOptionPane.showMessageDialog(null, "Se ha realizado el prestamo del libro " + nodoLibros.getLibros().getTitulo() + " al usuario " + nodoPersonas.getPersona().getNombre(), null, JOptionPane.INFORMATION_MESSAGE);

                        prestamosDevoluciones.limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(null, "Este libro no esta disponible para prestar, Espere que otro usuario lo devuelva", null, JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro el usuario con esta identificacion o el libro con ese codigo", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar realizar este prestamo", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void devolver(){
        try {
            int codigoLibro = Integer.parseInt(prestamosDevoluciones.getTxt_codigoLibro().getText());
            int idUsuario = Integer.parseInt(prestamosDevoluciones.getTxt_idUsuario().getText());

            NodoPersonas nodoPersonas = listaPersona.buscar(idUsuario);
            NodoLibros nodoLibros = listaLibros.buscarPorCodigo(codigoLibro);
            NodoPrestamos nodoPrestamos = listaPrestamos.buscarPrestamos(codigoLibro, idUsuario);

            if(nodoPrestamos != null && nodoPrestamos.getPrestamos().getActivo() == true){
                nodoPrestamos.getPrestamos().setActivo(false);

                int cantidad = nodoLibros.getLibros().getCantidad();
                nodoLibros.getLibros().setCantidad(cantidad + 1);

                JOptionPane.showMessageDialog(null, "Se ha devuelto el libro " + nodoLibros.getLibros().getTitulo() + "\nque se encontraba en posesion del usuario " + nodoPersonas.getPersona().getNombre(), null, JOptionPane.INFORMATION_MESSAGE);

                prestamosDevoluciones.limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el prestamo de este libro, por favor verifique la informacion(codigo del libro, y el id del usuario)", null, JOptionPane.ERROR_MESSAGE);
                prestamosDevoluciones.getTxt_idUsuario().grabFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar realizar esta devolucion", null, JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
