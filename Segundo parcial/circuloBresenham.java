import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;
import java.lang.Math;

public class circuloBresenham extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;

    public circuloBresenham() {

        setTitle("Circulo - Bresenham");
        setResizable(false);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();

    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    public void dibujar(int xc, int yc, int x, int y){

        putPixel(xc + x, yc + y, Color.RED);  // (y, -x)
        putPixel(xc - x, yc + y, Color.RED);  // (-y, -x)
        putPixel(xc + x, yc - y, Color.RED);  // (y, x)
        putPixel(xc - x, yc - y, Color.RED);  // (-y, x)
        putPixel(xc + y, yc + x, Color.RED);  // (x, -y)
        putPixel(xc - y, yc + x, Color.RED);  // (-x, -y)
        putPixel(xc + y, yc - x, Color.RED);  // (x, y)
        putPixel(xc - y, yc - x, Color.RED);  // (-x, y)

    }

    public void calcularPixeles(int xc, int yc, int R) {

        int x = 0, y = R;
        int d = 3 - 2 * R;
        dibujar(xc, yc, x, y);

        while (y >= x) {

            x++;
            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + 10;
            } else
                d = d + 4 * x + 6;
                dibujar(xc, yc, x, y);

        }

    }

    public static void main(String args[]) {
        int xc = 250, yc = 250, R = 90;
        circuloBresenham b = new circuloBresenham();
        b.calcularPixeles(xc, yc, R);
    }

}
