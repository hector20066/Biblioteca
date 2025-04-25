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
public class ControladorBiblioteca{
    
    private Biblioteca biblioteca;
    private PrestamosDevoluciones prestamosDevoluciones;
    private RegistrarUsuario registrarUsuarios;
    private RegistrarLibros registrarLibros;
    private RegistroPrestamos registroPrestamos;
    private ControladorRegistroPrestamos controladorRegistroPrestamos;

    public ControladorBiblioteca(Biblioteca biblioteca, PrestamosDevoluciones prestamosDevoluciones, RegistrarUsuario registrarUsuario, RegistrarLibros registrarLibros, RegistroPrestamos registroPrestamos, ControladorRegistroPrestamos controladorRegistroPrestamos){
        this.biblioteca = biblioteca;
        this.prestamosDevoluciones = prestamosDevoluciones;
        this.registrarUsuarios = registrarUsuario;
        this.registrarLibros = registrarLibros;
        this.registroPrestamos = registroPrestamos;
        this.controladorRegistroPrestamos = controladorRegistroPrestamos;

        conectarEventos();
    }

    private void conectarEventos(){
        biblioteca.setControlInicio(e -> inicio());
        biblioteca.setControlRegistrarUsuarios(e -> panelRegistrarUsuarios());
        biblioteca.setControlRegistrarLibros(e -> panelRegistrarLibros());
        biblioteca.setControlPrestamosDevoluciones(e -> panelPrestamosDevoluciones());
        biblioteca.setControlRegistroPrestamos(e -> panelRegistroPrestamos());
        biblioteca.setControlSalir(e -> salir());
    }

    private void inicio(){
        biblioteca.cambioPaneles(new Inicio());
    }

    private void panelRegistrarUsuarios(){
        biblioteca.cambioPaneles(registrarUsuarios);
    }

    private void panelRegistrarLibros(){
        biblioteca.cambioPaneles(registrarLibros);
    }

    private void panelPrestamosDevoluciones(){
        biblioteca.cambioPaneles(prestamosDevoluciones);
    }

    private void panelRegistroPrestamos(){
        controladorRegistroPrestamos.actualizarTabla();
        biblioteca.cambioPaneles(registroPrestamos);
    }

    private void salir(){
        System.exit(0);
    }
    
}
