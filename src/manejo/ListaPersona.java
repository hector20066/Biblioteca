/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo;

import modelo.Persona;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ListaPersona {
    
    private NodoPersonas cabeza;
    private static ListaPersona listaPersona;

    public ListaPersona(){
        cabeza = null;
        listaPersona = null;
    }

    public static ListaPersona getListaPersona(){
        if(listaPersona == null){
            listaPersona = new ListaPersona();
        }
        return listaPersona;
    }

    public void setCabeza(NodoPersonas cabeza){
        this.cabeza = cabeza;
    }

    public NodoPersonas getPersona(){
        return cabeza;
    }

    public NodoPersonas ultimo(){
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

    public int contarNodo(){
        int contador = 0;
        NodoPersonas temp = cabeza;
        while(temp != null){
            contador++;
            temp = temp.getSiguiente();
        }
        return contador;
    }

    public void agregarNodo(NodoPersonas nuevo){
        if(cabeza == null){
            setCabeza(nuevo);
        }else{
            ultimo().setSiguiente(nuevo);
        }
    }

    public void agregarCabeza(NodoPersonas nuevo){
        nuevo.setSiguiente(cabeza);
        setCabeza(nuevo);
    }

    public void agregarPersona(Persona persona){
        NodoPersonas temp = cabeza;
        while(temp != null){
            persona = temp.getPersona();
            temp = temp.getSiguiente();
        }
    }

    public NodoPersonas buscar(int identificacion){
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

    public void eliminar(NodoPersonas nodo){
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

    public void cambiar(NodoPersonas nodo1, NodoPersonas nodo2){
        NodoPersonas temp = new NodoPersonas();
        temp.compiarNodo(nodo1);
        nodo1.compiarNodo(nodo2);
        nodo2.compiarNodo(temp);
    }

    public void ordenarLista(){
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
