import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EspiralArquimedes extends JFrame{

    public static void main(String args[]) { 
        EspiralArquimedes esp = new EspiralArquimedes();
        esp.setTitle("Espiral de Arquimedes");
        esp.setLocationRelativeTo(null);
        
    }

    public EspiralArquimedes(){
        setSize(800, 800);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new esp());
    }

    class esp extends JPanel{
		int d = 10, m = 10, n = 0;
		public esp(){
			ActionListener construccionEspiral = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        };
        Timer temporizador = new Timer(1000, construccionEspiral);
        temporizador.start();
        
		}

		@Override
		public void paint(Graphics g){
			if (d < 2000){
				g.drawArc(350-m*n, 350-m*n ,d, d, 0, 180);
				g.drawArc(350-m*(n+1), 350-m*n, d, d, 180, 180);
				d += m*2;
				n+=1;
			}
		}
	}
}