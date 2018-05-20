/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.Fabrica;
import Logica.IContUsuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author ninoh
 */
public class ModificarPerfil extends javax.swing.JFrame {

    /**
     * Creates new form ModificarPerfil
     */
    String RutaImagen;
    private IContUsuario Usr;
    public ModificarPerfil() {
        initComponents();
        this.Usr = Fabrica.getUsuario();
        setTitle("Modificar Perfil");
        setResizable(false);
        getRootPane().setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.cyan,Color.white));

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
        txt_Apellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Contra = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        txt_Contra1 = new javax.swing.JPasswordField();
        Img = new javax.swing.JLabel();
        CargarImg = new javax.swing.JButton();
        CargarImg1 = new javax.swing.JButton();
        rutaImg = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Apellido:");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Contraseña:");

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setText("Verificacion Contraseña: ");

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

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rutaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CargarImg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CargarImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txt_Contra)
                                    .addComponent(txt_Contra1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(38, 38, 38)))
                        .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_Contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_Contra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Img, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CargarImg1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CargarImg)
                                .addComponent(jButton1)
                                .addComponent(jButton2)))
                        .addGap(18, 18, 18)
                        .addComponent(rutaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void CargarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarImgActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes", "jpg", "png", "JPG", "PNG"); // filtro para el Filechooser
        Buscar.setFileFilter(filtro);
        int a = Buscar.showOpenDialog(this); // guarda la accion que se realiza en el filechooser

        if (a == JFileChooser.APPROVE_OPTION) { // la accion si se le da a abrir
            File archivo = Buscar.getSelectedFile(); // capturar el nombre y ruta

            RutaImagen = archivo.getPath();
            String rutaMostrar = RutaImagen;

            //Si la ruta es muy larga, la corta y le ponde los puntos suspesivos para mostrarla
            if (RutaImagen.length() > 35) {
                rutaMostrar = RutaImagen.substring(0, 35) + "...";
            }

            rutaImg.setText(rutaMostrar);
            ImageIcon imagen = new ImageIcon(RutaImagen); //genera la imagen que seleccionamos
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(Img.getWidth(), Img.getHeight(), Image.SCALE_DEFAULT));

            this.Img.setIcon(icono); // coloca la imagen en el label

            this.pack();
        }
    }//GEN-LAST:event_CargarImgActionPerformed

    private void CargarImg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarImg1ActionPerformed
        RutaImagen = null;
        rutaImg.setText("");
        this.Img.setIcon(null); // limpia la imagen del label
    }//GEN-LAST:event_CargarImg1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean formatOk=true;
        String nombre, apellido;
        String contrasenia = new String(txt_Contra.getPassword());
        String contrasenia2 = new String(txt_Contra1.getPassword());

        nombre = txt_Nombre.getText();
        apellido = txt_Apellido.getText();


            if (!contrasenia.equals(contrasenia2)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
                formatOk = false;
                txt_Contra.setText(null);
                txt_Contra1.setText(null);
            } else {
                formatOk = true;
            }

            if(formatOk){

                boolean Ok;
                    Ok = Usr.ModificarUSR(nombre,apellido,contrasenia, RutaImagen);
                    if(Ok){
                        javax.swing.JOptionPane.showMessageDialog(this,"El Usuario ha sido modificado");
                        this.dispose();
                    }
                    else{
                        javax.swing.JOptionPane.showMessageDialog(this,"El Usuario no ha podido ser modificado", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);
                    }
               
            }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser Buscar;
    private javax.swing.JButton CargarImg;
    private javax.swing.JButton CargarImg1;
    private javax.swing.JLabel Img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel rutaImg;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JPasswordField txt_Contra;
    private javax.swing.JPasswordField txt_Contra1;
    private javax.swing.JTextField txt_Nombre;
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
