import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_FILA1=10;
    private static final int MAX_COLUMNA1=10;
    private static int [][] tablero1;
    private static final int MAX_FILA2=10;
    private static final int MAX_COLUMNA2=10;
    private static String [][] tablero2= new String[MAX_FILA2][MAX_COLUMNA2];
    private static int generarAleatorios(int bound){
        Random aleatorio= new Random();
        int numAlea=aleatorio.nextInt(bound);
        return numAlea;
    }
    private static void rellenarTableroAleatorios(){
        tablero1 = new int[MAX_FILA1][MAX_COLUMNA1];
        for (int i = 0; i < MAX_FILA1; i++) {
            for (int j = 0; j < MAX_COLUMNA1; j++) {
                tablero1[i][j]= (generarAleatorios(89)+10);
            }
        }
    }
    private static void rellenarTableroX(){
        for (int i = 0; i < MAX_FILA2; i++) {
            for (int j = 0; j < MAX_COLUMNA2; j++) {
                tablero2[i][j]="XX";
            }
        }
    }
    private static void imprimirTablero1(){
        for (int i = 0; i < MAX_FILA1; i++) {
            for (int j = 0; j < MAX_COLUMNA1; j++) {
                System.out.print(tablero1[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    private static void imprimirTablero2(){
        for (int i = 0; i < MAX_FILA2; i++) {
            for (int j = 0; j < MAX_COLUMNA2; j++) {
                System.out.print(tablero2[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        //Hacemos el primer tablero rellenado por numeros aleatorios
        rellenarTableroAleatorios();
        imprimirTablero1();
        System.out.println(" ");
        //Hacemos el segundo tablero rellenado por X
        rellenarTableroX();
        imprimirTablero2();
        //Pedimos 10 nº al usuario y comprobamos si están en el tablero mostrando su posición
        int cont=0;
        do {
            System.out.println("Dime un nº");
            Scanner lector= new Scanner(System.in);
            int numUsuario= lector.nextInt();
            for (int i = 0; i < MAX_FILA1; i++) {
                for (int j = 0; j < MAX_COLUMNA1; j++) {
                    if (tablero1[i][j]==numUsuario){
                        tablero2[i][j]= String.valueOf(numUsuario);
                        System.out.println("El nº está en esta posición");
                    }
                }
            }
            imprimirTablero2();
            cont++;
        } while (cont<10);
    }
}