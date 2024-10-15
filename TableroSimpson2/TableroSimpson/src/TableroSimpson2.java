import java.util.Random;

public class TableroSimpson2 {

    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static char [][] tablero;

    private static void imprimirTablero() {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                // [0,0],[0,1],[0,2],ETC.
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(); // Espacio entre tableros
        System.out.println();
        System.out.println();
    }
    private static void asignarLibreACasilla(char caracter){
        // Rellenar el tablero "L"
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                // [0,0],[0,1],[0,2]...
                tablero[i][j] = caracter;
            }
        }
    }
    private static void asignarBartACasillaLibre(char caracter) {
        // Asignar a Bart
        Random aleatorio = new Random();
        int filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO); // Nº aleatorios de 0 a 9
        int columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO); // Nº aleatorios de 0 a 9
        tablero[filaAleatorio][columnaAleatorio] = caracter;
    }
    private static void asignarCaracterACasillasLibres(char caracter) {
        Random aleatorio = new Random();
        // Repartir 10 Homers dentro del tablero
        int filaAleatorioHomer;
        int columnaAleatorioHomer;
        for (int i = 0; i < 10; i++) {
            do {
                filaAleatorioHomer = aleatorio.nextInt(MAX_FILA_TABLERO); // Nº aleatorios de 0 a 9
                columnaAleatorioHomer = aleatorio.nextInt(MAX_COLUMNA_TABLERO); // Nº aleatorios de 0 a 9
            } while (tablero[filaAleatorioHomer][columnaAleatorioHomer] != 'L');
            tablero[filaAleatorioHomer][columnaAleatorioHomer] = caracter;
        }
    }

    public static void main(String[] args) {

        // 1º) Inicializar mi matriz tablero
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

        // 2ª) Rellenar el tablero "L"
        asignarLibreACasilla('L');

        // 3º) Imprimir tablero
        imprimirTablero();

        // 4º) Asignar a Bart
        asignarBartACasillaLibre('B');

        imprimirTablero();

        // 5º) Repartir 10 Homers dentro del tablero
        asignarCaracterACasillasLibres('H');

        imprimirTablero();

        // 6º) Repartir 10 Muros dentro del tablero
        asignarCaracterACasillasLibres('M');

        imprimirTablero();

        // 7º) Poner la celda final
        tablero[MAX_FILA_TABLERO-1][MAX_COLUMNA_TABLERO-1] = 'F';

        imprimirTablero();
    }
}
