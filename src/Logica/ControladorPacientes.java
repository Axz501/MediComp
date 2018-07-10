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
import java.util.Date;
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
    private final ControladorUsuarios User = ControladorUsuarios.getInstance();
    private Map<String, Paciente> pacientes = new HashMap();
    private List<Entidad> entidades = new ArrayList();

    @Override
    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }

    private final Map<Long, NombredeEstudio> estudios = new HashMap();
    private final Map<Long, Prototipo> prototipos = new HashMap();
    
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
            persist(e);
            m.getEntidades().add(e);
            m.getEntidadescreadas().add(e);
            this.commit();
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
    
    public Map<Long, NombredeEstudio> getEstudios(){
        return estudios;
    }
    
    public Map<Long, Prototipo> getPrototipos(){
        return prototipos;
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


    private static class ControladorPacientesHolder {
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MediCompPU");
        private static final EntityManager em = emf.createEntityManager();
        private static final ControladorPacientes INSTANCE = new ControladorPacientes();
    }
    
    public static EntityManager getEntityManager(){
        return ControladorPacientesHolder.em;
    }
    
    private static EntityManagerFactory EntityManagerFactory(){
        return ControladorPacientesHolder.emf;
    }
    
    public void remove(Object object) {
        EntityManager em = ControladorPacientes.getEntityManager();
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
        EntityManager em = ControladorPacientes.getEntityManager();
        if (!em.getTransaction().isActive())
            em.getTransaction().begin();
        try {
            em.persist(object);
            //if (!em.getTransaction().isActive())
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            //em.close();
        }
    }
    public void close(){
        ControladorPacientes.getEntityManager().close();
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
            Logger.getLogger(ControladorPacientes.class.getName()).log(Level.SEVERE, null, ex);

            return false; // Error, no se pudo copiar la imagen
        }
    }
    
