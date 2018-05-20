/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
@Entity
public class Imagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //private String url;
    @Column(columnDefinition="MEDIUMBLOB")
    private byte[] tapa;

    public void setTapa(byte[] tapa) {
        this.tapa = tapa;
    }

    public byte[] getTapa() {
        return tapa;
    }
    public ImageIcon getImagen(){
        return new ImageIcon(tapa);
    }
    private void setImagen(String archivo){
        try{
            byte[] imagen = new byte[0]; //se interpreta como null en el servidor
            File im = new File(archivo);
            imagen = org.apache.commons.io.FileUtils.readFileToByteArray(im);
            this.setTapa(imagen);
//            FileInputStream myStream = new FileInputStream(archivo);
//            DataInputStream dis = new DataInputStream(myStream);
//            dis.readFully(this.tapa);
//            if(dis != null){
//                dis.close();
//            }
        } catch(Exception ex){}
    }
    
    public Imagen(){}

    public Imagen(String url) {
       this.setImagen(url);
    }

//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
    

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
        if (!(object instanceof Imagen)) {
            return false;
        }
        Imagen other = (Imagen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Imagen[ id=" + id + " ]";
    }
    
}
