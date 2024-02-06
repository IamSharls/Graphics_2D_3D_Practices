import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Traslacion extends JFrame{

    int x = 32;
    int y = 56;
    int ancho = 5;
    int alto = 15;
    Color lluviaColor = new Color(235, 9, 9 );

    public Traslacion() {

        setTitle("Traslacion");
        setLayout(null);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Runnable runnable = new Runnable() {
			@Override
			public void run() {
				// Esto se ejecuta en segundo plano una única vez
				while (true) {
					if(y < 490){
                        y = y + 3;
                    }else{
                        y = 56;
                    }
					try {
						Thread.sleep(2000);
						System.out.println("Me imprimo cada segundo");
                        System.out.println(y);
                        
                        g2d.setColor(lluviaColor);
                        g2d.translate(x, y);
                        g2d.fillRect(0, 0, ancho, alto);
						
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		// Creamos un hilo y le pasamos el runnable
		Thread hilo = new Thread(runnable);
		hilo.start();
        
    }

    public static void main(String[] args) {
        Traslacion h = new Traslacion();
    }
}
