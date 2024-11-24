import java.util.Random;
import java.util.Scanner;

public class Memoriza_DobleTablero {
    public static final int MAX_FILA = 4;
    public static final int MAX_COLUMNA = 4;
    public static final int [][]tablero= new int[MAX_FILA][MAX_COLUMNA];
    public static final int [][]tableroOculto = new int[MAX_FILA][MAX_COLUMNA];
    public static Random aleatorio= new Random();
    public static int filaAleatoria,columnaAleatoria;
    
    public static void rellenarTablero1(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                tablero[i][j]=0;
            }
        }
    }
    public static void asignarParejas(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 2; j++) {
                filaAleatoria=0;
                columnaAleatoria=0;
                do {
                    filaAleatoria= aleatorio.nextInt(MAX_FILA);
                    columnaAleatoria=aleatorio.nextInt(MAX_COLUMNA);
                }while (tablero[filaAleatoria][columnaAleatoria]!=0);
                tablero[filaAleatoria][columnaAleatoria]=i;
            }
        }
    }
    public static void imprimirTablero(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    public static void rellenarTableroOculto(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                tableroOculto[i][j]=0;
            }
        }
    }
    public static void imprimirTableroOculto(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print(tableroOculto[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        rellenarTablero1();
        asignarParejas();
        imprimirTablero();
        rellenarTableroOculto();
        System.out.println();
        imprimirTableroOculto();
        Scanner lector= new Scanner(System.in);
        int intentos=10;
        do {
            System.out.println("Dime una fila");
            int fila1Usuario= lector.nextInt();
            System.out.println("Dime una columna");
            int columna1Usuario= lector.nextInt();
            System.out.println("Dime una fila");
            int fila2Usuario= lector.nextInt();
            System.out.println("Dime una columna");
            int columna2Usuario=lector.nextInt();
            if (tablero[fila1Usuario][columna1Usuario]== tablero[fila2Usuario][columna2Usuario]){
                for (int i = 0; i < MAX_FILA; i++) {
                    for (int j = 0; j < MAX_COLUMNA; j++) {
                        if ((tablero[fila1Usuario][columna1Usuario]==tablero[i][j]) && (tablero[fila2Usuario][columna2Usuario]==tablero[i][j])){
                            tableroOculto[fila1Usuario][columna1Usuario]=tablero[i][j];
                            tableroOculto[fila2Usuario][columna2Usuario]=tablero[i][j];
                        }
                    }
                }
                tablero[fila1Usuario][columna1Usuario]=0;
                tablero[fila2Usuario][columna2Usuario]=0;
                System.out.println("Pareja encontrada");
                imprimirTableroOculto();
            }else {
                System.out.println("Pareja no encontrada, vuelva a intentarlo"+", te quedan "+intentos+"intentos");
                intentos--;
            }
        }while (intentos>0);
        System.out.println("Has Perdido!!");
    }    
}