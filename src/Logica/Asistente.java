package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class Asistente extends Usuario implements Serializable {

    //private static final long serialVersionUID = 1L;
//    @Id
//    private String ci;
    
    @OneToMany(mappedBy = "asistente")
    private List<Rel_Med_Asis> medicos = new ArrayList();
    
    public Asistente(){}

    public Asistente(String ci, String nombre, String apellido, String correo, String contraseña, Imagen imagen) {
        super(ci, nombre, apellido, correo, contraseña, imagen);
//        this.renumerado = renumerado;
//        this.horas_trabajadas = horas_trabajadas;
//        this.horas_renumeradas = horas_renumeradas;
    }

    Asistente(String ci, String contrasenia, String nombre, String apellido, String correo) {
        super(ci, contrasenia, nombre, apellido, correo);
//        this.renumerado = renumerado;
//        this.horas_trabajadas = horas_trabajadas;
//        this.horas_renumeradas = horas_renumeradas;
    }

    public void agregarMedico(Rel_Med_Asis e){
        this.medicos.add(e);
    }
    
    public List<Rel_Med_Asis> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Rel_Med_Asis> medicos) {
        this.medicos = medicos;
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
    public DtUsuario getDatos(String ci){
        Rel_Med_Asis rel = null;
        for (int i=0; i<this.getMedicos().size();i++){
            if (getMedicos().get(i).getMedico().getCi().equals(ci))
                rel = getMedicos().get(i);
        }
        DtUsuario a = null;
        if (rel!=null)
            a = new DtUsuario(this.getCi(),this.getNombre(),this.getApellido(),this.getCorreo(),this.getImagen(),rel.isRenumerado(),rel.getHoras_renumeradas(),rel.getHoras_trabajadas());
        else
            a = new DtUsuario(this.getCi(),this.getNombre(),this.getApellido(),this.getCorreo(),this.getImagen());
        return a;
    }
    
}
