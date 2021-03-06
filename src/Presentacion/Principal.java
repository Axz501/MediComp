/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Fabrica;
import Logica.IContUsuario;
import Logica.Usuario;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import Utils.JPanelConFondo;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 *
 * @author ninoh
 */
public class Principal extends JPanelConFondo {

    private Principall escritorio;
    private IContUsuario User;
    private JComboBox jcd;
    private JDialog diag;
    /**
     * Creates new form Principal
     */

    public Principal(int x, int y, Principall j) {
        initComponents(); 
        
        
        escritorio = j;
        User = Fabrica.getUsuario();
        
        jPanel1.setBounds(0, 0, x/2, y);
        jPanel1.repaint();
        jPanel3.setLocation(x/4*3-jPanel3.getWidth()/2, y/2-jPanel3.getHeight()/2);
        jPanel3.repaint();
        jPanel2.setLocation(x/4-jPanel2.getWidth()/2, y/2-jPanel2.getHeight()/2);
        jPanel2.repaint();
        //jPanel4.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        contra = new javax.swing.JPasswordField();
        Registrarse3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        Entrar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 51));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jPanel2.setOpaque(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Logo (2).png"))); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(15, 38, 420, 480);

        jPanel4.setOpaque(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Mages/cerrar-normal.png"))); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Mages/FrameResize.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Mages/minimizar-activo.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 10, 90, 25);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 460, 620);

        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contraseña:");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Iniciar Sesión");

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        contra.setBackground(new java.awt.Color(0, 0, 51));
        contra.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        contra.setForeground(new java.awt.Color(255, 255, 255));
        contra.setBorder(null);
        contra.setCaretColor(new java.awt.Color(255, 255, 255));
        contra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                contraFocusGained(evt);
            }
        });
        contra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contraKeyReleased(evt);
            }
        });

        Registrarse3.setBackground(new java.awt.Color(0, 0, 153));
        Registrarse3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Registrarse3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Registrarse3MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Registrarse");

        javax.swing.GroupLayout Registrarse3Layout = new javax.swing.GroupLayout(Registrarse3);
        Registrarse3.setLayout(Registrarse3Layout);
        Registrarse3Layout.setHorizontalGroup(
            Registrarse3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Registrarse3Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        Registrarse3Layout.setVerticalGroup(
            Registrarse3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Registrarse3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cedula de Identidad/Correo Electrónico:");

        Entrar.setBackground(new java.awt.Color(0, 204, 204));
        Entrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Entrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EntrarMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Entrar");

        javax.swing.GroupLayout EntrarLayout = new javax.swing.GroupLayout(Entrar);
        Entrar.setLayout(EntrarLayout);
        EntrarLayout.setHorizontalGroup(
            EntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EntrarLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        EntrarLayout.setVerticalGroup(
            EntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EntrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cedula.setBackground(new java.awt.Color(0, 0, 51));
        cedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cedula.setForeground(new java.awt.Color(255, 255, 255));
        cedula.setToolTipText("Introduzca su cédula sin puntos ni guiones");
        cedula.setBorder(null);
        cedula.setCaretColor(new java.awt.Color(255, 255, 255));
        cedula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        cedula.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        cedula.setSelectionColor(new java.awt.Color(153, 255, 255));
        cedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cedulaMouseClicked(evt);
            }
        });
        cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Si todavia no tienes un cuenta registrate.");

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));

        jButton4.setBackground(new java.awt.Color(51, 255, 255));
        jButton4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 153));
        jButton4.setText("Elegir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel3Layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.CENTER)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51)
                                    .addComponent(Registrarse3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(cedula)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Registrarse3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        add(jPanel3);
        jPanel3.setBounds(480, 30, 400, 490);
    }// </editor-fold>//GEN-END:initComponents

    private void cedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cedulaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaMouseClicked

    private void contraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contraFocusGained
        contra.setText("");
    }//GEN-LAST:event_contraFocusGained

    private void cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.escritorio.getExtendedState()==JFrame.MAXIMIZED_BOTH){
            this.escritorio.setState(Frame.NORMAL);
            this.escritorio.setExtendedState(Frame.NORMAL);
            
        }
        else{
            this.escritorio.setState(Frame.MAXIMIZED_BOTH);
            this.escritorio.setExtendedState(Frame.MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.escritorio.setState(Frame.ICONIFIED);
        //this.escritorio.setExtendedState(Frame.ICONIFIED);
        //this.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    JLabel label = new JLabel("¿Deseas salir del programa?");
    Font fuente = new Font("Verdana", Font.BOLD, 13);
    label.setFont(fuente);
    JLabel j1 = new JLabel("Si");
    JLabel j2 = new JLabel("No");
    j1.setFont(fuente);
    j1.setForeground(Color.black);
    j2.setFont(fuente);
    j2.setForeground(Color.black);
    Object[] options = {j1.getText(), j2.getText()};
    int x = JOptionPane.showOptionDialog(null,
    label,"Cerrar Programa",JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
    //int x = javax.swing.JOptionPane.showConfirmDialog(null, label , "Cerrar", JOptionPane.YES_NO_OPTION);
    if (x==0)
        System.exit(0);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void EntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntrarMouseClicked
        this.iniciarsesion();        
    }//GEN-LAST:event_EntrarMouseClicked

    public void iniciarsesion(){
        Color c = Entrar.getBackground();
        Border b = Entrar.getBorder();
        Color c2 = Registrarse3.getBackground();
        Entrar.setBackground(c2);
        Entrar.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.WHITE));
        Timer timer = new Timer(50, new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
          Entrar.setBackground(c);
          Entrar.setBorder(BorderFactory.createSoftBevelBorder(0));
        }
        });
        timer.setRepeats(false); // Only execute once
        timer.start();
        
        String ci = cedula.getText();
        char[] passw = contra.getPassword();
        String pass = "";
        for (int i=0;i<passw.length;i++)
            pass = pass + passw[i];
        if (User.login(ci, pass)){
            javax.swing.JOptionPane.showMessageDialog(null,"Sesión Iniciada");
            this.escritorio.changefeeltoNimrod();
            MenuPrincipal nuevo = new MenuPrincipal();
            nuevo.setVisible(true);
            nuevo.changefeeltoSeaGlass();
            this.escritorio.dispose();
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(null,"Credenciales Inválidas");
            Object[] options = {"Si","No"};
            int x = JOptionPane.showOptionDialog(null,
            "Si te has olvidado de tu contraseña puedes restaurarla ¿Deseas restaurar tu contraseña?","Contraseña de Cuenta",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if (x==0){
                String correo = javax.swing.JOptionPane.showInputDialog(null,"Ingrese el correo de su cuenta, para enviarle una nueva contraseña", "Restaurar Contraseña",JOptionPane.QUESTION_MESSAGE);
                if (correo!=null){
                    if (User.enviarcorreo(correo)){
                        JOptionPane.showMessageDialog(null, "Se te enviará un correo en breve a tu casilla", "Correo Válido", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Tu correo no esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    private void Registrarse3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Registrarse3MouseClicked
        Color c = Registrarse3.getBackground();
        Border b = Registrarse3.getBorder();
        Color f = jLabel10.getForeground();
        Registrarse3.setBackground(Entrar.getBackground());
        Registrarse3.setBorder(BorderFactory.createBevelBorder(1, Color.CYAN, Color.black));
        jLabel10.setForeground(Color.black);
        Registrarse nuevo = new Registrarse();
        String ruta = this.getClass().getClassLoader().getResource("").getPath();
        ruta = ruta.replace("build/classes/", "src/Utils/Logomini.png");
        Image icono = new ImageIcon(ruta).getImage();
        icono = icono.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        nuevo.setIconImage(icono);
        //nuevo.setSize(600,600);
        nuevo.setVisible(true);
        nuevo.centrar();
        JOptionPane.showMessageDialog(nuevo, "Ingresa un nuevo usuario");
        
        Timer timer = new Timer(50, new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
          Registrarse3.setBackground(c);
          Registrarse3.setBorder(b);
          jLabel10.setForeground(f);
        }
        });
        timer.setRepeats(false); // Only execute once
        timer.start();
    }//GEN-LAST:event_Registrarse3MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int i = 0;
        List<String> list = new ArrayList();
        for (Usuario u : User.getUsuarios().values()) {
            list.add(u.getCorreo());
            i++;
        }
        jcd = new JComboBox(list.toArray());
        //jcd.setEditable(true);
        Object[] options = new Object[] {};
        JOptionPane jop = new JOptionPane("Elija su correo",
                                        JOptionPane.QUESTION_MESSAGE,
                                        JOptionPane.DEFAULT_OPTION,
                                        null,options, null);
        jop.add(jcd);
        diag = new JDialog();
        diag.getContentPane().add(jop);
        diag.pack();
        diag.setSize(300,150);
        diag.setLocationRelativeTo(null);
        diag.setVisible(true);
        jcd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcdActionPerformed(evt);
            }
        });
    }//GEN-LAST:event_jButton4ActionPerformed

    private void contraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode()==10){
            this.iniciarsesion();
        }
    }//GEN-LAST:event_contraKeyReleased
    private void jcdActionPerformed(java.awt.event.ActionEvent evt){
        String texto = jcd.getSelectedItem().toString();
        cedula.setText(texto);
        diag.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Entrar;
    private javax.swing.JPanel Registrarse3;
    private javax.swing.JTextField cedula;
    private javax.swing.JPasswordField contra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
