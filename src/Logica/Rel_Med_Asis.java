/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Admin
 */
@Entity
public class Rel_Med_Asis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int horas_trabajadas;
    private int horas_renumeradas;
    private boolean renumerado;
    
    Rel_Med_Asis(){
        this.horas_renumeradas=0;
        this.horas_trabajadas=0;
        this.renumerado=false;
    }
    
    @ManyToOne
    private Asistente asistente = null;

    @ManyToOne
    private Medico medico = null;
    
    public Asistente getAsistente() {
        return asistente;
    }

    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }

    public boolean isRenumerado() {
        return renumerado;
    }

    public void setRenumerado(boolean renumerado) {
        this.renumerado = renumerado;
    }

    
    public int getHoras_trabajadas() {
        return horas_trabajadas;
    }

    public void setHoras_trabajadas(int horas_trabajadas) {
        this.horas_trabajadas = horas_trabajadas;
    }

    public int getHoras_renumeradas() {
        return horas_renumeradas;
    }

    public void setHoras_renumeradas(int horas_renumeradas) {
        this.horas_renumeradas = horas_renumeradas;
    }

    
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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
        if (!(object instanceof Rel_Med_Asis)) {
            return false;
        }
        Rel_Med_Asis other = (Rel_Med_Asis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Rel_Med_Asis[ id=" + id + " ]";
    }
    
}
