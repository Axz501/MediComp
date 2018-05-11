/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;


import Logica.Fabrica;
import Logica.IContUsuario;
import java.awt.Toolkit;
import javax.swing.JFrame;
import Utils.JFrameConFondo;
import Utils.JMoverFrame;
import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.seaglasslookandfeel.SeaGlassLookAndFeel;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;
import sun.java2d.SunGraphicsEnvironment;


/**
 *
 * @author ninoh
 */
public class Principall extends JFrameConFondo {

    /**
     * Creates new form Principall
     */
    private IContUsuario User;
    int x;
    int y;
    public Principall() {
        initComponents();
        this.changefeel();
        User = Fabrica.getUsuario();
        User.getUsuariosdeBD();
        //this.setUndecorated(false);
        this.repaint();
        x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        this.setContentPane(new Principal(x,y,this));
        
        setLocationRelativeTo(null);
        GraphicsConfiguration config = this.getGraphicsConfiguration();
        this.setMaximizedBounds(SunGraphicsEnvironment.getUsableBounds(config.getDevice()));
        setExtendedState(MAXIMIZED_BOTH);
        
        String ruta = this.getClass().getClassLoader().getResource("").getPath();
        ruta = ruta.replace("build/classes/", "src/Utils/Logomini.png");
        Image icono = new ImageIcon(ruta).getImage();
        icono = icono.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        setIconImage(icono);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        if(evt.getNewState()==JFrame.NORMAL){
        this.setSize(910, 551);
        Principal p = new Principal(910,551,this);
        this.setContentPane(p);
        this.setLocation(x/2-910/2,y/2-551/2);
        JMoverFrame mueve1 = new JMoverFrame(p);
        p.addMouseListener(mueve1);
        p.addMouseMotionListener(mueve1);
        }
        else if(evt.getNewState()==JFrame.MAXIMIZED_BOTH){
            x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
            y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            this.setContentPane(new Principal(x,y,this));
            setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_formWindowStateChanged

    public void minimizar(){
        this.setSize(910, 551);
        this.setContentPane(new Principal(910,551,this));
        this.setLocation(x/2-910/2,y/2-551/2);
        setExtendedState(NORMAL);
    }
    public void maximizar(){
        x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        this.setContentPane(new Principal(x,y,this));
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
    }
    public void changefeel(){
            try {
                javax.swing.UIManager.setLookAndFeel(new SeaGlassLookAndFeel());
                }
            catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Principall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
            javax.swing.UIManager.setLookAndFeel(new SeaGlassLookAndFeel());
            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Principall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Principall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Principall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Principall().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
