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

    public static ListaLibros getListaLibros() {
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

    public boolean verficarCodigo(int codigo){
        NodoLibros temp = cabeza;
        while(temp != null){
            if(temp.getLibros().getCodigo() == codigo){
                return true;
            }else{
                temp = temp.getSiguiente();
            }
        }
        return false;
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

    public void eliminarLista() {
        while(cabeza != null){
            eliminar(cabeza);
        }
    }

    public void cambiar(NodoLibros nodo1, NodoLibros nodo2) {
        NodoLibros temp = new NodoLibros();
        temp.copiarNodo(nodo1);
        nodo1.copiarNodo(nodo2);
        nodo2.copiarNodo(temp);
    }

    public void ordenarListaPorTitulo() {
        NodoLibros ni;
        NodoLibros nj;
        ni = cabeza;
        while(ni != null){
            nj = ni.getSiguiente();
            while(nj != null){
                if(ni.getLibros().getTitulo().compareTo(nj.getLibros().getTitulo()) > 0){
                    cambiar(ni, nj);
                }
                nj = nj.getSiguiente();
            }
            ni = ni.getSiguiente();
        }
    }

    public void ordenarListaPorCodigo() {
        NodoLibros ni;
        NodoLibros nj;
        ni = cabeza;
        while(ni != null){
            nj = ni.getSiguiente();
            while(nj != null){
                if(ni.getLibros().getCodigo() > nj.getLibros().getCodigo()){
                    cambiar(ni, nj);
                }
                nj = nj.getSiguiente();
            }
            ni = ni.getSiguiente();
        }
    }

}
