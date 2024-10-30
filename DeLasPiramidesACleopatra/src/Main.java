import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Scanner lector = new Scanner(System.in);
        System.out.println("¿CUANTOS CASOS DE PRUEBA QUIERES? ");

        int NumeroCasosPrueba = leer.nextInt();
        System.out.println("Ingrese un número entre -10000 y 10000 ");

        for (int i = 0; i < NumeroCasosPrueba; i++) { // En cada iteración, se reciben tres enteros A, B, y C
            int A = leer.nextInt();
            int B = leer.nextInt();
            int C = leer.nextInt();
            do {
                int DistanciaA = Math.abs(B - A); // CALCULO LAS DISTANCIAS
                int DistanciaC = Math.abs(B - C);

                if (DistanciaC < DistanciaA) {
                    System.out.println("C está más cerca de: " + B);
                    System.out.println("DISTANCIA DE C:" + C);
                } else if (DistanciaA < DistanciaC) {
                    System.out.println("A está más cerca de: " + B);
                    System.out.println("DISTANCIA DE A:" + A);
                } else {
                    System.out.println("EMPATE");
                }
            }while (A < -10000 || A > 10000 || B < -10000 || B > 10000 || C < -10000 || C > 10000);
        }
    }
}