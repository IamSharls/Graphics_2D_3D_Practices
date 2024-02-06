import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;
import java.lang.Math;

public class rectaSimpleMejorado extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel;

    // Constructor
    public rectaSimpleMejorado() {

        setTitle("Ecuacion de la Recta - Mejorado");
        setResizable(false);
        setSize(400, 400);
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

    public void correcciones(float x0, float y0, float x1, float y1) {

        float dx, dy, m, b;

        dx = (float)x1 - x0;
        dy = (float)y1 - y0;
        m = (dy)/(dx);
        b = y0-(m*x0);

        // Sin pendiente - LINEA ROJA
        if (dx == 0) {

            if (y0 > y1) {
                for (int y = (int) y0; y > (int) y1; y--) {
                    putPixel((int) x0, y, Color.RED);
                }
            } else {
                for (int y = (int) y0; y < (int) y1; y++) {
                    putPixel((int) x0, y, Color.RED);
                }
            }

        }

        // Restas negativas - LINEA AZUL
        else if ((x0 > x1) && (y0 <= y1)) {
            dy = y0 - y1;
            dx = x0 - x1;

            m = (dy) / (dx);
            b = y1 - (m * x1);
            float y = 0;

            for (int x = (int) x1; x < x0; x++) {

                y = Math.round((m * x) + b);
                putPixel(x, (int) y, Color.BLUE);

            }
        }

        //Pendiente mayor a 1 - LINEA NEGRA
        else if (Math.abs(m) < 1) {

            m = (dy) / (dx);
            b = y0 - (m * x0);
            float x = 0;

            for (int y = (int) y1; y < (int) y0; y++) {

                x = (y - b) / m;
                putPixel((int) x, y, Color.BLACK);

            }

        }

        else {
            for (int x = (int) x0; x <= x1; x++) {

                int y = Math.round(m * x + b);
                putPixel(x, y, Color.GREEN);

            }
        }

    }

    public static void main(String[] args) {

        rectaSimpleMejorado recta = new rectaSimpleMejorado();

        // Recta 1 - Sin pendiente
        int x0 = 50;
        int y0 = 300;
        int x1 = 50;
        int y1 = 100;

        // Recta 2 - Restas negativas
        int x00 = 250;
        int y00 = 150;
        int x11 = 100;
        int y11 = 300;

        // Recta 3 - Pendiente mayor a 1
        int x000 = 150;
        int y000 = 100;
        int x111 = 50;
        int y111 = 50;

        recta.correcciones(x0, y0, x1, y1);
        recta.correcciones(x00, y00, x11, y11);
        recta.correcciones(x000, y000, x111, y111);
    }

}
