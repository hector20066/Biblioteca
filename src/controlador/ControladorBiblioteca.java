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

    public ControladorBiblioteca(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
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
                biblioteca.cambioPaneles(new PrestamosDevoluciones());
            }else{
                if (evento.getSource() == biblioteca.getBtn_registrarLibros()) {
                    biblioteca.cambioPaneles(new RegistrarLibros());
                }else{
                    if (evento.getSource() == biblioteca.getBtn_registrarUsuarios()) {
                        biblioteca.cambioPaneles(new RegistrarUsuario());
                    }else{
                        if(evento.getSource() == biblioteca.getBtn_registroPrestamos()){
                            biblioteca.cambioPaneles(new RegistroPrestamos());
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
