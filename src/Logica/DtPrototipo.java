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
public class DtPrototipo {
    private Long id;
    private String prototipo;

    public DtPrototipo(Long id, String prototipo) {
        this.id = id;
        this.prototipo = prototipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrototipo() {
        return prototipo;
    }

    public void setPrototipo(String prototipo) {
        this.prototipo = prototipo;
    }
    
    
}
