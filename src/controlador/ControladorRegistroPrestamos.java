/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.RegistroPrestamos;

/**
 *
 * @author Mi PC
 */
public class ControladorRegistroPrestamos implements ActionListener{
    
    private RegistroPrestamos registroPrestamos;

    public ControladorRegistroPrestamos(RegistroPrestamos registroPrestamos){
        this.registroPrestamos = registroPrestamos;

        this.registroPrestamos.getBtn_aceptar().addActionListener(this);
        this.registroPrestamos.getCbo_mostrarPrestamos().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        
    }

    private void cargarPrestamos(){
        try {
            
        } catch (Exception e) {
        }
    }

    private void cargarPrestamosActivos(){
        try {
            
        } catch (Exception e) {
        }
    }

    private void cargarPrestamosInactivos(){
        try {
            
        } catch (Exception e) {
        }
    }
    
}
