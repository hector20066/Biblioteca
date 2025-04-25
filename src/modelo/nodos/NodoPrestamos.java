/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.nodos;

import modelo.dominio.Prestamos;

/**
 *
 * @author Mi PC
 */
public class NodoPrestamos {
    
    private Prestamos prestamos;
    private NodoPrestamos siguiente;

    public NodoPrestamos(){
        prestamos = null;
        siguiente = null;
    }

    public void setPrestamos(Prestamos prestamos){
        this.prestamos = prestamos;
    }

    public void setSiguiente(NodoPrestamos siguiente){
        this.siguiente = siguiente;
    }

    public Prestamos getPrestamos(){
        return prestamos;
    }

    public NodoPrestamos getSiguiente(){
        return siguiente;
    }

    public void copiarNodo(NodoPrestamos nodo){
        this.prestamos = nodo.getPrestamos();
    }

}
