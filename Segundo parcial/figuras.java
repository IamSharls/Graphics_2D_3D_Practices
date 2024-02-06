import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;
import java.lang.Math;

public class figuras extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;

    public figuras() {

        setTitle("Practica Lineas");
        setResizable(false);
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();

    }

    public void lineasPixel(int x0, int y0, int x1, int y1, Color c) {

        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x0, y0, this);

        int dx, dy, A, B, p, steps;
        float xinc, yinc, x, y;

        dx = x1 - x0;
        dy = y1 - y0;

        A = 2 * dy;
        B = 2 * dy - 2 * dx;
        p = 2 * dy - dx;

        if (Math.abs(dx) > Math.abs(dy)) {
            steps = Math.abs(dx);
        } else {
            steps = Math.abs(dy);
        }

        xinc = (float) dx / steps;
        yinc = (float) dy / steps;

        x = x0;
        y = y0;

        for (int k = 1; k <= steps; ++k) {
            if (p < 0) {
                this.getGraphics().drawImage(buffer, Math.round(x) + 1, Math.round(y), this);
                p = p + A;
            } else {
                this.getGraphics().drawImage(buffer, Math.round(x) + 1, Math.round(y) + 1, this);
                p = p + B;
            }
            x = x + xinc;
            y = y + yinc;
        }
    }

    public void circulosPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    public void circuloPuntoMedio(int xc, int yc, int R) {
        int x = R, y = 0;

        circulosPixel((x + xc), (y + yc), Color.red);
        if (R > 0) {
            circulosPixel((x + xc), (-y + yc), Color.red);
            circulosPixel((y + xc), (x + yc), Color.red);
            circulosPixel((-y + xc), (x + yc), Color.red);

        }
        int P = 1 - R;
        while (x > y) {
            y++;
            if (P <= 0)
                P = P + 2 * y + 1;
            else {
                x--;
                P = P + 2 * y - 2 * x + 1;
            }
            if (x < y)
                break;
            circulosPixel((x + xc), (y + yc), Color.red);
            circulosPixel((-x + xc), (y + yc), Color.red);
            circulosPixel((x + xc), (-y + yc), Color.red);
            circulosPixel((-x + xc), (-y + yc), Color.red);
            if (x != y) {
                circulosPixel((y + xc), (x + yc), Color.red);
                circulosPixel((-y + xc), (x + yc), Color.red);
                circulosPixel((y + xc), (-x + yc), Color.red);
                circulosPixel((-y + xc), (-x + yc), Color.red);
            }
        }
    }

    
    public void elipsePixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    private void cuatroPuntos(int x0, int y0, int x, int y) {
        //metodo para completar cuadrantes restantes:
        
        elipsePixel(x0 + x, y0 + y, Color.RED);
        elipsePixel(x0 + x, y0 - y, Color.RED);
        elipsePixel(x0 - x, y0 + y, Color.RED);
        elipsePixel(x0 - x, y0 - y, Color.RED);
    }

    
    public void elipse(float x0, float y0, float rx, float ry) {
        float x, y, p, px, py;
        float rx2, ry2, tworx2, twory2;
        ry2 = ry * ry;
        rx2 = rx * rx;
        twory2 = 2 * ry2;
        tworx2 = 2 * rx2;

        float incx = 15 / rx2;
        float incy = 15 / ry2;
       
        x = 0;
        y = ry;
        cuatroPuntos((int) Math.round(x0), (int) Math.round(y0), (int) Math.round(x), (int) Math.round(y));
        p = (int) Math.round(ry2 - rx2 * ry + 0.25 * rx2);
        px = 0;
        py = tworx2 * y;

        
        while (px < py) {
           
            x = x + 1;
            px = px + twory2;
            if (p < 0) {
                p = p + ry2 + px;
            } else {
                y = y - 1;
                py = py - tworx2;
                p = p + ry2 + px - py;
            }
            cuatroPuntos((int) Math.round(x0), (int) Math.round(y0), (int) Math.round(x), (int) Math.round(y));
        }
        
        p = (int) Math.round(ry2 * (x + 0.5) * (x + 0.5) + rx2 * (y - 1) * (y - 1) - (rx2 * ry2));
        px = 0;
        py = tworx2 * y;
        while (y > 0) {
           
            y = y - 1;
            py = py - 1;
            if (p > 0) {
                p = p + rx2 - py;
            } else {
                x = x + 1;
                px = px + twory2;
                p = p + rx2 + py + px;
            }
            cuatroPuntos((int) Math.round(x0), (int) Math.round(y0), (int) Math.round(x), (int) Math.round(y));
        }
    }

    public void crearRectangulo(int x1, int y1, int alt, int an){

        int x11 = x1 + an; 
        int y11 = y1 + alt;

        
        for(int y = y1; y <= y11; y++){

            int x = x1;
            circulosPixel(x, y, Color.RED); //LINEA IZQUIERDA
            circulosPixel(x11, y, Color.RED); // LINEA DERECHA

        }

        for(int x = x1; x <= x11; x++){

            int y = y1;
            circulosPixel(x, y11, Color.RED); // LINEA INFERIOR
            circulosPixel(x, y + 1, Color.RED); //LINEA SUPERIOR

        }
    }

    public void crearRectanguloInverso(int x1, int y1, int alt, int an){

        int x11 = x1 + an; // 450
        int y11 = y1 + alt; //325

        //y = 325   Mientras 325 <= 275, se repite 50 veces
        for(int y = y11 ; y >= y1; y--){

            int x = x1;
            circulosPixel(x, y, Color.RED); //LINEA IZQUIERDA
            circulosPixel(x11, y, Color.RED); // LINEA DERECHA

        }

        //x = 450 Mientras 450 >= 300, se repite 150 veces
        for(int x = x11; x >= x1; x--){

            int y = y1;
            circulosPixel(x, y11, Color.RED); // LINEA INFERIOR
            circulosPixel(x, y + 1, Color.RED); //LINEA SUPERIOR

        }
    }


    public static void main(String[] args) {

        figuras b = new figuras();

        b.lineasPixel(100, 130, 170, 180, Color.red); // Pendiente negativa
        b.lineasPixel(290, 155, 210, 155, Color.RED); // Horizontal 1
        b.lineasPixel(350, 131, 290, 185, Color.RED); // Pendiente positiva
        b.lineasPixel(370, 157, 450, 157, Color.red);

        // Circulo grande
        b.circuloPuntoMedio(100, 300, 60);
        // Circulo mediano
        b.circuloPuntoMedio(100, 300, 40);
        // Circulo pequeño
        b.circuloPuntoMedio(100, 300, 20);
        // Circulo a centro
        b.circuloPuntoMedio(100, 300, 5);

        b.elipse(390, 400, 80, 35);
        b.elipse(390, 400, 80, 35);
        b.elipse(390, 400, 65, 25);
        b.elipse(390, 400, 50, 12);
        b.elipse(390, 400, 30, 5);

        b.crearRectangulo(250, 250, 100, 250);
        b.crearRectanguloInverso(300, 275, 50, 150);

    }

}
