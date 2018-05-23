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
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Admin
 */
public class ControladorUsuarios  implements IContUsuario{
    
    private static ControladorUsuarios instancia;
    private Map<String, Usuario> usuarios = new HashMap();
    private Usuario sesionactiva;

    @Override
    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public void setUsuarios(Map<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    

    @Override
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
    
    public static EntityManager getEntityManager(){
        return ControladorUsuariosHolder.em;
    }
    
    private static EntityManagerFactory EntityManagerFactory(){
        return ControladorUsuariosHolder.emf;
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
        String pass2 = this.get_SHA_512_SecurePassword(pass);
        for (Usuario u : this.usuarios.values()) {
            if (u.getCi().equals(ci) && u.getContrasenia().equals(pass2)){
                this.setSesionactiva(u);
                return true;
            }
            if (u.getCorreo().equals(ci) && u.getContrasenia().equals(pass2)){
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
        
        String passhash = this.get_SHA_512_SecurePassword(contrasenia);

        //Si no retorno false antes, entonces los datos están bien
        if (Img != null) {
            //Divide el string por el punto, tambien elimina el punto
//            String[] aux = Img.split("\\."); // al punto(.) se le agregan las dos barras (\\) porque es un caracter especial
//
//            //toma la segunda parte porque es la extension
//            //Ej. "C:\Imagenes\imagen.jpg" -> aux[0] = "C:\Imagenes\imagen" y aux[1] = "jpg"
//            String extension = aux[1];
//
//            //Ruta donde se va a copiar el archivo de imagen
//            String rutaDestino = "Imagenes/Usuarios/Medicos/" + ci + "." + extension; // se le agrega el punto(.) porque la hacer el split tambien se borra
//
//            //esa funcion retorna un booleano que indica si la imagen se pudo crear correctamente
//            //la funcion ya esta definida en el controlador de cliente porque ahi se usa, entocnces no hay que declararla otra vez en este controlador
//            if (Fabrica.getUsuario().copiarArchivo(Img, rutaDestino) == true) {
//                Img = rutaDestino; //la ruta que hay que guardar es la del archivo nuevo que fue copiado dentro del servidor
//            } else {
//                Img = null; // no se pudo copiar la imagen, queda en null
//            }
            Imagen img = new Imagen(Img);
            Medico m = new Medico(ci, nombre, apellido, correo,passhash ,img);
            this.usuarios.put(ci, m);
            try {
                persist(img);
                persist(m);
                return true;
            } catch (Exception ex) {
                return false;
            }
        } else {
            Medico m = new Medico(ci, passhash, nombre, apellido, correo);
            this.usuarios.put(ci, m);
            try {
                persist(m);
                return true;
            } catch (Exception ex) {
                return false;
            }
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
        
        String passhash = this.get_SHA_512_SecurePassword(contrasenia);

        //Si no retorno false antes, entonces los datos están bien
        if (Img != null) {
            //Divide el string por el punto, tambien elimina el punto
//            String[] aux = Img.split("\\."); // al punto(.) se le agregan las dos barras (\\) porque es un caracter especial
//
//            //toma la segunda parte porque es la extension
//            //Ej. "C:\Imagenes\imagen.jpg" -> aux[0] = "C:\Imagenes\imagen" y aux[1] = "jpg"
//            String extension = aux[1];
//
//            //Ruta donde se va a copiar el archivo de imagen
//            String rutaDestino = "Imagenes/Usuarios/Asistente/" + ci + "." + extension; // se le agrega el punto(.) porque la hacer el split tambien se borra
//
//            //esa funcion retorna un booleano que indica si la imagen se pudo crear correctamente
//            //la funcion ya esta definida en el controlador de cliente porque ahi se usa, entocnces no hay que declararla otra vez en este controlador
//            if (Fabrica.getUsuario().copiarArchivo(Img, rutaDestino) == true) {
//                Img = rutaDestino; //la ruta que hay que guardar es la del archivo nuevo que fue copiado dentro del servidor
//            } else {
//                Img = null; // no se pudo copiar la imagen, queda en null
//            }
            Imagen img = new Imagen(Img);
            Asistente a = new Asistente(renumerado, horas_trabajadas, horas_renumeradas, ci, nombre, apellido, correo,passhash, img);
            this.usuarios.put(ci, a);
            try {
                persist(img);
                persist(a);
                return true;
            } catch (Exception ex) {
                return false;
            }
        } else {
            Asistente a = new Asistente(renumerado, horas_trabajadas, horas_renumeradas, ci, passhash, nombre, apellido, correo);
            this.usuarios.put(ci, a);
            try {
                persist(a);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }
    @Override
    public boolean enviarcorreo(String correo){
        String gen = new RandomString(9, ThreadLocalRandom.current()).nextString();
        String nuevapass = this.get_SHA_512_SecurePassword(gen);
        if(!this.verificarDatos(correo, correo)){ //usamos el verificardatos a la inversa
            Iterator it = this.usuarios.values().iterator();
            while (it.hasNext()){
                Usuario u = (Usuario) it.next();
                if (u.getCorreo().equals(correo)){
                    u.setContrasenia(nuevapass);
                    break;
                }
            }
            try {
                ControladorUsuarios.getEntityManager().getTransaction().begin();
                Query q = ControladorUsuarios.getEntityManager().createNativeQuery("UPDATE medicomp.usuario SET contrasenia='"+nuevapass+"' WHERE correo='"+correo+"';");
                q.executeUpdate();
                ControladorUsuarios.getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                ControladorUsuarios.getEntityManager().getTransaction().rollback();
            }
            try {
                SendEmail.EnviarCorreo(correo,gen);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void getUsuariosdeBD(){
        List<Usuario> resultado = null;
        ControladorUsuarios.getInstance().getEntityManager().getTransaction().begin();
        try {
            resultado = ControladorUsuarios.getEntityManager().createNativeQuery("SELECT * FROM medicomp.usuario ;", Usuario.class).getResultList();
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
    
    public List<Asistente> getAsistentes(){
        List<Asistente> asis = new ArrayList();
        Iterator it = this.usuarios.entrySet().iterator();
        while (it.hasNext()){
            Usuario u = (Usuario) it.next();
            if (u instanceof Asistente){
                Asistente a = (Asistente) u;
                asis.add(a);
            }
        }
        return asis;
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
    
    @Override
    public String get_SHA_512_SecurePassword(String passwordToHash){
        String salt = "ok";
        String generatedPassword = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    public boolean ModificarUSR(String nombre,String apellido,String contrasenia, String RutaImagen, boolean elim){
        if (!ControladorUsuarios.getInstance().getEntityManager().getTransaction().isActive())
            ControladorUsuarios.getInstance().getEntityManager().getTransaction().begin();
        try{
            Usuario u = this.getSesionactiva();
            if (elim){
                if (u.getImagen()!=null){
                    Long id = u.getImagen().getId();
                    Query q1 = ControladorUsuarios.getEntityManager().createNativeQuery("UPDATE medicomp.usuario SET imagen_id=null WHERE correo='"+u.getCorreo()+"';");
                    Query q2 = ControladorUsuarios.getEntityManager().createNativeQuery("DELETE FROM medicomp.imagen WHERE id = "+id+";");
                    q1.executeUpdate();
                    q2.executeUpdate();
                    u.setImagen(null);
                }
            }
            if (!nombre.equals("")) {
                Query q = ControladorUsuarios.getEntityManager().createNativeQuery("UPDATE medicomp.usuario SET nombre='"+nombre+"' WHERE correo='"+u.getCorreo()+"';");
                q.executeUpdate();
                u.setNombre(nombre);
            }
            if (!apellido.equals("")) {
                Query q = ControladorUsuarios.getEntityManager().createNativeQuery("UPDATE medicomp.usuario SET apellido='"+apellido+"' WHERE correo='"+u.getCorreo()+"';");
                q.executeUpdate();
                u.setApellido(apellido);
            }
            if (!contrasenia.equals("")) {
                String nuevapas = this.get_SHA_512_SecurePassword(contrasenia);
                Query q = ControladorUsuarios.getEntityManager().createNativeQuery("UPDATE medicomp.usuario SET contrasenia='"+nuevapas+"' WHERE correo='"+u.getCorreo()+"';");
                q.executeUpdate();
                u.setContrasenia(nuevapas);
            }
            if (!RutaImagen.equals("")) {
                if (u.getImagen()!=null){
                    Long id = u.getImagen().getId();
                    Query q1 = ControladorUsuarios.getEntityManager().createNativeQuery("UPDATE medicomp.usuario SET imagen_id=null WHERE correo='"+u.getCorreo()+"';");
                    Query q2 = ControladorUsuarios.getEntityManager().createNativeQuery("DELETE FROM medicomp.imagen WHERE id = "+id+";");
                    q1.executeUpdate();
                    q2.executeUpdate();
                }
                Imagen i = new Imagen(RutaImagen);
                u.setImagen(i);
                this.persist(i);
            }
        if (ControladorUsuarios.getInstance().getEntityManager().getTransaction().isActive())
            ControladorUsuarios.getInstance().getEntityManager().getTransaction().commit();
        return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public ArrayList<Asistente> listarAsistentes() {
        ArrayList<Asistente> retornar = new ArrayList<>();
        for(Map.Entry<String,Usuario> u : usuarios.entrySet()){
            if(u.getValue() instanceof Asistente){
            retornar.add(((Asistente) u.getValue()).getDatos());
        }}
        return retornar;

    }
    
     public ArrayList<Asistente> BuscarAsistente(String ci) {
        ArrayList<Asistente> retornar = new ArrayList<>();
        Iterator iterador = this.usuarios.values().iterator();
        if (ci.equals("") == false) {
             for(Map.Entry<String,Usuario> u : usuarios.entrySet()){
            if(u.getValue() instanceof Asistente){
                if (u.getValue().getCi().startsWith(ci) == true) {
                    retornar.add(((Asistente) u.getValue()).getDatos());
                }
            }
             }

        } else {
            System.out.println("campo vacio");
        }

        return retornar;
    }
    public Asistente BuscarAsist(String correo) {

        if (correo.equals("") == false) {
             for(Map.Entry<String,Usuario> u : usuarios.entrySet()){
            if(u.getValue() instanceof Asistente){
                if (u.getValue().getCorreo().equals(correo)) {
                    return ((Asistente) u.getValue());
                }
            }
             }

        } else {
            System.out.println("no existe");
        }

        return null;
    }
}
