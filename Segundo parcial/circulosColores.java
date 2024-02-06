import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;
import java.lang.Math;

public class circulosColores extends JFrame{

    private BufferedImage buffer;
    private Graphics graPixel;

    public circulosColores(){

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

        int r=0,h=xc, k=yc;
        int tetar,teta,x,y;
        while(r<300){
            for(teta=0; teta<360; teta++){
                
                tetar=(int)((teta*180)/Math.PI);
                x=(int)(r*Math.cos(tetar));
                y=(int)(r*Math.sin(tetar));
                putPixel2(x+h,  y+k, Color.BLACK);
                putPixel2(-x+h,-y+k, Color.red);
                putPixel2(-x+h, y+k, Color.yellow);
                putPixel2(x+h, -y+k, Color.pink);
            }
            r=r+2;
        }

     
    }

    public static void main(String args[]){
        int xc = 250, yc = 250, R = 90;
        circulosColores b = new circulosColores();
        b.putPixel(xc, yc, R);
    }
}
