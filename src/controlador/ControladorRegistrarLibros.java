/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.daoImplementaciones.DAOListLibrosImpl;
import modelo.daoInterfaces.DAOListaLibros;
import modelo.dominio.Libros;
import modelo.nodos.NodoLibros;
import vistas.RegistrarLibros;

/**
 *
 * @author Mi PC
 */
public class ControladorRegistrarLibros{
    
    private RegistrarLibros registrarLibros;
    
    DAOListaLibros listaLibros = DAOListLibrosImpl.getListaLibros();
    
    public ControladorRegistrarLibros(RegistrarLibros registrarLibros){
        this.registrarLibros = registrarLibros;
        
        cargarDatos();
        conectarEventos();
    }
    
    private void conectarEventos(){
        registrarLibros.setControladorAceptar(e -> aceptar());
        registrarLibros.setControladorGuardar(e -> guardar());
    }
    
    private void llenar(NodoLibros nodo){
        String titulo = registrarLibros.getTxt_titulo().getText();
        int codigo = Integer.parseInt(registrarLibros.getTxt_codigo().getText());
        String autor = registrarLibros.getTxt_autor().getText();
        int cantidad = Integer.parseInt(registrarLibros.getTxt_cantDisponible().getText());
        
        Libros libros = new Libros();
        libros.setCodigo(codigo);
        libros.setTitulo(titulo);
        libros.setAutor(autor);
        libros.setCantidad(cantidad);
        nodo.setLibros(libros);
    }
    
    private void cargarDatos(){
        NodoLibros nodo = listaLibros.getCabeza();
        registrarLibros.getModelo().setRowCount(0);
        while(nodo != null){
            String titulo = nodo.getLibros().getTitulo();
            int codigo = nodo.getLibros().getCodigo();
            String autor = nodo.getLibros().getAutor();
            int cantidad = nodo.getLibros().getCantidad();

            Object listar[] = new Object[]{titulo, codigo, autor, cantidad};
            registrarLibros.getModelo().addRow(listar);

            nodo = nodo.getSiguiente();
        }
    }

    private void limpiarCampos(){
        registrarLibros.getTxt_autor().setText("");
        registrarLibros.getTxt_cantDisponible().setText("");
        registrarLibros.getTxt_codigo().setText("");
        registrarLibros.getTxt_codigoOpciones().setText("");
        registrarLibros.getTxt_titulo().setText("");
        registrarLibros.getTxt_autor().setText("");
    }
    
    private void guardar(){
        try{
            int codigo = Integer.parseInt(registrarLibros.getTxt_codigo().getText());
            
            if(listaLibros.verificarCodigo(codigo) == false){
                NodoLibros nodo = new NodoLibros();

                llenar(nodo);
                listaLibros.agregarNodo(nodo);
                listaLibros.ordenarListCodigos();
                cargarDatos();
                JOptionPane.showMessageDialog(null, "Se ha registrado el libro correctamente", null, JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(null, "Ya hay un libro registrado con este codigo", null, JOptionPane.ERROR_MESSAGE);
                registrarLibros.getTxt_codigo().grabFocus();
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de guardar los datos de un libro", null, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void aceptar(){
        try{
            int opcion = registrarLibros.getCbo_opciones().getSelectedIndex();

            int codigoBuscar;
            String tituloBuscar;
            NodoLibros nodo;

            switch(opcion){
                case 0:
                    codigoBuscar = Integer.parseInt(registrarLibros.getTxt_codigoOpciones().getText());

                    nodo = listaLibros.buscar(codigoBuscar);
                    registrarLibros.getModelo().setRowCount(0);

                    if(nodo != null){
                        String titulo = nodo.getLibros().getTitulo();
                        int codigo = nodo.getLibros().getCodigo();
                        String autor = nodo.getLibros().getAutor();
                        int cantidad = nodo.getLibros().getCantidad();

                        Object listar[] = new Object[]{titulo, codigo, autor, cantidad};
                        registrarLibros.getModelo().addRow(listar);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro el libro con este codigo", null, JOptionPane.ERROR_MESSAGE);
                        registrarLibros.getTxt_codigoOpciones().grabFocus();
                    }
                    break;
                case 1:
                    tituloBuscar = registrarLibros.getTxt_codigoOpciones().getText();

                    nodo = listaLibros.buscar(tituloBuscar);
                    registrarLibros.getModelo().setRowCount(0);

                    if(nodo != null){
                        String titulo = nodo.getLibros().getTitulo();
                        int codigo = nodo.getLibros().getCodigo();
                        String autor = nodo.getLibros().getAutor();
                        int cantidad = nodo.getLibros().getCantidad();

                        Object listar[] = new Object[]{titulo, codigo, autor, cantidad};
                        registrarLibros.getModelo().addRow(listar);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro el libro con este titulo", null, JOptionPane.ERROR_MESSAGE);
                        registrarLibros.getTxt_codigoOpciones().grabFocus();
                    }
                    break;
                case 2:
                    codigoBuscar = Integer.parseInt(registrarLibros.getTxt_codigoOpciones().getText());
                    
                    nodo = listaLibros.buscar(codigoBuscar);

                    if(nodo != null){
                        listaLibros.eliminarNodo(nodo);
                        cargarDatos();
                        registrarLibros.getTxt_codigoOpciones().setText("");
                        JOptionPane.showMessageDialog(null, "Se ha eliminado el libro correctamente", null, JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro el libro con este codigo", null, JOptionPane.ERROR_MESSAGE);
                        registrarLibros.getTxt_codigoOpciones().grabFocus();
                    }
                    break;
                case 3:
                    listaLibros.ordenarListCodigos();
                    cargarDatos();
                    registrarLibros.getTxt_codigoOpciones().setText("");
                    break;
                case 4:
                    listaLibros.ordenarListTitulos();
                    cargarDatos();
                    registrarLibros.getTxt_codigoOpciones().setText("");
                    break;
                case 5:
                    listaLibros.eliminarLista();
                    cargarDatos();
                    registrarLibros.getTxt_codigoOpciones().setText("");
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Se ha producido un error al tratar de realizar esta accion");
        }
    }
    
}
