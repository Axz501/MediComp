/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Admin
 */
@Entity
public class Jornada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private enum estado{Pendiente,En_Curso,Finalizada};
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_Inicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_Fin;
    @ManyToOne
    private Direccion direccion;
    private boolean particular;

    public Jornada(Date Fecha_Inicio, Date Fecha_Fin, Direccion direccion, boolean particular) {
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Fin = Fecha_Fin;
        this.direccion = direccion;
        this.particular = particular;
    }

    public Date getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(Date Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public Date getFecha_Fin() {
        return Fecha_Fin;
    }

    public void setFecha_Fin(Date Fecha_Fin) {
        this.Fecha_Fin = Fecha_Fin;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public boolean isParticular() {
        return particular;
    }

    public void setParticular(boolean particular) {
        this.particular = particular;
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
        if (!(object instanceof Jornada)) {
            return false;
        }
        Jornada other = (Jornada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Jornada[ id=" + id + " ]";
    }
    
}
