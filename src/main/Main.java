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
            //Se usa el tema FlatLightLaf
            FlatIntelliJLaf.setup();
            
            // Otros temas de FlatLaf
            // FlatDarkLaf.setup();
            // FlatDarculaLaf.setup();
            // FlatLightLaf.setup();
            
        }catch(Exception ex){
            System.out.println("Fallo al cargar FlatLat");
        }
        
        //Instancias de las vistas del programa
        //Intancia de la vista Principal (Biblioteca)
        Biblioteca vista = new Biblioteca();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);

        //Intancias de las vistas del programa
        PrestamosDevoluciones prestamosDevoluciones = new PrestamosDevoluciones();
        RegistrarLibros registrarLibros = new RegistrarLibros();
        RegistrarUsuario registrarUsuarios = new RegistrarUsuario();
        RegistroPrestamos registroPrestamos = new RegistroPrestamos();

        //Instancia del controlador RegistroPrestamos, se usa para actualizar la informacion
        ControladorRegistroPrestamos controladorRegistroPrestamos = new ControladorRegistroPrestamos(registroPrestamos);
        //Se crean los controladores del programa
        new ControladorBiblioteca(vista, prestamosDevoluciones, registrarUsuarios, registrarLibros, registroPrestamos, controladorRegistroPrestamos);
        new ControladorPrestamosDevoluciones(prestamosDevoluciones);
        new ControladorRegistrarLibros(registrarLibros);
        new ControladorRegistrarUsuarios(registrarUsuarios);
        
    }
}
