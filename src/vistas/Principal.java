/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class Principal {
    
    public static void main(String[]args){
        
        //Se carga el tema FlatLaf
        try{
            //Se usa el tema FlatLightLaf
            FlatLightLaf.setup();
        }catch(Exception ex){
            System.out.println("Fallo al cargar FlatLat");
        }
        
        //Se instancia la vista principal de programa
        Biblioteca vista = new Biblioteca();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
    }
    
}
