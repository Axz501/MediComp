/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;


import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.sun.awt.AWTUtilities;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 * @author Admin
 */
public class Inicio extends JFrame {
    public Inicio() {
        Image icono = new ImageIcon(getClass().getResource("/Utils/Logomini.png")).getImage();
        setIconImage(icono);
        setLayout(new FlowLayout());
        Icon splash = new ImageIcon(getClass().getResource("/Utils/logogrande.png"));
        JLabel imagen = new JLabel();
        imagen.setIcon(splash);
        add(imagen);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Inicio p = new Inicio();
        p.setUndecorated(true);
        p.setVisible(true);
        p.setBounds(0, 0, 567, 500);
        p.setLocationRelativeTo(null);
        try {
            Class clazz = Class.forName("com.sun.awt.AWTUtilities");
            Method method = clazz.getMethod("setWindowOpaque", java.awt.Window.class, Boolean.TYPE);
            method.invoke(clazz, p, false);
        } catch (Exception e) {
        }
        try {
            UIManager.setLookAndFeel(new NimRODLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
        }
        Timer timer = new Timer("Printer");
        MyTask t = new MyTask(p);
        timer.schedule(t, 0, 500);

    }
}
class MyTask extends TimerTask {
    //times member represent calling times.

    private int times = 0;
    private Inicio p;

    MyTask(Inicio p) {
        this.p = p;
    }

    @Override
    public void run() {
        times++;
        if (times < 0) {
        } else {
            //DatosDePrueba.Cargar();
            Principall p1 = new Principall();
            p1.setLocationRelativeTo(null);
            Image icono = new ImageIcon(getClass().getResource("/Utils/logomini.png")).getImage();
            p1.setIconImage(icono);
            p1.setVisible(true);
            //Shape shape = new RoundRectangle2D.Float(0, 0, 400, 217, 30, 30);
            //AWTUtilities.setWindowShape(p1, shape);
            p.dispose();
            this.cancel();
        }
    }
}
