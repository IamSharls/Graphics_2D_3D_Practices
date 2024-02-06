import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;

public class dibujarPixel extends JFrame{
    private BufferedImage buffer;
    private Graphics graPixel;

    public dibujarPixel(){
        setTitle("Grafica de Puntito");
        setResizable(false);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
    }

    public void putPixel(int x, int y, Color c){
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    public static void main(String[] args) {
        dibujarPixel ventana = new dibujarPixel();
        for(int i = 0; i <= 100; i = i + 1)
            ventana.putPixel(i, 100, Color.BLACK);
    }
}
