/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dominio;

/**
 *
 * @author Mi PC
 */
public class Docentes extends Personas{

    public Docentes(){
        super();
    }

    @Override
    public String getTipoPersona() {
        return "Docente";
    }
    

}
