/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Admin
 */
public class ControladorUsuarios {
    
    private ControladorUsuarios() {
    }
    
    public static ControladorUsuarios getInstance() {
        return ControladorUsuariosHolder.INSTANCE;
    }
    
    private static class ControladorUsuariosHolder {
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MediCompPU");
        private static final EntityManager em = emf.createEntityManager();
        private static final ControladorUsuarios INSTANCE = new ControladorUsuarios();
    }
    
    private static EntityManager getEntityManager(){
        return ControladorUsuariosHolder.em;
    }
    
    private static EntityManagerFactory EntityManagerFactory(){
        return ControladorUsuariosHolder.emf;
    }

    public void persist(Object object) {
        EntityManager em = ControladorUsuarios.getEntityManager();
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
    
    public void ingresarusuario(){
        Medico m = new Medico("444","juan","perez","juan@gmail.com","sape","url.jpg");
        Asistente a = new Asistente(false,0,0,"555",m.getNombre(),m.getApellido(),m.getCorreo(),m.getContrasenia(),m.getImagen());
        Direccion d = new Direccion("Soriano","Mercedes","Uruguay",80);
        Date d1=null,d2=null;
        try{
            d1 = new SimpleDateFormat("yyyy-MM-dd").parse("2001-10-20");
            d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2001-10-28");
            }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        Jornada j = new Jornada(d1,d2,d,false,null);
        this.persist(m);
        this.persist(a);
        this.persist(d);
        this.persist(j);
    }
    
    
}
