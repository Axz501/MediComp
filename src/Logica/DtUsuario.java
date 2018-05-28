/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Admin
 */
public class DtUsuario {
    
    private String ci;
    private String nombre;
    private String apellido;
    private String correo;
    private Imagen imagen;
    private boolean renumerado;
    private int horas_renum;
    private int horas_trab;

    public DtUsuario(String ci, String nombre, String apellido, String correo, Imagen imagen, boolean renumerado, int horas_renum, int horas_trab) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.imagen = imagen;
        this.renumerado = renumerado;
        this.horas_renum = horas_renum;
        this.horas_trab = horas_trab;
    }

    public DtUsuario(String ci, String nombre, String apellido, String correo, Imagen imagen) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.imagen = imagen;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public boolean isRenumerado() {
        return renumerado;
    }

    public void setRenumerado(boolean renumerado) {
        this.renumerado = renumerado;
    }

    public int getHoras_renum() {
        return horas_renum;
    }

    public void setHoras_renum(int horas_renum) {
        this.horas_renum = horas_renum;
    }

    public int getHoras_trab() {
        return horas_trab;
    }

    public void setHoras_trab(int horas_trab) {
        this.horas_trab = horas_trab;
    }
    
}
