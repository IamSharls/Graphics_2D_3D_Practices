//Clase principal
public class Hex2Ip {

    //Variables de instancia
    String ip = "";
    String hex = "";

    //Metodo HEX a IP
    public void Hex(String ob){
        //Hacemos validaciones para comprobar que el tamaño del segundo parametro obtenido sea 8
        if(ob.length() < 8){
            System.out.println("El formato hexadecimal es muy pequeño");
        }else if(ob.length() > 8){
            System.out.println("El formato hexadecimal es muy largo");
        }else{
            System.out.println("Conversion Hex a IP");
            //Separamos la cadenas cada dos digitos convirtiendolos en enteros base 16 y separandolos con un punto
            for(int i = 0; i < ob.length(); i = i + 2){
                ip = ip + Integer.valueOf(ob.substring(i, i+2), 16) + ".";
            }
            System.out.println("Ip: " + ip);
        }
        
    }

    //Metodo IP a HEX
    public void Ip(String ob){
        String[] division = ob.split("[\\.,]");
        //Hacemos validaciones para comprobar que el tamaño del segundo parametro obtenido sea 4 separados por un punto
		if (division.length < 4) {
			System.out.println("El formato de la IP es muy corto");
		}else if(division.length > 4){
           System.out.println("El formtao de la IP es muy largo");
        }else{
            System.out.println("Conversion IP a Hex");
            for (int i = 0; i < 4; i++) {
                int decimal = Integer.parseInt(division[i]);
                if (decimal < 16){
                    hex += "0" + String.format("%01X", decimal);
                }else{
                    hex += String.format("%01X", decimal);
                }
            }
        }
        System.out.println(hex);
    }

    //Metodo main
    public static void main(String[] args){
        //Cramos un objeto de la clase Hex2Ip para poder usar sus metodos
        Hex2Ip op = new Hex2Ip();
        //Comprobamos si existe una cadena en args
        if(args.length > 0){
            //Validamos si el elemento de la primera posicion, es decir, el primer argumento es -hex o -ip
            if(args[0].equalsIgnoreCase("-hex")){
                //Se comprueba que haya más de un elemento para comprobar si se envió el segundo parametro
                if(args.length > 1){
                    //Guardamos en una variable tipo String el segundo parametro
                    String obtencionHex = String.join("", args[1]);
                    System.out.println("Hexadecimal: " + obtencionHex);
                    //Enviamos el parametro al metodo para su conversion
                    op.Hex(obtencionHex);
                }else{
                    System.out.println("No se envio el segundo parametro");
                }
            }else if(args[0].equalsIgnoreCase("-ip")){
                //Se comprueba que haya más de un elemento para comprobar si se envió el segundo parametro
                if(args.length > 1){
                    //Guardamos en una variable tipo String el segundo parametro
                    String obtencionIp = String.join("", args[1]);
                    System.out.println("IP: " + obtencionIp);
                    //Enviamos el parametro al metodo para su conversion
                    op.Ip(obtencionIp);
                }else{
                    System.out.println("No se envio el segundo parametro");
                }
            }else{
                System.out.println("Ingrese correctamente el primer parametro");
            }

        }else{
            System.out.println("No se han enviado argumentos");
        }
    }
}
