import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;
import java.lang.Math;

public class Bresenham extends JFrame{
    private BufferedImage buffer;
    private Graphics graPixel;

    public Bresenham(){

        setTitle("Bresenham");
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
        this.getGraphics().drawImage(buffer, x0, y0, this);

        int dx, dy, A, B, p, steps;
        float xinc, yinc, x, y;

        dx = x1 - x0;
        dy = y1 - y0;

        A = 2 * dy;
        B = 2 * dy - 2 * dx;
        p = 2 * dy - dx;


        if(Math.abs(dx) > Math.abs(dy)){
            steps = Math.abs(dx);
        }else{
            steps = Math.abs(dy);
        }

        xinc = (float) dx / steps;
        yinc = (float) dy / steps;

        x = x0;
        y = y0;

        for(int k = 1; k <= steps; ++k){
            if(p < 0){
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

    public static void main(String[] args) {

        Bresenham b = new Bresenham();
        b.putPixel(200, 100, 110, 300, Color.RED);

    }
}