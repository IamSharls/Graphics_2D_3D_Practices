import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;
import java.lang.Math;
import java.util.ArrayList;

public class proyeccionParalela extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;
    static ArrayList<String> coordenadas = new ArrayList<>();
    public int xp = xp = 100, yp = 150, zp = 300;
    public static Color rojoEspecial = new Color(236, 68, 92);
    
    public proyeccionParalela(){

        setTitle("Proyeccion Paralela");
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
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    public void puntoMedio(int x0, int y0, int x1, int y1, Color c){

        float x, y, dx, dy, incx = 1, incy = 1, incE, incNE, p = 0;

        x = x0;
        y = y0;

        dx = x1 - x0;
        dy = y1 - y0;

        if(dx < 0){
            dx = -dx;
            incx = -1;
        }
        if(dy < 0){
            dy = -dy;
            incy = -1;
        }

        if(Math.abs(dx) > Math.abs(dy)){ 
            incE = 2 * dy;
            incNE = 2 * (dy - dx);
            while(x != x1){
                putPixel((int)Math.round(x), (int)Math.round(y), c);
                x = x + incx;
                if(2 * (p + dy) < dx){
                    p = p + incE;
                }else{
                    p = p + incNE;
                    y = y + incy;
                }
            }
        }else{
            incE = 2 * dx;
            incNE = 2 * (dx - dy);
            while(y != y1){
                putPixel((int)Math.round(x), (int)Math.round(y), c);
                y = y + incy;
                if(2 * (p + dx) < dy){
                    p = p + incE;
                }else{
                    p = p + incNE;
                    x = x + incx;
                }
            }
        } 

    }

    public void calcular2D(int x1, int y1, int z1){
        
        int x2, y2;

        x2 = x1 + ((xp * z1)/zp);
        y2 = y1 + ((yp * z1)/zp);

        coordenadas.add(Integer.toString(Math.round(x2)));
        coordenadas.add(Integer.toString(Math.round(y2)));

    }

    public static void main(String[] args){

        proyeccionParalela b = new proyeccionParalela();

        b.calcular2D(100, 100, 1); 
        b.calcular2D(100, 200, 1); 
        b.calcular2D(200,100, 1);  
        b.calcular2D(200,200, 1);  

        b.puntoMedio(Integer.parseInt(coordenadas.get(0)), Integer.parseInt(coordenadas.get(1)),Integer.parseInt(coordenadas.get(2)), Integer.parseInt(coordenadas.get(3)), rojoEspecial);
        b.puntoMedio(Integer.parseInt(coordenadas.get(0)), Integer.parseInt(coordenadas.get(1)),Integer.parseInt(coordenadas.get(4)), Integer.parseInt(coordenadas.get(5)), rojoEspecial);
        b.puntoMedio(Integer.parseInt(coordenadas.get(4)), Integer.parseInt(coordenadas.get(5)),Integer.parseInt(coordenadas.get(6)), Integer.parseInt(coordenadas.get(7)), rojoEspecial);
        b.puntoMedio(Integer.parseInt(coordenadas.get(2)), Integer.parseInt(coordenadas.get(3)),Integer.parseInt(coordenadas.get(6)), Integer.parseInt(coordenadas.get(7)), rojoEspecial);
        
        b.calcular2D(100, 100, 100); 
        b.calcular2D(100, 200, 100); 
        b.calcular2D(200,200, 100);  
        b.calcular2D(200,100, 100);  

        b.puntoMedio(Integer.parseInt(coordenadas.get(8)), Integer.parseInt(coordenadas.get(9)),Integer.parseInt(coordenadas.get(10)), Integer.parseInt(coordenadas.get(11)), rojoEspecial);
        b.puntoMedio(Integer.parseInt(coordenadas.get(8)), Integer.parseInt(coordenadas.get(9)),Integer.parseInt(coordenadas.get(14)), Integer.parseInt(coordenadas.get(15)), rojoEspecial);
        b.puntoMedio(Integer.parseInt(coordenadas.get(12)), Integer.parseInt(coordenadas.get(13)),Integer.parseInt(coordenadas.get(14)), Integer.parseInt(coordenadas.get(15)), rojoEspecial);
        b.puntoMedio(Integer.parseInt(coordenadas.get(10)), Integer.parseInt(coordenadas.get(11)),Integer.parseInt(coordenadas.get(12)), Integer.parseInt(coordenadas.get(13)), rojoEspecial);
 
        b.puntoMedio(Integer.parseInt(coordenadas.get(0)), Integer.parseInt(coordenadas.get(1)),Integer.parseInt(coordenadas.get(8)), Integer.parseInt(coordenadas.get(9)), rojoEspecial);
        b.puntoMedio(Integer.parseInt(coordenadas.get(4)), Integer.parseInt(coordenadas.get(5)),Integer.parseInt(coordenadas.get(14)), Integer.parseInt(coordenadas.get(15)), rojoEspecial);
        b.puntoMedio(Integer.parseInt(coordenadas.get(6)), Integer.parseInt(coordenadas.get(7)),Integer.parseInt(coordenadas.get(12)), Integer.parseInt(coordenadas.get(13)), rojoEspecial);
        b.puntoMedio(Integer.parseInt(coordenadas.get(2)), Integer.parseInt(coordenadas.get(3)),Integer.parseInt(coordenadas.get(10)), Integer.parseInt(coordenadas.get(11)), rojoEspecial);
    }

}
