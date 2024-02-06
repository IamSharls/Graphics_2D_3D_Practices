//Clase principal
public class Subcadenas{
    //Metodo main
    public static void main(String[] args){
        //Comprobamos si existe una cadena en la variable args
        if(args.length > 0){
            //Pasamos los valores de nuestro arreglo de Strings a una variable de tipo String, separando cada elemento(palabra) 
            //con un espacio
            String conversion = String.join(" ", args);
            //Imrimimos la variable
            System.out.println("Cadena original:");
            System.out.println(conversion);
            System.out.println("\n");
            //Obtenemos el tamaño del contenido de la variable conversion
            int tam = conversion.length();
            //Definimos nuestros rangos para imprimir las subcadenas
            int indexMaximo = tam;
            int indexMinimo = 0;
            System.out.println("Subcadenas 1:");
            //Imprimimos las subcadenas quitando letras de derecha a izquierda
            for(int i = 0;  i <= tam; i++){ 
                System.out.println(conversion.substring(0,  indexMaximo));
                indexMaximo --;
            }
            //Imprimimos las subcadenas quitando letras de izquierda a derecha
            System.out.println("Subcadenas 2:");
            for(int j = 0; j <= tam; j++){
                System.out.println(conversion.substring(indexMinimo, tam));
                indexMinimo ++;
            }
        }else{
            System.out.println("No se enviaron argumentos");
        }
    }

}