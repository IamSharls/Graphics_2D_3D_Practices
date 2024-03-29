import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class dibujador{

    private BufferedImage buffer;
    private JFrame parent;
    private static BufferedImage Fondo;
    private static Graphics gFondo;

    public dibujador(JFrame parent){

        this.parent = parent;
        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        Fondo = new BufferedImage(parent.getWidth(), parent.getHeight(),BufferedImage.TYPE_INT_RGB);
        gFondo = Fondo.getGraphics();

    }

    //Funcion para dibujar un pixel
    public void Pixel(int x, int y, Color c){
        buffer.setRGB(0, 0, c.getRGB());
        parent.getGraphics().drawImage(buffer, x, y, parent);
        gFondo.drawImage(buffer, x, y, parent);
    }

    //Funcion para dibujar una linea con el metodo de punto medio
    public void puntomedio(int x1, int y1, int x2, int y2, Color c) 
    {
        int pk, A, B, pxlx, pxly;

        int dx = (x2 - x1);
        int dy = (y2 - y1);

        if (dy < 0) {
            dy = -dy;
            pxly = -1;
        }
        else {
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
        Pixel(x1, y1, c);

        if(dx>dy){
            pk = 2*dy - dx;
            A = 2*dy;
            B = 2*(dy-dx);
            while (X != x2){
                X = X + pxlx;
                if (pk < 0){
                    pk = pk + A;
                } else {
                    Y = Y + pxly + 1/2;
                    pk = pk + B;
                }
                Pixel(X, Y, c);
            }
        } else {
            pk = 2*dx - dy;
            A = 2*dx;
            B = 2*(dx-dy);
            while (Y != y2){
                Y = Y + pxly + 1/2;
                if (pk < 0){
                    pk = pk + A;
                } else {
                    X = X + pxlx;
                    pk = pk + B;
                }
                Pixel(X, Y, c);
            }
        }
    }

    //Funcion para dibujar un cubo
    public void cube(int x1, int y1, int x2, int y2, Color c) 
    {
        puntomedio(x1, y1, x2, y1, c);
        puntomedio(x1, y1, x1, y2, c);
        puntomedio(x2, y1, x2, y2, c);
        puntomedio(x1, y2, x2, y2, c);
    }

    //Metodo Scanline para rellenar el cubo
    public void scanline(int x, int y, Color c)
    {

        int IntDelColorOld = Fondo.getRGB(x, y);
        Color ColorOld = new Color(IntDelColorOld);
        Color ColorOld2 = new Color(IntDelColorOld);
        
        for(int i = y; ColorOld.equals(ColorOld2); i++) {
            for(int j = x; ColorOld.equals(ColorOld2); j++) 
            {
                ColorOld2 = new Color(Fondo.getRGB(j+1, i));
                Pixel(j, i, c);
            }
            ColorOld2 = new Color(Fondo.getRGB(x-1, i));
            for(int j = x; ColorOld.equals(ColorOld2); j--) 
            {
                ColorOld2 = new Color(Fondo.getRGB(j-1, i));
                Pixel(j, i, c);
            }
            ColorOld2 = new Color(Fondo.getRGB(x, i+1));
        }

        ColorOld2 = new Color(Fondo.getRGB(x, y-1));
        for(int i=y-1; ColorOld.equals(ColorOld2); i--) {
            for(int j = x; ColorOld.equals(ColorOld2); j++) 
            {
                ColorOld2 = new Color(Fondo.getRGB(j+1, i));
                Pixel(j, i, c);
            }
            ColorOld2 = new Color(Fondo.getRGB(x-1, i));
            for(int j = x; ColorOld.equals(ColorOld2); j--) 
            {
                ColorOld2 = new Color(Fondo.getRGB(j-1, i));
                Pixel(j, i, c);
            }
            ColorOld2 = new Color(Fondo.getRGB(x,i-1));
        }
    }

}
