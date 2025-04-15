/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class Administrativo extends Persona{
    
    public Administrativo(){
        super();
    }

    @Override
    public String getTipoPersona(){
        return "Administrativo";
    }
    
}
