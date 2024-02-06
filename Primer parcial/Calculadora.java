import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculadora extends JFrame implements ActionListener{

    public JButton bt1, bt2, bt3, bt4,bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, btc;
    public JTextField tf1;
    public float pn, sn;
    public String op;

    public Calculadora(){
        setLayout(null);
        setTitle("Calculadora");

        tf1 = new JTextField();
        tf1.setBounds(10, 10, 200, 35);
        add(tf1);

        btc = new JButton("C");
        btc.setBounds(10, 50, 50, 50);
        add(btc);
        btc.addActionListener(this);

        bt1 = new JButton("/");
        bt1.setBounds(60, 50, 50, 50);
        add(bt1);
        bt1.addActionListener(this);

        bt2 = new JButton("*");
        bt2.setBounds(110, 50, 50, 50);
        add(bt2);
        bt2.addActionListener(this);

        bt3 = new JButton("-");
        bt3.setBounds(160, 50, 50, 50);
        add(bt3);
        bt3.addActionListener(this);

        bt4 = new JButton("7");
        bt4.setBounds(10, 100, 50, 50);
        add(bt4);
        bt4.addActionListener(this);

        bt5 = new JButton("8");
        bt5.setBounds(60, 100, 50, 50);
        add(bt5);
        bt5.addActionListener(this);

        bt6 = new JButton("9");
        bt6.setBounds(110, 100, 50, 50);
        add(bt6);
        bt6.addActionListener(this);

        bt7 = new JButton("4");
        bt7.setBounds(10, 150, 50, 50);
        add(bt7);
        bt7.addActionListener(this);

        bt8 = new JButton("5");
        bt8.setBounds(60, 150, 50, 50);
        add(bt8);
        bt8.addActionListener(this);

        bt9 = new JButton("6");
        bt9.setBounds(110, 150, 50, 50);
        add(bt9);
        bt9.addActionListener(this);

        bt10 = new JButton("1");
        bt10.setBounds(10, 200, 50, 50);
        add(bt10);
        bt10.addActionListener(this);

        bt11 = new JButton("2");
        bt11.setBounds(60, 200, 50, 50);
        add(bt11);
        bt11.addActionListener(this);

        bt12 = new JButton("3");
        bt12.setBounds(110, 200, 50, 50);
        add(bt12);
        bt12.addActionListener(this);

        bt13 = new JButton("+");
        bt13.setBounds(160, 100, 50, 100);
        add(bt13);
        bt13.addActionListener(this);

        bt14 = new JButton("=");
        bt14.setBounds(160, 200, 50, 100);
        add(bt14);
        bt14.addActionListener(this);

        bt15 = new JButton("0");
        bt15.setBounds(10, 250, 100, 50);
        add(bt15);
        bt15.addActionListener(this);

        bt16 = new JButton(".");
        bt16.setBounds(110, 250, 50, 50);
        add(bt16);
        bt16.addActionListener(this);

    }

    public void actionPerformed(ActionEvent p){

        //Programacion de los numeros
        if(p.getSource() == bt10){
            tf1.setText(tf1.getText() + "1");
        } 
        if(p.getSource() == bt11){
            tf1.setText(tf1.getText() + "2");
        } 
        if(p.getSource() == bt12){
            tf1.setText(tf1.getText() + "3");
        }  
        if(p.getSource() == bt7){
            tf1.setText(tf1.getText() + "4");
        } 
        if(p.getSource() == bt8){
            tf1.setText(tf1.getText() + "5");
        }  
        if(p.getSource() == bt9){
            tf1.setText(tf1.getText() + "6");
        }
        if(p.getSource() == bt4){
            tf1.setText(tf1.getText() + "7");
        }  
        if(p.getSource() == bt5){
            tf1.setText(tf1.getText() + "8");
        }
        if(p.getSource() == bt6){
            tf1.setText(tf1.getText() + "9");
        }
        if(p.getSource() == bt15){
            tf1.setText(tf1.getText() + "0");
        }

        //Programacion de la tecla C
        if(p.getSource() == btc){
            tf1.setText("");
        }  

        //Programacion de los operadores
        if(p.getSource() == bt1){
            pn = Float.parseFloat(tf1.getText());
            op = "/";
            tf1.setText("");     
        }
        if(p.getSource() == bt2){
            pn = Float.parseFloat(tf1.getText());
            op = "*";
            tf1.setText("");     
        } 
        if(p.getSource() == bt13){
            pn = Float.parseFloat(tf1.getText());
            op = "+";
            tf1.setText("");     
        } 
        if(p.getSource() == bt3){
            pn = Float.parseFloat(tf1.getText());
            op = "-";
            tf1.setText("");     
        }  

        //Programacion boton igual
        if(p.getSource() == bt14){
            sn = Float.parseFloat(tf1.getText());
            switch(op){
                case "+":
                    tf1.setText(ope(pn + sn));
                break;
                case "-":
                    tf1.setText(ope(pn - sn));
                break;
                case "*":
                    tf1.setText(ope(pn * sn));
                break;
                case "/":
                    if(sn == 0){
                        tf1.setText("Error de sintaxis");
                        
                    }else{
                        tf1.setText(ope(pn / sn));
                    } 
                break;
            }  
        }

        //Programacion boton punto
        if(p.getSource() == bt16){
            if(!(tf1.getText().contains("."))){
                tf1.setText(tf1.getText() + ".");
            }     
        }    
             
    }

    public String ope(float res){
        String ret = "";
        ret = Float.toString(res);
        if(res % 1 == 0){
            ret = ret.substring(0, ret.length() - 2);
        }
        return ret;
    }

    public static void main(String[] args){
        
        Calculadora cal = new Calculadora();
        cal.setBounds(0, 0, 235, 345);
        cal.setVisible(true);
        cal.setResizable(false);
        cal.setLocationRelativeTo(null);

    }
    
}
