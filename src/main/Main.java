/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.formdev.flatlaf.FlatIntelliJLaf;
import controlador.*;
import vistas.*;

/**
 *
 * @author Mi PC
 */
public class Main {
    
    public static void main(String[]args){
        //Se carga el tema FlatLaf
        try{
            //Se usa el tema FlatIntelliJLaf
            FlatIntelliJLaf.setup();
            
            // Otros temas de FlatLaf
            // FlatDarkLaf.setup();
            // FlatDarculaLaf.setup();
            // FlatLightLaf.setup();
            
        }catch(Exception ex){
            System.out.println("Fallo al cargar FlatLat");
        }
        
        //Se inicia la aplicacion a traves del coordinador, que es el encargado de conectar los controladores con sus vistas, e iniciar la vista principal
        new Coordinador().iniciarAplicacion();
    }
}
