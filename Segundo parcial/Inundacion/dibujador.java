import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class dibujador {

    private BufferedImage buffer;
    private JFrame parent;

    private static BufferedImage Fondo, BufferSol;// Image Fondo;
    private static Graphics gFondo, GraphicSol;

    public dibujador(JFrame parent) {

        this.parent = parent;
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Fondo = new BufferedImage(parent.getWidth(), parent.getHeight(), BufferedImage.TYPE_INT_RGB);
        gFondo = Fondo.getGraphics();
        BufferSol = new BufferedImage(parent.getWidth(), parent.getHeight(), BufferedImage.TYPE_INT_ARGB);
        GraphicSol = BufferSol.getGraphics();

    }

    public void pixel(int x, int y, Color c) {

        buffer.setRGB(0, 0, c.getRGB());
        parent.getGraphics().drawImage(buffer, x, y, parent);
        gFondo.drawImage(buffer, x, y, parent);

    }

    public void puntoMedio(int x1, int y1, int x2, int y2, Color c) {
        int pk, A, B, pxlx, pxly;

        int dx = (x2 - x1);
        int dy = (y2 - y1);

        if (dy < 0) {
            dy = -dy;
            pxly = -1;
        } else {
            pxly = 1;
        }
        if (dx < 0) {
            dx = -dx;
            pxlx = -1;
        } else {
            pxlx = 1;
        }

        int X = x1;
        int Y = y1;
        pixel(x1, y1, c);

        if (dx > dy) {
            pk = 2 * dy - dx;
            A = 2 * dy;
            B = 2 * (dy - dx);
            while (X != x2) {
                X = X + pxlx;
                if (pk < 0) {
                    pk = pk + A;
                } else {
                    Y = Y + pxly + 1 / 2;
                    pk = pk + B;
                }
                pixel(X, Y, c);
            }
        } else {
            pk = 2 * dx - dy;
            A = 2 * dx;
            B = 2 * (dx - dy);
            while (Y != y2) {
                Y = Y + pxly + 1 / 2;
                if (pk < 0) {
                    pk = pk + A;
                } else {
                    X = X + pxlx;
                    pk = pk + B;
                }
                pixel(X, Y, c);
            }
        }
    }

    public void inundacion(int x, int y, Color c) {
        int IntDelColorOld = Fondo.getRGB(x, y);
        Color ColorOld = new Color(IntDelColorOld);

        if (!ColorOld.equals(c)) {
            pixel(x, y, c);
            inundacion(x + 1, y, c);
            inundacion(x - 1, y, c);
            inundacion(x, y + 1, c);
            inundacion(x, y - 1, c);
        }
    }

}
