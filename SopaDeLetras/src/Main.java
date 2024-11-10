import java.util.Random;

public class Main {
    private final static int MAX_FILA_TABLERO = 10;
    private final static int MAX_COLUMNA_TABLERO = 10;
    private static char[][] tablero;
    private static final String[] palabrasBuscar = {"silla", "mesa", "sol", "ojo", "rata"};

    public static void rellenarTablero() {
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                Random aleatorio = new Random();
                char caracter = (char) ((aleatorio.nextInt(26)) + 'A');           //Genera nº aleatorio 0-25 (para A-Z), caracter mayúscula, añade A para que esté incluida.
                tablero[i][j] = caracter;
            }
        }
    }

    private static void colocarPalabras() {
        Random aleatorio = new Random();
        for (int i = 0; i < palabrasBuscar.length; i++) {                               //Recorre las palabras
            String palabra = palabrasBuscar[i];                                         //Coge cada palabra del array y la almacena en palabra
            System.out.println(palabra); //Las escribe al inicio

            int filaAleatoria = aleatorio.nextInt(MAX_FILA_TABLERO);
            int columnaAleatoria = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            boolean horizontal= aleatorio.nextBoolean();
            boolean vertical= aleatorio.nextBoolean();
            boolean diagonalDerecha= aleatorio.nextBoolean();
            boolean diagonalIzquierda= aleatorio.nextBoolean();

            // Colocar la palabra en dirección aleatoria
            for (int n = 0; n < palabra.length(); n++) {                                //Recorre cada carácter de la palabra que toque y lo coloca según la dirección
                    // Horizontal
                if (horizontal && columnaAleatoria + n < MAX_COLUMNA_TABLERO) {         //Horizontal y que no se salga fuera del tablero.
                    tablero[filaAleatoria][columnaAleatoria + n] = palabra.charAt(n);   //Se coloca el caracter una columna más a la derecha, para n=0 (r) posición inicial, n=1 (a) sig columna...

                    // Vertical
                } else if (vertical && filaAleatoria + n < MAX_FILA_TABLERO) {
                    tablero[filaAleatoria + n][columnaAleatoria] = palabra.charAt(n);   //Se coloca el caracter una fila más a la derecha

                    //Diagonal
                } else if (diagonalDerecha && (columnaAleatoria + n < MAX_COLUMNA_TABLERO && filaAleatoria + n < MAX_FILA_TABLERO)) {
                    tablero[filaAleatoria + n][columnaAleatoria+n] = palabra.charAt(n);
                } else if (diagonalIzquierda && columnaAleatoria - n >= 0 && filaAleatoria + n < MAX_FILA_TABLERO) {
                    tablero[filaAleatoria + n][columnaAleatoria - n] = palabra.charAt(n);
                }
            }
        }
    }

    private static void imprimirTablero() {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Encuentra las palabras: ");
        rellenarTablero();
        colocarPalabras();
        imprimirTablero();
    }
}