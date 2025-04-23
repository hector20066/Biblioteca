/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.*;
import vistas.RegistroPrestamos;

/**
 *
 * @author Mi PC
 */
public class ControladorRegistroPrestamos implements ActionListener{
    
    private RegistroPrestamos registroPrestamos;
    DAOListaPrestamos listaPrestamos = DAOListPrestamosImpl.getListaPrestamos();

    public ControladorRegistroPrestamos(RegistroPrestamos registroPrestamos){
        this.registroPrestamos = registroPrestamos;

        this.registroPrestamos.getBtn_aceptar().addActionListener(this);
        this.registroPrestamos.getCbo_mostrarPrestamos().addActionListener(this);

        cargarPrestamos();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource() == registroPrestamos.getBtn_aceptar()){
            aceptar();
        }else{
            if(evento.getSource() == registroPrestamos.getCbo_mostrarPrestamos()){
                if(registroPrestamos.getCbo_mostrarPrestamos().getSelectedItem().equals("Mostrar pretamos activos")){
                    cargarPrestamosActivos();
                }else{
                    if(registroPrestamos.getCbo_mostrarPrestamos().getSelectedItem().equals("Mostrar prestamos inactivos")){
                        cargarPrestamosInactivos();
                    }else{
                        if(registroPrestamos.getCbo_mostrarPrestamos().getSelectedItem().equals("Mostrar registro completo")){
                            cargarPrestamos();
                        }
                    }
                }
            }
        }
    }

    public void actualizarTabla(){
        cargarPrestamos();
    }

    private void cargarPrestamos(){
        try {
            NodoPrestamos nodo = listaPrestamos.getCabeza();
            registroPrestamos.getModelo().setRowCount(0);
            while(nodo != null){
                int codigoPrestamo = nodo.getPrestamos().getCodigo();
                int idUsuario = nodo.getPrestamos().getIdPersona();
                int idLibro = nodo.getPrestamos().getIdLibros();
                LocalDate fechaPrestamo = nodo.getPrestamos().getFechaPrestamo();
                boolean estado = nodo.getPrestamos().getActivo();
                String estados;

                if(estado == true){
                    estados = "Activo";
                }else{
                    estados = "Inactivo";
                }

                Object listar[] = new Object[]{codigoPrestamo, idUsuario, idLibro, fechaPrestamo, estados};
                registroPrestamos.getModelo().addRow(listar);

                nodo = nodo.getSiguiente();
            }
        } catch (Exception e) {
        }
    }

    private void cargarPrestamosActivos(){
        try {
            NodoPrestamos nodo = listaPrestamos.getCabeza();
            registroPrestamos.getModelo().setRowCount(0);

            while(nodo != null){
                boolean estado = nodo.getPrestamos().getActivo();

                if(estado){
                    int codigoPrestamo = nodo.getPrestamos().getCodigo();
                    int idUsuario = nodo.getPrestamos().getIdPersona();
                    int idLibro = nodo.getPrestamos().getIdLibros();
                    LocalDate fechaPrestamo = nodo.getPrestamos().getFechaPrestamo();
                    String estados = null;

                    if(estado == true){
                        estados = "Activo";
                    }

                    Object listar[] = new Object[]{codigoPrestamo, idUsuario, idLibro, fechaPrestamo, estados};
                    registroPrestamos.getModelo().addRow(listar);
                }
                nodo = nodo.getSiguiente();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se han podido cargar los prestamos activos", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarPrestamosInactivos(){
        try {
            NodoPrestamos nodo = listaPrestamos.getCabeza();
            registroPrestamos.getModelo().setRowCount(0);

            while(nodo != null){
                boolean estado = nodo.getPrestamos().getActivo();

                if(estado == false){
                    int codigoPrestamo = nodo.getPrestamos().getCodigo();
                    int idUsuario = nodo.getPrestamos().getIdPersona();
                    int idLibro = nodo.getPrestamos().getIdLibros();
                    LocalDate fechaPrestamo = nodo.getPrestamos().getFechaPrestamo();
                    String estados = null;

                    if(estado == false){
                        estados = "Inactivo";
                    }

                    Object listar[] = new Object[]{codigoPrestamo, idUsuario, idLibro, fechaPrestamo, estados};
                    registroPrestamos.getModelo().addRow(listar);
                }
                nodo = nodo.getSiguiente();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se han podido cargar los prestamos activos", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void aceptar(){
        try {
            int opciones = registroPrestamos.getCbo_opciones().getSelectedIndex();
            int codigoBuscar;
            int idUsuarioBuscar;

            NodoPrestamos nodo;

            switch(opciones){
                case 0: //Buscar prestamo
                    codigoBuscar = Integer.parseInt(registroPrestamos.getTxt_codigo_idUsuario().getText());
                    nodo = listaPrestamos.buscar(codigoBuscar);

                    if(nodo != null){
                        int codigoPrestamo = nodo.getPrestamos().getCodigo();
                        int idUsuario = nodo.getPrestamos().getIdPersona();
                        int idLibro = nodo.getPrestamos().getIdLibros();
                        LocalDate fechaPrestamo = nodo.getPrestamos().getFechaPrestamo();
                        boolean estado = nodo.getPrestamos().getActivo();
                        String estados;

                        if(estado == true){
                            estados = "Activo";
                        }else{
                            estados = "Inactivo";
                        }

                        registroPrestamos.getModelo().setRowCount(0);

                        Object listar[] = new Object[]{codigoPrestamo, idUsuario, idLibro, fechaPrestamo, estados};
                        registroPrestamos.getModelo().addRow(listar);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro el prestamo con este codigo, por favor verifique el codigo.", null, JOptionPane.ERROR_MESSAGE);
                        registroPrestamos.getTxt_codigo_idUsuario().grabFocus();
                    }
                    break;
                case 1: //Buscar prestamo segun el usuario
                    idUsuarioBuscar = Integer.parseInt(registroPrestamos.getTxt_codigo_idUsuario().getText());
                    nodo = listaPrestamos.buscarIdUsuario(idUsuarioBuscar);

                    if(nodo != null){
                        int codigoPrestamo = nodo.getPrestamos().getCodigo();
                        int idUsuario = nodo.getPrestamos().getIdPersona();
                        int idLibro = nodo.getPrestamos().getIdLibros();
                        LocalDate fechaPrestamo = nodo.getPrestamos().getFechaPrestamo();
                        boolean estado = nodo.getPrestamos().getActivo();
                        String estados;

                        if(estado == true){
                            estados = "Activo";
                        }else{
                            estados = "Inactivo";
                        }

                        registroPrestamos.getModelo().setRowCount(0);

                        Object listar[] = new Object[]{codigoPrestamo, idUsuario, idLibro, fechaPrestamo, estados};
                        registroPrestamos.getModelo().addRow(listar);
                    }else{
                        JOptionPane.showMessageDialog(null, "Este usuario no se encuentra en el registro de prestamos, Por favor revise que la identificacion sea valida", null, JOptionPane.ERROR_MESSAGE);
                        registroPrestamos.getTxt_codigo_idUsuario().grabFocus();
                    }
                    break;
                case 2: //Eliminar Prestamo
                    codigoBuscar = Integer.parseInt(registroPrestamos.getTxt_codigo_idUsuario().getText());
                    nodo = listaPrestamos.buscar(codigoBuscar);

                    if(nodo != null){
                        listaPrestamos.eliminarNodo(nodo);
                        cargarPrestamos();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha encontrado el prestamo con este codigo", null, JOptionPane.ERROR_MESSAGE);
                        registroPrestamos.getTxt_codigo_idUsuario().grabFocus();
                    }
                    break;
                case 3: //Eliminar toda la lista de prestamos
                    listaPrestamos.eliminarLista();
                    cargarPrestamos();
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el registro de prestamos", null, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4: //Ordenar los prestamos por fecha del prestamo
                    listaPrestamos.ordenarPrestamosFecha();
                    cargarPrestamos();
                    break;
                case 5: //Ordenar los prestamos por su codigo
                    listaPrestamos.ordenarPrestamosCodigos();;
                    cargarPrestamos();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la accion deseada, por favor intentelo nuevamente", null, JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
