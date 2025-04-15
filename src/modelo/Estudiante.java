/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class Estudiante extends Persona{
    
    public Estudiante(){
        super();
    }

    public void setEstuiante(String nombre, int identificacion){
        setPersona(nombre, identificacion);
    }
    
    @Override
    public String getTipoPersona(){
        return "Estudiante";
    }

    
}
