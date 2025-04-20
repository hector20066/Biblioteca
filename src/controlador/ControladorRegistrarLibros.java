/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Libros;
import modelo.ListaLibros;
import modelo.NodoLibros;
import vistas.RegistrarLibros;

/**
 *
 * @author Mi PC
 */
public class ControladorRegistrarLibros implements ActionListener{
    
    private RegistrarLibros registrarLibros;
    
    ListaLibros listaLibros = ListaLibros.getListaLibros();
    
    public ControladorRegistrarLibros(RegistrarLibros registrarLibros){
        this.registrarLibros = registrarLibros;
        
        this.registrarLibros.getBtn_aceptar().addActionListener(this);
        this.registrarLibros.getBtn_guardar().addActionListener(this);
        
        cargarDatos();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource() == registrarLibros.getBtn_aceptar()){
            aceptar();
        }else{
            if(evento.getSource() == registrarLibros.getBtn_guardar()){
                guardar();
            }
        }
    }
    
    private void llenar(NodoLibros nodo){
        String titulo = registrarLibros.getTxt_titulo().getText();
        int codigo = Integer.parseInt(registrarLibros.getTxt_codigo().getText());
        String autor = registrarLibros.getTxt_autor().getText();
        int cantidad = Integer.parseInt(registrarLibros.getTxt_cantDisponible().getText());
        
        Libros libros = new Libros();
        libros.setCodigo(codigo);
        libros.setTitulo(titulo);
        libros.setAutor(autor);
        libros.setCantidad(cantidad);
        nodo.setLibros(libros);
    }
    
    private void cargarDatos(){
        registrarLibros.getModelo().setRowCount(0);
    }
    
    private void guardar(){
        try{
            
        }catch(Exception e){
            
        }
    }
    
    private void aceptar(){
        try{
            
        }catch(Exception e){
            
        }
    }
    
}
