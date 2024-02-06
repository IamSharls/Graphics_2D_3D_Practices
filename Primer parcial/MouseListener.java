import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MouseListenerA extends JFrame implements MouseListener{  
    JLabel etiqueta = new JLabel("");  
    MouseListenerA(){  
        addMouseListener(this);  
        etiqueta.setBounds(20,50,100,20);  
        add(etiqueta);  

        this.setTitle("MouseListener"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setLocationRelativeTo(null);
        
        setSize(300,300);  
        setLayout(null);  
        setVisible(true);  
    }  
    public void mouseClicked(MouseEvent e) {  
        etiqueta.setText("Click");  
    }  
    public void mouseEntered(MouseEvent e) {  
        etiqueta.setText("Cursor dentro");  
    }  
    public void mouseExited(MouseEvent e) {  
        etiqueta.setText("Salida");  
    }  
    public void mousePressed(MouseEvent e) {  
        etiqueta.setText("Click mantenido");  
    }  
    public void mouseReleased(MouseEvent e) {  
        etiqueta.setText("Mouse Released");  
    }  
public static void main(String[] args) {  
    MouseListenerA p = new MouseListenerA();  
}  
}  