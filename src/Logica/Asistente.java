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
public class Asistente extends Usuario implements Serializable {

    //private static final long serialVersionUID = 1L;
//    @Id
//    private String ci;
    private boolean renumerado;
    private int horas_trabajadas;
    private int horas_renumeradas;
    @ManyToOne
    private Medico medico;

    public Asistente(Medico medico) {
        this.medico = medico;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public Asistente(){}

    public Asistente(boolean renumerado, int horas_trabajadas, int horas_renumeradas, String ci, String nombre, String apellido, String correo, String contraseña, Imagen imagen) {
        super(ci, nombre, apellido, correo, contraseña, imagen);
        this.renumerado = renumerado;
        this.horas_trabajadas = horas_trabajadas;
        this.horas_renumeradas = horas_renumeradas;
    }

    Asistente(boolean renumerado, int horas_trabajadas, int horas_renumeradas, String ci, String contrasenia, String nombre, String apellido, String correo) {
        super(ci, contrasenia, nombre, apellido, correo);
        this.renumerado = renumerado;
        this.horas_trabajadas = horas_trabajadas;
        this.horas_renumeradas = horas_renumeradas;
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
        return "Logica.Asistente[ id=" + this.getCi() + " ]";
    }
    public Asistente getDatos(){ 
        return new Asistente(this.renumerado,this.getHoras_trabajadas(),this.getHoras_renumeradas(),this.getCi(),this.getContrasenia(),this.getNombre(),this.getApellido(),this.getCorreo());
    }
    
}