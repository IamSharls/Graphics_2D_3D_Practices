import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.lang.Math;

public class recortePorPunto extends JFrame{

    private BufferedImage buffer;

    //Sectores
    int dentro = 0 /*0000*/, izquierda = 1 /*0001*/, derecha = 2 /*0010*/, abajo = 4 /*0100*/, arriba = 8 /*1000*/;   
   
    //Indices maximos y minimos
    int xmin = 100, xmax = 400, ymin = 100, ymax = 380;

    public recortePorPunto(){
        setTitle("Recorte por punto");
        setResizable(true);
		setSize(550,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);  
        
        //Dibujando el rectangulo
        lineaBresenham(xmin, ymin, xmax, ymin, Color.RED);
        lineaBresenham(xmin, ymin, xmin, ymax, Color.RED);
        lineaBresenham(xmax, ymax, xmax, xmin, Color.RED);
        lineaBresenham(xmax, ymax, xmin, ymax, Color.RED);
        //Segmento faltante
        lineaBresenham(xmin, ymin, xmax, ymin, Color.RED);
    }

    //Funcion para dibujar un pixel
    public void putPixel(int x, int y, Color c){
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    //Funcion para calcular en que sector se encuentra el punto inicial y final
    public int calSec(double x, double y){
        int sector = dentro;
 
        if (x < xmin)          
            sector |= izquierda;
        else if (x > xmax)     
            sector |= derecha;
        if (y < ymin)          
            sector |= abajo;
        else if (y > ymax)     
            sector |= arriba;
    
        return sector;
    }

    //Funcion para calcular como se va a dibujar la linea dependiendo de los sectores
    public void dibujarLineaCalculada(double x1, double y1, double x2, double y2, Color c){
        //Calculamos en que sectores se encuentran el punto de inicio y el punto de final
        int sector1 = calSec(x1, y1);
        int sector2 = calSec(x2, y2);

        boolean aceptar = false;
        
        //Serie de condiciones para dibujar la linea
        while (true) {
            if ((sector1 == 0) && (sector2 == 0)) {
                aceptar = true;
                break;
            }
            else if ((sector1 & sector2) != 0) {
               
                break;
            }
            else {
                int sector_out;
                double x = 0;
                double y = 0;
     
                if (sector1 != 0)
                    sector_out = sector1;
                else
                    sector_out = sector2;
     
                if ((sector_out & arriba) != 0) {
                   
                    x = x1 + (x2 - x1) * (ymax - y1) / (y2 - y1);
                    y = ymax;
                }
                else if ((sector_out & abajo) != 0) {
                    
                    x = x1 + (x2 - x1) * (ymin - y1) / (y2 - y1);
                    y = ymin;
                }
                else if ((sector_out & derecha) != 0) {
                    
                    y = y1 + (y2 - y1) * (xmax - x1) / (x2 - x1);
                    x = xmax;
                }
                else if ((sector_out & izquierda) != 0) {
                   
                    y = y1 + (y2 - y1) * (xmin - x1) / (x2 - x1);
                    x = xmin;
                }
     
                if (sector_out == sector1) {
                    x1 = x;
                    y1 = y;
                    sector1 = calSec(x1, y1);
                }
                else {
                    x2 = x;
                    y2 = y;
                    sector2 = calSec(x2, y2);
                }
            }
        }
        if (aceptar) {
            lineaBresenham((int)x1, (int)y1, (int)x2, (int)y2, c);
        }
    }

    //Funcion para dibujar lineas
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
    
    public static void main(String[] args) {
        recortePorPunto l = new recortePorPunto();
        //Lineas dentro del limite
        l.dibujarLineaCalculada(100, 232, 650, 238, Color.BLUE);
        l.dibujarLineaCalculada(210, 100, 285, 214, Color.BLUE);
        l.dibujarLineaCalculada(242, 381, 280, 366, Color.BLUE);
        l.dibujarLineaCalculada(193, 189, 222, 286, Color.BLUE);
        l.dibujarLineaCalculada(346, 380, 400, 344, Color.BLUE);
        //Linea fuera del limite
        l.dibujarLineaCalculada(64, 181, 76, 278, Color.BLUE);
    
    }
}
