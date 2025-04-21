/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.RegistrarUsuario;

/**
 *
 * @author Mi PC
 */
public class ControladorRegistrarUsuarios implements ActionListener{
    
    private RegistrarUsuario registrarUsuarios;

    public ControladorRegistrarUsuarios(RegistrarUsuario registrarUsuarios){
        this.registrarUsuarios = registrarUsuarios;

        this.registrarUsuarios.getBtn_aceptar().addActionListener(this);
        this.registrarUsuarios.getBtn_guardar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        
    }

    private void llenar(){

    }

    private void guardar(){
        try {
            
        } catch (Exception e) {
        }
    }

    private void aceptar(){
        try {
            
        } catch (Exception e) {
        }
    }
    
}
