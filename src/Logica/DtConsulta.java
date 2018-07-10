/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DtConsulta {
    private Date Fecha;
    private List<EstudioRealizado> estudios;
    private String paciente;

    public DtConsulta(Date Fecha, List<EstudioRealizado> estudios, String paciente) {
        this.Fecha = Fecha;
        this.estudios = estudios;
        this.paciente = paciente;
    }

    public DtConsulta() {
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public List<EstudioRealizado> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<EstudioRealizado> estudios) {
        this.estudios = estudios;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
    
    
}
