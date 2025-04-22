/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.*;

/**
 *
 * @author Mi PC
 */
public class ControladorBiblioteca implements ActionListener{
    
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
        
        this.biblioteca.getBtn_inicio().addActionListener(this);
        this.biblioteca.getBtn_prestamosDevoluciones().addActionListener(this);
        this.biblioteca.getBtn_registrarLibros().addActionListener(this);
        this.biblioteca.getBtn_registrarUsuarios().addActionListener(this);
        this.biblioteca.getBtn_registroPrestamos().addActionListener(this);
        this.biblioteca.getBtn_salir().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource() == biblioteca.getBtn_inicio()){
            biblioteca.cambioPaneles(new Inicio());
        }else{
            if(evento.getSource() == biblioteca.getBtn_prestamosDevoluciones()){
                biblioteca.cambioPaneles(prestamosDevoluciones);
            }else{
                if (evento.getSource() == biblioteca.getBtn_registrarLibros()) {
                    biblioteca.cambioPaneles(registrarLibros);
                }else{
                    if (evento.getSource() == biblioteca.getBtn_registrarUsuarios()) {
                        biblioteca.cambioPaneles(registrarUsuarios);
                    }else{
                        if(evento.getSource() == biblioteca.getBtn_registroPrestamos()){
                            controladorRegistroPrestamos.actualizarTabla();
                            biblioteca.cambioPaneles(registroPrestamos);
                        }else{
                            if(evento.getSource() == biblioteca.getBtn_salir()){
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
    }
    
}
