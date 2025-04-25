/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dominio;

/**
 *
 * @author Mi PC
 */
public class Libros {
    
    private String titulo;
    private int codigo;
    private String autor;
    private int cantidad;

    public Libros(){

    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getAutor(){
        return autor;
    }

    public int getCantidad(){
        return cantidad;
    }

}
