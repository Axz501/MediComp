/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Admin
 */
@Entity
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date Fecha_Hora;
    @OneToMany(mappedBy = "consulta")
    private List<EstudioRealizado> estudios;
    @OneToOne
    private Deuda deuda;
    @ManyToOne
    private Paciente paciente;

    public List<EstudioRealizado> getEstudios() {
        return estudios;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
    public void agregarestudio(EstudioRealizado e){
        this.estudios.add(e);
    }

    public void setEstudios(List<EstudioRealizado> estudios) {
        this.estudios = estudios;
    }

    public Deuda getDeuda() {
        return deuda;
    }

    public void setDeuda(Deuda deuda) {
        this.deuda = deuda;
    }
    
    public Consulta(Date Fecha_Hora) {
        this.Fecha_Hora = Fecha_Hora;
    }

    public Date getFecha_Hora() {
        return Fecha_Hora;
    }

    public void setFecha_Hora(Date Fecha_Hora) {
        this.Fecha_Hora = Fecha_Hora;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Consulta[ id=" + id + " ]";
    }
    
}
