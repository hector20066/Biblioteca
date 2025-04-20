/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.*;
import vistas.PrestamosDevoluciones;

/**
 *
 * @author Mi PC
 */
public class ControladorPrestamosDevoluciones implements ActionListener{
    
    private PrestamosDevoluciones prestamosDevoluciones;

    ListaLibros listaLibros = ListaLibros.getListaLibros();
    ListaPersona listaPersona = ListaPersona.getListaPersona();
    ListaPrestamos listaPrestamos = ListaPrestamos.getPrestamos();

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

    private void prestar(){
        try {
            int codigoPrestamo = Integer.parseInt(prestamosDevoluciones.getTxt_codigoPrestamo().getText());
            int idUsuario = Integer.parseInt(prestamosDevoluciones.getTxt_idUsuario().getText());
            int codigoLibro = Integer.parseInt(prestamosDevoluciones.getTxt_codigoLibro().getText());

            //Instancia de los Nodos
            NodoPersonas nodoPersonas = listaPersona.buscar(idUsuario);
            NodoLibros nodoLibros = listaLibros.buscarPorCodigo(codigoLibro);
            NodoPrestamos nodoPrestamos;
            //Instancia de la clase Prestamos
            Prestamos prestamos;
            
            LocalDate fechaPrestamo = LocalDate.now(); //Se obtiene la fecha en la que se realiza el prestamo

            if (listaPrestamos.verificarExistencia(codigoLibro, idUsuario) == false) {
                if (nodoPersonas != null && nodoLibros != null) {
                    int cantLibros = nodoLibros.getLibros().getCantidad();

                    if(cantLibros > 0){
                        nodoPrestamos = new NodoPrestamos();
                        int nuevaCantidad;

                        prestamos = new Prestamos();
                        prestamos.setIdPersona(idUsuario);
                        prestamos.setIdLibro(codigoLibro);
                        prestamos.setCodigo(codigoPrestamo);
                        prestamos.setFechaPrestamos(fechaPrestamo);
                        prestamos.setActivo(true);

                        nodoPrestamos.setPrestamos(prestamos);
                        listaPrestamos.agregarPrestamo(nodoPrestamos);

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
            }else{
                JOptionPane.showMessageDialog(null, "Este usuario ya ha prestado este libro", null, JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ha ocurrido un error al tratar de prestar el libro.\nError: " + e);
        }
    }

    private void devolver(){
        try {
            int codigoLibro = Integer.parseInt(prestamosDevoluciones.getTxt_codigoLibro().getText());
            int idUsuario = Integer.parseInt(prestamosDevoluciones.getTxt_idUsuario().getText());

            NodoPersonas nodoPersonas = listaPersona.buscar(idUsuario);
            NodoLibros nodoLibros = listaLibros.buscarPorCodigo(codigoLibro);
            NodoPrestamos nodoPrestamos = listaPrestamos.buscarPrestamo(codigoLibro, idUsuario);

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
            System.out.println("Ha ocurrido un error al tratar de devolver el libro.\nError: " + e);
        }
    }
    
}
