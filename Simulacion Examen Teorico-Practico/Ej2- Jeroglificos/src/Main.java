import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] simbolos = {'T', 'G', 'C', 'F', 'D', 'R', 'H'};
        int[] potencias = {1, 10, 100, 1000, 10000, 100000, 1000000};

        while (true) {
            int numero = scanner.nextInt(); //Nº usuario = numero

            if (numero == 0) break;

            String resultado = "";

            int tamano = String.valueOf(numero).length(); // LONGITUD del nº pasado a cadena, Ej) 52= "2"

            for (int i = (tamano-1); i >= 0; i--) { //Recorrerá al revés los dos arrays
                int digito = numero / potencias[i]; //devuelve el cociente. Ej)5
                numero %= potencias[i]; //Devuelve el resto
                for (int j = 0; j < digito; j++) { // Se repetiría 5 veces la letra
                    resultado = resultado + (simbolos[i]); //Devuelve el símbolo en la posicion correspondiente de i. Ej) 52, su tamaño es 2, por lo cual i=1, así que devolverá el caracter de la posicion 1 (G)
                }
            }
            System.out.println(resultado);
        }
        scanner.close();
    }
}