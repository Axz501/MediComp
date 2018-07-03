/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.CascadeType;
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
public class Prototipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String prototipo;
    @ManyToOne 
    private NombredeEstudio nombredeEstudio;

    public NombredeEstudio getNombredeEstudio() {
        return nombredeEstudio;
    }

    public void setNombredeEstudio(NombredeEstudio nombredeEstudio) {
        this.nombredeEstudio = nombredeEstudio;
    }

    public Prototipo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prototipo(String prototipo) {
        this.prototipo = prototipo;
    }

    public String getPrototipo() {
        return prototipo;
    }

    public void setPrototipo(String prototipo) {
        this.prototipo = prototipo;
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
        if (!(object instanceof Prototipo)) {
            return false;
        }
        Prototipo other = (Prototipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Prototipo[ id=" + id + " ]";
    }
    
    public DtPrototipo getDatos() {
        DtPrototipo dtp = new DtPrototipo(this.id,this.prototipo);
        return dtp;
    }
}
