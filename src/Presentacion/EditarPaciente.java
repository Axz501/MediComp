/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Direccion;
import Logica.DtPaciente;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContPaciente;
import Logica.Medico;
import Logica.Paciente;
import Utils.JFrameConFondo;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ninoh
 */
public final class EditarPaciente extends JFrameConFondo {

    /**
     * Creates new form EditarPaciente
     */
    String RutaImagen = "";
    private MenuPrincipal principal;
    private IContPaciente Pct;
    private Medico pct;
    Paciente p;
    List<DtPaciente> lp;
    public EditarPaciente() {
        initComponents();
        this.principal = principal;
        this.Pct = Fabrica.getPaciente();
        setTitle("Editar Paciente");
        setResizable(false);
        getRootPane().setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.cyan,Color.white));
        this.setImagen("Fondo.jpg");
        listarPacientes("");
    }
    
        public void listarPacientes(String ci) {

        DefaultTableModel modelo = (DefaultTableModel) PacienteTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        lp = Pct.listarPacientesMedico(ci);
        for (DtPaciente dtp : lp) {
            String[] datos = {String.valueOf(dtp.getCi()),ConvertirString(dtp.getNombre()),ConvertirString(dtp.getApellido()),ConvertirString(dtp.getCorreo()),String.valueOf(dtp.getEdad()),String.valueOf(dtp.getTelefono()),String.valueOf(dtp.getDireccion()),ConvertirString(dtp.getGenero()),String.valueOf(dtp.isParticular()),String.valueOf(dtp.getImagen())};
            modelo.addRow(datos);
        }
        
    }
            String ConvertirString(String cad) {
        cad = cad.toLowerCase();
        String[] palabras = cad.split("\\s+");
        cad = "";
        for (int i = 0; i < palabras.length; i++) {
            palabras[i].toLowerCase();
            palabras[i] = palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1);
            if (i == 0) {
                cad = cad + palabras[i];
            } else {
                cad = cad + " " + palabras[i];
            }
        }
        return cad;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Buscar = new javax.swing.JFileChooser();
        txt_Edad = new javax.swing.JPasswordField();
        eliminarimagen = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JPasswordField();
        Img = new javax.swing.JLabel();
        CargarImg = new javax.swing.JButton();
        CargarImg1 = new javax.swing.JButton();
        txt_Apellido = new javax.swing.JTextField();
        rutaImg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_Nombre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmb_Tipo = new javax.swing.JComboBox<>();
        particular = new javax.swing.JCheckBox();
        txt_Ciudad = new javax.swing.JTextField();
        txt_Numero = new javax.swing.JTextField();
        txt_Calle = new javax.swing.JTextField();
        rutaImg1 = new javax.swing.JLabel();
        txt_Departamento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        PacienteTable = new javax.swing.JTable();
        buscarIngTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eliminarimagen.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        eliminarimagen.setText("Eliminar Imagen actual");
        eliminarimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarimagenActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Telefono:");

        Img.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Apellido:");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Direccion:");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Edad:");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setText("Genero:");

        cmb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cmb_Tipo.setToolTipText("");
        cmb_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_TipoActionPerformed(evt);
            }
        });

        particular.setText("Particular?");

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

        PacienteTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        PacienteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI", "Nombre", "Apellido", "Correo", "Edad", "Telefono", "Direccion", "Genero", "Particular", "Imagen"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PacienteTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        PacienteTable.setGridColor(new java.awt.Color(204, 204, 204));
        PacienteTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PacienteTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(PacienteTable);

        buscarIngTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarIngTextFieldKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Buscar Paciente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_Nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                        .addComponent(txt_Apellido, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txt_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_Calle, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_Departamento)
                                                .addComponent(txt_Numero)))
                                        .addComponent(txt_Telefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buscarIngTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(66, 66, 66)
                                        .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(particular)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eliminarimagen)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(CargarImg)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CargarImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(Img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rutaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rutaImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 64, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buscarIngTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(rutaImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CargarImg1)
                            .addComponent(CargarImg))
                        .addGap(18, 18, 18)
                        .addComponent(rutaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarimagen)
                        .addGap(33, 82, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(particular))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addGap(21, 21, 21))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarimagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarimagenActionPerformed

    private void CargarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarImgActionPerformed
        FileDialog fd = new FileDialog(new JFrame(), "Choose a file", FileDialog.LOAD);
        fd.setDirectory("C:\\");
            fd.setFile("*.jpg;*.png");
            fd.setAlwaysOnTop(true);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ci =  (String) PacienteTable.getValueAt(PacienteTable.getSelectedRow(), 0);
        boolean part=false, elim=false;
        String nombre, apellido, correo, comboTipo, ciudad, departamento, calle;
        int edad, telefono, numero;
        nombre = txt_Nombre.getText();
        apellido = txt_Apellido.getText();
        edad = Integer.valueOf(txt_Edad.getText());
        telefono = Integer.valueOf(txt_Telefono.getText());
        ciudad = txt_Ciudad.getText();
        departamento = txt_Departamento.getText();
        calle = txt_Calle.getText();
        numero = Integer.valueOf(txt_Numero.getText());
        comboTipo = cmb_Tipo.getSelectedItem().toString();
        part = particular.isSelected();
        elim = eliminarimagen.isSelected();
        Direccion direccion = new Direccion(ciudad, departamento, calle, numero);

                boolean Ok;
                Ok = Pct.ModificarPCT(ci,nombre,apellido,edad,telefono,direccion,comboTipo,part,RutaImagen,elim);
                if(Ok){
                    javax.swing.JOptionPane.showMessageDialog(this,"El Paciente ha sido modificado");
                    this.dispose();
                }
                else{
                    javax.swing.JOptionPane.showMessageDialog(this,"El Paciente no ha podido ser modificado", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);
                }

            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmb_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_TipoActionPerformed

    }//GEN-LAST:event_cmb_TipoActionPerformed

    private void txt_CiudadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CiudadFocusGained
        if (txt_Ciudad.getText().equalsIgnoreCase("Ciudad")) {
            txt_Ciudad.setText("");
            txt_Ciudad.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_CiudadFocusGained

    private void txt_CiudadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CiudadFocusLost
        if (txt_Ciudad.getText().equalsIgnoreCase("")) {
            txt_Ciudad.setText("Ciudad");
            txt_Ciudad.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_CiudadFocusLost

    private void txt_CiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CiudadActionPerformed

    private void txt_NumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_NumeroFocusGained
        if (txt_Numero.getText().equalsIgnoreCase("Numero")) {
            txt_Numero.setText("");
            txt_Numero.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_NumeroFocusGained

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

    private void txt_NumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NumeroActionPerformed

    private void txt_CalleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CalleFocusGained
        if (txt_Calle.getText().equalsIgnoreCase("Calle")) {
            txt_Calle.setText("");
            txt_Calle.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_CalleFocusGained

    private void txt_CalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CalleFocusLost
        if (txt_Calle.getText().equalsIgnoreCase("")) {
            txt_Calle.setText("Calle");
            txt_Calle.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_CalleFocusLost

    private void txt_CalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CalleActionPerformed

    private void txt_DepartamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_DepartamentoFocusGained
        if (txt_Departamento.getText().equalsIgnoreCase("Departamento")) {
            txt_Departamento.setText("");
            txt_Departamento.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_DepartamentoFocusGained

    private void txt_DepartamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_DepartamentoFocusLost
        if (txt_Departamento.getText().equalsIgnoreCase("")) {
            txt_Departamento.setText("Departamento");
            txt_Departamento.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txt_DepartamentoFocusLost

    private void txt_DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DepartamentoActionPerformed

    private void PacienteTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PacienteTableMouseClicked
        if (PacienteTable.getSelectedRow() > -1) {
            for (Paciente p : pct.getPacientes()){
                if (p.getCi().equals(PacienteTable.getValueAt(PacienteTable.getSelectedRow(), 0))){
                    if (p.getImagen()!=null){
                        ImageIcon imagen = p.getImagen().getImagen();
                        Icon imagenperfil = new ImageIcon(imagen.getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_DEFAULT));
                        jLabel3.setIcon(imagenperfil);
                    }
                    else{
                        java.util.Properties pr = System.getProperties();
                        String cadena = pr.getProperty("user.dir");
                        ImageIcon imagen = new ImageIcon(cadena+"/src/Utils/iconoUsuario.jpg"); //genera la imagen que seleccionamos
                        Icon imagenperfil = new ImageIcon(imagen.getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_DEFAULT));
                        jLabel3.setIcon(imagenperfil);
                    }
                }
            }
            int part = Integer.parseInt((String) PacienteTable.getValueAt(PacienteTable.getSelectedRow(), 8));
            String par = String.valueOf(part);
            if(par.equals("Si")){
                //mostrar direccion y telefono
                }}

    }//GEN-LAST:event_PacienteTableMouseClicked

    private void buscarIngTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarIngTextFieldKeyReleased
        listarPacientes(buscarIngTextField.getText());
    }//GEN-LAST:event_buscarIngTextFieldKeyReleased

public void centrar(){
        //este metodo devuelve el tamaÃ±o de la pantalla
        int x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        int y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        int h = this.getHeight();
        int z = this.getWidth();
        this.setLocation(x/2-z/2,y/2-h/2);
        
    }    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser Buscar;
    private javax.swing.JButton CargarImg;
    private javax.swing.JButton CargarImg1;
    private javax.swing.JLabel Img;
    private javax.swing.JTable PacienteTable;
    private javax.swing.JTextField buscarIngTextField;
    private javax.swing.JComboBox<String> cmb_Tipo;
    private javax.swing.JCheckBox eliminarimagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox particular;
    private javax.swing.JLabel rutaImg;
    private javax.swing.JLabel rutaImg1;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_Calle;
    private javax.swing.JTextField txt_Ciudad;
    private javax.swing.JTextField txt_Departamento;
    private javax.swing.JPasswordField txt_Edad;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Numero;
    private javax.swing.JPasswordField txt_Telefono;
    // End of variables declaration//GEN-END:variables
}
