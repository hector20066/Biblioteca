/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author Mi PC
 */
public interface DAOListaPersonas {
    
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
