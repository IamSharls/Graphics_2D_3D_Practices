import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.lang.Math;

public class recorteCircunferencia extends JFrame{

    private BufferedImage buffer;

    //Indices maximos y minimos
    int xmin = 100, xmax = 400, ymin = 100, ymax = 380;

    public recorteCircunferencia(){
        setTitle("Recorte de Circunferencia");
        setResizable(false);
		setSize(550,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        
        lineaBresenham(xmin, ymin, xmax, ymin, Color.RED);
        lineaBresenham(xmin, ymin, xmin, ymax, Color.RED);
        lineaBresenham(xmax, ymax, xmax, xmin, Color.RED);
        lineaBresenham(xmax, ymax, xmin, ymax, Color.RED);
        lineaBresenham(xmin, ymin, xmax, ymin, Color.RED);
    }

    //Funcion para dibujar un pixel
    public void putPixel(int x, int y, Color c){
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    //Funcion para dibujar lineas del rectangulo
    public void lineaBresenham(int x0, int y0, int x1, int y1, Color c){
        int dx = x1 - x0;
        int dy = y1 - y0;

        int A = 2 * dy;
        int B = 2 * dy - 2 * dx;
        int p = 2 * dy - dx;

        int steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);
        float xinc = (float) dx / steps;
        float yinc = (float) dy / steps;

        float x = x0;
        float y = y0;

        for(int k = 1; k <= steps; ++k){
            if(p < 0){
                putPixel(Math.round(x) + 1, Math.round(y), c);
                p = p + A;
            } else {
                putPixel(Math.round(x) + 1, Math.round(y) + 1, c);
                p = p + B;
            }
            x = x + xinc;
            y = y + yinc;
        }
    }
    
    //Funcion para calcular que octantes estan dentro de los rangos minimos y maximos 
    public void calculoOctantes(int xc, int yc, int R, Color c) {
        double a = 2, x = 0, h = xc, k = yc,y = R;

        double xf=R/Math.sqrt(2);
        
        while(x <= xf){

        y= Math.sqrt(R*R-x*x);

        if (((int)Math.round(x+h)) > xmin && ((int)Math.round(x+h)) < xmax){
            if ((int)Math.round(y+k) > ymin && (int)Math.round(y+k) < ymax) {
                putPixel((int)Math.round(x+h), (int)Math.round(y+k), Color.BLUE);
            }
            if((int)Math.round(-y+k) > ymin && (int)Math.round(-y+k) < ymax) {
                putPixel((int)Math.round(x+h), (int)Math.round(-y+k), Color.BLUE);
            }            
        }

        if ((int)Math.round(-x+h) > xmin && (int)Math.round(-x+h) < xmax) {
            if((int)Math.round(y+k) > ymin && (int)Math.round(y+k) < ymax) {
                putPixel((int)Math.round(-x+h), (int)Math.round(y+k), Color.BLUE);
            }
            if ((int)Math.round(-y+k) > ymin && (int)Math.round(-y+k) < ymax) {
                putPixel((int)Math.round(-x+h), (int)Math.round(-y+k), Color.BLUE);
            }
        }

        if ((int)Math.round(y+h) > xmin && (int)Math.round(y+h) < xmax) {
            if ((int)Math.round(x+k) > ymin && (int)Math.round(x+k) < ymax) {
                putPixel((int)Math.round(y+h), (int)Math.round(x+k), Color.BLUE);
            }
            if ((int)Math.round(-x+k) > ymin && (int)Math.round(-x+k) < ymax) {
                putPixel((int)Math.round(y+h), (int)Math.round(-x+k), Color.BLUE);
            }
        }
        if ((int)Math.round(-y+h) > xmin && (int)Math.round(-y+h) < xmax) {
            if ((int)Math.round(x+k) > ymin && (int)Math.round(x+k) < ymax) {
                putPixel((int)Math.round(-y+h), (int)Math.round(x+k), Color.BLUE);
            }
            if ((int)Math.round(-x+k) > ymin && (int)Math.round(-x+k) < ymax) {
                putPixel((int)Math.round(-y+h), (int)Math.round(-x+k), Color.BLUE);
            }
        }
        x = x+1;
        }
    }

    public static void main(String[] args) {
        recorteCircunferencia l = new recorteCircunferencia();
        //Circulos dentro de los limites
        l.calculoOctantes(245, 236, 20, Color.BLUE);
        l.calculoOctantes(359, 184, 80, Color.BLUE);
        l.calculoOctantes(390, 369, 50, Color.BLUE);
        l.calculoOctantes(76, 235, 80, Color.BLUE);

        //Circulo fuera de los limites
        l.calculoOctantes(458, 200, 80, Color.BLUE);
    }
}
