/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;

/**
 *
 * @author Admin
 */
public class DtEntidad {
    
    private long id;
    private String correo;
    private String nombre;
    private Imagen imagen;
    private Direccion direccion;
    private List<String> telefono;
    private boolean privado;

    public DtEntidad(long id,String correo, String nombre, Imagen imagen, Direccion direccion, List<String> telefono, boolean p) {
        this.correo = correo;
        this.nombre = nombre;
        this.imagen = imagen;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id = id;
        this.privado = p;
    }

    public boolean isPrivado() {
        return privado;
    }

    public long getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }
    
    public String getTelefonosString(){
        String x = "";
        for (String s : telefono){
           x = x + s + ';'; 
        }
        return x;
    }

    public String getNombre() {
        return nombre;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public List<String> getTelefono() {
        return telefono;
    }
    
}
