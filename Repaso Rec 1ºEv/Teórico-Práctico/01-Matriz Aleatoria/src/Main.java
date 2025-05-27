import java.util.Random;

public class Main {
    private static int[][] matriz = new int[3][9];

    private static void llenarMatriz(){
        Random random = new Random();
        for (int col = 0; col < matriz[0].length; col++) {
            int min = 10 + (col * 10); // valor mínimo para la columna actual
            int max = min + 9;     	// valor máximo para la columna actual

            for (int row = 0; row < matriz.length; row++) {
                matriz[row][col] = random.nextInt(max - min + 1) + min;
            }
        }
    }
    private static void ordenarColumnas(){
        int cont = 0;
        do {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 9; j++) {
                    if (matriz[i][j] > matriz[i+1][j]){
                        int aux;
                        aux = matriz[i][j];
                        matriz[i][j] = matriz[i+1][j];
                        matriz[i+1][j] = aux;
                    }
                }
            }
            cont++;
        }while (cont<3);
    }
    private static void imprimir(){
        for (int row = 0; row < matriz.length; row++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.print(matriz[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        llenarMatriz();
        ordenarColumnas();
        imprimir();
    }
}