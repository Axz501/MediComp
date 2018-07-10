/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Admin
 */
@Entity
public class Entidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean privado;
    
    private String correo;
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    private Imagen imagen;
    @OneToOne(cascade = CascadeType.ALL)
    private Direccion direccion;
    private String telefono = "";
    @ManyToMany(mappedBy = "entidades")
    private List<Paciente> pacientes = null;
    
    public Entidad(){};

    public Entidad(String correo, String nombre, Direccion direccion, List<String> telefono, Imagen img,boolean b) {
        this.correo = correo;
        this.nombre = nombre;
        this.direccion = direccion;
        for (String s : telefono){
           this.telefono = this.telefono + s + ';'; 
        }
        this.imagen = img;
        this.privado = b;
    }

    
    
    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }
    
    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<String> getTelefono() {
        List<String> lista = new ArrayList();
        String[] telefonos = this.telefono.split(";");
        lista.addAll(Arrays.asList(telefonos));
        return lista;
    }

    public void setTelefono(List<String> telefono) {
        this.telefono = "";
        for (String s : telefono){
           this.telefono = this.telefono + s + ';'; 
        }
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
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Entidad[ id=" + id + " ]";
    }
    
    public DtEntidad getDatos(){
        return new DtEntidad(this.getId(),this.getCorreo(),this.getNombre(),this.getImagen(),this.getDireccion(),this.getTelefono(),this.isPrivado());
    }
}
