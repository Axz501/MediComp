/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Admin
 */
@Entity
public class NombredeEstudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    
    @OneToMany(mappedBy = "nombredeEstudio", cascade = {CascadeType.ALL})
    
    private List<Prototipo> prototipos;

    public NombredeEstudio() {
    }

    public NombredeEstudio(Long id, String nombre, List<Prototipo> prototipos) {
        this.id = id;
        this.nombre = nombre;
        this.prototipos = prototipos;
    }

    public List<Prototipo> getPrototipos() {
        return prototipos;
    }

    public void setPrototipos(List<Prototipo> prototipos) {
        this.prototipos = prototipos;
    }

    public NombredeEstudio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof NombredeEstudio)) {
            return false;
        }
        NombredeEstudio other = (NombredeEstudio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.NombredeEstudio[ id=" + id + " ]";
    }
    
    public DtEstudio getDatos(){
//        for(Prototipo p : this.getPrototipos()){
//            String[] pro = {p.getId().toString()};
//        }
        DtEstudio dte = new DtEstudio(this.id,this.nombre, this.prototipos);
        return dte;
    }
}
