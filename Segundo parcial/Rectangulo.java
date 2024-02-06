import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;

public class Rectangulo extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;

    public Rectangulo(){

        setTitle("Rectangulo");
        setResizable(false);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();

    }

    public void putPixel(int x, int y, Color c){

        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, Math.round(x), Math.round(y), this);
        
    }

    public void crear(int x1, int y1, int alt, int an){

        int x11 = x1 + an; 
        int y11 = y1 + alt;

        
        for(int y = y1; y <= y11; y++){

            int x = x1;
            putPixel(x, y, Color.RED); //LINEA IZQUIERDA
            putPixel(x11, y, Color.RED); // LINEA DERECHA

        }

        for(int x = x1; x <= x11; x++){

            int y = y1;
            putPixel(x, y11, Color.RED); // LINEA INFERIOR
            putPixel(x, y + 5, Color.RED); //LINEA SUPERIOR

        }
    }

    public static void main(String[] args) {

        Rectangulo rec = new Rectangulo();
        rec.crear(125, 130, 80, 150);

    }
}
