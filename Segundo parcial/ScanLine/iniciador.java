
public class iniciador{
    private constructorVentana constructorVentana;
    
    public static void main(String[] args) {
        new iniciador().start();
    }
    void start(){
        constructorVentana = new constructorVentana();
    }
}
