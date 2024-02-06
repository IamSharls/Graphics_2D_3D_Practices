import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GraficasPastel extends JFrame implements ActionListener{
    
    private JButton bt2;
    public JTextField tf1, tf2, tf3;
    public JLabel jl1, jl2, jl3;
    ArrayList<String> numeros = new ArrayList<>();
    ArrayList<String> nombres = new ArrayList<>();
    ArrayList<String> grados = new ArrayList<>();
    boolean b = false;

    public GraficasPastel(){
        setLayout(null);
        setTitle("Grafica de pastel");

        jl3 = new JLabel("¿Cual es el nombre del lenguaje?");
        jl3.setBounds(10, 350, 250, 30);
        add(jl3);

        tf1 = new JTextField();
        tf1.setBounds(10, 380, 150, 30);
        add(tf1);

        jl2 = new JLabel("¿Cuantas horas has estudiado?");
        jl2.setBounds(10, 410, 250, 30);
        add(jl2);

        tf2 = new JTextField();
        tf2.setBounds(10, 440, 150, 30);
        add(tf2);
        
        bt2 = new JButton("Graficar");
        bt2.setBounds(10, 480, 100, 30);
        add(bt2);
        bt2.addActionListener(this);

    }
  
    public void actionPerformed(ActionEvent p){
        if(p.getSource() == bt2){
            b = true;
            repaint();  
        }    
    }

    public void paint(Graphics g){
        super.paint(g);
        if(b == true){

            String nom = tf1.getText();
            String num = tf2.getText(); 
            int total = 0, totalGrados = 0, posicionYRect = 120, posicionYString = 135;
            int min = 0, max = 255, r = 0, gg = 0, b = 0, remover = 0;
            Random random = new Random();

            numeros.add(num);
            nombres.add(nom);
            for(int i = 0; i < numeros.size(); i++){
                total = total + Integer.parseInt(numeros.get(i));
                System.out.print("Total horas:" + total + "\n");
                int gr = Integer.parseInt(numeros.get(i)) * 360 / total;
                System.out.print("Grado individual:" + gr + "\n");
                grados.add(Integer.toString(gr));
                for(int j = 0; j < grados.size(); j++){
                    System.out.print("Grados dentro del array:" + grados.get(j) + "\n");
                }
                
                r = random.nextInt(max + min) + min;
                gg = random.nextInt(max + min) + min;
                b = random.nextInt(max + min) + min;
                g.setColor(new Color(r, gg, b));
                g.fillArc(25, 80, 200, 200, totalGrados, Integer.parseInt(grados.get(i)));
                g.fillRect(250, posicionYRect, 20, 20);
                g.drawString(nombres.get(i), 275, posicionYString);

                posicionYRect = posicionYRect + 30;
                posicionYString = posicionYString + 30;

                System.out.print("Total Grados acumulados:" + totalGrados + "\n");
                if(i == 0){
                    totalGrados = totalGrados + Integer.parseInt(grados.get(i));
                    System.out.print("Total Grados acumulados despues de sumar - Posicion 0:" + totalGrados + "\n");
                }else{
                    totalGrados = totalGrados + Integer.parseInt(grados.get(i - 1));
                    System.out.print("Total Grados acumulados despues de sumar - Posiciones luego de 0:" + totalGrados + "\n");
                }

                System.out.println("Variable remover antes del aumento:" + remover);
                if(remover == numeros.size() - 1){
                    grados.removeAll(grados);
                    System.out.println("(REMOVER == NUMEROS.SIZE)Arreglo de grados despues del remove:" + grados.size());
                }
                remover++;
                System.out.println("Tamaño de numeros.size:" + (numeros.size() - 1));
                System.out.println("Variable remover despues del aumento:" + remover + "\n");
                
            }

        }
    }

    public static void main(String[] args){
        GraficasPastel g = new GraficasPastel();
        g.setBounds(0, 0, 600, 600);
        g.setVisible(true);
        g.setResizable(false);
        g.setLocationRelativeTo(null);
        
    }

}