//    @Override
//    public void getPacientesdeBD(){
//        List<Paciente> resultado = null;
//        ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
//        try {
//            resultado = ControladorPacientes.getEntityManager().createNativeQuery("SELECT * FROM medicomp.paciente ;", Paciente.class).getResultList();
//            ControladorPacientes.getEntityManager().getTransaction().commit();
//        } catch (Exception e) {
//            ControladorPacientes.getEntityManager().getTransaction().rollback();
//        }
//        if (resultado!=null && !resultado.isEmpty()){
//            for (int i=0;i<resultado.size();i++){
//                this.getPacientes().put(resultado.get(i).getCi(), resultado.get(i));
//            }
//        }
//    }
    
    @Override
    public List<DtPaciente> getPacientesMedico(String nom){
        Medico m = (Medico) this.User.getSesionactiva();
        List<DtPaciente> retornar = new ArrayList();
        for(Paciente p : m.getPacientes()){
            if (p.getNombre().toLowerCase().contains(nom.toLowerCase()))
                retornar.add(p.getDatos());
        }
        return retornar;
    }
    
     @Override
    public void getEstudiosBD(){
        List<NombredeEstudio> resultado = null;
        if (!ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive())
            ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
        try {
            resultado = ControladorPacientes.getEntityManager().createNativeQuery("SELECT * FROM medicomp.nombredeestudio ;", NombredeEstudio.class).getResultList();
            ControladorPacientes.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            ControladorPacientes.getEntityManager().getTransaction().rollback();
        }
        if (resultado!=null && !resultado.isEmpty()){
            for (int i=0;i<resultado.size();i++){
                this.getEstudios().put(resultado.get((int) i).getId(), resultado.get((int) i));
            }
        }
    }
     @Override
    public void getPrototipoBD(){
        List<Prototipo> resultado = null;
        if (!ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive())
            ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
        try {
            resultado = ControladorPacientes.getEntityManager().createNativeQuery("SELECT * FROM medicomp.prototipo ;", Prototipo.class).getResultList();
            ControladorPacientes.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            ControladorPacientes.getEntityManager().getTransaction().rollback();
        }
        if (resultado!=null && !resultado.isEmpty()){
            for (int i=0;i<resultado.size();i++){
                this.getPrototipos().put(resultado.get((int) i).getId(), resultado.get((int) i));
            }
        }
    }
    @Override
    public boolean IngresarPacienteP(String ci, String nombre, String apellido, String correo, int edad, String telefono, Direccion direccion, String comboTipo, boolean particular, String Img) {
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
    @Override
    public boolean IngresarPaciente(String ci, String nombre, String apellido, String correo, int edad, String comboTipo, boolean particular, String Img) {
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
            Paciente p = new Paciente(ci, nombre, apellido,correo ,edad,comboTipo,particular, img);
            this.pacientes.put(ci, p);
            try {
                persist(img);
                persist(p);
                return true;
            } catch (Exception ex) {
                return false;
            }
        } else {
            Paciente p = new Paciente(ci, nombre, apellido, correo,edad,comboTipo,particular);
            this.pacientes.put(ci, p);
            try {
                persist(p);
                return true;
            } catch (Exception ex) {
                return false;
        }

    }
}
    @Override
    public List<DtPaciente> listarPacientesMedico(String ci) {
        List<DtPaciente> retornar = new ArrayList<>();
        Medico m = (Medico) User.getSesionactiva();
        for (Paciente pac : m.getPacientes()) {
            if (pac.getCi().toLowerCase().contains(ci.toLowerCase()) || pac.getNombre().toLowerCase().contains(ci.toLowerCase()) || pac.getApellido().toLowerCase().contains(ci.toLowerCase())) {
                retornar.add(pac.getDatos());
            }
        }
        return retornar;
    }
    @Override
        public ArrayList<Paciente> listarPacientes() {
        ArrayList<Paciente> retornar = new ArrayList<>();
        for(Map.Entry<String,Paciente> p : pacientes.entrySet()){
            retornar.add((Paciente) p.getValue());
        }
        return retornar;

    }
    @Override
        public boolean ModificarPCTP(String ci, String nombre, String apellido, int edad, String telefono, String ciudad, String departamento, String calle, int numero, String comboTipo, boolean particular, String Img, boolean elim){
        if (!ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive())
            ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
        try{
            Paciente p = this.pacientes.get(ci);
            if (elim){
                if (p.getImagen()!=null){
                    Long id = p.getImagen().getId();
                    Query q1 = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET imagen_id=null WHERE correo='"+p.getCorreo()+"';");
                    Query q2 = ControladorPacientes.getEntityManager().createNativeQuery("DELETE FROM medicomp.imagen WHERE id = "+id+";");
                    q1.executeUpdate();
                    q2.executeUpdate();
                    p.setImagen(null);
                }
            }
            if (!nombre.equals("")) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET nombre='"+nombre+"' WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setNombre(nombre);
            }
            if (!apellido.equals("")) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET apellido='"+apellido+"' WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setApellido(apellido);
            }
            if (edad != 0) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET edad='"+edad+"' WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setEdad(edad);
            }
            if (!telefono.equals("")) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET telefono='"+telefono+"' WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setTelefono(telefono);
            }
            if (!ciudad.equals("")) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.direccion SET ciudad='"+ciudad+"' WHERE id='"+p.getDireccion().getId()+"';");
                q.executeUpdate();
                p.getDireccion().setCiudad(ciudad);
            }
            if (!departamento.equals("")) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.direccion SET departamento='" +departamento+ "' WHERE id='" + p.getDireccion().getId() + "';");
                q.executeUpdate();
                p.getDireccion().setDepartamento(departamento);
            }
            if (!calle.equals("")) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.direccion SET calle='" +calle+ "' WHERE id='" + p.getDireccion().getId() + "';");
                q.executeUpdate();
                p.getDireccion().setCalle(calle);
            }
            if (numero != 0) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.direccion SET numero='" +numero+ "' WHERE id='" + p.getDireccion().getId() + "';");
                q.executeUpdate();
                p.getDireccion().setNumero(numero);
            }
            if (!comboTipo.equals("")) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET genero='"+comboTipo+"' WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setGenero(comboTipo);
            }
            if (!particular) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET particular=false WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setParticular(particular);
            }else{
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET particular=true WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setParticular(particular);
            }
            if (!Img.equals("")) {
                if (p.getImagen()!=null){
                    Long id = p.getImagen().getId();
                    Query q1 = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET imagen_id=null WHERE correo='"+p.getCorreo()+"';");
                    Query q2 = ControladorPacientes.getEntityManager().createNativeQuery("DELETE FROM medicomp.imagen WHERE id = "+id+";");
                    q1.executeUpdate();
                    q2.executeUpdate();
                }
                Imagen i = new Imagen(Img);
                p.setImagen(i);
                this.persist(i);
            }
        if (ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive())
            ControladorPacientes.getInstance().getEntityManager().getTransaction().commit();
        return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    @Override
        public boolean ModificarPCT(String ci, String nombre, String apellido, int edad, String comboTipo, boolean particular, String Img, boolean elim){
        if (!ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive())
            ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
        try{
            Paciente p = this.pacientes.get(ci);
            if (elim){
                if (p.getImagen()!=null){
                    Long id = p.getImagen().getId();
                    Query q1 = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET imagen_id=null WHERE correo='"+p.getCorreo()+"';");
                    Query q2 = ControladorPacientes.getEntityManager().createNativeQuery("DELETE FROM medicomp.imagen WHERE id = "+id+";");
                    q1.executeUpdate();
                    q2.executeUpdate();
                    p.setImagen(null);
                }
            }
            if (!nombre.equals("")) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET nombre='"+nombre+"' WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setNombre(nombre);
            }
            if (!apellido.equals("")) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET apellido='"+apellido+"' WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setApellido(apellido);
            }
            if (edad != 0) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET edad='"+edad+"' WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setEdad(edad);
            }
            if (!comboTipo.equals("")) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET genero='"+comboTipo+"' WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setGenero(comboTipo);
            }
            if (!particular) {
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET particular=false WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setParticular(particular);
            }else{
                Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET particular=true WHERE correo='"+p.getCorreo()+"';");
                q.executeUpdate();
                p.setParticular(particular);
            }
            if (!Img.equals("")) {
                if (p.getImagen()!=null){
                    Long id = p.getImagen().getId();
                    Query q1 = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.paciente SET imagen_id=null WHERE correo='"+p.getCorreo()+"';");
                    Query q2 = ControladorPacientes.getEntityManager().createNativeQuery("DELETE FROM medicomp.imagen WHERE id = "+id+";");
                    q1.executeUpdate();
                    q2.executeUpdate();
                }
                Imagen i = new Imagen(Img);
                p.setImagen(i);
                this.persist(i);
            }
        if (ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive())
            ControladorPacientes.getInstance().getEntityManager().getTransaction().commit();
        return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    @Override
    public void AgregarPaciente(String ci){
        Medico m = (Medico) User.getSesionactiva();
        Paciente p = (Paciente) this.pacientes.get(ci);
        m.AgregarPaciente(p);

        
        if (!ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
            ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
        }

        if (ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
            ControladorPacientes.getInstance().getEntityManager().getTransaction().commit();
        }

    }
    
    @Override
    public void BorrarPaciente(String ci){
        Paciente p = (Paciente) this.pacientes.get(ci);
        Medico m = (Medico) User.getSesionactiva();
        m.BorrarPaciente(p);
        getEntityManager().merge(m);
        if (!ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
            ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
        }

        if (ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
            ControladorPacientes.getInstance().getEntityManager().getTransaction().commit();
        }

    }
    @Override
    public void AgregarEstudio(String nombEst, String nomPro){
        NombredeEstudio e = new NombredeEstudio(nombEst);
        e.setPrototipos(new ArrayList<Prototipo>());
        Prototipo p = new Prototipo(nomPro);
        p.setNombredeEstudio(e);
        e.getPrototipos().add(p);
        this.persist(e);
        
        if (!ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
            ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
        }

        if (ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
            ControladorPacientes.getInstance().getEntityManager().getTransaction().commit();
        }
        
    }
    
    @Override
    public List<DtEstudio> listarEstudio(String nombre) {
        List<DtEstudio> retornar = new ArrayList<>();
        if(nombre.equals("")){
        for (NombredeEstudio Ne : this.estudios.values()) {
                retornar.add(Ne.getDatos());   
        }
        }else{
        for (NombredeEstudio Ne : this.estudios.values()) {
            if(Ne.getNombre().contains(nombre)){
                retornar.add(Ne.getDatos());
            }
        }}
        return retornar;
    }
    @Override
    public List<DtPrototipo> listarPrototipo(String nombre) {
        List<DtPrototipo> retornar = new ArrayList<>();
        if(nombre.equals("")){
        for (Prototipo Pr : this.prototipos.values()) {
                retornar.add(Pr.getDatos());   
        }
        }else{
        for (Prototipo Pr : this.prototipos.values()) {
            if(Pr.getPrototipo().contains(nombre)){
                retornar.add(Pr.getDatos());
            }
        }}
        return retornar;
    }
    
    @Override
    public DtEstudio BuscarEstudio(String nombre){
        for (NombredeEstudio aux : this.estudios.values()) {
            Long nombEst = aux.getId();
            String nomb = String.valueOf(nombEst);
            if (nomb.equals(nombre)) {
                return aux.getDatos();
            }
        }
        return null;
    }
    
    @Override
    public boolean ModificarEstudio(Long id, String nombre){
        if (!ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
            ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
        }
        try {
            NombredeEstudio ne = this.estudios.get(id);
            Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.nombredeestudio SET nombre='" + nombre + "' WHERE id='" + ne.getId() + "';");
            q.executeUpdate();
            ne.setNombre(nombre);
            if (ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
                ControladorPacientes.getInstance().getEntityManager().getTransaction().commit();
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    @Override
    public DtPrototipo BuscarPrototipo(String informe){
        for (Prototipo aux : this.prototipos.values()) {
            Long id = aux.getId();
            String inf = String.valueOf(id);
            if (inf.equals(informe)) {
                return aux.getDatos();
            }
        }
        return null;
    }
    
    @Override
    public boolean ModificarPrototipo(Long id, String informe){
        if (!ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
            ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
        }
        try {
            Prototipo pr = this.prototipos.get(id);
            Query q = ControladorPacientes.getEntityManager().createNativeQuery("UPDATE medicomp.prototipo SET prototipo='" + informe + "' WHERE id='" + pr.getId() + "';");
            q.executeUpdate();
            pr.setPrototipo(informe);
            if (ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
                ControladorPacientes.getInstance().getEntityManager().getTransaction().commit();
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean EliminarEstudio(String ide){
        NombredeEstudio ne = (NombredeEstudio) this.estudios.get(Long.valueOf(ide));
        if (!ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
            ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
        }
        try {
            Long e = Long.valueOf(ide);
            this.estudios.remove(e);
            getEntityManager().remove(ne);
            if (ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
                ControladorPacientes.getInstance().getEntityManager().getTransaction().commit();
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    @Override
    public boolean EliminarPrototipo(String idp){
       if (!ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
            ControladorPacientes.getInstance().getEntityManager().getTransaction().begin();
        }
        try {
            Long e = Long.valueOf(idp);
            this.prototipos.remove(e);
            Query q = ControladorPacientes.getEntityManager().createNativeQuery("DELETE FROM medicomp.prototipo WHERE id= " + e);
            q.executeUpdate();
            if (ControladorPacientes.getInstance().getEntityManager().getTransaction().isActive()) {
                ControladorPacientes.getInstance().getEntityManager().getTransaction().commit();
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
   /* public List<DtConsulta> listarConsulta(String paciente){
        List<DtConsulta> retornar = new ArrayList<>();
        Medico m = (Medico) User.getSesionactiva();
        for (Consulta con : ) {
            if () {
                retornar.add(pac.getDatos());
            }
        }
        return retornar;
    }
    
    
    public boolean AgregarEstudioaPaciente(String ci,String idEst){
        
    return false;
*/    
}