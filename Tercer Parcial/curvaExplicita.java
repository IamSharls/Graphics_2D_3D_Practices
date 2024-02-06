import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.lang.Math;

public class curvaExplicita extends JFrame implements KeyListener{
    
    private BufferedImage buff, buffer;
    private JPanel zonaTeclado;
    private JTextArea teclado;

    public int xp = 0, yp = 120, zp = 100;

    public static Color rojoEspecial = new Color(236, 68, 92);
    private final int pC = 30;

    int curva[][] = new int[pC][4];

    double[] repintarRotacion = {0,-Math.PI/4,Math.PI*2/16};
    int[] repintarTraslacion = {0, 0, 0};
    int[] traslacionCurva = {200, 250, 0};
    double[] repintarEscalacion = {2,2,2};

    private int rM;
    private int cMX;
    private int cMY;
    private int cMZ;

    public curvaExplicita(){
        
        zonaTeclado = new JPanel();
        teclado = new JTextArea();
        teclado.addKeyListener(this);
        getContentPane().add(teclado, BorderLayout.CENTER);
        getContentPane().add(zonaTeclado, BorderLayout.CENTER);

        setTitle("Curva explicita");
        setResizable(true);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        buff = new BufferedImage(1,1, BufferedImage.TYPE_INT_RGB);

        paint();
    }

    public void putPixel(int x, int y, Color c){
        buff.setRGB(0, 0, c.getRGB());
        buffer.getGraphics().drawImage(buff, x, y, this);
    }

    public void puntoMedio(int x0, int y0, int x1, int y1){

        float x, y, dx, dy, incx = 1, incy = 1, incE, incNE, p = 0;

        x = x0;
        y = y0;

        dx = x1 - x0;
        dy = y1 - y0;

        if(dx < 0){
            dx = -dx;
            incx = -1;
        }
        if(dy < 0){
            dy = -dy;
            incy = -1;
        }

        if(Math.abs(dx) > Math.abs(dy)){ 
            incE = 2 * dy;
            incNE = 2 * (dy - dx);
            while(x != x1){
                putPixel((int)Math.round(x), (int)Math.round(y), rojoEspecial);
                x = x + incx;
                if(2 * (p + dy) < dx){
                    p = p + incE;
                }else{
                    p = p + incNE;
                    y = y + incy;
                }
            }
        }else{
            incE = 2 * dx;
            incNE = 2 * (dx - dy);
            while(y != y1){
                putPixel((int)Math.round(x), (int)Math.round(y), rojoEspecial);
                y = y + incy;
                if(2 * (p + dx) < dy){
                    p = p + incE;
                }else{
                    p = p + incNE;
                    x = x + incx;
                }
            }
        } 

    }

    public void formulaCurve(int curva[][], int x, int y, double expX, double expY){
        
        double coorX, coorY, coorZ;
        double maxX = x, minX = x;
        double maxY = y, minY = y;
        double maxZ = 0, minZ = 0;
        
        for (int i = 0; i < pC; i++) {

            coorX = x + (expX * i);
            coorY = y + (expY * i);
            coorZ = (Math.sin(coorX / 2) * Math.sin(coorY)) * 100; //(sen(x/2) * sen(y)) * 100

            curva[i][0] = (int)Math.round(coorX);
            curva[i][1] = (int)Math.round(coorY);
            curva[i][2] = (int)Math.round(coorZ);
            curva[i][3] = 1;

            if(i == 0){
                maxZ = coorZ;
                minZ = coorZ;
            }

            if (coorX < minX){
                minX = coorX;
            }
            if (coorX > maxX){
                maxX = coorX;
            }

            if (coorY < minY){
                minY = coorY;
            }
            if (coorY > maxY){
                maxY = coorY;
            }

            if (coorZ < minZ){
                minZ = coorZ;
            }
            if (coorZ > maxZ){
                maxZ = coorZ;
            }
        }
        double rangoX = maxX-minX;
        double rangoY = maxY-minY;
        double rangoZ = maxZ-minZ;

        cMX = (int)Math.round(minX);
        cMX = (int)Math.round(minY);
        cMX = (int)Math.round(minZ);

        if((rangoX) > (rangoY)){
            if((rangoX) > (rangoZ)){
                rM = (int)Math.round(rangoX);
            }
            else{
                rM = (int)Math.round(rangoZ);
            }
        }
        else if((rangoY) > (rangoZ)){
            rM = (int)Math.round(rangoY);
        }
        else{
            rM = (int)Math.round(rangoZ);
        }

        traslacionCurva[0] = rM;
        traslacionCurva[1] = rM;
        zp = rM;
    }

