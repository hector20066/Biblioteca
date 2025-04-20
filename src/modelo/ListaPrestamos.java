/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ListaPrestamos {
    
    private static ListaPrestamos prestamos;
    private NodoPrestamos cabeza;

    public ListaPrestamos(){
        cabeza = null;
    }

    public static ListaPrestamos getPrestamos(){
        if(prestamos == null){
            prestamos = new ListaPrestamos();
        }
        return prestamos;
    }

    public void setCabeza(NodoPrestamos cabeza){
        this.cabeza = cabeza;
    }

    public NodoPrestamos getCabeza(){
        return cabeza;
    }

    public NodoPrestamos ultimo(){
        NodoPrestamos nodo = cabeza;
        while(nodo != null){
            if(nodo.getSiguiente() == null){
                break;
            }else{
                nodo = nodo.getSiguiente();
            }
        }
        return nodo;
    }

    public int contarNodo(){
        int contador = 0;
        NodoPrestamos nodo = cabeza;
        while(nodo != null){
            contador++;
            nodo = nodo.getSiguiente();
        }
        return contador;
    }

    public boolean verificarExistencia(int codigo){
        NodoPrestamos nodo = cabeza;
        while(nodo != null){
            if(nodo.getPrestamos().getCodigo() == codigo){
                return true;
            }else{
                nodo = nodo.getSiguiente();
            }
        }
        return false;
    }

    public void agragarPrestamo(NodoPrestamos nuevo){
        if(cabeza == null){
            setCabeza(nuevo);
        }else{
            ultimo().setSiguiente(nuevo);
        }
    }

    public void agregarCabeza(NodoPrestamos nodo){
        nodo.setSiguiente(cabeza);
        setCabeza(nodo);
    }

    public NodoPrestamos buscar(int codigo){
        NodoPrestamos nodo = cabeza;
        while(nodo != null){
            if(nodo.getPrestamos().getCodigo() == codigo){
                break;
            }else{
                nodo = nodo.getSiguiente();
            }
        }
        return nodo;
    }

    public NodoPrestamos buscarPrestamo(int idLibro, int idPersona){
        NodoPrestamos nodo = cabeza;
        while(nodo != null){
            if((nodo.getPrestamos().getIdLibros() == idLibro) && (nodo.getPrestamos().getIdPersona() == idPersona)){
                break;
            }else{
                nodo = nodo.getSiguiente();
            }
        }
        return nodo;
    }

    public void eliminar(NodoPrestamos nodo){
        NodoPrestamos anterior;
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

    public void eliminarLista(){
        while(cabeza != null){
            eliminar(cabeza);
        }
    }

    public void cambiar(NodoPrestamos nodo1, NodoPrestamos nodo2){
        NodoPrestamos temp = new NodoPrestamos();
        temp.copiarNodo(nodo1);
        nodo1.copiarNodo(nodo2);
        nodo2.copiarNodo(temp);
    }

    public void ordenarListaCodigo(){
        NodoPrestamos ni;
        NodoPrestamos nj;
        ni = cabeza;
        while(ni != null){
            nj = ni.getSiguiente();
            while(nj != null){
                if(ni.getPrestamos().getCodigo() > nj.getPrestamos().getCodigo()){
                    cambiar(ni, nj);
                }
                nj = nj.getSiguiente();
            }
            ni = ni.getSiguiente();
        }
    }

    public void ordenarListaFecha(){
        NodoPrestamos ni;
        NodoPrestamos nj;
        ni = cabeza;
        while(ni != null){
            nj = ni.getSiguiente();
            while(nj != null){
                if(ni.getPrestamos().getFechaPrestamo().compareTo(nj.getPrestamos().getFechaPrestamo()) > 0){
                    cambiar(ni, nj);
                }
                nj = nj.getSiguiente();
            }
        }
    }
    
    public boolean verificarExistencia(int idLibro, int idPersona){
        NodoPrestamos temp = cabeza;
        while(temp != null){
            if((temp.getPrestamos().getIdLibros() == idLibro) && (temp.getPrestamos().getIdPersona() == idPersona)){
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

}
