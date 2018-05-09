package Utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
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
        
//        try{
//        String path = Paths.get("").toAbsolutePath().toString() + "/src/Utils/Fondo.jpg";
//        this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(path)))));
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }
    }

    public void setImagen(String nombreImagen) {
        contenedor.setImagen(nombreImagen);
    }

    public void setImagen(Image nuevaImagen) {
        contenedor.setImagen(nuevaImagen);
    }
}
