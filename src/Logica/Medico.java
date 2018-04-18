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

/**
 *
 * @author Admin
 */
@Entity
public class Medico extends Usuario implements Serializable {

    //private static final long serialVersionUID = 1L;
//    @Id
//    private String ci;

    public Medico(String ci, String nombre, String apellido, String correo, String contraseña, String imagen) {
        super(ci, nombre, apellido, correo, contraseña, imagen);
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
    
}
