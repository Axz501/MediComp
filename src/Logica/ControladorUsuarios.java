/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Logica.Fabrica;
import Logica.IContUsuario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Admin
 */
public class ControladorUsuarios  implements IContUsuario{
    
    private static ControladorUsuarios instancia;
    private Map<String, Usuario> usuarios = new HashMap();
    private Usuario sesionactiva;

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Map<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    

    public Usuario getSesionactiva() {
        return sesionactiva;
    }

    public void setSesionactiva(Usuario sesionactiva) {
        this.sesionactiva = sesionactiva;
    }
    
    
    
    public static ControladorUsuarios getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        return instancia;
    }

//    public static ControladorUsuarios getInstance() {
//        return ControladorUsuariosHolder.INSTANCE;
//    }

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
    @Override
    public boolean copiarArchivo(String rutaOrigenArchivo, String rutaDestino) {
        try {
            File archivoOrigen = new File(rutaOrigenArchivo);

            //Archivo de destino auxiliar
            File dest = new File(rutaDestino);

            //Crea las carpetas en donde va a ser guardado el tema si no estaban creadas todavia
            dest.getParentFile().mkdirs();

            //Crea el archivo auxiliar primero para despues sobreescribirlo, sino da error
            dest.createNewFile();

            //Copiar el archivo seleccionado al destino
            Files.copy(archivoOrigen.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            return true; // Se pudo copiar la imagen correctamente
        } catch (IOException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);

            return false; // Error, no se pudo copiar la imagen
        }
    }
    
    @Override
    public boolean login(String ci, String pass){
        for (Usuario u : this.usuarios.values()) {
            if (u.getCi().equals(ci) && u.getContrasenia().equals(pass)){
                this.setSesionactiva(u);
                return true;
            }
            if (u.getCorreo().equals(ci) && u.getContrasenia().equals(pass)){
                this.setSesionactiva(u);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean verificarDatos(String ci, String correo) {
        for (Usuario usr : this.usuarios.values()) {
            if (usr.getCi().equals(ci)) {
                return false; 
            }

            if (usr.getCorreo().equals(correo)) {
                return false; 
            }
        }
        return true;
    }
        
    @Override
    public boolean IngresarMedico(String ci, String nombre, String apellido, String correo, String contrasenia, String Img) {
        if (Fabrica.getUsuario().verificarDatos(ci, correo) == false) { // si ya existe un cliente con ese nickname o correo
            return false;
        } else {
            if (this.verificarDatos(ci, correo) == false) {
                return false;
            }
        }

        //Si no retorno false antes, entonces los datos están bien
        if (Img != null) {
            //Divide el string por el punto, tambien elimina el punto
            String[] aux = Img.split("\\."); // al punto(.) se le agregan las dos barras (\\) porque es un caracter especial

            //toma la segunda parte porque es la extension
            //Ej. "C:\Imagenes\imagen.jpg" -> aux[0] = "C:\Imagenes\imagen" y aux[1] = "jpg"
            String extension = aux[1];

            //Ruta donde se va a copiar el archivo de imagen
            String rutaDestino = "Imagenes/Usuarios/Medicos/" + ci + "." + extension; // se le agrega el punto(.) porque la hacer el split tambien se borra

            //esa funcion retorna un booleano que indica si la imagen se pudo crear correctamente
            //la funcion ya esta definida en el controlador de cliente porque ahi se usa, entocnces no hay que declararla otra vez en este controlador
            if (Fabrica.getUsuario().copiarArchivo(Img, rutaDestino) == true) {
                Img = rutaDestino; //la ruta que hay que guardar es la del archivo nuevo que fue copiado dentro del servidor
            } else {
                Img = null; // no se pudo copiar la imagen, queda en null
            }
        }

        Medico m = new Medico(ci, contrasenia, nombre, apellido, correo, new Imagen(Img));
        try{
        persist(m);
        return true;
        } catch(Exception ex){
        return false;
        }
        
    }
    
    @Override
    public boolean IngresarAsistente(boolean renumerado,int horas_trabajadas,int horas_renumeradas,String ci, String nombre, String apellido, String correo, String contrasenia, String Img) {
        if (Fabrica.getUsuario().verificarDatos(ci, correo) == false) { // si ya existe un cliente con ese nickname o correo
            return false;
        } else {
            if (this.verificarDatos(ci, correo) == false) {
                return false;
            }
        }

        //Si no retorno false antes, entonces los datos están bien
        if (Img != null) {
            //Divide el string por el punto, tambien elimina el punto
            String[] aux = Img.split("\\."); // al punto(.) se le agregan las dos barras (\\) porque es un caracter especial

            //toma la segunda parte porque es la extension
            //Ej. "C:\Imagenes\imagen.jpg" -> aux[0] = "C:\Imagenes\imagen" y aux[1] = "jpg"
            String extension = aux[1];

            //Ruta donde se va a copiar el archivo de imagen
            String rutaDestino = "Imagenes/Usuarios/Asistente/" + ci + "." + extension; // se le agrega el punto(.) porque la hacer el split tambien se borra

            //esa funcion retorna un booleano que indica si la imagen se pudo crear correctamente
            //la funcion ya esta definida en el controlador de cliente porque ahi se usa, entocnces no hay que declararla otra vez en este controlador
            if (Fabrica.getUsuario().copiarArchivo(Img, rutaDestino) == true) {
                Img = rutaDestino; //la ruta que hay que guardar es la del archivo nuevo que fue copiado dentro del servidor
            } else {
                Img = null; // no se pudo copiar la imagen, queda en null
            }
        }

        Asistente a = new Asistente(renumerado,horas_trabajadas,horas_renumeradas,ci, contrasenia, nombre, apellido, correo, new Imagen(Img));
        try{
        persist(a);
        return true;
        } catch(Exception ex){
        return false;
        }
        
    }
    
    @Override
    public void getUsuariosdeBD(){
        List<Usuario> resultado = null;
        ControladorUsuarios.getInstance().getEntityManager().getTransaction().begin();
        try {
            resultado = ControladorUsuarios.getEntityManager().createNativeQuery("SELECT * FROM usuario ;", Usuario.class).getResultList();
            ControladorUsuarios.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            ControladorUsuarios.getEntityManager().getTransaction().rollback();
        }
        //this.setClientes(clientes);
        if (resultado!=null && !resultado.isEmpty()){
            for (int i=0;i<resultado.size();i++){
                this.getUsuarios().put(resultado.get(i).getCi(), resultado.get(i));
            }
        }
    }
    @Override
    public void prueba(){
        Imagen i = new Imagen("123.jpg");
        Medico m = new Medico("45678","Cosme","fulanito","hola@gmail.com","123456789",i);
        Asistente a = new Asistente(false,0,0,"5555","Juan","Perez","juan2@gmail.com","123456789",i);
        persist(i);
        persist(m);
        persist(a);
    }
    
    
}
