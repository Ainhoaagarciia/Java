import java.util.Scanner;

public class Main {
    private static final int MAX_FILA = 3;
    private static final int MAX_COLUMNA = 3;

    private static final int [][] matriz = new int[MAX_FILA][MAX_COLUMNA];

    private static void pedirNumeros(){
        Scanner lector = new Scanner(System.in);
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                int num;
                do {
                    System.out.println("Numero para [" + i + "][" + j + "]: ");
                    num = lector.nextInt();
                }while (num < 1 || num > 9);
                matriz[i][j] = num;
            }
        }
        lector.close();
    }

    private static void verificarMagico(){
        int objetivo = matriz[0][0] + matriz[0][1] + matriz[0][2]; // La suma que deben tener todas las filas
        boolean esMagico = true;

        //Verificar Filas
        for (int i = 0; i < MAX_FILA; i++) {
            int sumaFila = matriz[i][0] + matriz[i][1] + matriz[i][2];
            if (sumaFila != objetivo) {
                esMagico = false;
                break;
            }
        }
        //Verificar Columnas
        for (int j = 0; j < MAX_COLUMNA; j++) {
            int sumaColumna = matriz[0][j] + matriz[1][j] + matriz[2][j];
            if (sumaColumna != objetivo) {
                esMagico = false;
                break;
            }
        }
        //Verificar Diagonales
        int diagDcha = matriz[0][0] + matriz[1][1] + matriz[2][2];
        int diagIzq = matriz[0][2] + matriz[1][1] + matriz[2][0];
        if (diagDcha != objetivo || diagIzq != objetivo) {
            esMagico = false;
        }

        if (esMagico){
            System.out.println("Es un cuadrado mágico! ");
        }else {
            System.out.println("No es mágico :(");
        }
    }

    private static void imprimirMatriz(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print(matriz[i][j] + " \t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pedirNumeros();
        imprimirMatriz();
        verificarMagico();   //2,7,6,9,5,1,4,3,8 es magico
    }
}
