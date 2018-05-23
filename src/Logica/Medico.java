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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Admin
 */
@Entity
public class Medico extends Usuario implements Serializable {

    //private static final long serialVersionUID = 1L;
//    @Id
//    private String ci;
    @OneToMany
    private List<Entidad> entidades;
    @OneToMany
    private List<Paciente> pacientes;
    

    @OneToMany(mappedBy = "medico")
    private List<Asistente> asistentes;

    public List<Asistente> getAsistentes() {
        return asistentes;
    }
    

    public void setAsistentes(List<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    public Medico(List<Asistente> asistentes) {
        this.asistentes = asistentes;
    }
    
    public Medico(){}

    public Medico(String ci, String nombre, String apellido, String correo, String contraseña, Imagen imagen) {
        super(ci, nombre, apellido, correo, contraseña, imagen);
        this.entidades=null;
        this.pacientes=null;
    }

    public Medico(List<Entidad> entidades, List<Paciente> pacientes, String ci, String nombre, String apellido, String correo, String contraseña, Imagen imagen) {
        super(ci, nombre, apellido, correo, contraseña, imagen);
        this.entidades = entidades;
        this.pacientes = pacientes;
    }

    public Medico(String ci, String contrasenia, String nombre, String apellido, String correo) {
        super(ci, contrasenia, nombre, apellido, correo);
        this.entidades=null;
        this.pacientes=null;
    }
    
    public void AgregarEntidad(Entidad e){
        this.entidades.add(e);
    }
    
    public void AgregarPaciente(Paciente p){
        this.pacientes.add(p);
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
    public void AgregarAsistente(Asistente a){
        if(asistentes==null){
            asistentes=new ArrayList<>();
        }
        asistentes.add(a);
    }
        public List<Asistente> getAsistente(String ci) {
            List<Asistente> asis = new ArrayList();
            for (Asistente a : this.getAsistentes()) {
                if (a.getCi().equals(ci)) {
                    Asistente as = a;
                    asis.add(as);
                }
            return asis;
            }
            return null;
        }
}
