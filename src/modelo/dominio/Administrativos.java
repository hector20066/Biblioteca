/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dominio;

/**
 *
 * @author Mi PC
 */
public class Administrativos extends Personas{
    
    public Administrativos(){
        super();
    }

    @Override
    public String getTipoPersona() {
        return "Administrativo";
    }
}
