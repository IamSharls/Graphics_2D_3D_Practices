import java.util.Arrays;
import java.util.Collections;

//Clase principal
public class OrdenDescendente {
    
    //Metodo main
    public static void main(String args[]){
        //Comprobamos si existe una cadena en la variable args
        if(args.length > 0){
           
            //Obtenemos el tamaño de la cadena
            int tamano = args.length;
            //Creamos un arreglo de tipo INT con el mismo tamaño que la cadena de args
            int [] arr = new int [tamano];
            //Comenzamos a ingresar los elementos de args en el arreglo llamado arr pero convirtiendolos de tipo String a Int
            for(int i = 0; i < tamano; i++){
                arr[i] = Integer.parseInt(args[i]);  
            }
            //Ordenamos de forma ascendente los valores de arr
            Arrays.sort(arr);
            //Utilizamos un for inverso para imprimir los valores al reves, es decir, orden descendente
            System.out.println("Valores en descendente:");
            for(int i = tamano - 1; i >= 0; i--){
                System.out.print(arr[i] + " ");
            }
        }else{
            System.out.println("No ha especificado argumentos");
        }
        
    }
}
