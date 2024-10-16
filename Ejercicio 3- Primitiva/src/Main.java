import java.util.Random;
import java.util.Scanner;

public class Main {
    //String arrayPrimitiva[]= new String[6];
    public static void main(String[] args) {
        Random alea = new Random();
        Scanner leer = new Scanner(System.in);
        //PRIMITIVA
        String arrayPrimitiva[]= new String[6];
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            int numAle= alea.nextInt(10);
            //¿Cómo convertir un entero a cadena?
            //CONVERSOR DE TIPOS DE DATOS, De int a String
            arrayPrimitiva[i] = String.valueOf(numAle);
        }
        //Imprimir array
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            System.out.print(arrayPrimitiva[i]+ " ");
        }
        System.out.println("");
        //Pedida de 3 nº al usuario, si están en el array= "XX"
        System.out.println("Dame un nº");
        String numUsuario1=leer.next();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if (numUsuario1.equals(arrayPrimitiva[i])) {
                arrayPrimitiva[i] = "XX";
            }
        }
        System.out.println("Dame un nº");
        String numUsuario2=leer.next();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if (numUsuario2.equals(arrayPrimitiva[i])) {
                arrayPrimitiva[i] = "XX";
            }
        }
        System.out.println("Dame un nº");
        String numUsuario3=leer.next();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if (numUsuario3.equals(arrayPrimitiva[i])) {
                arrayPrimitiva[i] = "XX";
            }
        }
        //Imprimir array
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            System.out.print(arrayPrimitiva[i]+ " ");
        }
        System.out.println("");
    }
}