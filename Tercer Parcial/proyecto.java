import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.lang.Math;

public class proyecto extends JFrame implements Runnable{

    private BufferedImage buff, buffer;
    private JPanel zonaTeclado;

    private int rM;

    //Color figura 1
    public static int r1 = 236, g1 = 68, b1 = 92;
    public static Color colorFigura1 =  new Color(r1, g1, b1);

    //Color figura 2
    public static int r2 = 252, g2 = 249, b2 = 124;
    public static Color colorFigura2 =  new Color(r2, g2, b2);

    //Color figura 3
    public static int r3 = 7, g3 = 62, b3 = 198;
    public static Color colorFigura3 =  new Color(r3, g3, b3);

    //Color figura 4
    public static int r4 = 167, g4 = 189, b4 = 243;
    public static Color colorFigura4 =  new Color(r4, g4, b4);

    //Color figura 5
    public static int r5 = 231, g5 = 123, b5 = 223;
    public static Color colorFigura5 =  new Color(r5, g5, b5);

    //Color figura 6
    public static int r6 = 88, g6 = 170, b6 = 44;
    public static Color colorFigura6 =  new Color(r6, g6, b6);

    //Color figura 7
    public static int r7 = 253, g7 = 139, b7 = 31;
    public static Color colorFigura7 =  new Color(r7, g7, b7);

    //Color figura 7
    public static int r8 = 0, g8 = 0, b8 = 0;
    public static Color colorFigura8 =  new Color(r8, g8, b8);

    private final int casillasVerticales = 30;
    private int casillasHorizontales = 30;

    public int xp = 0, yp = 300, zp = 100;
   
    ///////////////////////////////////////////////////
    //Variables generales de la figuras
    double[] repintarEscalacion = {
                                    .3, .3, .3,  //Cilindro raro
                                    .4, .4, .4,  //Tazo raro
                                    .12, .12, .12,   //Bola rara
                                    .5, .5, .5   //Campana
                                  };
    double[] repintarRotacion = {
                                     0, 0, 6.8, //Cilindro raro
                                     0, 0, 6.8, //Plato
                                     0, 0, 6.8,  //Tazo raro
                                     0, 0, 6.8,  //Bola rara
                                     0, 0, 6.6,     //Campana
                                     0, 0, 6.8,   //Lampara
                                     0, 0 , 6.8   //Lampara 2
                                };
    int[] repintarTraslacion = {
                                     430, 150, 0, //Cilindro raro
                                     770, 15, 0,  //Plato
                                     1050, 60, 0,  //Tazo raro
                                     150, 350, 0,  //Bola rara
                                     450, 350, 0,   //Campana
                                     760, 380, 0,   //Lampara
                                     1050, 350, 0    //Lampara 2
                               };
    //////////////////////////////////////////////////
    
    //Variables individuales de las figuras         

    //Cilindro raro
    int transformacionGeneral[][] = new int[8][4];
    int space[][][] = new int [casillasHorizontales][casillasVerticales][4];
    int curva[][] = new int[casillasVerticales][4];
    int[] traslacionCurva = {200, 200, 0};
    //Plato
    int transformacionGeneral2[][] = new int[8][4];
    int space2[][][] = new int [casillasHorizontales][casillasVerticales][4];
    int curva2[][] = new int[casillasVerticales][4];
    int[] traslacionCurva2 = {200, 200, 0};                              
    //Tazo raro
    int transformacionGeneral3[][] = new int[8][4];
    int space3[][][] = new int [casillasHorizontales][casillasVerticales][4];
    int curva3[][] = new int[casillasVerticales][4];
    int[] traslacionCurva3 = {200, 200, 0};   
    //Bola rara
    int transformacionGeneral4[][] = new int[8][4];
    int space4[][][] = new int [casillasHorizontales][casillasVerticales][4];
    int curva4[][] = new int[casillasVerticales][4];
    int[] traslacionCurva4 = {200, 200, 0};   
    //Campana
    int transformacionGeneral5[][] = new int[8][4];
    int space5[][][] = new int [casillasHorizontales][casillasVerticales][4];
    int curva5[][] = new int[casillasVerticales][4];
    int[] traslacionCurva5 = {200, 200, 0}; 
    //Lampara
    int transformacionGeneral6[][] = new int[8][4];
    int space6[][][] = new int [casillasHorizontales][casillasVerticales][4];
    int curva6[][] = new int[casillasVerticales][4];
    int[] traslacionCurva6 = {200, 200, 0};  
    //Lampara 2
    int transformacionGeneral7[][] = new int[8][4];
    int space7[][][] = new int [casillasHorizontales][casillasVerticales][4];
    int curva7[][] = new int[casillasVerticales][4];
    int[] traslacionCurva7 = {200, 200, 0};  
    

    ///////////////////////////////////////////////////
    //Proyeccion cubos
    public int xpCubo = -100, ypCubo = -70, zpCubo = 500;

    //Cubos
    double[] repintarRotacionCubo = {0,0,0};
    int[] repintarTraslacionCubo = {150, 150, 0};
    double[] repintarRotacionCubo2 = {0,0,0};
    int[] repintarTraslacionCubo2 = {150, 150, 0};

    int[][] cube = {
        {-50, -50, -23, 1}, 
        {-50, 50, -23, 1},
        {50, 50, -23, 1},
        {50, -50, -23, 1},
        {-50, -50, 75, 1},
        {-50, 50, 75, 1},
        {50, 50, 75, 1},
        {50, -50, 75, 1}
    };

