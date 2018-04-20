/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import UpperEssential.UpperEssentialLookAndFeel;
import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import Utils.JFrameConFondo;
import Utils.JMoverFrame;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author ninoh
 */
public class Principall extends JFrameConFondo {

    /**
     * Creates new form Principall
     */
    int x;
    int y;
    public Principall() {
        if (!this.isUndecorated()){
            this.setUndecorated(true);
        }
        initComponents();
        this.repaint();
        x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        this.setContentPane(new Principal(x,y,this));
        
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        
        String ruta = this.getClass().getClassLoader().getResource("").getPath();
        ruta = ruta.replace("build/classes/", "src/Utils/Logomini.png");
        javax.swing.JOptionPane.showMessageDialog(null,ruta);
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
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        getContentPane().setLayout(null);

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
        if(evt.getNewState()!=JFrame.ICONIFIED && evt.getNewState()!=JFrame.NORMAL){
            x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
            y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            this.setContentPane(new Principal(x,y,this));
            setLocationRelativeTo(null);
            setExtendedState(MAXIMIZED_BOTH);
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
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
            javax.swing.UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("src/Utils/TemaLindo2.theme"));
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principall().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
