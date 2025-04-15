/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class Prestamos {
    
    private Persona persona;
    private Libros libros;
    private LocalDate fechaPrestamo;

    public Prestamos(){
        
    }

    public void setFechaPrestamos(LocalDate fechaPrestamos){
        this.fechaPrestamo = fechaPrestamos;
    }

    public LocalDate getFechaPrestamo(){
        return fechaPrestamo;
    }

    public Persona getPersona(){
        return persona;
    }

    public Libros getLibros(){
        return libros;
    }

}
