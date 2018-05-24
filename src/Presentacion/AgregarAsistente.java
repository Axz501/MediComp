/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Asistente;
import Logica.ControladorUsuarios;
import Logica.Fabrica;
import Logica.IContUsuario;
import Logica.Medico;
import Logica.Usuario;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Presentacion.ModificarAsistente;
import java.util.List;


/**
 *
 * @author ninoh
 */
public class AgregarAsistente extends javax.swing.JFrame {

    /**
     * Creates new form ListaAsistentes
     */
    private DefaultTableModel modelo;
    private ModificarAsistente mod;
    private IContUsuario Usr;
    ArrayList<Asistente> asi = null; 
    Asistente assi;
    public AgregarAsistente() {
        initComponents();
        Usr = ControladorUsuarios.getInstance();
        setTitle("Lista de Asistentes");
        setResizable(false);
        
//        List<DtArtista> artistas = Art.BuscarArtistas(BusquedaArtista.getText());
//            
//        //modelo=(DefaultTableModel) tablart.getModel();
//        
//        for (int i=0;i<artistas.size();i++){
//            DtArtista dt = (DtArtista)artistas.get(i);
//            Object[] dat={dt.getNickname(), dt.getNombre(), dt.getApellido()};
//            modelo.addRow(dat);
//            }
//        }
        asi = (ArrayList<Asistente>) Usr.getAsistentes();
        modelo = (DefaultTableModel) AsistTable.getModel();
        modelo.setRowCount(0);
        for (Asistente a : asi) {
            String[] datos = {a.getNombre() + " " + a.getApellido(),a.getCi(), a.getCorreo(),String.valueOf(a.getHoras_renumeradas()),String.valueOf(a.getHoras_trabajadas())};
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

        jScrollPane2 = new javax.swing.JScrollPane();
        AsistTable = new javax.swing.JTable();
        buscarIngTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        AsistTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        AsistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Completo", "C.I.", "Correo", "Horas renumeradas", "Horas trabajadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AsistTable.setGridColor(new java.awt.Color(204, 204, 204));
        AsistTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AsistTableMouseClicked(evt);
            }
        });
        AsistTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AsistTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(AsistTable);

        buscarIngTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarIngTextFieldKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar Asistente:");

        jButton1.setText("Agregar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarIngTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buscarIngTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AsistTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AsistTableMouseClicked

    }//GEN-LAST:event_AsistTableMouseClicked

    private void AsistTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AsistTableKeyReleased

    }//GEN-LAST:event_AsistTableKeyReleased

    private void buscarIngTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarIngTextFieldKeyReleased
        JOptionPane.showMessageDialog(this, modelo.getValueAt(AsistTable.getSelectedRow(),AsistTable.getSelectedColumn()));
    }//GEN-LAST:event_buscarIngTextFieldKeyReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (AsistTable.getSelectedRow() > -1) {
            String correo = (String) AsistTable.getValueAt(AsistTable.getSelectedRow(), 1);
            assi = Usr.BuscarAsist(correo);
            Usuario u = Usr.getSesionactiva();
            if (u instanceof Medico) {
                ((Medico) u).AgregarAsistente(assi);
                javax.swing.JOptionPane.showMessageDialog(this, "El Asistente ha sido agregado");
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(AgregarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarAsistente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AsistTable;
    private javax.swing.JTextField buscarIngTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
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


