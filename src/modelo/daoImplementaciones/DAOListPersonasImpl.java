/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.daoImplementaciones;

import modelo.daoInterfaces.DAOListaPersonas;
import modelo.nodos.NodoPersonas;

/**
 *
 * @author Mi PC
 */
public class DAOListPersonasImpl implements DAOListaPersonas{

    private NodoPersonas cabeza;
    private static DAOListPersonasImpl listaPersonas;

    public DAOListPersonasImpl(){
        cabeza = null;
        listaPersonas = null;
    }

    public static DAOListPersonasImpl getListaPersonas(){
        if(listaPersonas == null){
            listaPersonas = new DAOListPersonasImpl();
        }
        return listaPersonas;
    }

    @Override
    public void setCabeza(NodoPersonas cabeza) {
        this.cabeza = cabeza;
    }

    @Override
    public NodoPersonas getCabeza() {
        return cabeza;
    }

    @Override
    public NodoPersonas ultimo() {
        NodoPersonas temp = cabeza;
        while(temp != null){
            if(temp.getSiguiente() == null){
                break;
            }else{
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    @Override
    public int contarNodos() {
        int contador = 0;
        NodoPersonas temp = cabeza;
        while(temp != null){
            contador++;
            temp = temp.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean verificarId(int identificacion) {
        NodoPersonas temp = cabeza;
        while(temp != null){
            if(temp.getPersona().getIdentificacion() == identificacion){
                return true;
            }else{
                temp = temp.getSiguiente();
            }
        }
        return false;
    }

    @Override
    public void agregarNodo(NodoPersonas nodo) {
        if(cabeza == null){
            setCabeza(nodo);
        }else{
            ultimo().setSiguiente(nodo);
        }
    }

    @Override
    public NodoPersonas buscar(int identificacion) {
        NodoPersonas temp = cabeza;
        while(temp != null){
            if(temp.getPersona().getIdentificacion() == identificacion){
                break;
            }else{
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    @Override
    public void eliminarNodo(NodoPersonas nodo) {
        NodoPersonas anterior;
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

    @Override
    public void eliminarLista() {
        while(cabeza != null){
            eliminarNodo(cabeza);
        }
    }

    @Override
    public void cambiar(NodoPersonas nodo1, NodoPersonas nodo2) {
        NodoPersonas temp = new NodoPersonas();
        temp.copiarNodo(nodo1);
        nodo1.copiarNodo(nodo2);
        nodo2.copiarNodo(temp);
    }

    @Override
    public void ordenarLista() {
        NodoPersonas ni;
        NodoPersonas nj;
        ni = cabeza;
        while(ni != null){
            nj = ni.getSiguiente();
            while(nj != null){
                if(ni.getPersona().getIdentificacion() > nj.getPersona().getIdentificacion()){
                    cambiar(ni, nj);
                }
                nj = nj.getSiguiente();
            }
            ni = ni.getSiguiente();
        }
    }
    
}
