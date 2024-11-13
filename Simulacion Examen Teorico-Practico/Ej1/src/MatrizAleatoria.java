import java.util.Random;

public class MatrizAleatoria {
    private static final int row=3;
    private static final int col=9;
    private static final int [][] matriz= new int [row][col];
    private static final Random random= new Random();
    private static void rellenarMatriz(){
        for (int col = 0; col < matriz[0].length; col++) {
            int min = 10 + (col * 10); // valor mínimo para la columna actual
            int max = min + 9;     	// valor máximo para la columna actual

            for (int row = 0; row < matriz.length; row++) {
                matriz[row][col] = random.nextInt(max - min + 1) + min;
            }
        }
    }
    private static void ordenarMatriz(){
        int cont=0;
        do {
            for (int row = 0; row < matriz.length -1; row++) { //Límites, va hasta filas -2 (por ir comparando)
                for (int col = 0; col < matriz[0].length; col++) { //Va hasta columnas -1
                    if (matriz[row][col] > matriz[row + 1][col]) {
                        int aux;
                        aux = matriz[row][col];
                        matriz[row][col] = matriz[row + 1][col];
                        matriz[row + 1][col] = aux;
                    }
                }
            }
            cont++;
        }while (cont < row); //Se repetirá el nº de columnas que haya
    }
    private static void imprimirMatriz(){
        for (int row = 0; row < matriz.length; row++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.print(matriz[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Llenar la matriz de acuerdo al rango en cada columna
        rellenarMatriz();
        ordenarMatriz();
        // Imprimir la matriz
        imprimirMatriz();
    }
}
