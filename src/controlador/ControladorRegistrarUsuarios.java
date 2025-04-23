/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.*;
import vistas.RegistrarUsuario;

/**
 *
 * @author Mi PC
 */
public class ControladorRegistrarUsuarios implements ActionListener{
    
    private RegistrarUsuario registrarUsuarios;
    DAOListaPersonas listaPersonas = DAOListPersonasImpl.getListaPersonas();

    public ControladorRegistrarUsuarios(RegistrarUsuario registrarUsuarios){
        this.registrarUsuarios = registrarUsuarios;

        this.registrarUsuarios.getBtn_aceptar().addActionListener(this);
        this.registrarUsuarios.getBtn_guardar().addActionListener(this);

        cargarDatos();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        if (evento.getSource() == registrarUsuarios.getBtn_aceptar()) {
            aceptar();
        }else{
            if(evento.getSource() == registrarUsuarios.getBtn_guardar()){
                guardar();
            }
        }
    }

    private void llenar(NodoPersonas nodo){
        String nombre = registrarUsuarios.getTxt_nombre().getText();
        int identificacion = Integer.parseInt(registrarUsuarios.getTxt_identificacion().getText());
        String telefono = registrarUsuarios.getTxt_telefono().getText();

        if(registrarUsuarios.getCbo_tipoUsuario().getSelectedItem().equals("Estudiante")){
            Persona estudiante = new Estudiante();

            estudiante.setPersona(nombre, identificacion, telefono);
            nodo.setPersona(estudiante);
        }else{
            if(registrarUsuarios.getCbo_tipoUsuario().getSelectedItem().equals("Docente")){
                Persona docente = new Docente();

                docente.setPersona(nombre, identificacion, telefono);
                nodo.setPersona(docente);
            }else{
                if(registrarUsuarios.getCbo_tipoUsuario().getSelectedItem().equals("Administrativo")){
                    Persona administrativo = new Administrativo();

                    administrativo.setPersona(nombre, identificacion, telefono);
                    nodo.setPersona(administrativo);
                }
            }
        }
    }

    public void cargarDatos(){
        NodoPersonas temp = listaPersonas.getCabeza();
        registrarUsuarios.getModelo().setRowCount(0);

        while(temp != null){
            String nombre = temp.getPersona().getNombre();
            int identificacion = temp.getPersona().getIdentificacion();
            String telefono = temp.getPersona().getTelefono();
            String tipoUsuario = temp.getPersona().getTipoPersona();

            Object listar[] = new Object[]{nombre, identificacion, telefono, tipoUsuario};
            registrarUsuarios.getModelo().addRow(listar);

            temp = temp.getSiguiente();
        }
    }

    private void guardar(){
        try {
            NodoPersonas nodo = new NodoPersonas();
            
            llenar(nodo);
            listaPersonas.agregarNodo(nodo);
            cargarDatos();
            JOptionPane.showMessageDialog(null, "Los datos del usuario han sido guardados correctamente", null, JOptionPane.INFORMATION_MESSAGE);
            registrarUsuarios.limpiarCampos();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar los datos.", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void aceptar(){
        try {
            int opcion = registrarUsuarios.getCbo_opciones().getSelectedIndex();
            int identificacionBuscar;
            NodoPersonas nodo;

            switch(opcion){
                case 0:
                    identificacionBuscar = Integer.parseInt(registrarUsuarios.getTxt_identificacionOpciones().getText());
                    nodo = listaPersonas.buscar(identificacionBuscar);

                    registrarUsuarios.getModelo().setRowCount(0);

                    if(nodo != null){
                        String nombre = nodo.getPersona().getNombre();
                        int identificacion = nodo.getPersona().getIdentificacion();
                        String telefono = nodo.getPersona().getTelefono();
                        String tipoUsuario = nodo.getPersona().getTipoPersona();

                        Object listar[] = new Object[]{nombre, identificacion, telefono, tipoUsuario};
                        registrarUsuarios.getModelo().addRow(listar);

                        registrarUsuarios.getTxt_identificacionOpciones().setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario con esta identificacion", null, JOptionPane.ERROR_MESSAGE);
                        registrarUsuarios.getTxt_identificacionOpciones().grabFocus();
                    }
                    break;
                case 1:
                    identificacionBuscar = Integer.parseInt(registrarUsuarios.getTxt_identificacionOpciones().getText());
                    nodo = listaPersonas.buscar(identificacionBuscar);

                    if(nodo != null){
                        listaPersonas.eliminarNodo(nodo);
                        cargarDatos();
                        registrarUsuarios.getTxt_identificacionOpciones().setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario con esta identificacion", null, JOptionPane.ERROR_MESSAGE);
                        registrarUsuarios.getTxt_identificacionOpciones().grabFocus();
                    }
                    break;
                case 2:
                    listaPersonas.ordenarLista();
                    cargarDatos();
                    break;
                case 3:
                    listaPersonas.eliminarLista();
                    registrarUsuarios.getModelo().setRowCount(0);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de realizar esta opcion");
        }
    }
    
}
