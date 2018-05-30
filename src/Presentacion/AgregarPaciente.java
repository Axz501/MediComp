/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ControladorPacientes;
import Logica.Direccion;
import Logica.IContPaciente;
import Utils.JFrameConFondo;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ninoh
 */
public class AgregarPaciente extends JFrameConFondo {

    /**
     * Creates new form AgregarPaciente
     */
    String RutaImagen;
    private IContPaciente Pct;
    public AgregarPaciente() {
        initComponents();
        Pct = ControladorPacientes.getInstance();
        setTitle("Agregar Paciente");
        setResizable(false);
        this.setImagen("Fondo.jpg");
    }


    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Buscar = new javax.swing.JFileChooser();
        txt_Ci = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Img = new javax.swing.JLabel();
        txt_Correo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_Apellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CargarImg = new javax.swing.JButton();
        CargarImg1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmb_Tipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_Edad = new javax.swing.JTextField();
        particular = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_Calle = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        rutaImg = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txt_Departamento = new javax.swing.JTextField();
        txt_Ciudad = new javax.swing.JTextField();
        txt_Numero = new javax.swing.JTextField();

        txt_Ci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CiActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("Correo:");

        Img.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CorreoActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 204));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Cedula de Identidad:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Apellido:");

        CargarImg.setText("Elegir Imagen");
        CargarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarImgActionPerformed(evt);
            }
        });

        CargarImg1.setText("Quitar");
        CargarImg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarImg1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel1.setText("Click derecho en la barra superior para minimizar");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setText("Genero:");

        cmb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cmb_Tipo.setToolTipText("");
        cmb_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_TipoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Edad:");

        txt_Edad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EdadActionPerformed(evt);
            }
        });

        particular.setText("Particular?");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setText("Telefono:");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setText("Direccion:");

        txt_Calle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CalleActionPerformed(evt);
            }
        });

        txt_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TelefonoActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DepartamentoActionPerformed(evt);
            }
        });

        txt_Ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CiudadActionPerformed(evt);
            }
        });

        txt_Numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NumeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(134, 134, 134)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txt_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton2)
                                                        .addComponent(txt_Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGap(169, 169, 169)))))
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_Calle, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17)
                                        .addComponent(rutaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(particular)
                                    .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addGap(65, 65, 65)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_Correo, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addComponent(txt_Apellido)
                        .addComponent(txt_Nombre)
                        .addComponent(txt_Ci))
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(CargarImg)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CargarImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(42, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmb_Tipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(particular)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rutaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(23, 23, 23))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(189, 189, 189)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CargarImg1)
                                .addComponent(CargarImg)))
                        .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txt_Ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(232, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_CiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CiActionPerformed

    private void txt_CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CorreoActionPerformed

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void CargarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarImgActionPerformed
        //        java.util.Properties p = System.getProperties();
        //        String cadena = p.getProperty("user.dir");
        //        System.out.println(cadena);
        this.setAlwaysOnTop(false);
        FileDialog fd = new FileDialog(new JFrame(), "Choose a file", FileDialog.LOAD);
        fd.setDirectory("C:\\");
            fd.setFile("*.jpg;*.png");
            //fd.setAlwaysOnTop(true);
            fd.setVisible(true);
            String filename = fd.getFile();
            if (filename != null){
                RutaImagen = fd.getDirectory()+filename;
                rutaImg.setText(RutaImagen);
                ImageIcon imagen = new ImageIcon(RutaImagen); //genera la imagen que seleccionamos
                Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(Img.getWidth(), Img.getHeight(), Image.SCALE_DEFAULT));
                this.Img.setIcon(icono); // coloca la imagen en el label
            }
            //        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes", "jpg", "png", "JPG", "PNG"); // filtro para el Filechooser
            //        Buscar.setFileFilter(filtro);
            //        int a = Buscar.showOpenDialog(this); // guarda la accion que se realiza en el filechooser
            //
            //        if (a == JFileChooser.APPROVE_OPTION) { // la accion si se le da a abrir
                //            File archivo = Buscar.getSelectedFile(); // capturar el nombre y ruta
                //
                //            RutaImagen = archivo.getPath();
                //            String rutaMostrar = RutaImagen;
                //
                //            //Si la ruta es muy larga, la corta y le ponde los puntos suspesivos para mostrarla
                //            if (RutaImagen.length() > 35) {
                    //                rutaMostrar = RutaImagen.substring(0, 35) + "...";
                    //            }
                //
                //            rutaImg.setText(rutaMostrar);
                //            ImageIcon imagen = new ImageIcon(RutaImagen); //genera la imagen que seleccionamos
                //            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(Img.getWidth(), Img.getHeight(), Image.SCALE_DEFAULT));
                //
                //            this.Img.setIcon(icono); // coloca la imagen en el label
                //
                //            this.pack();
                //        }
    }//GEN-LAST:event_CargarImgActionPerformed

    private void CargarImg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarImg1ActionPerformed
        RutaImagen = null;
        rutaImg.setText("");
        this.Img.setIcon(null); // limpia la imagen del label
    }//GEN-LAST:event_CargarImg1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code
    }//GEN-LAST:event_jLabel1MouseClicked

    private void cmb_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_TipoActionPerformed
        //CardLayout cl = (CardLayout) contenedor2.getLayout();

        //        String texto = cmb_Tipo.getSelectedItem().toString();
        //        if ("Medico".equals(texto)) {
            //            cl.show(contenedor2, "panelVacio");
            //            panelAsistente2.setVisible(false);
            //            renumerado2.setText(null);
            //        } else if ("Asistente".equals(texto)) {
            //            cl.show(contenedor2, "panelAsistente");
            //            panelAsistente2.setVisible(true);
            //            renumerado2.setText(null);
            //        }
    }//GEN-LAST:event_cmb_TipoActionPerformed

    private void txt_EdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EdadActionPerformed

    private void txt_CalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CalleActionPerformed

    private void txt_TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelefonoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean part=false, formatocorreo=false, largoci = false;
        String ci, nombre, apellido, correo, comboTipo, ciudad, departamento, calle;
        Direccion direccion = null;
        int edad, telefono, numero;
        ci = txt_Ci.getText();
        nombre = txt_Nombre.getText();
        apellido = txt_Apellido.getText();
        correo = txt_Correo.getText();
        edad = Integer.valueOf(txt_Edad.getText());
        telefono = Integer.valueOf(txt_Telefono.getText());
        ciudad = txt_Ciudad.getText();
        departamento = txt_Departamento.getText();
        calle = txt_Calle.getText();
        numero = Integer.valueOf(txt_Numero.getText());
        comboTipo = cmb_Tipo.getSelectedItem().toString();
        part = particular.isSelected();
        direccion = new Direccion(ciudad,departamento,calle,numero);
        if ((txt_Ci.getText().equals("")) || edad == 0 || telefono == 0 || direccion == null || (txt_Nombre.getText().equals("")) || (txt_Apellido.getText().equals("")) || (txt_Correo.getText().equals("")) || ((cmb_Tipo.getSelectedItem() == null))) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Ci.requestFocus();
        } else {
            if (ci.length()==8 && ci.matches("[0-9]+"))
            largoci = true;
            else{
                if (ci.length()!=8)
                javax.swing.JOptionPane.showMessageDialog(this, "Tu cédula debe tener 8 dígitos");
                if (!ci.matches("[0-9]+"))
                javax.swing.JOptionPane.showMessageDialog(this, "Tu cédula debe tener solo números");
                txt_Ci.requestFocus();
            }
            if ((correo.contains("@")) && (correo.contains(".com"))){
                formatocorreo = true;
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(this, "Formato de correo inválido");
                txt_Correo.requestFocus();
            }
            if(formatocorreo && largoci){
                boolean Ok;
                System.out.println("comboTipo = "+comboTipo);

                Ok = Pct.IngresarPaciente(ci,nombre,apellido,correo,edad,telefono,direccion,comboTipo,part,RutaImagen);
                if(Ok){
                    javax.swing.JOptionPane.showMessageDialog(this,"El Usuario ha sido dado de alta");
                    this.dispose();
                }
                else{
                    javax.swing.JOptionPane.showMessageDialog(this,"El Usuario no ha podido ser dado de alta, CI y/o correo en uso", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DepartamentoActionPerformed

    private void txt_CiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CiudadActionPerformed

    private void txt_NumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NumeroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser Buscar;
    private javax.swing.JButton CargarImg;
    private javax.swing.JButton CargarImg1;
    private javax.swing.JLabel Img;
    private javax.swing.JComboBox<String> cmb_Tipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox particular;
    private javax.swing.JLabel rutaImg;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_Calle;
    private javax.swing.JTextField txt_Ci;
    private javax.swing.JTextField txt_Ciudad;
    private javax.swing.JTextField txt_Correo;
    private javax.swing.JTextField txt_Departamento;
    private javax.swing.JTextField txt_Edad;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Numero;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables
public void centrar(){
        //este metodo devuelve el tamaÃ±o de la pantalla
        int x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        int y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        int h = this.getHeight();
        int z = this.getWidth();
        this.setLocation(x/2-z/2,y/2-h/2);
        
    }
}
