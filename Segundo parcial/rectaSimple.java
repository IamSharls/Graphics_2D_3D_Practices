import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;
import java.lang.Math;


public class rectaSimple extends JFrame{

    private BufferedImage buffer;
    private Graphics graPixel;

    public rectaSimple(){
        setTitle("Ecuacion de la Recta - Simple");
        setResizable(false);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
    }

    public void putPixel(int x0, int y0, int x1, int y1, Color c){
        buffer.setRGB(0, 0, c.getRGB());

        float dx, dy, m, b;
        int y;

        dx = (float)x1 - x0;
        dy = (float)y1 - y0;
        m = (dy)/(dx);
        b = y0-(m*x0);

        for(int x = x0; x <= x1; x = x + 1){
            y = Math.round(m * x + b);
            this.getGraphics().drawImage(buffer, x, y, this);
        }
     
    }

    public static void main(String[] args) {

        rectaSimple recta = new rectaSimple();

        //Recta 1
        int x0 = 50;
        int y0 = 100;
        int x1 = 200;
        int y1 = 300;

        //Recta 2
        int x00 = 200;
        int y00 = 150;
        int x11 = 250;
        int y11 = 300;

        recta.putPixel(x0, y0, x1, y1, Color.RED);
        recta.putPixel(x00, y00, x11, y11, Color.GREEN);
    }

}