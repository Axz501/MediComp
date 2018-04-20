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
import javax.persistence.Temporal;

/**
 *
 * @author Admin
 */
@Entity
public class EstudioRealizado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_hora;
    private String informe;
    private List<String> imagenes;
    @ManyToOne
    private NombredeEstudio nombre;
    @ManyToOne
    private Consulta consulta;
    
    public EstudioRealizado(Date fecha_hora, String informe, List<String> imagen) {
        this.fecha_hora = fecha_hora;
        this.informe = informe;
        this.imagenes = imagen;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

    public NombredeEstudio getNombre() {
        return nombre;
    }

    public void setNombre(NombredeEstudio nombre) {
        this.nombre = nombre;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    

    public void AgregarImagen(String imagen){
        this.imagenes.add(imagen);
    }
    
    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public List<String> getImagen() {
        return imagenes;
    }

    public void setImagen(List<String> imagen) {
        this.imagenes = imagen;
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
        if (!(object instanceof EstudioRealizado)) {
            return false;
        }
        EstudioRealizado other = (EstudioRealizado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.EstudioRealizado[ id=" + id + " ]";
    }
    
}