    int[][] cube2 = {
        {-50, -50, -23, 1}, 
        {-50, 50, -23, 1},
        {50, 50, -23, 1},
        {50, -50, -23, 1},
        {-50, -50, 75, 1},
        {-50, 50, 75, 1},
        {50, 50, 75, 1},
        {50, -50, 75, 1}
    };

    int cuboDub[][] = new int[8][4];
    int cuboDub2[][] = new int[8][4];
    ///////////////////////////////////////////////////
    //Hilo
    public Thread hilo;
    //////////////////////////////////////////////
    //Principal
    public proyecto(){

        zonaTeclado = new JPanel();
        getContentPane().add(zonaTeclado, BorderLayout.CENTER);

        setTitle("Proyecto 3ER Parcial");
        setResizable(true);
		setSize(1300,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        buff = new BufferedImage(1,1, BufferedImage.TYPE_INT_RGB);

        paint(colorFigura1, colorFigura2, colorFigura3, colorFigura4, colorFigura5, colorFigura6, colorFigura7, colorFigura8);
        hilo = new Thread(this);
        hilo.start();
    }

    public void putPixel(int x, int y, Color c){
        buff.setRGB(0, 0, c.getRGB());
        buffer.getGraphics().drawImage(buff, x, y, this);
    }

    public void puntoMedio(int x0, int y0, int x1, int y1, Color c){

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
                putPixel((int)Math.round(x), (int)Math.round(y), c);
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
                putPixel((int)Math.round(x), (int)Math.round(y), c);
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


    public void trazado(int cube[][], int xp, int yp, int zp, Color c){
        int coordCubo[][] = new int [8][2];
        int coordCubo2[][] = new int [8][2];

        for (int i = 0; i < 8; i++) {
            coordCubo[i] = calcular2D(cube[i][0], cube[i][1], cube[i][2], xp, yp, zp);
            coordCubo2[i] = calcular2D(cube[i][0], cube[i][1], cube[i][2], xp, yp, zp);
        }

        //Vertices cuadrado frontal
        puntoMedio(coordCubo[0][0], coordCubo[0][1], coordCubo[1][0], coordCubo[1][1], c);
        puntoMedio(coordCubo[1][0], coordCubo[1][1], coordCubo[2][0], coordCubo[2][1], c);
        puntoMedio(coordCubo[2][0], coordCubo[2][1], coordCubo[3][0], coordCubo[3][1], c);
        puntoMedio(coordCubo[3][0], coordCubo[3][1], coordCubo[0][0], coordCubo[0][1], c);

        //Vertices cuadrado posterior
        puntoMedio(coordCubo[0][0], coordCubo[0][1], coordCubo[4][0], coordCubo[4][1], c);
        puntoMedio(coordCubo[1][0], coordCubo[1][1], coordCubo[5][0], coordCubo[5][1], c);
        puntoMedio(coordCubo[2][0], coordCubo[2][1], coordCubo[6][0], coordCubo[6][1], c);
        puntoMedio(coordCubo[3][0], coordCubo[3][1], coordCubo[7][0], coordCubo[7][1], c);

        //Aristas entre los cuadrados
        puntoMedio(coordCubo[4][0], coordCubo[4][1], coordCubo[5][0], coordCubo[5][1], c);
        puntoMedio(coordCubo[5][0], coordCubo[5][1], coordCubo[6][0], coordCubo[6][1], c);
        puntoMedio(coordCubo[6][0], coordCubo[6][1], coordCubo[7][0], coordCubo[7][1], c);
        puntoMedio(coordCubo[7][0], coordCubo[7][1], coordCubo[4][0], coordCubo[4][1], c);

        //Vertices cuadrado frontal
        puntoMedio(coordCubo2[0][0], coordCubo2[0][1], coordCubo2[1][0], coordCubo2[1][1], c);
        puntoMedio(coordCubo2[1][0], coordCubo2[1][1], coordCubo2[2][0], coordCubo2[2][1], c);
        puntoMedio(coordCubo2[2][0], coordCubo2[2][1], coordCubo2[3][0], coordCubo2[3][1], c);
        puntoMedio(coordCubo2[3][0], coordCubo2[3][1], coordCubo2[0][0], coordCubo2[0][1], c);

        //Vertices cuadrado posterior
        puntoMedio(coordCubo2[0][0], coordCubo2[0][1], coordCubo2[4][0], coordCubo2[4][1], c);
        puntoMedio(coordCubo2[1][0], coordCubo2[1][1], coordCubo2[5][0], coordCubo2[5][1], c);
        puntoMedio(coordCubo2[2][0], coordCubo2[2][1], coordCubo2[6][0], coordCubo2[6][1], c);
        puntoMedio(coordCubo2[3][0], coordCubo2[3][1], coordCubo2[7][0], coordCubo2[7][1], c);

        //Aristas entre los cuadrados
        puntoMedio(coordCubo2[4][0], coordCubo2[4][1], coordCubo2[5][0], coordCubo2[5][1], c);
        puntoMedio(coordCubo2[5][0], coordCubo2[5][1], coordCubo2[6][0], coordCubo2[6][1], c);
        puntoMedio(coordCubo2[6][0], coordCubo2[6][1], coordCubo2[7][0], coordCubo2[7][1], c);
        puntoMedio(coordCubo2[7][0], coordCubo2[7][1], coordCubo2[4][0], coordCubo2[4][1], c);

    }

    public void formulaCurva(int curva[][]){
        double coorX, coorY;

        double maxX = 0, minX = 0;
        double maxY = 0, minY = 0;
        double maxZ = 0, minZ = 0;
        
        double t = 0;
        double exp = 2.3 * 4 / casillasVerticales;
        
        for (int i = 0; i < casillasVerticales; i++) {

            t = exp * i;

            //Cilindro raro
            coorX = ((Math.sin(t)) * 100/.5) + 200;
            coorY = (-t * 50);

            curva[i][0] = (int)coorX;
            curva[i][1] = (int)coorY;
            curva[i][2] = 0;
            curva[i][3] = 1;

            if(i == 0){
                maxY = coorY;
                minY = coorY;
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
        }

        double rangoX = maxX-minX;
        double rangoY = maxY-minY;
        double rangoZ = maxZ-minZ;


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

        int temp[][] = {{0,0,0,1}};
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                temp[0][0] = curva[j][0];
                temp[0][1] = curva[j][1] + rM/2;
                temp[0][2] = curva[j][2];
                temp[0][3] = curva[j][3];

                rot(temp, 0, 2 * Math.PI/casillasHorizontales * i, 0);

                space[i][j][0] = temp[0][0];
                space[i][j][1] = temp[0][1];
                space[i][j][2] = temp[0][2];
                space[i][j][3] = temp[0][3];

            }
        }
    }

    

    public void drawSup(int space[][][], int xp, int yp, int zp, Color c){
        int space2D[][][] = new int [casillasHorizontales][casillasVerticales][3];
        
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                space2D[i][j] = calcular2D(space[i][j][0], space[i][j][1], space[i][j][2], xp,  yp, zp);
            }
        }

