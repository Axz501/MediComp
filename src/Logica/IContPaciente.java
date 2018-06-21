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
    public abstract boolean IngresarPacienteP(String ci, String nombre, String apellido, String correo, int edad, String telefono, Direccion direccion, String comboTipo, boolean particular, String RutaImagen);
    public abstract boolean IngresarPaciente(String ci, String nombre, String apellido, String correo, int edad, String comboTipo, boolean particular, String Img);
    public abstract boolean verificarDatosP(String ci, String correo);
    public abstract ArrayList<Paciente> listarPacientes();
    public abstract List<DtPaciente> listarPacientesMedico(String ci);
    public abstract boolean ModificarPCTP(String ci, String nombre, String apellido, int edad, String telefono, String ciudad, String departamento, String calle, int numero, String comboTipo, boolean particular, String Img, boolean elim);
    public abstract boolean ModificarPCT(String ci, String nombre, String apellido, int edad, String comboTipo, boolean particular, String Img, boolean elim);
    public abstract void AgregarPaciente(String ci);    
    public abstract void getPacientesdeBD();
    public abstract void BorrarPaciente(String ci);
}
