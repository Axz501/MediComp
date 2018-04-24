/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Map;

/**
 *
 * @author ninoh
 */
public interface IContUsuario {
    public abstract boolean copiarArchivo(String rutaOrigenArchivo, String rutaDestino);
    public abstract boolean verificarDatos(String ci, String correo);
    public abstract boolean IngresarMedico(String ci, String contrasenia, String nombre, String apellido, String correo, String Img);
    public abstract boolean IngresarAsistente(boolean renumerado,int horas_trabajadas,int horas_renumeradas,String ci, String nombre, String apellido, String correo, String contrasenia, String Img);
    public abstract boolean login(String ci, String pass);
    public abstract void prueba();
    public abstract void getUsuariosdeBD();
    public abstract boolean enviarcorreo(String correo);
    public abstract String get_SHA_512_SecurePassword(String passwordToHash);
    public abstract Map<String, Usuario> getUsuarios();
    public abstract void setUsuarios(Map<String, Usuario> usuarios);
}