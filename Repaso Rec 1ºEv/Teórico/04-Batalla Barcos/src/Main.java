import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_FILA = 8;
    private static final int MAX_COLUMNA = 8;
    private static char [][] matriz = new char[MAX_FILA][MAX_COLUMNA];

    private static void rellenarTablero(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                matriz[i][j] = '-';
            }
        }
    }

    private static void imprimirTablero(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void colocarBarcos(){
        Random aleatorio = new Random();
        int filaAleatorio=0;
        int columnaAleatorio=0;
        for (int i = 0; i < 3; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(MAX_FILA);
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA);
            }while (matriz[filaAleatorio][columnaAleatorio]!='-' );
            matriz[filaAleatorio][columnaAleatorio] = 'B';
        }
    }
    private static void hundirBarcos(){
        int aciertos = 0;
        do {
            imprimirTablero();
            System.out.println("Dime una fila");
            Scanner lector = new Scanner(System.in);
            int fila = lector.nextInt();

            System.out.println("Ahora una columna");
            int columna = lector.nextInt();

            if (matriz[fila][columna] == 'B') {
                matriz[fila][columna] = 'X'; // Acierto
                System.out.println("¡Tocado!");
                aciertos++;
            } else {
                matriz[fila][columna] = 'O'; // Agua
                System.out.println("Agua.");
            }
        }while (aciertos<4);
    }

    public static void main(String[] args) {
        rellenarTablero();
        colocarBarcos();
        hundirBarcos();
        imprimirTablero();
    }
}