/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mi PC
 */
public class DAOListLibrosImpl implements DAOListaLibros{

    private NodoLibros cabeza;
    private static DAOListLibrosImpl listaLibros;

    public DAOListLibrosImpl(){
        cabeza = null;
        listaLibros = null;
    }

    public static DAOListLibrosImpl getListaLibros(){
        if(listaLibros == null){
            listaLibros = new DAOListLibrosImpl();
        }
        return listaLibros;
    }

    public void setCabeza(NodoLibros cabeza){
        this.cabeza = cabeza;
    }

    public NodoLibros getCabeza(){
        return cabeza;
    }

    @Override
    public NodoLibros ultimo(){
        NodoLibros temp = cabeza;
        while (temp != null){ 
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
        NodoLibros temp = cabeza;
        while(temp != null){
            contador++;
            temp = temp.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean verificarCodigo(int codigo) {
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

    @Override
    public void agregarNodo(NodoLibros nodo) {
        if(cabeza == null){
            setCabeza(nodo);
        }else{
            ultimo().setSiguiente(nodo);
        }
    }

    @Override
    public NodoLibros buscarPorTitulo(String titulo) {
        NodoLibros temp = cabeza;
        while(temp != null){
            if(temp.getLibros().getTitulo().equals(titulo)){
                break;
            }else{
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    @Override
    public NodoLibros buscarPorCodigo(int codigo) {
        NodoLibros temp = cabeza;
        while(temp != null){
            if(temp.getLibros().getCodigo() == codigo){
                break;
            }else{
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    @Override
    public void eliminarNodo(NodoLibros nodo) {
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

    @Override
    public void eliminarLista() {
        while(cabeza != null){
            eliminarNodo(cabeza);
        }
    }

    @Override
    public void cambiar(NodoLibros nodo1, NodoLibros nodo2) {
        NodoLibros temp = new NodoLibros();
        temp.copiarNodo(nodo1);
        nodo1.copiarNodo(nodo2);
        nodo2.copiarNodo(temp);
    }

    @Override
    public void ordenarListTitulos() {
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

    @Override
    public void ordenarListCodigos() {
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
