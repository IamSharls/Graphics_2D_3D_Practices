import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Proyecto2DOParcial extends JFrame implements Runnable {

    private BufferedImage buffer, animacion;
    private Color color, disponible;

    BufferedImage Fondo;
    public static Color c = new Color(236, 68, 92);
    public static Color c2 = new Color(255, 68, 92);
    public static Color contornoBlack = new Color(28, 40, 51);
    public static Color rellenoContornoBlack = new Color(0, 0, 0);
    public static Color lineaVerde = new Color(44, 60, 44);
    public static Color petalo1 = new Color(251, 159, 144);
    public static Color petalo2 = new Color(252, 211, 186);
    public static Color petalo3 = new Color(251, 142, 130);
    public static Color centroFlor = new Color(90, 95, 100);
    public static Color blancoLuna = new Color(239, 239, 239 );
    public static Color blancoLunaContorno = new Color(213, 213, 213);
    public static Color blancoLunaExterior = new Color(255, 255, 255 );
    public static Color colorEdificioContorno = new Color(12, 28, 65);
    public static Color colorEdificioInterno = new Color(17, 39, 88);
    public static Color detalleEdificio= new Color(162, 162, 162);
    public static Color gota = new Color(151, 183, 255);
    public static Color gota1 = new Color(166, 166, 166);

    private Thread hilo;

    //Colores gradientes
    public static Color gra1 = new Color(44, 65, 44);
    public static Color gra2 = new Color(44, 70, 44);
    public static Color gra3 = new Color(44, 75, 44);
    public static Color gra4 = new Color(44, 80, 44);

    //Colores Monito
    public static Color zapatos = new Color(228, 228, 220);
    public static Color pantalones = new Color(108, 164, 180);
    public static Color pantalones2 = new Color(92, 140, 156);
    public static Color chamarra = new Color(96, 101, 101);
    public static Color piel = new Color(252, 196, 148);
    public static Color camisa = new Color(172, 53, 36);
    public static Color camisa1 = new Color(220, 68, 52);
    public static Color cabello = new Color(196, 156, 132);
    public static Color cabello1 = new Color(137, 103, 90 );

    //Declaracion de las gotas
                      //      x    y
    private int[] GotaP1 = { 40, 100, 1 }; 
    private int[] GotaP2 = { 46, 120, 1 };

    private int[] GotaP3 = { 34, 150, 1 };
    private int[] GotaP4 = { 40, 170, 1 };

    private int[] GotaP5 = { 46, 200, 1 };
    private int[] GotaP6 = { 52, 220, 1 };

    private int[] GotaP7 = { 40, 250, 1 };
    private int[] GotaP8 = { 46, 270, 1 };

    private int[] GotaP9 = { 30, 290, 1 };
    private int[] GotaP10 = { 36, 310, 1 };

    private int[] GotaP11 = { 115, 70, 1 };
    private int[] GotaP12 = { 121, 90, 1 };

    private int[] GotaP13 = { 135, 120, 1 };
    private int[] GotaP14 = { 141, 140, 1 };

    private int[] GotaP15 = { 165, 160, 1 };
    private int[] GotaP16 = { 171, 180, 1 };

    private int[] GotaP17 = { 170, 250, 1 };
    private int[] GotaP18 = { 176, 270, 1 };

    private int[] GotaP19 = { 125, 260, 1 };
    private int[] GotaP20 = { 131, 280, 1 };

    private int[] GotaP21 = { 200, 75, 1 };
    private int[] GotaP22 = { 206, 95, 1 };

    private int[] GotaP23 = { 230, 220, 1 };
    private int[] GotaP24 = { 236, 240, 1 };

    private int[] GotaP25 = { 240, 140, 1 };
    private int[] GotaP26 = { 246, 160, 1 };

    private int[] GotaP27 = { 270, 80, 1 };
    private int[] GotaP28 = { 276, 100, 1 };

    private int[] GotaP29 = { 460, 70, 1 };
    private int[] GotaP30 = { 466, 90, 1 };

    private int[] GotaP31 = { 480, 100, 1 };
    private int[] GotaP32 = { 486, 120, 1 };

    private int[] GotaP33 = { 380, 200, 1 };
    private int[] GotaP34 = { 386, 220, 1 };

    private int[] GotaP35 = { 310, 170, 1 };
    private int[] GotaP36 = { 316, 190, 1 };

    private int[] GotaP37 = { 340, 260, 1 };
    private int[] GotaP38 = { 346, 280, 1 };

    private int[] GotaP39 = { 310, 290, 1 };
    private int[] GotaP40 = { 316, 310, 1 };

    public int contador = 0;
    public int gotaY = 30;

    public Proyecto2DOParcial() {
        setTitle("Proyecto 2D Parcial - Animacion 2D");
        setSize(500, 500);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        animacion = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        disponible = new Color(0, 0, 0);

        hilo = new Thread(this);
        hilo.start();
    }

    public static void main(String[] args) {
        Proyecto2DOParcial moc = new Proyecto2DOParcial();
    }

    public void paint(Graphics g) {
        animacion = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);

        //Movimiento de las gotas
        dibujarRectangulo(GotaP1[0], GotaP1[1], GotaP2[0], GotaP2[1], gota);
        inundacion(GotaP1[0] + 1, GotaP1[1] + 1, gota);
        traslacionn(GotaP1, 0, gotaY);
        traslacionn(GotaP2, 0, gotaY);

        dibujarRectangulo(GotaP3[0], GotaP3[1], GotaP4[0], GotaP4[1], gota1);
        inundacion(GotaP3[0] + 1, GotaP3[1] + 1, gota1);
        traslacionn(GotaP3, 0, gotaY);
        traslacionn(GotaP4, 0, gotaY);

        dibujarRectangulo(GotaP5[0], GotaP5[1], GotaP6[0], GotaP6[1], gota);
        inundacion(GotaP5[0] + 1, GotaP5[1] + 1, gota);
        traslacionn(GotaP5, 0, gotaY);
        traslacionn(GotaP6, 0, gotaY);

        dibujarRectangulo(GotaP7[0], GotaP7[1], GotaP8[0], GotaP8[1], gota1);
        inundacion(GotaP7[0] + 1, GotaP7[1] + 1, gota);
        traslacionn(GotaP7, 0, gotaY);
        traslacionn(GotaP8, 0, gotaY);

        dibujarRectangulo(GotaP9[0], GotaP9[1], GotaP10[0], GotaP10[1], gota);
        inundacion(GotaP9[0] + 1, GotaP9[1] + 1, gota);
        traslacionn(GotaP9, 0, gotaY);
        traslacionn(GotaP10, 0, gotaY);

        dibujarRectangulo(GotaP11[0], GotaP11[1], GotaP12[0], GotaP12[1], gota1);
        inundacion(GotaP11[0] + 1, GotaP11[1] + 1, gota);
        traslacionn(GotaP11, 0, gotaY);
        traslacionn(GotaP12, 0, gotaY);

        dibujarRectangulo(GotaP13[0], GotaP13[1], GotaP14[0], GotaP14[1], gota);
        inundacion(GotaP13[0] + 1, GotaP13[1] + 1, gota);
        traslacionn(GotaP13, 0, gotaY);
        traslacionn(GotaP14, 0, gotaY);

        dibujarRectangulo(GotaP15[0], GotaP15[1], GotaP16[0], GotaP16[1], gota1);
        inundacion(GotaP15[0] + 1, GotaP15[1] + 1, gota);
        traslacionn(GotaP15, 0, gotaY);
        traslacionn(GotaP16, 0, gotaY);

        dibujarRectangulo(GotaP17[0], GotaP17[1], GotaP18[0], GotaP18[1], gota);
        inundacion(GotaP17[0] + 1, GotaP17[1] + 1, gota);
        traslacionn(GotaP17, 0, gotaY);
        traslacionn(GotaP18, 0, gotaY);

        dibujarRectangulo(GotaP19[0], GotaP19[1], GotaP20[0], GotaP20[1], gota);
        inundacion(GotaP19[0] + 1, GotaP19[1] + 1, gota);
        traslacionn(GotaP19, 0, gotaY);
        traslacionn(GotaP20, 0, gotaY);

        dibujarRectangulo(GotaP21[0], GotaP21[1], GotaP22[0], GotaP22[1], gota);
        inundacion(GotaP21[0] + 1, GotaP21[1] + 1, gota);
        traslacionn(GotaP21, 0, gotaY);
        traslacionn(GotaP22, 0, gotaY);

        dibujarRectangulo(GotaP23[0], GotaP23[1], GotaP24[0], GotaP24[1], gota1);
        inundacion(GotaP23[0] + 1, GotaP23[1] + 1, gota);
        traslacionn(GotaP23, 0, gotaY);
        traslacionn(GotaP24, 0, gotaY);

        dibujarRectangulo(GotaP25[0], GotaP25[1], GotaP26[0], GotaP26[1], gota);
        inundacion(GotaP25[0] + 1, GotaP25[1] + 1, gota);
        traslacionn(GotaP25, 0, gotaY);
        traslacionn(GotaP26, 0, gotaY);

        dibujarRectangulo(GotaP27[0], GotaP27[1], GotaP28[0], GotaP28[1], gota1);
        inundacion(GotaP27[0] + 1, GotaP27[1] + 1, gota);
        traslacionn(GotaP27, 0, gotaY);
        traslacionn(GotaP28, 0, gotaY);

        dibujarRectangulo(GotaP29[0], GotaP29[1], GotaP30[0], GotaP30[1], gota);
        inundacion(GotaP29[0] + 1, GotaP29[1] + 1, gota);
        traslacionn(GotaP29, 0, gotaY);
        traslacionn(GotaP30, 0, gotaY);

        dibujarRectangulo(GotaP31[0], GotaP31[1], GotaP32[0], GotaP32[1], gota);
        inundacion(GotaP31[0] + 1, GotaP31[1] + 1, gota);
        traslacionn(GotaP31, 0, gotaY);
        traslacionn(GotaP32, 0, gotaY);

        dibujarRectangulo(GotaP33[0], GotaP33[1], GotaP34[0], GotaP34[1], gota1);
        inundacion(GotaP33[0] + 1, GotaP33[1] + 1, gota);
        traslacionn(GotaP33, 0, gotaY);
        traslacionn(GotaP34, 0, gotaY);

        dibujarRectangulo(GotaP35[0], GotaP35[1], GotaP36[0], GotaP36[1], gota1);
        inundacion(GotaP35[0] + 1, GotaP35[1] + 1, gota);
        traslacionn(GotaP35, 0, gotaY);
        traslacionn(GotaP36, 0, gotaY);

        dibujarRectangulo(GotaP37[0], GotaP37[1], GotaP38[0], GotaP38[1], gota);
        inundacion(GotaP37[0] + 1, GotaP37[1] + 1, gota);
        traslacionn(GotaP37, 0, gotaY);
        traslacionn(GotaP38, 0, gotaY);

        dibujarRectangulo(GotaP39[0], GotaP39[1], GotaP40[0], GotaP40[1], gota1);
        inundacion(GotaP39[0] + 1, GotaP39[1] + 1, gota);
        traslacionn(GotaP39, 0, gotaY);
        traslacionn(GotaP40, 0, gotaY);

        //Dibujar luna
        circuloCartesiano(390, 100, 35, blancoLunaExterior);
        circuloCartesiano(390, 100, 40, blancoLunaExterior);
        circuloCartesiano(390, 100, 50, blancoLunaExterior);
        dibujarCirculo(390, 100, 30, blancoLunaContorno);
        inundacionCirculo(361, 100, blancoLuna);

        // Crear y rellenar el fondo
        dibujarRectangulo(8, 31, 491, 424, c2);
        inundacion(9, 32, c);

        // Crear y rellenar el suelo
        dibujarRectangulo(8, 425, 491, 435, lineaVerde);
        inundacion(9, 434, lineaVerde);

        //Gradientes del suelo
        dibujarRectangulo(8, 436, 491, 446, gra1);
        inundacion(9, 445, gra1);

        dibujarRectangulo(8, 447, 491, 457, gra2);
        inundacion(9, 456, gra2);

        dibujarRectangulo(8, 458, 491, 468, gra3);
        inundacion(9, 467, gra3);

        dibujarRectangulo(8, 469, 491, 491, gra4);
        inundacion(9, 490, gra4);

        //Detalles del suelo
        putLineaGruesa(80, 440, 130, 440, contornoBlack, 2);
        putLineaGruesa(90, 460, 140, 460, contornoBlack, 2);
        putLineaGruesa(200, 480, 220, 480, contornoBlack, 2);
        putLineaGruesa(300, 470, 350, 470, contornoBlack, 2);
        putLineaGruesa(380, 450, 350, 450, contornoBlack, 2);
        putLineaGruesa(450, 480, 490, 480, contornoBlack, 2);
        putLineaGruesa(400, 460, 450, 460, contornoBlack, 2);
        putLineaGruesa(250, 460, 280, 460, contornoBlack, 2);

        // Pequeña linea verde arriba del suelo
        linea_bresenham(8, 420, 491, 420, contornoBlack);
        linea_bresenham(8, 421, 491, 421, contornoBlack);
        linea_bresenham(8, 422, 491, 422, contornoBlack);
        linea_bresenham(8, 423, 491, 423, contornoBlack);
        linea_bresenham(8, 424, 491, 424, contornoBlack);

        // Poste
        putLineaGruesa(80, 420, 80, 30, contornoBlack, 4);
        putLineaGruesa(89, 430, 89, 30, lineaVerde, 6);

        // Detalles poste
        //Detalle 1
        putLineaGruesa(68, 110, 68, 80, lineaVerde, 3);
        putLineaGruesa(72, 115, 72, 85, contornoBlack, 4);
        putLineaGruesa(76, 110, 76, 80, lineaVerde, 3);

        //Detalle 2
        putLineaGruesa(94, 200, 94, 170, contornoBlack, 3);
        putLineaGruesa(98, 205, 98, 175, lineaVerde, 4);
        putLineaGruesa(102, 200, 102, 170, contornoBlack, 3);

        //Detalle 3
        putLineaGruesa(68, 300, 68, 270, lineaVerde, 3);
        putLineaGruesa(72, 305, 72, 275, contornoBlack, 4);
        putLineaGruesa(76, 300, 76, 270, lineaVerde, 3);

        //Detalle 4
        putLineaGruesa(94, 380, 94, 350, contornoBlack, 3);
        putLineaGruesa(98, 385, 98, 355, lineaVerde, 4);
        putLineaGruesa(102, 380, 102, 350, contornoBlack, 3);

        // ---------------- Flor 2 ----------------//

        // Flor - Tallo
        putLineaGruesa(150, 430, 150, 410, contornoBlack, 2);
        putLineaGruesa(152, 440, 152, 430, contornoBlack, 2);
        putLineaGruesa(152, 405, 152, 415, contornoBlack, 2);
        putLineaGruesa(154, 400, 154, 405, contornoBlack, 2);

        // Flor - Hojas
        putLineaGruesa(156, 400, 156, 410, petalo1, 3);
        putLineaGruesa(158, 405, 158, 415, petalo2, 3);
        putLineaGruesa(158, 400, 158, 405, petalo3, 3);
        putLineaGruesa(162, 395, 162, 405, centroFlor, 4);
        putLineaGruesa(164, 395, 164, 405, centroFlor, 4);
        putLineaGruesa(166, 390, 166, 405, petalo3, 2);
        putLineaGruesa(159, 392, 175, 392, petalo2, 3);
        putLineaGruesa(159, 389, 170, 389, petalo1, 2);
        putLineaGruesa(160, 407, 170, 407, petalo1, 3);
        putLineaGruesa(156, 385, 156, 395, petalo3, 3);
        putLineaGruesa(150, 397, 159, 397, petalo2, 3);

        // ---------------- Flor 1 ----------------//

        // Flor - Tallo
        putLineaGruesa(30, 430, 30, 410, contornoBlack, 2);
        putLineaGruesa(32, 440, 32, 430, contornoBlack, 2);
        putLineaGruesa(32, 405, 32, 415, contornoBlack, 2);
        putLineaGruesa(34, 400, 34, 405, contornoBlack, 2);

        // Flor - Hojas
        putLineaGruesa(36, 400, 36, 410, petalo1, 3);
        putLineaGruesa(38, 405, 38, 415, petalo2, 3);
        putLineaGruesa(38, 400, 38, 405, petalo3, 3);
        putLineaGruesa(42, 395, 42, 405, centroFlor, 4);
        putLineaGruesa(44, 395, 44, 405, centroFlor, 4);
        putLineaGruesa(46, 390, 46, 405, petalo3, 2);
        putLineaGruesa(39, 392, 55, 392, petalo2, 3);
        putLineaGruesa(39, 389, 50, 389, petalo1, 2);
        putLineaGruesa(40, 407, 50, 407, petalo1, 3);
        putLineaGruesa(36, 385, 36, 395, petalo3, 3);
        putLineaGruesa(30, 397, 39, 397, petalo2, 3);

        //Edificios
        putLineaGruesa(487,419,487,300,colorEdificioContorno,5);
        putLineaGruesa(487,305,420,360,colorEdificioContorno,3);
        putLineaGruesa(487,310,420,365,colorEdificioInterno,3);
        putLineaGruesa(487,315,420,370,colorEdificioContorno,3);
        putLineaGruesa(422,415,483,415,colorEdificioInterno,5);
        putLineaGruesa(422,406,483,406,colorEdificioInterno,5);
        putLineaGruesa(422,397,483,397,colorEdificioInterno,5);
        putLineaGruesa(422,391,483,391,colorEdificioInterno,5);
        putLineaGruesa(422,385,483,385,colorEdificioInterno,5);
        putLineaGruesa(422,379,483,379,colorEdificioInterno,5);
        putLineaGruesa(422,373,483,373,colorEdificioInterno,5);
        putLineaGruesa(487,320,420,375,colorEdificioInterno,3);
        putLineaGruesa(487,325,420,380,colorEdificioInterno,3);
        putLineaGruesa(487,330,420,385,colorEdificioInterno,3);
        putLineaGruesa(487,335,420,390,colorEdificioInterno,3);
        putLineaGruesa(487,335,420,390,colorEdificioInterno,3);
        putLineaGruesa(487,340,420,395,colorEdificioInterno,3);
        putLineaGruesa(487,345,420,400,colorEdificioInterno,3);
        putLineaGruesa(487,350,420,405,colorEdificioInterno,3);
        putLineaGruesa(487,355,420,410,colorEdificioInterno,3);
        putLineaGruesa(487,360,420,415,colorEdificioInterno,3);
        putLineaGruesa(487,365,420,420,colorEdificioInterno,3);

        //Edificio 1 
        putLineaGruesa(470,314,475,314,colorEdificioInterno,2);
        putLineaGruesa(470,311,480,311,colorEdificioInterno,2);
        putLineaGruesa(470,308,482,308,colorEdificioInterno,2);
        putLineaGruesa(470,304,483,304,colorEdificioInterno,3);
        putLineaGruesa(470,297,492,297,colorEdificioInterno,5);
        putLineaGruesa(470,288,492,288,colorEdificioInterno,5);
        putLineaGruesa(470,279,492,279,colorEdificioInterno,5);
        putLineaGruesa(470,270,492,270,colorEdificioInterno,5);
        putLineaGruesa(470,261,492,261,colorEdificioInterno,5);
        putLineaGruesa(470,252,492,252,colorEdificioInterno,5);
        putLineaGruesa(470,243,492,243,colorEdificioInterno,5);
        putLineaGruesa(470,234,492,234,colorEdificioInterno,5);
        putLineaGruesa(470,225,493,225,colorEdificioInterno,5);
        putLineaGruesa(471,217,493,217,colorEdificioInterno,4);
        putLineaGruesa(478,211,493,211,colorEdificioInterno,3);
        putLineaGruesa(482,207,493,207,colorEdificioInterno,2);


        //Edificio 2
        putLineaGruesa(449,323,468,308,colorEdificioInterno,3);
        putLineaGruesa(449,326,468,311,colorEdificioInterno,3);
        putLineaGruesa(449,331,468,316,colorEdificioInterno,3);
        putLineaGruesa(450,315,468,315,colorEdificioInterno,5);
        putLineaGruesa(450,306,468,306,colorEdificioInterno,5);
        putLineaGruesa(450,297,468,297,colorEdificioInterno,5);
        putLineaGruesa(450,288,468,288,colorEdificioInterno,5);
        putLineaGruesa(450,279,468,279,colorEdificioInterno,5);
        putLineaGruesa(450,270,468,270,colorEdificioInterno,5);
        putLineaGruesa(450,261,468,261,colorEdificioInterno,5);
        putLineaGruesa(450,252,468,252,colorEdificioInterno,5);
        putLineaGruesa(450,243,468,243,colorEdificioInterno,5);
        putLineaGruesa(450,235,468,235,colorEdificioInterno,5);

        //Edificio 3
        putLineaGruesa(443,235,453,235,colorEdificioInterno,5);
        putLineaGruesa(437,240,453,240,colorEdificioInterno,3);
        putLineaGruesa(433,245,453,245,colorEdificioInterno,5);
        putLineaGruesa(433,254,453,254,colorEdificioInterno,5);
        putLineaGruesa(433,263,453,263,colorEdificioInterno,5);
        putLineaGruesa(433,272,453,272,colorEdificioInterno,5);
        putLineaGruesa(433,281,453,281,colorEdificioInterno,5);
        putLineaGruesa(433,290,453,290,colorEdificioInterno,5);
        putLineaGruesa(439,299,453,299,colorEdificioInterno,5);
        putLineaGruesa(439,308,453,308,colorEdificioInterno,5);
        putLineaGruesa(439,317,450,317,colorEdificioInterno,5);
        putLineaGruesa(439,326,450,326,colorEdificioInterno,5);
        putLineaGruesa(439,335,447,335,colorEdificioInterno,5);

        //Edificio 4
        putLineaGruesa(420,340,440,325,colorEdificioInterno,3);
        putLineaGruesa(420,345,440,330,colorEdificioInterno,3);
        putLineaGruesa(420,350,440,335,colorEdificioInterno,3);
        putLineaGruesa(420,355,440,340,colorEdificioInterno,3);
        putLineaGruesa(420,335,440,335,colorEdificioInterno,5);
        putLineaGruesa(420,326,440,326,colorEdificioInterno,5);
        putLineaGruesa(420,317,440,317,colorEdificioInterno,5);
        putLineaGruesa(420,310,440,310,colorEdificioInterno,4);
        putLineaGruesa(423,306,440,306,colorEdificioInterno,2);
        putLineaGruesa(429,302,440,302,colorEdificioInterno,4);
        putLineaGruesa(434,298,440,298,colorEdificioInterno,4);
        
        putLineaGruesa(420,419,420,355,colorEdificioContorno,4);
        putLineaGruesa(495,200,465,220,colorEdificioContorno,3);
        putLineaGruesa(468,220,468,322,colorEdificioContorno,3);
        putLineaGruesa(448,230,468,230,colorEdificioContorno,3);
        putLineaGruesa(448,230,430,245,colorEdificioContorno,3);
        putLineaGruesa(448,230,448,336,colorEdificioContorno,2);
        putLineaGruesa(432,245,432,298,colorEdificioContorno,2);
        putLineaGruesa(439,291,420,310,colorEdificioContorno,3);
        putLineaGruesa(440,290,440,346,colorEdificioContorno,2);
        putLineaGruesa(420,310,420,358,colorEdificioContorno,2);

        //Valla
        putLineaGruesa(418,400,355,400,colorEdificioContorno,2);
        putLineaGruesa(361,400,361,421,colorEdificioContorno,2);
        putLineaGruesa(375,400,375,421,colorEdificioContorno,2);
        putLineaGruesa(389,400,389,421,colorEdificioContorno,2);
        putLineaGruesa(403,400,403,421,colorEdificioContorno,2);

        //Monito

        putLineaGruesa(230,440,240,440,zapatos,3);
        putLineaGruesa(255,440,265,440,zapatos,3);
        putLineaGruesa(241,442,241,390,pantalones,3);
        putLineaGruesa(236,437,236,390,pantalones2,3);
        putLineaGruesa(253,442,253,390,pantalones,3);
        putLineaGruesa(258,437,258,390,pantalones2,3);
        putLineaGruesa(258,437,258,390,pantalones2,3);
        putLineaGruesa(246,400,246,390,pantalones,5);

        putLineaGruesa(236,395,236,350,chamarra,3);
        putLineaGruesa(258,395,258,350,chamarra,3);

        putLineaGruesa(232,385,232,355,chamarra,3);
        putLineaGruesa(263,385,263,355,chamarra,3);

        putLineaGruesa(232,385,232,395,piel,3);
        putLineaGruesa(263,385,263,395,piel,3);

        putLineaGruesa(239,388,256,388,camisa,3);
        putLineaGruesa(239,383,256,383,camisa1,3);
        putLineaGruesa(239,379,256,379,camisa,3);
        putLineaGruesa(239,375,256,375,camisa1,3);
        putLineaGruesa(239,371,256,371,camisa,3);
        putLineaGruesa(239,367,256,367,camisa1,3);
        putLineaGruesa(239,363,256,363,camisa,3);
        putLineaGruesa(239,359,256,359,camisa1,3);
        putLineaGruesa(239,355,256,355,camisa,3);
        putLineaGruesa(239,351,256,351,piel,3);
        putLineaGruesa(239,347,256,347,piel,3);
        putLineaGruesa(235,343,260,343,piel,3);
        putLineaGruesa(235,339,260,339,piel,3);
        putLineaGruesa(235,335,260,335,piel,3);
        putLineaGruesa(235,331,260,331,piel,3);
        putLineaGruesa(235,327,260,327,piel,3);
        putLineaGruesa(239,324,256,324,piel,3);
        putLineaGruesa(235,324,240,324,cabello,3);
        putLineaGruesa(256,324,260,324,cabello,3);
        putLineaGruesa(235,320,260,320,cabello1,3);
        putLineaGruesa(235,316,255,316,cabello1,3);
        putLineaGruesa(240,331,245,331,contornoBlack,3);
        putLineaGruesa(250,331,255,331,contornoBlack,3);
        
        this.getGraphics().drawImage(animacion, 0, 0, this);
    }

    public void dibujarCirculo(int xc, int yc, int r, Color c){
        double x, y, dt;
        dt = Math.PI / (r * 4);
        for(double t = 0; t <= 2 * Math.PI; t += dt) {
            x = Math.cos(t) * r + xc;
            y = Math.sin(t) * r +yc;
            putPixelTras((int)(Math.round(x)), (int)(Math.round(y)), c);
        }
    }

    public void circuloCartesiano(int xc, int yc, int R, Color c){

        int x;
        double y1, y2;

        for(x = xc - R; x <= xc + R; x = x + 1){
            
            y1 = yc + Math.sqrt(R * R - ((x - xc) * (x - xc)));
            y2 = yc - Math.sqrt(R * R - ((x - xc) * (x - xc))) ;

            putPixelTras(x, (int)Math.round(y1), c);
            putPixelTras(x, (int)Math.round(y2), c);
        }
     
    }

    public void putLineaGruesa(int x0, int y0, int x1, int y1, Color c, int GRUESO) {

        double x, y;
        double dx, dy;

        double incx = 1;
        double incy = 1;

        double incE, incNE;
        double p = 0;

        x = x0;
        y = y0;

        dx = x1 - x0;
        dy = y1 - y0;

        if (dx < 0) {
            dx = -dx;
            incx = -1;
        }

        if (dy < 0) {
            dy = -dy;
            incy = -1;
        }

        if (Math.abs(dx) > Math.abs(dy)) {
            incE = 2 * dy;
            incNE = 2 * (dy - dx);

            while (x != x1) {
                for (int i = 0; i < GRUESO; i++) {
                    putPixelTras((int) Math.round(x), (int) Math.round(y + i), c);
                    putPixelTras((int) Math.round(x), (int) Math.round(y - i), c);
                }

                x = x + incx;

                if (2 * (p + dy) < dx) {
                    p = p + incE;
                } else {
                    p = p + incNE;
                    y = y + incy;
                }
            }
        } else {
            incE = 2 * dx;
            incNE = 2 * (dx - dy);

            while (y != y1) {
                for (int i = 0; i < GRUESO; i++) {
                    putPixelTras((int) Math.round(x + i), (int) Math.round(y), c);
                    putPixelTras((int) Math.round(x - i), (int) Math.round(y), c);
                }

                y = y + incy;

                if (2 * (p + dx) < dy) {
                    p = p + incE;
                } else {
                    p = p + incNE;
                    x = x + incx;
                }
            }
        }
    }

    // --------------------------- Funciones para las gotas
    // ---------------------------//
    public void traslacionn(int[] vector, int dx, int dy) {
        int r[] = { 0, 0, 0 };
        int[] P = { vector[0], vector[1], vector[2] };
        int[][] T = { { 1, 0, dx },
                      { 0, 1, dy },
                      { 0, 0, 1 }  };
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                r[i] += P[j] * T[i][j];
            }
        }
        vector[0] = r[0];
        vector[1] = r[1];
        vector[2] = r[2];
    }

    public void putPixelTras(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        animacion.getGraphics().drawImage(buffer, x, y, this);
    }

    public void dibujarRectangulo(int x0, int y0, int x1, int y1, Color c) {
        linea_bresenham(x0, y0, x1, y0, c);
        linea_bresenham(x0, y1, x1, y1, c);
        linea_bresenham(x0, y0, x0, y1, c);
        linea_bresenham(x1, y0, x1, y1, c);
    }

    public void linea_bresenham(int x0, int y0, int x1, int y1, Color c) {
        int x, y, dx, dy, P, A, B, stepx, stepy;
        dx = x1 - x0;
        dy = y1 - y0;
        if (dy < 0) {
            dy = -dy;
            stepy = -1;
        } else {
            stepy = 1;
        }

        if (dx < 0) {
            dx = -dx;
            stepx = -1;
        } else {
            stepx = 1;
        }

        x = x0;
        y = y0;
        putPixelTras(x, y, c);

        if (dx > dy) {
            P = 2 * dy - dx;
            A = 2 * dy;
            B = 2 * (dy - dx);
            while (x != x1) {
                x = x + stepx;
                if (P < 0) {
                    P = P + A;
                } else {
                    y = y + stepy;
                    P = P + B;
                }
                putPixelTras(x, y, c);
            }
        } else {

            P = 2 * dx - dy;
            A = 2 * dx;
            B = 2 * (dx - dy);
            while (y != y1) {
                y = y + stepy;
                if (P < 0) {
                    P = P + A;
                } else {
                    x = x + stepx;
                    P = P + B;
                }
                putPixelTras(x, y, c);
            }
        }
    }

    public void inundacion(int x, int y, Color relleno){
        if ((x < this.getWidth() && y < this.getHeight()) && (x > 0 && y > 0)) {
            color = leerColorPixel(x, y);
            if (color.equals(disponible)) {
                putPixelTras(x, y, relleno);
                inundacion(x, y + 1, relleno);
                inundacion(x + 1, y, relleno);
                inundacion(x, y - 1, relleno);
                // inundacion(x-1,y,relleno);
            }
        }
    }

    public void inundacionCirculo(int x, int y, Color relleno){
        if ((x < this.getWidth() && y < this.getHeight()) && (x > 0 && y > 0)) {
            color = leerColorPixel(x, y);
            if (color.equals(disponible)) {
                putPixelTras(x, y, relleno);
                inundacion(x, y + 1, relleno);
                inundacion(x + 1, y, relleno);
                inundacion(x, y - 1, relleno);
                inundacion(x - 1, y, relleno);
            }
        }
    }

    public Color leerColorPixel(int x, int y) {
        color = new Color(animacion.getRGB(x, y));
        return color;
    }

    public void run() {
        while (true) {
            try {
                contador++;
                System.out.println(contador);
                if(contador == 1 && gotaY == 30){
                    contador = 0;
                    gotaY = -29;
                    
                }
                if(contador == 1 && gotaY == -29){
                    contador = 0;
                    gotaY = 30;
                }
                repaint();
                hilo.sleep(400);
            } catch (InterruptedException ex) {

            }
        }
    }
}
