package Utils;

import java.awt.Image;
import javax.swing.JFrame;

public class JFrameConFondo extends JFrame {

    private final JPanelConFondo contenedor = new JPanelConFondo();

    public JFrameConFondo() {
        setContentPane(contenedor);
        setUndecorated(true);
        JMoverFrame mueve1 = new JMoverFrame(contenedor);
        contenedor.addMouseListener(mueve1);
        contenedor.addMouseMotionListener(mueve1);
    }

    public void setImagen(String nombreImagen) {
        contenedor.setImagen(nombreImagen);
    }

    public void setImagen(Image nuevaImagen) {
        contenedor.setImagen(nuevaImagen);
    }
}
