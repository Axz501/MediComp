/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author ninoh
 */
public interface IContPaciente {
    public abstract boolean copiarArchivo(String rutaOrigenArchivo, String rutaDestino);    
    public abstract boolean IngresarPaciente(String ci, String nombre, String apellido, String correo, int edad, int telefono, Direccion direccion, String comboTipo, boolean particular, String RutaImagen);
    public abstract boolean verificarDatosP(String ci, String correo);
}
