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
    public abstract void getPacientesdeBD();
    public abstract List<Entidad> getEntidades();
    public abstract Map<String, Paciente> getPacientes();
    public abstract boolean IngresarEntidad(String nom,String mail,List<String> listatel,String dpto,String ciudad,String calle, int nro,String rutaimagen,boolean b);
    public abstract boolean BorrarEntidaddeMedico(long id);
    public abstract boolean AgregarEntidaddeMedico(long id);
    public abstract void getEntidadesdeBD();
    public abstract List<DtEntidad> getDtEntidades(String nom,int n);
    public abstract void EditarEntidad(long id,String nom,String mail,List<String> listatel,String dpto,String ciudad,String calle, int nro,String rutaimagen,boolean b,boolean elimg);

    public abstract ArrayList<Paciente> listarPacientes();
    public abstract List<DtPaciente> listarPacientesMedico(String ci);
    public abstract boolean ModificarPCTP(String ci, String nombre, String apellido, int edad, String telefono, String ciudad, String departamento, String calle, int numero, String comboTipo, boolean particular, String Img, boolean elim);
    public abstract boolean ModificarPCT(String ci, String nombre, String apellido, int edad, String comboTipo, boolean particular, String Img, boolean elim);
    public abstract void AgregarPaciente(String ci);    
    public abstract void BorrarPaciente(String ci);
    public abstract void AgregarEstudio(String nombEst, String nomPro);
    public abstract List<DtEstudio> listarEstudio(String nombre); 
    public abstract List<DtPrototipo> listarPrototipo(String nombre);
    public abstract void getEstudiosBD();
    public abstract void getPrototipoBD();
    public abstract DtEstudio BuscarEstudio(String nombre);
    public abstract boolean ModificarEstudio(Long id, String nombre);
    public abstract DtPrototipo BuscarPrototipo(String informe);
    public abstract boolean ModificarPrototipo(Long id, String informe);
    public abstract boolean EliminarEstudio(String ide);
    public abstract boolean EliminarPrototipo(String idp);
}
