/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ControladorPacientes;
import Logica.ControladorUsuarios;
import Logica.DtConsulta;
import Logica.DtEstudio;
import Logica.IContPaciente;
import Logica.IContUsuario;
import Logica.Medico;
import Logica.NombredeEstudio;
import Logica.Paciente;
import Logica.Prototipo;
import Utils.JFrameConFondo;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ninoh
 */
public class EditarModificar_EstudioaPaciente extends JFrameConFondo {

    /**
     * Creates new form EditarModificar_EstudioaPaciente
     */   
    private final IContPaciente Pct;
    private final IContUsuario Usr;
    List<DtEstudio> Est;
    ArrayList<NombredeEstudio> es;
    ArrayList<Paciente> pa;
    List<DtConsulta> consultas;
    
    public EditarModificar_EstudioaPaciente() {
        initComponents();
                Pct = ControladorPacientes.getInstance();
        Usr = ControladorUsuarios.getInstance();
        Pct.getEstudiosBD();
        Pct.getPacientesdeBD();
        setTitle("Agregar Estudio a Paciente");
        this.setImagen("Fondo.jpg");
        listarjornadas();
        listarEstudios("");
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
                String[] datos = {ConvertirString(String.valueOf(e.getId())),ConvertirString(e.getNombre()),String.valueOf(p.getPrototipo())};
                modelo.addRow(datos);
            }
        }  
    }
    public void listarjornadas(){
        DefaultTableModel modelo = (DefaultTableModel)JornadaTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        consultas = Usr.getListadoJornadas("");
        for (DtConsulta d : consultas) {
            LocalDateTime localDate = d.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            int year  = localDate.getYear();
            int month = localDate.getMonthValue();
            int day   = localDate.getDayOfMonth();
            int hr = localDate.getHour();
            int min = localDate.getMinute();
            String[] datos = {day+"/"+month+"/"+year,"0"+hr+":"+"0"+min,d.getEntidad()!=null ? d.getEntidad().getNombre() : d.getDir().getDepartamento()+" "+d.getDir().getCiudad()+" "+d.getDir().getCalle()+" "+d.getDir().getNumero(),ConvertirString(d.getDtp().getNombre()+" "+d.getDtp().getApellido()),d.getDtp().getCi()};
            modelo.addRow(datos);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        JornadaTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buscarIngTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        EstudiosTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buscarIngTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JornadaTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        JornadaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Hora", "Hora Consulta", "Entidad/Direccion", "Nombre Paciente", "Ci"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JornadaTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        JornadaTable.setGridColor(new java.awt.Color(204, 204, 204));
        JornadaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JornadaTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JornadaTable);
        if (JornadaTable.getColumnModel().getColumnCount() > 0) {
            JornadaTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            JornadaTable.getColumnModel().getColumn(2).setPreferredWidth(120);
            JornadaTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        }

        jButton1.setText("Modificar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Buscar Consulta:");

        buscarIngTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarIngTextField1KeyReleased(evt);
            }
        });

        EstudiosTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        EstudiosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre de Estudio", "Informe del Protoripo"
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

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Buscar Estudio:");

        buscarIngTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarIngTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(buscarIngTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(buscarIngTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buscarIngTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buscarIngTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JornadaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JornadaTableMouseClicked

    }//GEN-LAST:event_JornadaTableMouseClicked

    private void buscarIngTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarIngTextField1KeyReleased
        listarjornadas();
    }//GEN-LAST:event_buscarIngTextField1KeyReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (JornadaTable.getSelectedRow() < -1 && EstudiosTable.getSelectedRow() < -1) {
            JOptionPane.showMessageDialog(this, "No hay ningun Estudio o Jornada Selecionada", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JornadaTable.getSelectedRow() > -1 && EstudiosTable.getSelectedRow() < -1) {
                String idEst = (String) JornadaTable.getValueAt(JornadaTable.getSelectedRow(), 0);
                ModificarEstudioaPaciente nuevo = new ModificarEstudioaPaciente(this);
                nuevo.toFront();
                nuevo.setVisible(true);
                nuevo.centrar();
                } else {
                JOptionPane.showMessageDialog(this, "No has seleccionado un Estudio");
            }
        
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (JornadaTable.getSelectedRow() > -1 && EstudiosTable.getSelectedRow() > -1) {
            Long id;
            boolean b = true, ok=false;
            DtConsulta Con = consultas.get(JornadaTable.getSelectedRow());
            Medico u = (Medico) Usr.getSesionactiva();
            id = Con.getId();
                    if(b){
                        //ok = Pct.EliminarEstudioaPaciente();
                        if(ok){
                            JOptionPane.showMessageDialog(this, "El estudio del paciente ha sido eliminado correctamente", "Operacion Completada", JOptionPane.ERROR_MESSAGE);
                            this.dispose();
                        }else{
                            JOptionPane.showMessageDialog(this, "No se pudo eliminar el estudio seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
                            this.dispose();
                        }
                    }
                   
            
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void EstudiosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstudiosTableMouseClicked

    }//GEN-LAST:event_EstudiosTableMouseClicked

    private void buscarIngTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarIngTextFieldKeyReleased
        listarEstudios(buscarIngTextField.getText());
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
            java.util.logging.Logger.getLogger(EditarModificar_EstudioaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarModificar_EstudioaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarModificar_EstudioaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarModificar_EstudioaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarModificar_EstudioaPaciente().setVisible(true);
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
    private javax.swing.JTable EstudiosTable;
    private javax.swing.JTable JornadaTable;
    private javax.swing.JTextField buscarIngTextField;
    private javax.swing.JTextField buscarIngTextField1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
