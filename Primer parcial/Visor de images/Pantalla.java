import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class Pantalla extends JPanel{

     private Image imagen;

     public Pantalla(Image img) {
         imagen = img;
    }

    public void paint (Graphics g){
         super.paint(g);

         Dimension tam = new Dimension(imagen.getWidth(this), imagen.getHeight(this));
         setPreferredSize(tam);
         setMinimumSize(tam);
         setMaximumSize(tam);
         setSize(tam);
         update(g);
     }
    
     public void update(Graphics g){
         g.drawImage(imagen, 0, 0, this);
     }
}
