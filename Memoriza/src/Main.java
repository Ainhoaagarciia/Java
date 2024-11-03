import java.util.Random;
import java.util.Scanner;
// Tablero 4x4 de parejas del 1 al 8, usuario mete coordenadas y las compara

public class Main {
    static final int MAX_FILA_TABLERO = 4;
    static final int MAX_COLUMNA_TABLERO = 4;
    static final int[][] tablero = new int[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
    static  Random aleatorio = new Random();
    static void establecerTablero0(){
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tablero[i][j] = 0;
            }
        }
    }
    static void distribucionAleatoriaParejas(){
        for (int i = 0; i <9 ; i++) { // Se ejecuta 8 veces, una por cada nº de la pareja (del 1 al 8). Empieza con el 1
            for (int j = 0; j <2 ; j++) {  // Se ejecuta 2 veces para colocar cada pareja en dos posiciones aleatorias. Repite el 1 para que tenga su pareja
                int FilaRandom;
                int ColumnaRandom;
                do {
                    FilaRandom = aleatorio.nextInt(MAX_FILA_TABLERO); //Genera fila aleatoria
                    ColumnaRandom = aleatorio.nextInt(MAX_FILA_TABLERO);
                }while(tablero[FilaRandom][ColumnaRandom]!=0); // Repetir hasta encontrar una posición vacía
                tablero[FilaRandom][ColumnaRandom] =i; 
            }
        }
    }
    static void imprimirTablero(){
        for (int i = 0; i <MAX_FILA_TABLERO; i++) {
            for (int j = 0; j <MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        establecerTablero0();
        distribucionAleatoriaParejas();
        imprimirTablero();
        int intentos = 10;
        do {
            Scanner leer = new Scanner(System.in);
            System.out.println("OPORTUNIDADES " +intentos);
            System.out.println("DAME EL PRIMER Nº");
            System.out.println("FILA:");
            int Fila1 = leer.nextInt();
            System.out.println("COLUMNA:");
            int Columna1 = leer.nextInt();
            System.out.println("DAME EL SEGUNDO Nº");
            System.out.println("FILA:");
            int Fila2 = leer.nextInt();
            System.out.println("COLUMNA:");
            int Columna2 = leer.nextInt();

            if (tablero[Fila1][Columna1] == tablero[Fila2][Columna2]) {
                System.out.println("HAS ACERTADO!!");
                tablero[Fila1][Columna1] = 0; // Los valores en esas posiciones se ponen en 0, indicando que la pareja fue encontrada
                tablero[Fila2][Columna2] = 0; 
            } else{
                System.out.println("HAS FALLADO!!");
                intentos--;
            }
            imprimirTablero();
        }while (intentos < 10 );
    }
}
