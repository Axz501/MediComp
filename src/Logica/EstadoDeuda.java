/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Admin
 */
@Entity
public class EstadoDeuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean pago;
    private int cant_cuotas;
    private int cuotas_pendientes;
    private int cuotas_pagas;
    private List<Cuota> cuotas;
    
    public EstadoDeuda(){
        this.pago = false;
        this.cant_cuotas = 0;
        this.cuotas_pendientes = 0;
        this.cuotas_pagas = 0;
        this.cuotas = null;
    }

    public EstadoDeuda(boolean pago, int cant_cuotas, int cuotas_pendientes, int cuotas_pagas, List<Cuota> cuotas) {
        this.pago = pago;
        this.cant_cuotas = cant_cuotas;
        this.cuotas_pendientes = cuotas_pendientes;
        this.cuotas_pagas = cuotas_pagas;
        this.cuotas = cuotas;
    }
    
    public void calcularcuotas(){
        int cant_c=0;
        int cant_p=0;
        for (int i=0;i<this.cuotas.size();i++){
            Cuota c = this.cuotas.get(i);
            cant_c++;
            if(c.isPago()){
                cant_p++;
            }
        }
        this.cant_cuotas=cant_c;
        this.cuotas_pagas=cant_p;
        this.cuotas_pendientes=(cant_c - cant_p);
    }
    
    public void agregarcuota(Cuota c){
        this.cuotas.add(c);
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public int getCant_cuotas() {
        return cant_cuotas;
    }

    public void setCant_cuotas(int cant_cuotas) {
        this.cant_cuotas = cant_cuotas;
    }

    public int getCuotas_pendientes() {
        return cuotas_pendientes;
    }

    public void setCuotas_pendientes(int cuotas_pendientes) {
        this.cuotas_pendientes = cuotas_pendientes;
    }

    public int getCuotas_pagas() {
        return cuotas_pagas;
    }

    public void setCuotas_pagas(int cuotas_pagas) {
        this.cuotas_pagas = cuotas_pagas;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
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
        if (!(object instanceof EstadoDeuda)) {
            return false;
        }
        EstadoDeuda other = (EstadoDeuda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.EstadoDeuda[ id=" + id + " ]";
    }
    
}
