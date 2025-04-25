/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.nodos;

import modelo.dominio.Libros;

/**
 *
 * @author Mi PC
 */
public class NodoLibros {
    
    private Libros libros;
    private NodoLibros siguiente;

    public NodoLibros() {
        libros = null;
        siguiente = null;
    }

    public void setLibros(Libros libro) {
        this.libros = libro;
    }

    public void setSiguiente(NodoLibros siguiente) {
        this.siguiente = siguiente;
    }

    public Libros getLibros() {
        return libros;
    }

    public NodoLibros getSiguiente() {
        return siguiente;
    }

    public void copiarNodo(NodoLibros nodo) {
        this.libros = nodo.getLibros();
    }
}
