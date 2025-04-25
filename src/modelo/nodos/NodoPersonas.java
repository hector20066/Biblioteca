/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.nodos;

import modelo.dominio.Personas;

/**
 *
 * @author Mi PC
 */
public class NodoPersonas {
    
    private Personas persona;
    private NodoPersonas siguiente;

    public NodoPersonas(){
        persona = null;
        siguiente = null;
    }

    public void setPersona(Personas persona){
        this.persona = persona;
    }

    public void setSiguiente(NodoPersonas siguiente){
        this.siguiente = siguiente;
    }

    public Personas getPersona(){
        return persona;
    }

    public NodoPersonas getSiguiente(){
        return siguiente;
    }

    public void copiarNodo(NodoPersonas nodo){
        this.persona = nodo.getPersona();
    }

}
