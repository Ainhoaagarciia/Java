import java.util.Random;

public class Main {
    private final static int MAX_FILA_TABLERO=10;
    private final static int MAX_COLUMNA_TABLERO=10;
    private static char [][] tablero;

    public static void rellenarTablero() {
        tablero= new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                Random aleatorio = new Random();
                char caracter= (char) ((aleatorio.nextInt(26)) + 'A');
                tablero[i][j] = caracter;
            }
        }
    }
    private static void colocarPalabras(String[] palabras) {
        Random random = new Random();
        for (int i = 0; i < palabras.length; i++) { //Recorre las palabras
            String palabra = palabras[i]; //Coge cada palabra y la almacena en palabra
            System.out.println(palabra); //Las escribe al inicio

            int fila = random.nextInt(MAX_FILA_TABLERO);
            int columna = random.nextInt(MAX_COLUMNA_TABLERO);
            boolean horizontal = random.nextBoolean(); // True si es horizontal, False vertical

            // Colocar la palabra en dirección aleatoria
            for (int n = 0; n < palabra.length(); n++) { //Recorre cada carácter y lo coloca según la dirección
                if (horizontal && columna + n < MAX_COLUMNA_TABLERO) {
                    // Horizontalmente
                    tablero[fila][columna + n] = palabra.charAt(n); //Se mantiene la fila pero la columna aumenta
                } else if (!horizontal && fila + n < MAX_FILA_TABLERO) {
                    // Verticalmente
                    tablero[fila + n][columna] = palabra.charAt(n); //Se mantiene la columna pero fila aumenta
                }
            }
        }
    }
    private static void imprimirTablero() {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Encuentra las palabras: ");
        rellenarTablero();
        //Asignar palabras
        String [] palabras = {"SILLA","MESA","SOL","OJO","RATA"};
        //Colocar palabras en el tablero
        colocarPalabras(palabras);
        imprimirTablero();
    }
}