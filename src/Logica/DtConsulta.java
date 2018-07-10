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
    private long id;
    private Date Fecha;
    private List<EstudioRealizado> estudios = null;
    private String paciente;
    private Direccion dir = null;
    private DtEntidad entidad = null;
    private DtPaciente dtp = null;

    public DtConsulta(Date Fecha, List<EstudioRealizado> estudios, String paciente) {
        this.Fecha = Fecha;
        this.estudios = estudios;
        this.paciente = paciente;
    }
    
    public DtConsulta(Date Fecha, DtPaciente paciente,Direccion dir, DtEntidad ent,long id) {
        this.Fecha = Fecha;
        this.dir = dir;
        this.dtp = paciente;
        this.entidad = ent;
        this.id = id;
    }

    public Direccion getDir() {
        return dir;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDir(Direccion dir) {
        this.dir = dir;
    }

    public DtEntidad getEntidad() {
        return entidad;
    }

    public void setEntidad(DtEntidad entidad) {
        this.entidad = entidad;
    }

    public DtPaciente getDtp() {
        return dtp;
    }

    public void setDtp(DtPaciente dtp) {
        this.dtp = dtp;
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