        for (int i = 1; i < casillasHorizontales; i++) {
            for (int j = 1; j < casillasVerticales; j++){
               
                puntoMedio(space2D[i-1][j-1][0], space2D[i-1][j-1][1], space2D[i-1][j][0], space2D[i-1][j][1], colorFigura1);
                puntoMedio(space2D[i-1][j-1][0], space2D[i-1][j-1][1], space2D[i][j-1][0], space2D[i][j-1][1], c);

                if(j == casillasVerticales - 1) {
                    puntoMedio(space2D[i-1][j][0], space2D[i-1][j][1], space2D[i][j][0], space2D[i][j][1], c);
                }
                
                if(i == casillasHorizontales - 1){
                   
                    puntoMedio(space2D[i][j-1][0], space2D[i][j-1][1], space2D[i][j][0], space2D[i][j][1], c);
                    puntoMedio(space2D[0][j-1][0], space2D[0][j-1][1], space2D[i][j-1][0], space2D[i][j-1][1], c);

                    if(j == casillasVerticales - 1) {
                        puntoMedio(space2D[0][j][0], space2D[0][j][1], space2D[i][j][0], space2D[i][j][1], c);
                    }
                }
            }
        }
    }

    public void formulaCurva2(int curva2[][]){
        double coorX, coorY;

        double maxX = 0, minX = 0;
        double maxY = 0, minY = 0;
        double maxZ = 0, minZ = 0;
        
        double t = 0;
        double exp = 2.3 * 4 / casillasVerticales;
        
        for (int i = 0; i < casillasVerticales; i++) {

            t = exp * i;

            //Plato
            coorX = (4 * Math.pow(Math.cos(t), 3) * 100);
            coorY = (3 * Math.pow(Math.sin(-t), 3)) * 100;

            curva2[i][0] = (int)coorX;
            curva2[i][1] = (int)coorY;
            curva2[i][2] = 0;
            curva2[i][3] = 1;

            if(i == 0){
                maxY = coorY;
                minY = coorY;
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
        }

        double rangoX = maxX-minX;
        double rangoY = maxY-minY;
        double rangoZ = maxZ-minZ;


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

        traslacionCurva2[0] = rM;
        traslacionCurva2[1] = rM;
        zp = rM;

        int temp[][] = {{0,0,0,1}};
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                temp[0][0] = curva2[j][0];
                temp[0][1] = curva2[j][1] + rM/2;
                temp[0][2] = curva2[j][2];
                temp[0][3] = curva2[j][3];

                rot(temp, 0, 2 * Math.PI/casillasHorizontales * i, 0);

                space2[i][j][0] = temp[0][0];
                space2[i][j][1] = temp[0][1];
                space2[i][j][2] = temp[0][2];
                space2[i][j][3] = temp[0][3];

            }
        }
    }


    public void drawSup2(int space2[][][], int xp, int yp, int zp, Color c){
        int space2D2[][][] = new int [casillasHorizontales][casillasVerticales][3];
        
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                space2D2[i][j] = calcular2D(space2[i][j][0], space2[i][j][1], space2[i][j][2], xp,  yp, zp);
                
            }
        }

        for (int i = 1; i < casillasHorizontales; i++) {
            for (int j = 1; j < casillasVerticales; j++){
               
                puntoMedio(space2D2[i-1][j-1][0], space2D2[i-1][j-1][1], space2D2[i-1][j][0], space2D2[i-1][j][1], colorFigura8);
                puntoMedio(space2D2[i-1][j-1][0], space2D2[i-1][j-1][1], space2D2[i][j-1][0], space2D2[i][j-1][1], c);

                if(j == casillasVerticales - 1) {
                    puntoMedio(space2D2[i-1][j][0], space2D2[i-1][j][1], space2D2[i][j][0], space2D2[i][j][1], c);
                }
                
                if(i == casillasHorizontales - 1){
                   
                    puntoMedio(space2D2[i][j-1][0], space2D2[i][j-1][1], space2D2[i][j][0], space2D2[i][j][1], c);
                    puntoMedio(space2D2[0][j-1][0], space2D2[0][j-1][1], space2D2[i][j-1][0], space2D2[i][j-1][1], c);

                    if(j == casillasVerticales - 1) {
                        puntoMedio(space2D2[0][j][0], space2D2[0][j][1], space2D2[i][j][0], space2D2[i][j][1], c);
                    }
                }
            }
        }
    }

    

    public void formulaCurva3(int curva3[][]){
        double coorX, coorY;

        double maxX = 0, minX = 0;
        double maxY = 0, minY = 0;
        double maxZ = 0, minZ = 0;
        
        double t = 0;
        double exp = 2.3 * 4 / casillasVerticales;
        
        for (int i = 0; i < casillasVerticales; i++) {

            t = exp * i;

            //Tazo raro
            coorX = (Math.cos(t) - Math.pow(Math.cos(2 * t), 3)) * 100;
            coorY = (Math.sin(-t) - Math.pow(Math.sin(2 * -t),3)) * 100;

            curva3[i][0] = (int)coorX;
            curva3[i][1] = (int)coorY;
            curva3[i][2] = 0;
            curva3[i][3] = 1;

            if(i == 0){
                maxY = coorY;
                minY = coorY;
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
        }

        double rangoX = maxX-minX;
        double rangoY = maxY-minY;
        double rangoZ = maxZ-minZ;


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

        traslacionCurva3[0] = rM;
        traslacionCurva3[1] = rM;
        zp = rM;

        int temp[][] = {{0,0,0,1}};
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                temp[0][0] = curva3[j][0];
                temp[0][1] = curva3[j][1] + rM/2;
                temp[0][2] = curva3[j][2];
                temp[0][3] = curva3[j][3];

                rot(temp, 0, 2 * Math.PI/casillasHorizontales * i, 0);

                space3[i][j][0] = temp[0][0];
                space3[i][j][1] = temp[0][1];
                space3[i][j][2] = temp[0][2];
                space3[i][j][3] = temp[0][3];

            }
        }
    }


    public void drawSup3(int space3[][][], int xp, int yp, int zp, Color c){
        int space2D3[][][] = new int [casillasHorizontales][casillasVerticales][3];
        
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                space2D3[i][j] = calcular2D(space3[i][j][0], space3[i][j][1], space3[i][j][2], xp,  yp, zp);
                
            }
        }

        for (int i = 1; i < casillasHorizontales; i++) {
            for (int j = 1; j < casillasVerticales; j++){
               
                puntoMedio(space2D3[i-1][j-1][0], space2D3[i-1][j-1][1], space2D3[i-1][j][0], space2D3[i-1][j][1], c);
                puntoMedio(space2D3[i-1][j-1][0], space2D3[i-1][j-1][1], space2D3[i][j-1][0], space2D3[i][j-1][1], c);

                if(j == casillasVerticales - 1) {
                    puntoMedio(space2D3[i-1][j][0], space2D3[i-1][j][1], space2D3[i][j][0], space2D3[i][j][1], c);
                }
                
                if(i == casillasHorizontales - 1){
                   
                    puntoMedio(space2D3[i][j-1][0], space2D3[i][j-1][1], space2D3[i][j][0], space2D3[i][j][1], c);
                    puntoMedio(space2D3[0][j-1][0], space2D3[0][j-1][1], space2D3[i][j-1][0], space2D3[i][j-1][1], c);

                    if(j == casillasVerticales - 1) {
                        puntoMedio(space2D3[0][j][0], space2D3[0][j][1], space2D3[i][j][0], space2D3[i][j][1], c);
                    }
                }
            }
        }
    }

    public void formulaCurva4(int curva4[][]){
        double coorX, coorY;

        double maxX = 0, minX = 0;
        double maxY = 0, minY = 0;
        double maxZ = 0, minZ = 0;
        
        double t = 0;
        double exp = 2.3 * 4 / casillasVerticales;
        
        for (int i = 0; i < casillasVerticales; i++) {

            t = exp * i;

            //Bola rara
            coorX = (10 * Math.cos(t) * Math.cos(t)) * 100;
            coorY = (10 * Math.cos(-t) * Math.sin(-t)) * 100;

            curva4[i][0] = (int)coorX;
            curva4[i][1] = (int)coorY;
            curva4[i][2] = 0;
            curva4[i][3] = 1;

            if(i == 0){
                maxY = coorY;
                minY = coorY;
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
        }

        double rangoX = maxX-minX;
        double rangoY = maxY-minY;
        double rangoZ = maxZ-minZ;


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

        traslacionCurva4[0] = rM;
        traslacionCurva4[1] = rM;
        zp = rM;

        int temp[][] = {{0,0,0,1}};
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                temp[0][0] = curva4[j][0];
                temp[0][1] = curva4[j][1] + rM/2;
                temp[0][2] = curva4[j][2];
                temp[0][3] = curva4[j][3];

                rot(temp, 0, 2 * Math.PI/casillasHorizontales * i, 0);

                space4[i][j][0] = temp[0][0];
                space4[i][j][1] = temp[0][1];
                space4[i][j][2] = temp[0][2];
                space4[i][j][3] = temp[0][3];

            }
        }
    }


    public void drawSup4(int space4[][][], int xp, int yp, int zp, Color c){
        int space2D4[][][] = new int [casillasHorizontales][casillasVerticales][3];
        
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                space2D4[i][j] = calcular2D(space4[i][j][0], space4[i][j][1], space4[i][j][2], xp,  yp, zp);
                
            }
        }

        for (int i = 1; i < casillasHorizontales; i++) {
            for (int j = 1; j < casillasVerticales; j++){
               
                puntoMedio(space2D4[i-1][j-1][0], space2D4[i-1][j-1][1], space2D4[i-1][j][0], space2D4[i-1][j][1], colorFigura6);
                puntoMedio(space2D4[i-1][j-1][0], space2D4[i-1][j-1][1], space2D4[i][j-1][0], space2D4[i][j-1][1], c);

                if(j == casillasVerticales - 1) {
                    puntoMedio(space2D4[i-1][j][0], space2D4[i-1][j][1], space2D4[i][j][0], space2D4[i][j][1], c);
                }
                
                if(i == casillasHorizontales - 1){
                   
                    puntoMedio(space2D4[i][j-1][0], space2D4[i][j-1][1], space2D4[i][j][0], space2D4[i][j][1], c);
                    puntoMedio(space2D4[0][j-1][0], space2D4[0][j-1][1], space2D4[i][j-1][0], space2D4[i][j-1][1], c);

                    if(j == casillasVerticales - 1) {
                        puntoMedio(space2D4[0][j][0], space2D4[0][j][1], space2D4[i][j][0], space2D4[i][j][1], c);
                    }
                }
            }
        }
    }

    public void formulaCurva5(int curva5[][]){
        double coorX, coorY;

        double maxX = 0, minX = 0;
        double maxY = 0, minY = 0;
        double maxZ = 0, minZ = 0;
        
        double t = 0;
        double exp = 2.3 * 4 / casillasVerticales;
        
        for (int i = 0; i < casillasVerticales; i++) {

            t = exp * i;

            //Campana
            coorX = (Math.cos(9 * t) - Math.pow(Math.cos(10 * t), 3)) * 100;
            coorY = (Math.sin(20 * -t) - Math.pow(Math.sin(9 * -t), 4)) * 100;


            curva5[i][0] = (int)coorX;
            curva5[i][1] = (int)coorY;
            curva5[i][2] = 0;
            curva5[i][3] = 1;

            if(i == 0){
                maxY = coorY;
                minY = coorY;
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
        }

        double rangoX = maxX-minX;
        double rangoY = maxY-minY;
        double rangoZ = maxZ-minZ;


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

        traslacionCurva5[0] = rM;
        traslacionCurva5[1] = rM;
        zp = rM;

        int temp[][] = {{0,0,0,1}};
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                temp[0][0] = curva5[j][0];
                temp[0][1] = curva5[j][1] + rM/2;
                temp[0][2] = curva5[j][2];
                temp[0][3] = curva5[j][3];

                rot(temp, 0, 2 * Math.PI/casillasHorizontales * i, 0);

                space5[i][j][0] = temp[0][0];
                space5[i][j][1] = temp[0][1];
                space5[i][j][2] = temp[0][2];
                space5[i][j][3] = temp[0][3];

            }
        }
    }


    public void drawSup5(int space5[][][], int xp, int yp, int zp, Color c){
        int space2D5[][][] = new int [casillasHorizontales][casillasVerticales][3];
        
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                space2D5[i][j] = calcular2D(space5[i][j][0], space5[i][j][1], space5[i][j][2], xp,  yp, zp);
                
            }
        }

        for (int i = 1; i < casillasHorizontales; i++) {
            for (int j = 1; j < casillasVerticales; j++){
               
                puntoMedio(space2D5[i-1][j-1][0], space2D5[i-1][j-1][1], space2D5[i-1][j][0], space2D5[i-1][j][1], colorFigura4);
                puntoMedio(space2D5[i-1][j-1][0], space2D5[i-1][j-1][1], space2D5[i][j-1][0], space2D5[i][j-1][1], c);

                if(j == casillasVerticales - 1) {
                    puntoMedio(space2D5[i-1][j][0], space2D5[i-1][j][1], space2D5[i][j][0], space2D5[i][j][1], c);
                }
                
                if(i == casillasHorizontales - 1){
                   
                    puntoMedio(space2D5[i][j-1][0], space2D5[i][j-1][1], space2D5[i][j][0], space2D5[i][j][1], c);
                    puntoMedio(space2D5[0][j-1][0], space2D5[0][j-1][1], space2D5[i][j-1][0], space2D5[i][j-1][1], c);

                    if(j == casillasVerticales - 1) {
                        puntoMedio(space2D5[0][j][0], space2D5[0][j][1], space2D5[i][j][0], space2D5[i][j][1], c);
                    }
                }
            }
        }
    }

    public void formulaCurva6(int curva6[][]){
        double coorX, coorY;

        double maxX = 0, minX = 0;
        double maxY = 0, minY = 0;
        double maxZ = 0, minZ = 0;
        
        double t = 0;
        double exp = 2.3 * 4 / casillasVerticales;
        
        for (int i = 0; i < casillasVerticales; i++) {

            t = exp * i;


            //Lampara
            coorX = (Math.cos(t) - Math.pow(Math.cos(20 * t), 3)) * 100;
            coorY = (Math.sin(20 * -t) - Math.pow(Math.sin(2 * -t), 4)) * 100;

            curva6[i][0] = (int)coorX;
            curva6[i][1] = (int)coorY;
            curva6[i][2] = 0;
            curva6[i][3] = 1;

            if(i == 0){
                maxY = coorY;
                minY = coorY;
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
        }

        double rangoX = maxX-minX;
        double rangoY = maxY-minY;
        double rangoZ = maxZ-minZ;


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

        traslacionCurva6[0] = rM;
        traslacionCurva6[1] = rM;
        zp = rM;

        int temp[][] = {{0,0,0,1}};
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                temp[0][0] = curva6[j][0];
                temp[0][1] = curva6[j][1] + rM/2;
                temp[0][2] = curva6[j][2];
                temp[0][3] = curva6[j][3];

                rot(temp, 0, 2 * Math.PI/casillasHorizontales * i, 0);

                space6[i][j][0] = temp[0][0];
                space6[i][j][1] = temp[0][1];
                space6[i][j][2] = temp[0][2];
                space6[i][j][3] = temp[0][3];

            }
        }
    }


    public void drawSup6(int space6[][][], int xp, int yp, int zp, Color c){
        int space2D6[][][] = new int [casillasHorizontales][casillasVerticales][3];
        
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                space2D6[i][j] = calcular2D(space6[i][j][0], space6[i][j][1], space6[i][j][2], xp,  yp, zp);
                
            }
        }

        for (int i = 1; i < casillasHorizontales; i++) {
            for (int j = 1; j < casillasVerticales; j++){
               
                puntoMedio(space2D6[i-1][j-1][0], space2D6[i-1][j-1][1], space2D6[i-1][j][0], space2D6[i-1][j][1], c);
                puntoMedio(space2D6[i-1][j-1][0], space2D6[i-1][j-1][1], space2D6[i][j-1][0], space2D6[i][j-1][1], c);

                if(j == casillasVerticales - 1) {
                    puntoMedio(space2D6[i-1][j][0], space2D6[i-1][j][1], space2D6[i][j][0], space2D6[i][j][1], c);
                }
                
                if(i == casillasHorizontales - 1){
                   
                    puntoMedio(space2D6[i][j-1][0], space2D6[i][j-1][1], space2D6[i][j][0], space2D6[i][j][1], c);
                    puntoMedio(space2D6[0][j-1][0], space2D6[0][j-1][1], space2D6[i][j-1][0], space2D6[i][j-1][1], c);

                    if(j == casillasVerticales - 1) {
                        puntoMedio(space2D6[0][j][0], space2D6[0][j][1], space2D6[i][j][0], space2D6[i][j][1], c);
                    }
                }
            }
        }
    }

    
    public void formulaCurva7(int curva7[][]){
        double coorX, coorY;

        double maxX = 0, minX = 0;
        double maxY = 0, minY = 0;
        double maxZ = 0, minZ = 0;
        
        double t = 0;
        double exp = 2.3 * 4 / casillasVerticales;
        
        for (int i = 0; i < casillasVerticales; i++) {

            t = exp * i;

            //Lampara 2
            coorX = (Math.cos(2 * t) - Math.pow(Math.cos(20 * t), 3)) * 100;
            coorY = (Math.sin(20 * -t) - Math.pow(Math.sin(-t), 4)) * 100;

            curva7[i][0] = (int)coorX;
            curva7[i][1] = (int)coorY;
            curva7[i][2] = 0;
            curva7[i][3] = 1;

            if(i == 0){
                maxY = coorY;
                minY = coorY;
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
        }

        double rangoX = maxX-minX;
        double rangoY = maxY-minY;
        double rangoZ = maxZ-minZ;


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

        traslacionCurva6[0] = rM;
        traslacionCurva6[1] = rM;
        zp = rM;

        int temp[][] = {{0,0,0,1}};
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                temp[0][0] = curva7[j][0];
                temp[0][1] = curva7[j][1] + rM/2;
                temp[0][2] = curva7[j][2];
                temp[0][3] = curva7[j][3];

                rot(temp, 0, 2 * Math.PI/casillasHorizontales * i, 0);

                space7[i][j][0] = temp[0][0];
                space7[i][j][1] = temp[0][1];
                space7[i][j][2] = temp[0][2];
                space7[i][j][3] = temp[0][3];

            }
        }
    }


    public void drawSup7(int space7[][][], int xp, int yp, int zp, Color c){
        int space2D7[][][] = new int [casillasHorizontales][casillasVerticales][3];
        
        for (int i = 0; i < casillasHorizontales; i++) {
            for (int j = 0; j < casillasVerticales; j++){
                space2D7[i][j] = calcular2D(space7[i][j][0], space7[i][j][1], space7[i][j][2], xp,  yp, zp);
                
            }
        }

        for (int i = 1; i < casillasHorizontales; i++) {
            for (int j = 1; j < casillasVerticales; j++){
               
                puntoMedio(space2D7[i-1][j-1][0], space2D7[i-1][j-1][1], space2D7[i-1][j][0], space2D7[i-1][j][1], c);
                puntoMedio(space2D7[i-1][j-1][0], space2D7[i-1][j-1][1], space2D7[i][j-1][0], space2D7[i][j-1][1], c);

                if(j == casillasVerticales - 1) {
                    puntoMedio(space2D7[i-1][j][0], space2D7[i-1][j][1], space2D7[i][j][0], space2D7[i][j][1], c);
                }
                
                if(i == casillasHorizontales - 1){
                   
                    puntoMedio(space2D7[i][j-1][0], space2D7[i][j-1][1], space2D7[i][j][0], space2D7[i][j][1], c);
                    puntoMedio(space2D7[0][j-1][0], space2D7[0][j-1][1], space2D7[i][j-1][0], space2D7[i][j-1][1], c);

                    if(j == casillasVerticales - 1) {
                        puntoMedio(space2D7[0][j][0], space2D7[0][j][1], space2D7[i][j][0], space2D7[i][j][1], c);
                    }
                }
            }
        }
    }

    
    public void paint(Color colorFigura1, Color colorFigura2, Color colorFigura3, Color colorFigura4, Color colorFigura5, Color colorFigura6, Color colorFigura7, Color colorFigura8){

        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        formulaCurva(curva);
        formulaCurva2(curva2);
        formulaCurva3(curva3);
        formulaCurva4(curva4);
        formulaCurva5(curva5);
        formulaCurva6(curva6);
        formulaCurva7(curva7);
       
        for (int i=0; i<casillasHorizontales; i++){
            esc(space[i], repintarEscalacion[0], repintarEscalacion[1], repintarEscalacion[2]);
            rot(space[i], repintarRotacion[0], repintarRotacion[1], repintarRotacion[2]);
            tras(space[i], repintarTraslacion[0], repintarTraslacion[1], repintarTraslacion[2]);
        }

        for (int i=0; i<casillasHorizontales; i++){
            esc(space2[i], repintarEscalacion[0], repintarEscalacion[1], repintarEscalacion[2]);
            rot(space2[i], repintarRotacion[3], repintarRotacion[4], repintarRotacion[5]);
            tras(space2[i], repintarTraslacion[3], repintarTraslacion[4], repintarTraslacion[5]);
        }

        for (int i=0; i<casillasHorizontales; i++){
            esc(space3[i], repintarEscalacion[3], repintarEscalacion[4], repintarEscalacion[5]);
            rot(space3[i], repintarRotacion[6], repintarRotacion[7], repintarRotacion[8]);
            tras(space3[i], repintarTraslacion[6], repintarTraslacion[7], repintarTraslacion[8]);
        }

        for (int i=0; i<casillasHorizontales; i++){
            esc(space4[i], repintarEscalacion[6], repintarEscalacion[7], repintarEscalacion[8]);
            rot(space4[i], repintarRotacion[9], repintarRotacion[10], repintarRotacion[11]);
            tras(space4[i], repintarTraslacion[9], repintarTraslacion[10], repintarTraslacion[11]);
        }

        for (int i=0; i<casillasHorizontales; i++){
            esc(space5[i], repintarEscalacion[9], repintarEscalacion[10], repintarEscalacion[11]);
            rot(space5[i], repintarRotacion[12], repintarRotacion[13], repintarRotacion[14]);
            tras(space5[i], repintarTraslacion[12], repintarTraslacion[13], repintarTraslacion[14]);
        }

        for (int i=0; i<casillasHorizontales; i++){
            esc(space6[i], repintarEscalacion[9], repintarEscalacion[10], repintarEscalacion[11]);
            rot(space6[i], repintarRotacion[15], repintarRotacion[16], repintarRotacion[17]);
            tras(space6[i], repintarTraslacion[15], repintarTraslacion[16], repintarTraslacion[17]);
        }

        for (int i=0; i<casillasHorizontales; i++){
            esc(space7[i], repintarEscalacion[9], repintarEscalacion[10], repintarEscalacion[11]);
            rot(space7[i], repintarRotacion[18], repintarRotacion[19], repintarRotacion[20]);
            tras(space7[i], repintarTraslacion[18], repintarTraslacion[19], repintarTraslacion[20]);
        }


        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 4; j++){
                cuboDub[i][j] = cube[i][j];
                cuboDub2[i][j] = cube2[i][j];
            }
        }

        //Cubo
        rot(cuboDub, repintarRotacionCubo[0], repintarRotacionCubo[1], repintarRotacionCubo[2]);
        tras(cuboDub, repintarTraslacionCubo[0], repintarTraslacionCubo[1], repintarTraslacionCubo[2]);
        trazado(cuboDub, xpCubo, ypCubo, zpCubo, colorFigura1);

        //Cubo 2
        rot(cuboDub2, repintarRotacionCubo2[0], repintarRotacionCubo2[1], repintarRotacionCubo2[2]);
        tras(cuboDub2, repintarTraslacionCubo2[0], repintarTraslacionCubo2[1], repintarTraslacionCubo2[2]);
        trazado(cuboDub2, xpCubo, ypCubo, zpCubo, colorFigura1);

        //Cilindro raro
        drawSup(space, xp,  yp, zp, colorFigura2);
        esc(transformacionGeneral, repintarEscalacion[0], repintarEscalacion[1], repintarEscalacion[2]);
        rot(transformacionGeneral, repintarRotacion[0], repintarRotacion[1], repintarRotacion[2]);
        tras(transformacionGeneral, repintarTraslacion[0], repintarTraslacion[1], repintarTraslacion[2]);

        //Plato
        drawSup2(space2, xp,  yp, zp, colorFigura3);
        esc(transformacionGeneral2, repintarEscalacion[0], repintarEscalacion[1], repintarEscalacion[2]);
        rot(transformacionGeneral2, repintarRotacion[3], repintarRotacion[4], repintarRotacion[5]);
        tras(transformacionGeneral2, repintarTraslacion[3], repintarTraslacion[4], repintarTraslacion[5]);

        //Tazo raro
        drawSup3(space3, xp,  yp, zp, colorFigura4);
        esc(transformacionGeneral3, repintarEscalacion[3], repintarEscalacion[4], repintarEscalacion[5]);
        rot(transformacionGeneral3, repintarRotacion[6], repintarRotacion[7], repintarRotacion[8]);
        tras(transformacionGeneral3, repintarTraslacion[6], repintarTraslacion[7], repintarTraslacion[8]);

        //Bola rara
        drawSup4(space4, xp,  yp, zp, colorFigura5);
        esc(transformacionGeneral4, repintarEscalacion[6], repintarEscalacion[7], repintarEscalacion[8]);
        rot(transformacionGeneral4, repintarRotacion[9], repintarRotacion[10], repintarRotacion[11]);
        tras(transformacionGeneral4, repintarTraslacion[9], repintarTraslacion[10], repintarTraslacion[11]);

        //Campana
        drawSup5(space5, xp,  yp, zp, colorFigura6);
        esc(transformacionGeneral5, repintarEscalacion[9], repintarEscalacion[10], repintarEscalacion[11]);
        rot(transformacionGeneral5, repintarRotacion[12], repintarRotacion[13], repintarRotacion[14]);
        tras(transformacionGeneral5, repintarTraslacion[12], repintarTraslacion[13], repintarTraslacion[14]);

        //Lampara
        drawSup6(space6, xp,  yp, zp, colorFigura7);
        esc(transformacionGeneral6, repintarEscalacion[9], repintarEscalacion[10], repintarEscalacion[11]);
        rot(transformacionGeneral6, repintarRotacion[15], repintarRotacion[16], repintarRotacion[17]);
        tras(transformacionGeneral6, repintarTraslacion[15], repintarTraslacion[16], repintarTraslacion[17]);

        //Lampara
        drawSup6(space7, xp,  yp, zp, colorFigura8);
        esc(transformacionGeneral7, repintarEscalacion[9], repintarEscalacion[10], repintarEscalacion[11]);
        rot(transformacionGeneral7, repintarRotacion[18], repintarRotacion[19], repintarRotacion[20]);
        tras(transformacionGeneral7, repintarTraslacion[18], repintarTraslacion[19], repintarTraslacion[20]);

        zonaTeclado.getGraphics().drawImage(buffer, 0, 0, this);
    }

    public int[] calcular2D(int x1, int y1, int z1, int xp, int yp, int zp){  

        int x2, y2;

        x2 = x1 + ((xp * z1)/zp);
        y2 = y1 + ((yp * z1)/zp);

        int dot[] = {(int)x2, (int)y2};
        return dot;

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

        for(int x1=0; x1<=cubo.length - 1; x1++){
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

    public void run() {
        while (true) {
            //Rotacion Cubo 1
            repintarRotacionCubo[0] = repintarRotacionCubo[0] + Math.PI/64;
            repintarRotacionCubo[1] = repintarRotacionCubo[1] + Math.PI/64;
            
            //Rotacion Cubo 2
            repintarRotacionCubo2[0] = repintarRotacionCubo2[0] - Math.PI/64;
            repintarRotacionCubo2[1] = repintarRotacionCubo2[1] - Math.PI/64;

            //Cilindro raro
            repintarRotacion[1] = repintarRotacion[1] + Math.PI/8;

            //Plato
            repintarRotacion[4] = repintarRotacion[4] - Math.PI/8;

            //Tazo raro
            repintarRotacion[7] = repintarRotacion[7] + Math.PI/8;

            //Bola rara
            repintarRotacion[10] = repintarRotacion[10] + Math.PI/8;

            //Campana
            repintarRotacion[13] = repintarRotacion[13] - Math.PI/8;

            //Lampara
            repintarRotacion[16] = repintarRotacion[16] + Math.PI/8;

            //Lampara 2
            repintarRotacion[19] = repintarRotacion[19] - Math.PI/8;

            r1++;
            g1++;
            b1++;
            if(r1 == 255){
                r1 = 0;
            }
            if(g1 == 255){
                g1 = 0;
            }
            if(b1 == 255){
                b1 = 0;
            }

            r2++;
            g2++;
            b2++;
            if(r2 == 255){
                r2 = 0;
            }
            if(g2 == 255){
                g2 = 0;
            }
            if(b2 == 255){
                b2 = 0;
            }

            r3++;
            g3++;
            b3++;
            if(r3 == 255){
                r3 = 0;
            }
            if(g3 == 255){
                g3 = 0;
            }
            if(b3 == 255){
                b3 = 0;
            }

            r4++;
            g4++;
            b4++;
            if(r4 == 255){
                r4 = 0;
            }
            if(g4 == 255){
                g4 = 0;
            }
            if(b4 == 255){
                b4 = 0;
            }

            r5++;
            g5++;
            b5++;
            if(r5 == 255){
                r5 = 0;
            }
            if(g5 == 255){
                g5 = 0;
            }
            if(b5 == 255){
                b5 = 0;
            }

            r6++;
            g6++;
            b6++;
            if(r6 == 255){
                r6 = 0;
            }
            if(g6 == 255){
                g6 = 0;
            }
            if(b6 == 255){
                b6 = 0;
            }

            r7++;
            g7++;
            b7++;
            if(r7 == 255){
                r7 = 0;
            }
            if(g7 == 255){
                g7 = 0;
            }
            if(b7 == 255){
                b7 = 0;
            }

            r8++;
            g8++;
            b8++;
            if(r8 == 255){
                r8 = 0;
            }
            if(g8 == 255){
                g8 = 0;
            }
            if(b8 == 255){
                b8 = 0;
            }

            colorFigura1 =  new Color(r1, g1, b1);
            colorFigura2 = new Color(r2, g2, b2);
            colorFigura3 = new Color(r3, g3, b3);
            colorFigura4 = new Color(r4, g4, b4);
            colorFigura5 = new Color(r5, g5, b5);
            colorFigura6 = new Color(r6, g6, b6);
            colorFigura7 = new Color(r7, g7, b7);
            colorFigura8 = new Color(r8, g8, b8);
            
            paint(colorFigura1, colorFigura2, colorFigura3, colorFigura4, colorFigura5, colorFigura6, colorFigura7, colorFigura8);

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        proyecto b = new proyecto();
    }
}
