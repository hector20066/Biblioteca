/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Ing. Hector Acevedo
 */
public abstract class Persona {

    protected String nombre;
    protected int identificacion;
    
    public Persona(){
        
    }
    
    public void setPersona(String nombre, int identificacion){
        this.nombre = nombre;
        this.identificacion = identificacion;
    }
    
    public abstract String getTipoEstudiante();

}
