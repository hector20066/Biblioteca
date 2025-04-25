/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author Mi PC
 */
public interface DAOListaLibros {
    
    //Metodos necesarios para el manejo de la informacion de los libros
    public void setCabeza(NodoLibros cabeza);
    public NodoLibros getCabeza();
    public NodoLibros ultimo();
    public int contarNodos();
    public boolean verificarCodigo(int codigo);
    public void agregarNodo(NodoLibros nodo);
    public NodoLibros buscarPorTitulo(String titulo);
    public NodoLibros buscarPorCodigo(int codigo);
    public void eliminarNodo(NodoLibros nodo);
    public void eliminarLista();
    public void cambiar(NodoLibros nodo1, NodoLibros nodo2);
    public void ordenarListTitulos();
    public void ordenarListCodigos();
    
}
