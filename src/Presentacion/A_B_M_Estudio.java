/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ControladorPacientes;
import Logica.DtEstudio;
import Logica.DtPrototipo;
import Logica.IContPaciente;
import Logica.Prototipo;
import Utils.JFrameConFondo;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ninoh
 */
public class A_B_M_Estudio extends JFrameConFondo {

    /**
     * Creates new form A_B_M_Estudio
     */
    private final IContPaciente Pct;
    List<DtEstudio> Est;
    List<DtPrototipo> Pro;
    DtEstudio dte;
    DtPrototipo dtp;
    public A_B_M_Estudio() {
        initComponents();
        Pct = ControladorPacientes.getInstance();
        Pct.getEstudiosBD();
        Pct.getPrototipoBD();
        setTitle("Alta Baja Modificacion de Estudio");
        this.setImagen("Fondo.jpg");
        
        listarEstudios("");
        listarPrototipos("");
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
    public void listarEstudios(String nombre) {

        DefaultTableModel modelo = (DefaultTableModel) EstudiosTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        Est = Pct.listarEstudio(nombre);
        for (DtEstudio e : Est) {
            for (Prototipo p : e.getPrototipos()){
                String[] datos = {ConvertirString(String.valueOf(e.getId())),ConvertirString(e.getNombre()),String.valueOf(p.getId())};
                modelo.addRow(datos);
            }
        }  
    }
     public void listarPrototipos(String nombre) {

        DefaultTableModel modelo = (DefaultTableModel) PrototipoTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        Pro = Pct.listarPrototipo(nombre);
        for (DtPrototipo p : Pro) {
            String[] datos = {ConvertirString(String.valueOf(p.getId())),String.valueOf(p.getPrototipo())};
            modelo.addRow(datos);
        }
        
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        AsistTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        EstudiosTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        PrototipoTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        buscarIngTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buscarIngTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        AsistTable1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        AsistTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "C.I.", "Correo", "Imagen", "Renumerado", "Horas renumeradas", "Horas trabajadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AsistTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        AsistTable1.setGridColor(new java.awt.Color(204, 204, 204));
        AsistTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AsistTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(AsistTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        EstudiosTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        EstudiosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre de Estudio", "Id Protoripo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EstudiosTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        EstudiosTable.setGridColor(new java.awt.Color(204, 204, 204));
        EstudiosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EstudiosTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(EstudiosTable);
        if (EstudiosTable.getColumnModel().getColumnCount() > 0) {
            EstudiosTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            EstudiosTable.getColumnModel().getColumn(1).setPreferredWidth(110);
        }

        PrototipoTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        PrototipoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Informe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PrototipoTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        PrototipoTable.setGridColor(new java.awt.Color(204, 204, 204));
        PrototipoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrototipoTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(PrototipoTable);
        if (PrototipoTable.getColumnModel().getColumnCount() > 0) {
            PrototipoTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            PrototipoTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Agregar");

        jButton4.setText("Modificar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setText("Aceptar");

        jButton7.setText("Cancelar");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        buscarIngTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarIngTextFieldKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Buscar Estudios:");

        buscarIngTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarIngTextField2KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Buscar Prototipos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(124, 124, 124)
                        .addComponent(jButton7)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(buscarIngTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buscarIngTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buscarIngTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buscarIngTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 74, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EstudiosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstudiosTableMouseClicked

        
        
    }//GEN-LAST:event_EstudiosTableMouseClicked

    private void AsistTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AsistTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AsistTable1MouseClicked

    private void PrototipoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrototipoTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PrototipoTableMouseClicked

    private void buscarIngTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarIngTextFieldKeyReleased
        listarEstudios(buscarIngTextField.getText());
    }//GEN-LAST:event_buscarIngTextFieldKeyReleased

    private void buscarIngTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarIngTextField2KeyReleased
        listarPrototipos(buscarIngTextField2.getText());
    }//GEN-LAST:event_buscarIngTextField2KeyReleased

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        dispose();
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (EstudiosTable.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "No hay ningun Estudio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (EstudiosTable.getSelectedRow() > -1) {
                String idEst = (String) EstudiosTable.getValueAt(EstudiosTable.getSelectedRow(), 0);
                dte = Pct.BuscarEstudio(idEst);
                ModificarEstudio nuevo = new ModificarEstudio(this);
                nuevo.toFront();
                nuevo.setVisible(true);
                nuevo.centrar();
                } else {
                JOptionPane.showMessageDialog(this, "No has seleccionado un Estudio");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if (PrototipoTable.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "No hay ningun Prototipo", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (PrototipoTable.getSelectedRow() > -1) {
                String idPro = (String) PrototipoTable.getValueAt(PrototipoTable.getSelectedRow(), 0);
                dtp = Pct.BuscarPrototipo(idPro);
                ModificarPrototipo nuevo = new ModificarPrototipo(this);
                nuevo.toFront();
                nuevo.setVisible(true);
                nuevo.centrar();
                } else {
                JOptionPane.showMessageDialog(this, "No has seleccionado un Prototipo");
            }
        }
    }//GEN-LAST:event_jButton4MouseClicked
    boolean ok;
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (EstudiosTable.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "No hay ningun Estudio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (EstudiosTable.getSelectedRow() > -1) {
                String idEst = (String) EstudiosTable.getValueAt(EstudiosTable.getSelectedRow(), 0);
                ok = Pct.EliminarEstudio(idEst);
                if(ok){JOptionPane.showMessageDialog(this, "El Estudio ha sido eliminado", "Operacion completada", JOptionPane.ERROR_MESSAGE);
                    this.listarEstudios("");
                    this.dispose();
                }else{JOptionPane.showMessageDialog(this, "El Estudio no se pudo eliminar", "Error", JOptionPane.ERROR_MESSAGE);}} else {
                JOptionPane.showMessageDialog(this, "No has seleccionado un Estudio");
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        if (PrototipoTable.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "No hay ningun Prototipo", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (PrototipoTable.getSelectedRow() > -1) {
                String idPro = (String) PrototipoTable.getValueAt(PrototipoTable.getSelectedRow(), 0);
                ok = Pct.EliminarPrototipo(idPro);
                if (ok) {
                    JOptionPane.showMessageDialog(this, "El Prototipo ha sido eliminado", "Operacion completada", JOptionPane.ERROR_MESSAGE);
                    this.listarPrototipos("");
                    this.dispose();
                }else {
                    JOptionPane.showMessageDialog(this, "El Prototipo no se pudo eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No has seleccionado un Prototipo");
            }
        }
    }//GEN-LAST:event_jButton5MouseClicked

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
            java.util.logging.Logger.getLogger(A_B_M_Estudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A_B_M_Estudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A_B_M_Estudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A_B_M_Estudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A_B_M_Estudio().setVisible(true);
            }
        });
    }
    public void centrar(){
        //este metodo devuelve el tamaÃ±o de la pantalla
        int x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        int y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        int h = this.getHeight();
        int z = this.getWidth();
        this.setLocation(x/2-z/2,y/2-h/2);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AsistTable1;
    private javax.swing.JTable EstudiosTable;
    private javax.swing.JTable PrototipoTable;
    private javax.swing.JTextField buscarIngTextField;
    private javax.swing.JTextField buscarIngTextField2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}