/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vistas.*;

/**
 *
 * @author Mi PC
 */
public class Coordinador {
    
    //Clase encargada de cordinar las acciones, esto vinculando las vistas con sus respectivos controladores
    public void iniciarAplicacion(){

        //Instancia de la ventana principal
        Biblioteca vista = new Biblioteca();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);

        //Instancias de las demas vistas del programa
        PrestamosDevoluciones prestamosDevoluciones = new PrestamosDevoluciones();
        RegistrarLibros registrarLibros = new RegistrarLibros();
        RegistrarUsuario registrarUsuarios = new RegistrarUsuario();
        RegistroPrestamos registroPrestamos = new RegistroPrestamos();

        //Instancia del controlador RegistroPrestamos, se usa para que se actualize la informacion cuando se ingresa a la vista del registro de los prestamos
        ControladorRegistroPrestamos controladorRegistroPrestamos = new ControladorRegistroPrestamos(registroPrestamos);

        //Se cran los demas controladores de la vistas del programa
        new ControladorBiblioteca(vista, prestamosDevoluciones, registrarUsuarios, registrarLibros, registroPrestamos, controladorRegistroPrestamos);
        new ControladorPrestamosDevoluciones(prestamosDevoluciones);
        new ControladorRegistrarLibros(registrarLibros);
        new ControladorRegistrarUsuarios(registrarUsuarios);
    }

}
