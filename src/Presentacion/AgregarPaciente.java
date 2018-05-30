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
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
        txt_Ciudad.setText("Ciudad");
        txt_Ciudad.setForeground(Color.LIGHT_GRAY);
        txt_Departamento.setText("Departamento");
        txt_Departamento.setForeground(Color.LIGHT_GRAY);
        txt_Calle.setText("Calle");
        txt_Calle.setForeground(Color.LIGHT_GRAY);
        txt_Numero.setText("Numero");
        txt_Numero.setForeground(Color.LIGHT_GRAY);
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

        txt_Edad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_EdadFocusLost(evt);
            }
        });
        txt_Edad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_EdadMouseReleased(evt);
            }
        });
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

        txt_Calle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_CalleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_CalleFocusLost(evt);
            }
        });
        txt_Calle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CalleActionPerformed(evt);
            }
        });

        txt_Telefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_TelefonoFocusLost(evt);
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

        txt_Departamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_DepartamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_DepartamentoFocusLost(evt);
            }
        });
        txt_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DepartamentoActionPerformed(evt);
            }
        });

        txt_Ciudad.setToolTipText("");
        txt_Ciudad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_CiudadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_CiudadFocusLost(evt);
            }
        });
        txt_Ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CiudadActionPerformed(evt);
            }
        });

        txt_Numero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_NumeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_NumeroFocusLost(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_Edad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Correo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Apellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Ci, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(txt_Telefono))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CargarImg)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CargarImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Calle, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txt_Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(particular)
                                    .addComponent(txt_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(rutaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CargarImg1)
                                    .addComponent(CargarImg)))
                            .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rutaImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(particular)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        txt_Ciudad.getAccessibleContext().setAccessibleName("");
        txt_Ciudad.getAccessibleContext().setAccessibleDescription("");

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
        Direccion direccion = new Direccion(ciudad, departamento, calle, numero);
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
            }else{
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

    private void txt_EdadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_EdadMouseReleased

    }//GEN-LAST:event_txt_EdadMouseReleased

    private void txt_EdadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_EdadFocusLost
        String edad;
        edad = txt_Edad.getText();
        if (!edad.matches("[0-9]+")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Este campo debe tener solo números");
            txt_Edad.setText("");
        }
        
    }//GEN-LAST:event_txt_EdadFocusLost

    private void txt_TelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_TelefonoFocusLost
        String tel;
        tel = txt_Telefono.getText();
        if (!tel.matches("[0-9]+")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Este campo debe tener solo números");
            txt_Telefono.setText("");
        }
    }//GEN-LAST:event_txt_TelefonoFocusLost

    private void txt_NumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_NumeroFocusLost
        String num;
        num = txt_Numero.getText();
        if (!num.matches("[0-9]+")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Este campo debe tener solo números");
            txt_Numero.setText("");
        }
        if (txt_Numero.getText().equalsIgnoreCase("")) {
            txt_Numero.setText("Numero");
            txt_Numero.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_NumeroFocusLost

    private void txt_CiudadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CiudadFocusLost
        if (txt_Ciudad.getText().equalsIgnoreCase("")) {
            txt_Ciudad.setText("Ciudad");
            txt_Ciudad.setForeground(Color.LIGHT_GRAY);
  }
    }//GEN-LAST:event_txt_CiudadFocusLost

    private void txt_CiudadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CiudadFocusGained
        if (txt_Ciudad.getText().equalsIgnoreCase("Ciudad")) {
            txt_Ciudad.setText("");
            txt_Ciudad.setForeground(Color.black);
  }
    }//GEN-LAST:event_txt_CiudadFocusGained

    private void txt_DepartamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_DepartamentoFocusLost
        if (txt_Departamento.getText().equalsIgnoreCase("")) {
            txt_Departamento.setText("Departamento");
            txt_Departamento.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_DepartamentoFocusLost

    private void txt_DepartamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_DepartamentoFocusGained
        if (txt_Departamento.getText().equalsIgnoreCase("Departamento")) {
            txt_Departamento.setText("");
            txt_Departamento.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_DepartamentoFocusGained

    private void txt_CalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CalleFocusLost
        if (txt_Calle.getText().equalsIgnoreCase("")) {
            txt_Calle.setText("Calle");
            txt_Calle.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_CalleFocusLost

    private void txt_CalleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CalleFocusGained
        if (txt_Calle.getText().equalsIgnoreCase("Calle")) {
            txt_Calle.setText("");
            txt_Calle.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_CalleFocusGained

    private void txt_NumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_NumeroFocusGained
        if (txt_Numero.getText().equalsIgnoreCase("Numero")) {
            txt_Numero.setText("");
            txt_Numero.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_NumeroFocusGained


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
