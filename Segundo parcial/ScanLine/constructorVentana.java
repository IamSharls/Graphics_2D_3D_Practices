import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class constructorVentana extends JFrame {
    private dibujador dibujadorIns;
    private Boolean existencia = Boolean.FALSE;

    private BufferedImage buffer;
    public JPanel myJPanel;

    public constructorVentana(){
        super("Scanline");
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJPanel = new JPanel();
        add(myJPanel);
        setVisible(true);
        dibujadorIns = new dibujador(this);
    }

    public void paint(Graphics g){
        if( existencia == Boolean.FALSE) {
            buffer = new BufferedImage (1,1,BufferedImage.TYPE_INT_RGB);

            buffer.setRGB(0, 0, Color.blue.getRGB());
            this.getGraphics().drawImage(buffer, getWidth()/2, getHeight()/2, this);

            existencia = Boolean.TRUE;
            super.paint(g);
        }
        this.update(g);
    }

    public void update(Graphics g){

        int x1 = 50, x2 = 150, y1 = 50, y2 = 150;
        //Dibujar cuadrado
        dibujadorIns.cube(x1, y1, x2, y2, Color.RED);

        //Rellenar con metodo Scanline
        dibujadorIns.scanline(75, 75, Color.RED);
        
    }
}
