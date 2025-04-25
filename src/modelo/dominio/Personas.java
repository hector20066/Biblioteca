/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dominio;

/**
 *
 * @author Mi PC
 */
public abstract class Personas {
    
    protected String nombre;
    protected int identificacion;
    protected String telefono;
    
    public Personas(){
        
    }
    
    public void setPersona(String nombre, int identificacion, String telefono){
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }

    public String getNombre(){
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
