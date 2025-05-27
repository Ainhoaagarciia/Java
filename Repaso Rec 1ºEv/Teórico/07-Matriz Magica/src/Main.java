import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] m = new int[3][3];

        System.out.println("Introduce 9 números del 1 al 9:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num;
                do {
                    System.out.print("Número [" + i + "][" + j + "]: ");
                    num = scanner.nextInt();
                } while (num < 1 || num > 9);
                m[i][j] = num;
            }
        }

        // Calcular la suma objetivo (suma de la primera fila)
        int objetivo = m[0][0] + m[0][1] + m[0][2];

        boolean esMagico = true;

        // Verificar filas
        for (int i = 0; i < 3; i++) {
            int sumaFila = m[i][0] + m[i][1] + m[i][2];
            if (sumaFila != objetivo) {
                esMagico = false;
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            int sumaColumna = m[0][j] + m[1][j] + m[2][j];
            if (sumaColumna != objetivo) {
                esMagico = false;
            }
        }

        // Verificar diagonales
        int diag1 = m[0][0] + m[1][1] + m[2][2];
        int diag2 = m[0][2] + m[1][1] + m[2][0];

        if (diag1 != objetivo || diag2 != objetivo) {
            esMagico = false;
        }

        // Mostrar resultado
        if (esMagico) {
            System.out.println("¡Es un cuadrado mágico!");
        } else {
            System.out.println("No es mágico.");
        }

        scanner.close();
    }
}