    public void curve(int curva[][], int xp, int yp, int zp){
        int curva2D[][] = new int [pC][2];

        for (int i = 0; i < pC; i++) {
            curva2D[i] = calcular2D(curva[i][0], curva[i][1], curva[i][2], xp,  yp, zp);
        }
        for (int i = 1; i < pC; i++) {
            puntoMedio(curva2D[i-1][0], curva2D[i-1][1], curva2D[i][0], curva2D[i][1]);
        }
    }
    
    public void paint(){
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        formulaCurve(curva, 2, 2, 0, 1.1);

        esc(curva, repintarEscalacion[0], repintarEscalacion[1], repintarEscalacion[2]);
        tras(curva, -rM/2, -rM/2, -rM/2);
        rot(curva, repintarRotacion[0], repintarRotacion[1], repintarRotacion[2]);
        tras(curva, -cMX, -cMY, -cMZ);
        tras(curva, traslacionCurva[0], traslacionCurva[1], traslacionCurva[2]);
        tras(curva, repintarTraslacion[0], repintarTraslacion[1], repintarTraslacion[2]);
        
        curve(curva, xp, yp, zp);

        zonaTeclado.getGraphics().drawImage(buffer, 0, 0, this);
    }

    public int[] calcular2D(int x1, int y1, int z1, int xp, int yp, int zp){      
        int x2, y2;

        x2 = x1 + ((xp * z1)/zp);
        y2 = y1 + ((yp * z1)/zp);

        int dot[] = {(int)x2, (int)y2};
        return dot;
    }

    public void rot(int [][] cubo, double Ax, double Ay, double Az){
        
        for(int x1=0; x1<=cubo.length - 1; x1++){
            double r[]={0,0,0,0};
            double [] P = {cubo[x1][0], cubo[x1][1],cubo[x1][2], cubo[x1][3]};
            double [][] T = {
                {Math.cos(Ax),-Math.sin(Ax),0,0},
                {Math.sin(Ax),Math.cos(Ax),0,0},
                {0,0,1,0},
                {0,0,0,1}
            };
            int i,j;
            for(i=0;i<4;i++){
                for(j=0;j<4;j++){
                    r[i] += P[j]*T[i][j];
                }
            }
            cubo[x1][0]=(int)r[0];
            cubo[x1][1]=(int)r[1];
            cubo[x1][2]=(int)r[2];
            cubo[x1][3]=(int)r[3];
        }
        
        for(int x1=0; x1<=cubo.length - 1; x1++){
            double r[]={0,0,0,0};
            double [] P = {cubo[x1][0], cubo[x1][1],cubo[x1][2], cubo[x1][3]};
            double [][] T = {
                {Math.cos(Ay), 0, Math.sin(Ay), 0},
                {0, 1, 0, 0},
                {-Math.sin(Ay), 0, Math.cos(Ay), 0},
                {0, 0, 0, 1}
            };
            int i,j;
            for(i=0;i<4;i++){
                for(j=0;j<4;j++){
                    r[i] += P[j]*T[i][j];
                }
            }
            cubo[x1][0]=(int)r[0];
            cubo[x1][1]=(int)r[1];
            cubo[x1][2]=(int)r[2];
            cubo[x1][3]=(int)r[3];
        }

        for(int x1=0; x1<=cubo.length - 1; x1++){
            double r[]={0,0,0,0};
            double [] P = {cubo[x1][0], cubo[x1][1],cubo[x1][2], cubo[x1][3]};
            double [][] T = {
                {1,0,0,0},
                {0,Math.cos(Az),-Math.sin(Az),0},
                {0,Math.sin(Az),Math.cos(Az),0},
                {0,0,0,1}
            };
            int i,j;
            for(i=0;i<4;i++){
                for(j=0;j<4;j++){
                    r[i] += P[j]*T[i][j];
                }
            }
            cubo[x1][0]=(int)r[0];
            cubo[x1][1]=(int)r[1];
            cubo[x1][2]=(int)r[2];
            cubo[x1][3]=(int)r[3];
        }
    }

