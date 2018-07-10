/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import Logica.IContPaciente;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ninoh
 */
public class ControladorPacientes implements IContPaciente{

    private static ControladorPacientes instancia;
    private ControladorUsuarios User = ControladorUsuarios.getInstance();
    private Map<String, Paciente> pacientes = new HashMap();
    private List<Entidad> entidades = new ArrayList();

    @Override
    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }

    
    public Map<String, Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Map<String, Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public static ControladorPacientes getInstance() {
        if (instancia == null) {
            instancia = new ControladorPacientes();
        }
        return instancia;
    }
    
    public boolean IngresarEntidad(String nom,String mail,List<String> listatel,String dpto,String ciudad,String calle, int nro,String rutaimagen,boolean b){
        Direccion d = new Direccion(ciudad,dpto,calle,nro);
        Entidad e = new Entidad(mail,nom,d,listatel,null,b);
        if (!rutaimagen.equals("")){
            Imagen img = new Imagen(rutaimagen);
            e.setImagen(img);
        }
        try {
            Medico m = (Medico) this.User.getSesionactiva();
            m.getEntidades().add(e);
            m.getEntidadescreadas().add(e);
            persist(e);
            //this.add(e);
            return true;
        } catch(Exception ex){
            return false;
        }
    }
    
    @Override
    public boolean AgregarEntidaddeMedico(long id){
        Medico m = (Medico) this.User.getSesionactiva();
        int i=0;
        while(this.entidades.get(i).getId()!=id){
            i++;
        }
        Entidad e = this.entidades.get(i);
        if (m.getEntidades().contains(e)){
            return false;
        }
        else{
            m.getEntidades().add(e);
            this.commit();
            return true;
        }
    }
    
    @Override
    public boolean BorrarEntidaddeMedico(long id){
        Medico m = (Medico) this.User.getSesionactiva();
        //for (int i=0;i<m.getEntidades().size();i++){
        int i=0;
        while(m.getEntidades().get(i).getId()!=id){
            i++;
        }
        Entidad e = m.getEntidades().get(i);
        if (e.isPrivado()){
            m.getEntidades().remove(i);
            m.getEntidadescreadas().remove(i);
            this.remove(e);
        }
        else{
            m.getEntidades().remove(i);
            this.commit();
        }
        return true;
    }
    
    public void commit(){
        if (!ControladorUsuarios.getEntityManager().getTransaction().isActive())
            ControladorUsuarios.getEntityManager().getTransaction().begin();
        if (ControladorUsuarios.getEntityManager().getTransaction().isActive())
            ControladorUsuarios.getEntityManager().getTransaction().commit();
    }
    
    @Override
    public List<DtEntidad> getDtEntidades(String nom, int n){
        List<DtEntidad> res = new ArrayList();
        Medico m = (Medico) this.User.getSesionactiva();
        if (n==1){
            for (Entidad ee : m.getEntidades()) {
                if (ee.getNombre().toLowerCase().contains(nom.toLowerCase()))
                    res.add(ee.getDatos());
            }
            return res;
        }
        if (n==2){
            this.getEntidadesdeBD();
            for (Entidad ee : this.entidades){
                if (!ee.isPrivado()) {
                    if (ee.getNombre().toLowerCase().contains(nom.toLowerCase())) {
                            res.add(ee.getDatos());
                        }
                    }
                }
            return res;
        }
        if (n==3){
            for (Entidad ee : m.getEntidadescreadas()){
                if (ee.getNombre().toLowerCase().contains(nom.toLowerCase()))
                    res.add(ee.getDatos());
            }
            return res;
        }
        return null;
    }
    
    @Override
    public void EditarEntidad(long id,String nom,String mail,List<String> listatel,String dpto,String ciudad,String calle, int nro,String rutaimagen,boolean b,boolean elimg){
        int i=0;
        while (this.entidades.get(i).getId()!=id){
            i++;
        }
        Entidad e = this.entidades.get(i);
        if (!ControladorUsuarios.getInstance().getEntityManager().getTransaction().isActive())
            ControladorUsuarios.getInstance().getEntityManager().getTransaction().begin();
        if (elimg){
            if (e.getImagen()!=null){
                Query q1 = ControladorUsuarios.getEntityManager().createNativeQuery("UPDATE medicomp.entidad SET imagen_id=null WHERE id='"+id+"';");
                Query q2 = ControladorUsuarios.getEntityManager().createNativeQuery("DELETE FROM medicomp.imagen WHERE id = "+e.getImagen().getId()+";");
                q1.executeUpdate();
                q2.executeUpdate();
                e.setImagen(null);
            }
        }
        if (nom!=""){
            e.setNombre(nom);
        }
        if (mail!=""){
            e.setCorreo(mail);
        }
        if (!listatel.isEmpty()){
            e.setTelefono(listatel);
        }
        if (dpto!=""){
            e.getDireccion().setDepartamento(dpto);
        }
        if (ciudad!=""){
            e.getDireccion().setCiudad(ciudad);
        }
        if (calle!=""){
            e.getDireccion().setCalle(calle);
        }
        if (nro!=0){
            e.getDireccion().setNumero(nro);
        }
        if (!rutaimagen.equals("")){
            e.setImagen(new Imagen(rutaimagen));
        }
        e.setPrivado(b);
        this.commit();
    }
    
    @Override
    public void getPacientesdeBD(){
        List<Paciente> resultado = null;
        if (!ControladorUsuarios.getEntityManager().getTransaction().isActive())
            ControladorUsuarios.getInstance().getEntityManager().getTransaction().begin();
        try {
            resultado = ControladorUsuarios.getEntityManager().createNativeQuery("SELECT * FROM medicomp.paciente ;", Paciente.class).getResultList();
            if (!ControladorUsuarios.getEntityManager().getTransaction().isActive())
                ControladorUsuarios.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            ControladorUsuarios.getEntityManager().getTransaction().rollback();
        }
        if (resultado!=null && !resultado.isEmpty()){
            for (int i=0;i<resultado.size();i++){
                this.getPacientes().put(resultado.get(i).getCi(), resultado.get(i));
            }
        }
    }
    
    
    @Override
    public void getEntidadesdeBD(){
        List<Entidad> resultado = null;
        if (!ControladorUsuarios.getEntityManager().getTransaction().isActive())
            ControladorUsuarios.getInstance().getEntityManager().getTransaction().begin();
        try {
            resultado = ControladorUsuarios.getEntityManager().createNativeQuery("SELECT * FROM medicomp.entidad ;", Entidad.class).getResultList();
            if (!ControladorUsuarios.getEntityManager().getTransaction().isActive())
                ControladorUsuarios.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            ControladorUsuarios.getEntityManager().getTransaction().rollback();
        }
        this.setEntidades(resultado);
    }
    
    @Override
    public boolean verificarDatosP(String ci, String correo) {
        for (Paciente pct : this.pacientes.values()) {
            if (pct.getCi().equals(ci)) {
                return false;
            }

            if (pct.getCorreo().equals(correo)) {
                return false;
            }
        }
        return true;
    }
    
    
    private static class ControladorUsuariosHolder {
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MediCompPU");
        private static final EntityManager em = emf.createEntityManager();
        private static final ControladorUsuarios INSTANCE = new ControladorUsuarios();
    }
    
    public static EntityManager getEntityManager(){
        return ControladorUsuariosHolder.em;
    }
    
    private static EntityManagerFactory EntityManagerFactory(){
        return ControladorUsuariosHolder.emf;
    }
    
    public void remove(Object object) {
        EntityManager em = ControladorUsuarios.getEntityManager();
        if (!em.getTransaction().isActive())
            em.getTransaction().begin();
        try {
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            //em.close();
        }
    }

    public void persist(Object object) {
        EntityManager em = ControladorUsuarios.getEntityManager();
        if (!em.getTransaction().isActive())
            em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            //em.close();
        }
    }
    public void close(){
        ControladorUsuarios.getEntityManager().close();
    }
        
    
    @Override
    public boolean IngresarPaciente(String ci, String nombre, String apellido, String correo, int edad, int telefono, Direccion direccion, String comboTipo, boolean particular, String Img) {
        if (Fabrica.getPaciente().verificarDatosP(ci, correo) == false) { // si ya existe un cliente con ese nickname o correo
            return false;
        } else {
            if (this.verificarDatosP(ci, correo) == false) {
                return false;
            }
        }

        //Si no retorno false antes, entonces los datos están bien
        
        if (Img != null) {
            Imagen img = new Imagen(Img);
            Paciente p = new Paciente(ci, nombre, apellido,correo ,edad,telefono, direccion,comboTipo,particular, img);
            this.pacientes.put(ci, p);
            try {
                persist(img);
                persist(p);
                return true;
            } catch (Exception ex) {
                return false;
            }
        } else {
            Paciente p = new Paciente(ci, nombre, apellido, correo,edad,telefono,direccion,comboTipo,particular);
            this.pacientes.put(ci, p);
            try {
                persist(p);
                return true;
            } catch (Exception ex) {
                return false;
        }

    }

}
}
