/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class NodoPersonas {
    
    private Persona persona;
    private NodoPersonas siguiente;

    public NodoPersonas(){
        persona = null;
        siguiente = null;
    }

    public void setPersona(Persona persona){
        this.persona = persona;
    }

    public void setSiguiente(NodoPersonas siguiente){
        this.siguiente = siguiente;
    }

    public Persona getPersona(){
        return persona;
    }

    public NodoPersonas getSiguiente(){
        return siguiente;
    }

    public void compiarNodo(NodoPersonas nodo){
        this.persona = nodo.getPersona();
    }

}
