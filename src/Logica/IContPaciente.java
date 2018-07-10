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
    public abstract boolean IngresarPaciente(String ci, String nombre, String apellido, String correo, int edad, int telefono, Direccion direccion, String comboTipo, boolean particular, String RutaImagen);
    public abstract boolean verificarDatosP(String ci, String correo);
    public abstract void getPacientesdeBD();
    public abstract List<Entidad> getEntidades();
    public abstract Map<String, Paciente> getPacientes();
    public abstract boolean IngresarEntidad(String nom,String mail,List<String> listatel,String dpto,String ciudad,String calle, int nro,String rutaimagen,boolean b);
    public abstract boolean BorrarEntidaddeMedico(long id);
    public abstract boolean AgregarEntidaddeMedico(long id);
    public abstract void getEntidadesdeBD();
    public abstract List<DtEntidad> getDtEntidades(String nom,int n);
    public abstract void EditarEntidad(long id,String nom,String mail,List<String> listatel,String dpto,String ciudad,String calle, int nro,String rutaimagen,boolean b,boolean elimg);

}
