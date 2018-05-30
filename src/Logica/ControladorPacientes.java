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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ninoh
 */
public class ControladorPacientes implements IContPaciente{

    private static ControladorPacientes instancia;
    private Map<String, Paciente> pacientes = new HashMap();

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
            Paciente p = new Paciente(ci, nombre, apellido,edad,comboTipo,particular, img);
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
