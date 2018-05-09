package Utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameConFondo extends JFrame {

    private final JPanelConFondo contenedor = new JPanelConFondo();

    public JFrameConFondo() {
        setContentPane(contenedor);
        setUndecorated(true);
        JMoverFrame mueve1 = new JMoverFrame(contenedor);
        contenedor.addMouseListener(mueve1);
        contenedor.addMouseMotionListener(mueve1);
        try{
        this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:\\ProyectoJavaEE\\MediComp\\src\\Utils\\Fondo.jpg")))));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void setImagen(String nombreImagen) {
        contenedor.setImagen(nombreImagen);
    }

    public void setImagen(Image nuevaImagen) {
        contenedor.setImagen(nuevaImagen);
    }
}
