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
    protected String telefono;
    
    public Persona(){
        
    }
    
    public void setPersona(String nombre, int identificacion, String telefono){
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }

    public String nombre(){
        return nombre;
    }

    public int getIdentificacion(){
        return identificacion;
    }

    public String getTelefono(){
        return telefono;
    }
    
    public abstract String getTipoPersona();

}
