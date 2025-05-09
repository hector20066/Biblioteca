/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo.daoInterfaces;

import modelo.nodos.NodoPersonas;

/**
 *
 * @author Mi PC
 */
public interface DAOListaPersonas {
    
    //Metodos necesarios para el manejo de la informacion de los usuarios
    public void setCabeza(NodoPersonas cabeza);
    public NodoPersonas getCabeza();
    public NodoPersonas ultimo();
    public int contarNodos();
    public boolean verificarId(int identificacion);
    public void agregarNodo(NodoPersonas nodo);
    public NodoPersonas buscar(int identificacion);
    public void eliminarNodo(NodoPersonas nodo);
    public void eliminarLista();
    public void cambiar(NodoPersonas nodo1, NodoPersonas nodo2);
    public void ordenarLista();
    
}
