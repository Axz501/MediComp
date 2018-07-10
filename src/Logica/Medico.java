/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
public class Medico extends Usuario implements Serializable {

    //private static final long serialVersionUID = 1L;
//    @Id
//    private String ci;
    @ManyToMany
    @JoinTable(name = "usuario_entidades")
    private List<Entidad> entidades = new ArrayList();
    @ManyToMany (cascade = {CascadeType.DETACH,CascadeType.MERGE})
    private List<Paciente> pacientes = new ArrayList() ;
    @OneToMany()
    @JoinTable(name = "usuario_entidades_creadas")
    private List<Entidad> entidadescreadas = new ArrayList();
    @OneToMany(mappedBy = "medico")
    private List<Rel_Med_Asis> asistentes = new ArrayList();
    
    public Medico(){}

    public Medico(String ci, String nombre, String apellido, String correo, String contraseña, Imagen imagen) {
        super(ci, nombre, apellido, correo, contraseña, imagen);
    }

    public Medico(List<Entidad> entidades, List<Paciente> pacientes, String ci, String nombre, String apellido, String correo, String contraseña, Imagen imagen) {
        super(ci, nombre, apellido, correo, contraseña, imagen);
        this.entidades = entidades;
        this.pacientes = pacientes;
    }

    public Medico(String ci, String contrasenia, String nombre, String apellido, String correo) {
        super(ci, contrasenia, nombre, apellido, correo);
    }

    public List<Entidad> getEntidadescreadas() {
        return entidadescreadas;
    }

    public void setEntidadescreadas(List<Entidad> entidadescreadas) {
        this.entidadescreadas = entidadescreadas;
    }

    
    public List<Rel_Med_Asis> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Rel_Med_Asis> asistentes) {
        this.asistentes = asistentes;
    }

    
    public void AgregarEntidad(Entidad e){
        this.entidades.add(e);
    }
    
    public void AgregarPaciente(Paciente p){
        this.pacientes.add(p);
    }
    public void BorrarPaciente(Paciente p){
        this.pacientes.remove(p);
    }
    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getCi() != null ? this.getCi().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.getCi() == null && other.getCi() != null) || (this.getCi() != null && !this.getCi().equals(other.getCi()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Medico[ id=" +  this.getCi() + " ]";
    }
    public void AgregarAsistente(Rel_Med_Asis a){
        if(asistentes==null){
            asistentes=new ArrayList<>();
        }
        asistentes.add(a);
    }
        public List<Asistente> getAsistente(String ci) {
            List<Asistente> asis = new ArrayList();
            for (Rel_Med_Asis a : this.asistentes) {
                if (a.getAsistente().getCi().equals(ci)) {
                    Asistente as = a.getAsistente();
                    asis.add(as);
                }
            return asis;
            }
            return null;
        }

    public DtUsuario getDatos() {
        DtUsuario a = null;
        a = new DtUsuario(this.getCi(),this.getNombre(),this.getApellido(),this.getCorreo(),this.getImagen());
        return a;
    }
    
}
