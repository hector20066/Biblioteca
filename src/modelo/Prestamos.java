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
    
    private int idPersona;
    private int idLibro;
    private LocalDate fechaPrestamo;
    private int codigo;

    public Prestamos(){
        
    }

    public void setIdPersona(int idPersona){
        this.idPersona = idPersona;
    }
    
    public void setIdLibro(int idLibro){
        this.idLibro = idLibro;
    }
    
    public void setFechaPrestamos(LocalDate fechaPrestamos){
        this.fechaPrestamo = fechaPrestamos;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public LocalDate getFechaPrestamo(){
        return fechaPrestamo;
    }

    public int getCodigo(){
        return codigo;
    }

    public int getIdPersona(){
        return idPersona;
    }

    public int getIdLibros(){
        return idLibro;
    }

}
