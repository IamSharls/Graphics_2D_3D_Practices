import java.util.Random;

//Clase principal
public class NumerosAleatorios {
    //Metodo main
    public static void main(String args[]){
        //Definimos el rango minimo y maximo para la generacion de los numeros randoms
        int min = 1;
        int max = 25;

        //Creamos un objeto de la funcion Random de Java
        Random random = new Random();
        //Asignamos dos valores aleatorios de 1 a 25 a dos variables diferentes
        int valor1 = random.nextInt(max + min) + min;
        int valor2 = random.nextInt(max + min) + min;
        System.out.println(valor1);
        System.out.println(valor2);

        //Damos uso de la funcion Math y le pasamos como argumentos los valores generados para obtener el numero mayor
        System.out.println("El mayor de los dos numeros es: " + Math.max(valor1, valor2));
    }
}
