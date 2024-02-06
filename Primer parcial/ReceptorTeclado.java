import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReceptorTeclado extends JFrame implements KeyListener{

    private JTextArea textArea; 
    private JLabel presionada;
    private JLabel soltada;
    private JPanel labels;     

    public ReceptorTeclado(){
        super("ReceptorTeclado");

        //Area de texto y asignar KeyListener
        textArea = new JTextArea(); 
        textArea.addKeyListener(this); 

        //Labels y Area de texto
        labels = new JPanel(new FlowLayout(FlowLayout.CENTER));
        presionada = new JLabel("Tecla Presionada:", JLabel.LEFT);
        soltada = new JLabel("Tecla Soltada:", JLabel.LEFT);

        //Agregar Labels a JPanel
        labels.add(presionada);
        labels.add(soltada);

        //Agregar Componentes
        getContentPane().add(textArea, BorderLayout.CENTER);
        getContentPane().add(labels, BorderLayout.SOUTH);
        
        //JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    public void keyTyped(KeyEvent e) { 
    }

    public void keyPressed(KeyEvent e) {
        presionada.setText ("Tecla Presionada: " + KeyEvent.getKeyText(e.getKeyCode())); 
    }

    public void keyReleased (KeyEvent e) {    
        soltada.setText ("Tecla Soltada: " + KeyEvent.getKeyText(e.getKeyCode()));    
    }   

    public static void main(String[] args){
        new ReceptorTeclado();
    }
}