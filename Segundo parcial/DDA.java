import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;

public class DDA extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;

    //Constructor

    public DDA(){
        
        setTitle("DDA");
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
    
        int dx, dy, steps;
        dx = x1 - x0;
        dy = y1 - y0;
        float x, y, xinc, yinc;

        if(Math.abs(dx) > Math.abs(dy)){
            steps = Math.abs(dx);
        }else{
            steps = Math.abs(dy);
        }

        xinc = (float) dx / steps;
        yinc =(float) dy / steps;

        x = x0;
        y = y0;

        this.getGraphics().drawImage(buffer, Math.round(x), Math.round(y), this);
        
        for(int k = 1; k <= steps; ++k){
            x =  x + xinc;
            y = y + yinc;
            this.getGraphics().drawImage(buffer, Math.round(x), Math.round(y), this);
        }

    }

    public static void main(String[] args) {

        DDA d = new DDA();
        d.putPixel(100, 250, 150, 50, Color.RED);

    }
}
