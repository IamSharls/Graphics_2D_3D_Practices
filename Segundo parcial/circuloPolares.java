import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;
import java.lang.Math;

public class circuloPolares extends JFrame{

    private BufferedImage buffer;
    private Graphics graPixel;

    public circuloPolares(){

        setTitle("Circulo - Coordenadas Polares");
        setResizable(false);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();

    }

    public void putPixel2(int x, int y, Color c){
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    public void putPixel(int xc, int yc, int R){

        double theta = Math.toRadians(0);
        int x = R;
        int y = 0;

        while(theta  <= 2 * Math.PI){

            putPixel2(x + xc, y + yc, Color.RED);
            theta = theta + Math.toRadians(.1);
            double xd = R * Math.cos(theta);
            x = (int)Math.round(xd);
            double yd = R * Math.sin(theta);
            y = (int)yd; 

        }

    }

    public static void main(String args[]){
        int xc = 250, yc = 250, R = 90;
        circuloPolares b = new circuloPolares();
        b.putPixel(xc, yc, R);
    }
}
