/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;

/**
 *
 * @author ninoh
 */
public class DtEstudio {
    private Long id;
    private String nombre;
    private List<Prototipo> prototipos;

    public DtEstudio(Long id, String nombre, List<Prototipo> prototipos) {
        this.id = id;
        this.nombre = nombre;
        this.prototipos = prototipos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Prototipo> getPrototipos() {
        return prototipos;
    }

    public void setPrototipos(List<Prototipo> prototipos) {
        this.prototipos = prototipos;
    }
    
    public DtEstudio getDatos(){
        DtEstudio dte = new DtEstudio(this.id,this.nombre,this.prototipos);
        return dte;
    }
}
