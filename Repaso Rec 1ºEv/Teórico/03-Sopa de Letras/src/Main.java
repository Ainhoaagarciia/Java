import java.util.Random;


public class Main {
    private static final int MAX_FILA= 10;
    private static final int MAX_COLUMNA= 10;
    private static final char [][] matriz = new char[MAX_FILA][MAX_COLUMNA];
    private static final String [] palabras = {"JAVA"};
    public static Random aleatorio = new Random();

    private static void rellenarMatriz(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                matriz[i][j] = '.';
            }
        }
    }
    private static void imprimirMatriz(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void colocarLetras(){
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            System.out.println();
            System.out.println(palabra);
            int filaAleatoria = aleatorio.nextInt(MAX_FILA);
            int columnaAleatoria = aleatorio.nextInt(MAX_COLUMNA);
            boolean vertical = aleatorio.nextBoolean();
            boolean horizontal = aleatorio.nextBoolean();
            boolean diagonalDerecha = aleatorio.nextBoolean();
            boolean diagonalIzquierda = aleatorio.nextBoolean();

            for (int n = 0; n < palabra.length(); n++) {
                if (vertical && filaAleatoria + n < MAX_FILA){
                    matriz[filaAleatoria+n][columnaAleatoria] = palabra.charAt(n);

                } else if (horizontal && columnaAleatoria + n < MAX_COLUMNA) {
                    matriz[filaAleatoria][columnaAleatoria + n] = palabra.charAt(n);

                } else if (diagonalDerecha && (columnaAleatoria + n < MAX_COLUMNA && filaAleatoria + n < MAX_FILA)) {
                matriz[filaAleatoria + n][columnaAleatoria+n] = palabra.charAt(n);

                } else if (diagonalIzquierda && columnaAleatoria - n >= 0 && filaAleatoria + n < MAX_FILA) {
                    matriz[filaAleatoria + n][columnaAleatoria - n] = palabra.charAt(n);
                }

            }
        }
    }
    public static void main(String[] args) {
        rellenarMatriz();
        imprimirMatriz();
        colocarLetras();
        System.out.println();
        imprimirMatriz();
    }
}