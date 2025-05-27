import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String generarAnagrama(char[] array) {
        Random aleatorio = new Random();
        for (int i = 0; i < array.length; i++) {
            int j = aleatorio.nextInt(array.length); // índice aleatorio entre 0 y arr.length - 1
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return new String(array); // Construye un nuevo String desde el arreglo permutado
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabra = scanner.nextLine();
        System.out.print("Introduce una palabra: ");
        
        char[] caracteres = palabra.toCharArray();

        String resultado = generarAnagrama(caracteres);
        System.out.println("Anagrama generado: " + resultado);

        scanner.close();
    }
}