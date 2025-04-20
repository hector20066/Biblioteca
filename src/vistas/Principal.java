/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import com.formdev.flatlaf.FlatIntelliJLaf;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class Principal {
    
    /**
     * Metodo principal del programa, se cargan los temas y las ventanas del proyecto
     * @param args 
     */
    public static void main(String[]args){
        
        //Se carga el tema FlatLaf
        try{
            //Se usa el tema FlatLightLaf
            FlatIntelliJLaf.setup();
            
            // Otros temas de FlatLaf
            // FlatLightLaf.setup();
            // FlatDarkLaf.setup();
            // FlatDarculaLaf.setup();
            // FlatLightLaf.setup();
            
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