    public void tras(int [][] cubo, int dx,int dy, int dz){
        for(int x1=0; x1 <= cubo.length - 1; x1++){
            int r[]={0,0,0,0};
            int [] P = {cubo[x1][0], cubo[x1][1],cubo[x1][2], cubo[x1][3]};
            int [][] T = {{1,0,0,dx},
                          {0,1,0,dy},
                          {0,0,1,dz},
                          {0,0,0,1}};
            int i,j;
            for(i=0;i<4;i++){
                for(j=0;j<4;j++){
                    r[i] += P[j]*T[i][j];
                }
            }
            cubo[x1][0]=r[0];
            cubo[x1][1]=r[1];
            cubo[x1][2]=r[2];
            cubo[x1][3]=r[3];
        }
    }

    public void esc(int [][] cubo, double Sx, double Sy, double Sz){
        for(int x1=0; x1<=cubo.length - 1; x1++){
            double r[]={0,0,0,0};
            double [] P = {cubo[x1][0], cubo[x1][1],cubo[x1][2], cubo[x1][3]};
            double [][] T = {
                {Sx,0,0,0},
                {0,Sy,0,0},
                {0,0,Sz,0},
                {0,0,0,1}
            };
            int i,j;
            for(i=0;i<4;i++){
                for(j=0;j<4;j++){
                    r[i] += P[j]*T[i][j];
                }
            }
            cubo[x1][0]=(int)r[0];
            cubo[x1][1]=(int)r[1];
            cubo[x1][2]=(int)r[2];
            cubo[x1][3]=(int)r[3];
        }
    }


    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            repintarRotacion[0] = repintarRotacion[0] - Math.PI/16;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            repintarRotacion[0] = repintarRotacion[0] + Math.PI/16;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            repintarRotacion[1] = repintarRotacion[1] + Math.PI/16;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            repintarRotacion[1] = repintarRotacion[1] - Math.PI/16;
        }
        if (e.getKeyCode() == KeyEvent.VK_K) {
            repintarRotacion[2] = repintarRotacion[2] - Math.PI/16;
        }
        if (e.getKeyCode() == KeyEvent.VK_L) {
            repintarRotacion[2] = repintarRotacion[2] + Math.PI/16;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_A) {
            repintarTraslacion[0] = repintarTraslacion[0] - 50;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            repintarTraslacion[0] = repintarTraslacion[0] + 50;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            repintarTraslacion[1] = repintarTraslacion[1] - 50;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            repintarTraslacion[1] = repintarTraslacion[1] + 50;
        }
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            repintarTraslacion[2] = repintarTraslacion[2] - 50;
        }
        if (e.getKeyCode() == KeyEvent.VK_E) {
            repintarTraslacion[2] = repintarTraslacion[2] + 50;
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
            repintarEscalacion[0] = repintarEscalacion[0] + 0.1;
            repintarEscalacion[1] = repintarEscalacion[1] + 0.1;
            repintarEscalacion[2] = repintarEscalacion[2] + 0.1;
        }
        if (e.getKeyCode() == KeyEvent.VK_N) {
            repintarEscalacion[0] = repintarEscalacion[0] - 0.1;
            repintarEscalacion[1] = repintarEscalacion[1] - 0.1;
            repintarEscalacion[2] = repintarEscalacion[2] - 0.1;
        }

       paint();

    }

    public static void main(String[] args) {
        curvaExplicita b = new curvaExplicita();
    }
}
