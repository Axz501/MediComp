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
import Logica.Usuario;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ninoh
 */
public class ListaAsistentes extends javax.swing.JFrame {

    /**
     * Creates new form ListaAsistentes
     */
    private IContUsuario Usr;
    ArrayList<Asistente> asi;   
    public ListaAsistentes() {
        initComponents();
        Usr = ControladorUsuarios.getInstance();
        setTitle("Lista de Asistentes");
        setResizable(false);
        listarAsistentes("");
    }
     public void listarAsistentes(String ci) {

        DefaultTableModel modelo = (DefaultTableModel) AsistTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        if(!ci.equals("")){
        asi = Usr.BuscarAsistente(ci);}else{
        asi = Usr.listarAsistentes();
        }

        for (Asistente a : asi) {
            String[] datos = {a.getNombre() + " " + a.getApellido(), a.getCorreo(),String.valueOf(a.getHoras_renumeradas()),String.valueOf(a.getHoras_trabajadas())};
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AsistTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        AsistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Apellido", "Correo", "Horas renumeradas", "Horas trabajadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buscarIngTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AsistTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AsistTableMouseClicked

    }//GEN-LAST:event_AsistTableMouseClicked

    private void AsistTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AsistTableKeyReleased

    }//GEN-LAST:event_AsistTableKeyReleased

    private void buscarIngTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarIngTextFieldKeyReleased
        listarAsistentes(buscarIngTextField.getText());
    }//GEN-LAST:event_buscarIngTextFieldKeyReleased

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
            java.util.logging.Logger.getLogger(ListaAsistentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAsistentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAsistentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAsistentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAsistentes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AsistTable;
    private javax.swing.JTextField buscarIngTextField;
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
