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
        jPanel1.setVisible(false);
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
        rutaImg = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_Telefono = new javax.swing.JTextField();
        txt_Departamento = new javax.swing.JTextField();
        txt_Ciudad = new javax.swing.JTextField();
        txt_Numero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_Calle = new javax.swing.JTextField();

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
        particular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                particularMouseClicked(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Calle, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        txt_Ciudad.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel7)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_Nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Apellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Correo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Edad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(particular))
                                    .addComponent(txt_Ci))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rutaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CargarImg))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CargarImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
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
                            .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(particular)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rutaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CargarImg1)
                                    .addComponent(CargarImg)))
                            .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(31, 31, 31))
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
        boolean part = false, formatocorreo = false, largoci = false;
        String ci, nombre, telefono, apellido, correo, comboTipo, ciudad, departamento, calle;
        int edad, numero;
        ci = txt_Ci.getText();
        nombre = txt_Nombre.getText();
        apellido = txt_Apellido.getText();
        correo = txt_Correo.getText();
        edad = Integer.valueOf(txt_Edad.getText());
        comboTipo = cmb_Tipo.getSelectedItem().toString();
        part = particular.isSelected();
        if (part == false) {
            if ((txt_Ci.getText().equals("")) || edad == 0  || (txt_Nombre.getText().equals("")) || (txt_Apellido.getText().equals("")) || (txt_Correo.getText().equals("")) ) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                txt_Ci.requestFocus();
            }else{
                if (ci.length() == 8 && ci.matches("[0-9]+")) {
                    largoci = true;
                } else {
                    if (ci.length() != 8) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Tu cédula debe tener 8 dígitos");
                    }
                    if (!ci.matches("[0-9]+")) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Tu cédula debe tener solo números");
                    }
                    txt_Ci.requestFocus();
                }
                if ((correo.contains("@")) && (correo.contains(".com"))) {
                    formatocorreo = true;
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Formato de correo inválido");
                    txt_Correo.requestFocus();
                }
                if (formatocorreo && largoci) {
                    boolean Ok;
                    System.out.println("comboTipo = " + comboTipo);

                    Ok = Pct.IngresarPaciente(ci, nombre, apellido, correo, edad, comboTipo, part, RutaImagen);
                    if (Ok) {
                        
                        javax.swing.JOptionPane.showMessageDialog(this, "El Usuario ha sido dado de alta");
                        this.dispose();
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "El Usuario no ha podido ser dado de alta, CI y/o correo en uso", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);
                    }

                }
            
        }}else {
            
            if(txt_Ciudad.getText().equals("Ciudad") || txt_Departamento.getText().equals("Departamento") || txt_Calle.getText().equals("Calle") || txt_Numero.getText().equals("Numero")){
                javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                txt_Ci.requestFocus();
            }else{
        telefono = txt_Telefono.getText();
        ciudad = txt_Ciudad.getText();
        departamento = txt_Departamento.getText();
        calle = txt_Calle.getText();
        numero = Integer.valueOf(txt_Numero.getText());
        Direccion direccion = new Direccion(ciudad, departamento, calle, numero);
            if ((txt_Ci.getText().equals("")) || edad == 0 || txt_Telefono.getText().equals("") || (txt_Nombre.getText().equals("")) || (txt_Apellido.getText().equals("")) || (txt_Correo.getText().equals("")) || ((cmb_Tipo.getSelectedItem() == null))) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                txt_Ci.requestFocus();
            } else {
                if (ci.length() == 8 && ci.matches("[0-9]+")) {
                    largoci = true;
                } else {
                    if (ci.length() != 8) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Tu cédula debe tener 8 dígitos");
                    }
                    if (!ci.matches("[0-9]+")) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Tu cédula debe tener solo números");
                    }
                    txt_Ci.requestFocus();
                }
                if ((correo.contains("@")) && (correo.contains(".com"))) {
                    formatocorreo = true;
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Formato de correo inválido");
                    txt_Correo.requestFocus();
                }
                if (formatocorreo && largoci) {
                    boolean Ok;
                    System.out.println("comboTipo = " + comboTipo);

                    Ok = Pct.IngresarPacienteP(ci, nombre, apellido, correo, edad, telefono, direccion, comboTipo, part, RutaImagen);
                    if (Ok) {
                        javax.swing.JOptionPane.showMessageDialog(this, "El Usuario ha sido dado de alta");
                        this.dispose();
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "El Usuario no ha podido ser dado de alta, CI y/o correo en uso", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);
                    }

                }
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

    private void particularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_particularMouseClicked
        if(particular.isSelected()){
            jPanel1.setVisible(true);
        }else{
            jPanel1.setVisible(false);}
    }//GEN-LAST:event_particularMouseClicked


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
    private javax.swing.JPanel jPanel1;
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
