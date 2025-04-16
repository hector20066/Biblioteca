/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ListaLibros {

    private NodoLibros cabeza;
    private static ListaLibros listaLibros;

    public ListaLibros() {
        cabeza = null;
        listaLibros = null;
    }

    public static ListaLibros geListaLibros() {
        if (listaLibros == null) {
            listaLibros = new ListaLibros();
        }
        return listaLibros;
    }

    public void setCabeza(NodoLibros cabeza) {
        this.cabeza = cabeza;
    }

    public NodoLibros getCabeza() {
        return cabeza;
    }

    public NodoLibros ultimo() {
        NodoLibros temp = cabeza;
        while (temp != null){
            if(temp.getSiguiente() == null){
                break;
            }else {
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    public int contarNodos() {
        int contador = 0;
        NodoLibros temp = cabeza;
        while (temp != null) {
            contador++;
            temp = temp.getSiguiente();
        }
        return contador;
    }

    public void agregarNodo(NodoLibros nuevo) {
        if(cabeza == null){
            setCabeza(nuevo);
        }else {
            ultimo().setSiguiente(nuevo);
        }
    }

    public NodoLibros buscarPorTitulo(String titulo) {
        NodoLibros temp = cabeza;
        while(temp != null){
            if(temp.getLibros().getTitulo().equals(titulo)){
                break;
            }else {
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    public NodoLibros buscarPorCodigo(int cod) {
        NodoLibros temp = cabeza;
        while(temp != null){
            if(temp.getLibros().getCodigo() == cod){
                break;
            }else {
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    public void eliminar(NodoLibros nodo) {
        NodoLibros anterior;
        if(nodo == cabeza){
            cabeza = cabeza.getSiguiente();
        }else{
            anterior = cabeza;
            while(anterior.getSiguiente() != nodo){
                anterior = anterior.getSiguiente();
            }
            anterior.setSiguiente(nodo.getSiguiente());
        }
    nodo.setSiguiente(null);

}
