import java.util.Random;


public class Main {
    private static final int Max_Fila= 5;
    private static final int Max_Columna= 5;
    private static final int [][] matriz = new int[Max_Fila][Max_Columna];

    public static void rellenarMatriz(){
        Random aleatorio = new Random();
        for (int i = 0; i < Max_Fila; i++) {
            for (int j = 0; j < Max_Columna; j++) {
                matriz[i][j] = aleatorio.nextInt(50);
            }
        }
    }
    public static void imprimirMatriz(){
        for (int i = 0; i < Max_Fila; i++) {
            for (int j = 0; j < Max_Columna; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void ordenarFilas(){
        int cont = 0;
        do {
            for (int i = 0; i < Max_Fila; i++) {
                for (int j = 0; j < Max_Columna - 1; j++) {
                    if (matriz[i][j] > matriz[i][j+1]){
                        int aux = matriz[i][j];
                        matriz[i][j] = matriz[i][j+1];
                        matriz[i][j+1] = aux;
                    }
                }
            }
            cont++;
        }while (cont<Max_Columna);
    }
    public static void ordenarColumnas(){
        int cont = 0;
        do {
            for (int i = 0; i < Max_Fila - 1; i++) {
                for (int j = 0; j < Max_Columna; j++) {
                    if (matriz[i][j] > matriz[i+1][j]){
                        int aux = matriz[i][j];
                        matriz[i][j] = matriz[i+1][j];
                        matriz[i+1][j] = aux;
                    }
                }
            }
            cont++;
        }while (cont<Max_Columna);
    }

    public static void main(String[] args) {
        rellenarMatriz();
        imprimirMatriz();
        ordenarFilas();
        System.out.println();
        imprimirMatriz();
        System.out.println();
        ordenarColumnas();
        imprimirMatriz();

    }
}