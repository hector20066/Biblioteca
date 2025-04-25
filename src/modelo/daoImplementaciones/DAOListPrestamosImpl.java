/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.daoImplementaciones;

import modelo.daoInterfaces.DAOListaPrestamos;
import modelo.nodos.NodoPrestamos;

/**
 *
 * @author Mi PC
 */
public class DAOListPrestamosImpl implements DAOListaPrestamos{

    private NodoPrestamos cabeza;
    private static DAOListPrestamosImpl listaPrestamos;

    public DAOListPrestamosImpl(){
        cabeza = null;
        listaPrestamos = null;
    }

    public static DAOListPrestamosImpl getListaPrestamos(){
        if(listaPrestamos == null){
            listaPrestamos = new DAOListPrestamosImpl();
        }
        return listaPrestamos;
    }

    @Override
    public void setCabeza(NodoPrestamos cabeza) {
        this.cabeza = cabeza;
    }

    @Override
    public NodoPrestamos getCabeza() {
        return cabeza;
    }

    @Override
    public NodoPrestamos ultimoNodo() {
        NodoPrestamos temp = cabeza;
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
        NodoPrestamos temp = cabeza;
        while(temp != null){
            contador++;
            temp = temp.getSiguiente();
        }
        return contador;
    }

    @Override
    public void agregarNodo(NodoPrestamos nodo) {
        if(cabeza == null){
            setCabeza(nodo);
        }else{
            ultimoNodo().setSiguiente(nodo);
        }
    }

    @Override
    public NodoPrestamos buscar(int codigoPrestamo) {
        NodoPrestamos temp = cabeza;
        while(temp != null){
            if(temp.getPrestamos().getCodigo() == codigoPrestamo){
                break;
            }else{
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    @Override
    public NodoPrestamos buscarIdUsuario(int idUsuario) {
        NodoPrestamos temp = cabeza;
        while(temp != null){
            if(temp.getPrestamos().getIdPersona() == idUsuario){
                break;
            }else{
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    @Override
    public NodoPrestamos buscarPrestamos(int idLibro, int idUsuario) {
        NodoPrestamos temp = cabeza;
        while(temp != null){
            if((temp.getPrestamos().getIdLibros() == idLibro) && (temp.getPrestamos().getIdPersona() == idUsuario)){
                break;
            }else{
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    @Override
    public void eliminarNodo(NodoPrestamos nodo) {
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

    @Override
    public void eliminarLista() {
        while(cabeza != null){
            eliminarNodo(cabeza);
        }
    }

    @Override
    public void cambiar(NodoPrestamos nodo1, NodoPrestamos nodo2) {
        NodoPrestamos temp = new NodoPrestamos();
        temp.copiarNodo(nodo1);
        nodo1.copiarNodo(nodo2);
        nodo2.copiarNodo(temp);
    }

    @Override
    public void ordenarPrestamosCodigos() {
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

    @Override
    public void ordenarPrestamosFecha() {
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
            ni = ni.getSiguiente();
        }
    }
    
}
