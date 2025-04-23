/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author Mi PC
 */
public interface DAOListaPrestamos {
    
    public NodoPrestamos ultimoNodo();
    public int contarNodos();
    public void agregarNodo(NodoPrestamos nodo);
    public NodoPrestamos buscar(int codigoPrestamo);
    public NodoPrestamos buscarIdUsuario(int idUsuario);
    public NodoPrestamos buscarPrestamos(int idLibro, int idUsuario);
    public void eliminar(NodoPrestamos nodo);
    public void eliminarLista();
    public void cambiar(NodoPrestamos nodo1, NodoPrestamos nodo2);
    public void ordenarPrestamosCodigos();
    public void ordenarPrestamosFecha();

}
