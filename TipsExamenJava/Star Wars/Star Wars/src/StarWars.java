import java.util.Random;
import java.util.Scanner;

public class StarWars {
    // static int movimiento[][] = {{-1, 0}, {0, -1},{ 1, 0}, {0, 1}};
    // static int movimiento1[][] = new int[4][2];
    // A
    // filaB = filaB + movimiento[1][0];
    // columnaB = columnaB + movimiento[1][1];

    //

    static int vidas = 5;
    // ATRIBUTOS "GLOBALES"
    // CONSTANTE
    static final char HOMER = 'H';
    static final char BART = 'B';
    static final char MURO = 'M';
    static final char POCIMA = 'P';
    static final char LIBRE = 'L';
    static final char FINAL = 'F';
    // FIN
    static char tablero[][] = new char[10][10];
    static Random aleatorio = new Random();
    static Scanner leer = new Scanner(System.in);

    static int filaB;
    static int columnaB;

    // PROCEDIMIENTOS/FUNCIONES
    private static boolean comprobarEnemigo(int fila, int columna) {
        filaB =filaB +fila;
        columnaB= columnaB +columnaB;
        fila=filaB;
        columna=columnaB;
        boolean isEnemigo = false;
        switch (tablero[fila][columna]){
            case HOMER :
                vidas = vidas - 1;
                // vidas--;
                // vidas -=1;
                System.out.println("Te he quitado una vida");
                tablero[filaB][columnaB] = LIBRE;
                filaB = fila;
                columnaB = columna;
                tablero[filaB][columnaB] = BART;
                isEnemigo = true;
                break;
            case MURO:
                System.out.println("No puedes desplazarte.");
                isEnemigo = true;
                break;
            case POCIMA:
                vidas++; // Siempre que sea menor que 5
                System.out.println("Dime en qué año empezó la segunda guerra mundial");
                System.out.println("Todo lo que se le ocurra a Alberto. ");
                tablero[filaB][columnaB] = LIBRE;
                filaB = fila;
                columnaB = columna;
                tablero[filaB][columnaB] = BART;
                isEnemigo = true;
                break;
            case FINAL:
                System.out.println("Has ganado!!, eres un crack!!");
                tablero[filaB][columnaB] = LIBRE;
                filaB = fila;
                columnaB = columna;
                tablero[filaB][columnaB] = BART;
                isEnemigo = true;
                break;
        }
        return isEnemigo;

    }
    private static boolean comprobarLimites(int desplazamiento, int desplazamiento1) {
        if(desplazamiento<0 || desplazamiento>9 || desplazamiento1<0 || desplazamiento1>9 ){
            return false;
        }
        return true;
    }
    private static void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
    }
    private static void rellenarMatrizM(char muro) {
        int fila;
        int columna;
        for (int i = 0; i < 10 ; i++) {
            do {
                fila = aleatorio.nextInt(10);
                columna = aleatorio.nextInt(10);
            } while (tablero[fila][columna] != LIBRE);
            tablero[fila][columna] = MURO;
        }
    }
    private static void rellenarMatrizB(char bart) {
        // CANDIDATO
        int fila;
        int columna;
        do{
            fila = aleatorio.nextInt(10);
            columna = aleatorio.nextInt(10);
        }while(fila==9 && columna==9);
        filaB = fila;
        columnaB = columna;
        tablero[fila][columna] = BART;
    }
    private static void rellenarMatrizH(char homer) {
        int fila;
        int columna;
        for (int i = 0; i < 10 ; i++) {
            do{
                fila = aleatorio.nextInt(10);
                columna = aleatorio.nextInt(10);
            }while(tablero[fila][columna]!=LIBRE);
            tablero[fila][columna] = HOMER;
        }
    }
    private static void rellenarMatrizL(char libre) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = LIBRE;
            }
        }
    }


    private static int dameCoordMov(char mov){
        for (int i = 0; i < movimientos.length; i++) {
            if (mov == letras[i]){
                return i;
            }
        }
        return -1;
    }
    

    /*
            //
            movimientos[0][0] = 0;
            movimientos[0][1] = 1;

            movimientos[1][0] = 0;
            movimientos[1][1] = -1;

            movimientos[2][0] = 1;
            movimientos[2][1] = 0;

            movimientos[3][0] = -1;
            movimientos[3][1] = 0;
            //

    */
/*
            int coor = dameCoordMov(movimiento.charAt(0));
            // (coor==-1)?System.out.println("Error"):;

*/
/*
            int filaCheck = movimientos[coor][0];
            int columnaCheck = movimientos[coor][1];
                resp = comprobarLimites(filaCheck,columnaCheck);
                if(resp==true){
                    System.out.println("Movimiento permitido");
                    boolean enemigo = comprobarEnemigo(filaCheck,columnaCheck);
                    if (!enemigo){
                        tablero[filaB][columnaB] = LIBRE;
                        filaB = filaB -1;
                        tablero[filaB][columnaB] = BART;
                    }
                }else{ // FALSE
                    System.out.println("Fuera de límites!!");
                }


*/
    static int movimientos[][] = new int[4][2];
    static char letras[] = {'W','A','S','D'};
    
    public static void main(String[] args) {
        movimientos[0][0]=-1;       //FILA
        movimientos[0][1]=0; //W    //COLUMNA

        movimientos[1][0]=0;
        movimientos[1][1]=-1; //A

        movimientos[2][0]=1;
        movimientos[2][1]=0; //S

        movimientos[3][0]=0;
        movimientos[3][1]=1; //D
        

        rellenarMatrizL(LIBRE);
        tablero[9][9] = FINAL;


        rellenarMatrizB(BART);
        rellenarMatrizH(HOMER);
        rellenarMatrizM(MURO);
        imprimirTablero();
        // PLAY
        do{
            System.out.println("Dime movimiento wasd!!");
            String movimiento = leer.next();
            int coordenadaMov= -1;
            for (int i = 0; i < letras.length; i++) {
                if (movimiento.charAt(0)==letras[i]){
                    coordenadaMov=i;
                    break;
                }
            }
            int filaCheck= movimientos[coordenadaMov][0];
            int columnaCheck= movimientos[coordenadaMov][1];
            boolean resp1 = comprobarLimites(filaCheck,columnaCheck);
            comprobarEnemigo(filaCheck,columnaCheck);

            boolean resp = false;
            switch (movimiento){
                case "w","W":
                    // LÍMITES
                    resp = comprobarLimites(filaB-1);
                    if(resp==true){
                        System.out.println("Movimiento permitido");
                        boolean enemigo = comprobarEnemigo(filaB-1, columnaB);
                        if (!enemigo){
                            tablero[filaB][columnaB] = LIBRE;
                            filaB = filaB -1;
                            tablero[filaB][columnaB] = BART;
                        }
                    }else{ // FALSE
                        System.out.println("Fuera de límites!!");
                    }
                    break;
                case "a","A":
                    resp = comprobarLimites(columnaB-1);
                    if(resp==true){
                        System.out.println("Movimiento permitido");
                        boolean enemigo = comprobarEnemigo(filaB, columnaB-1);
                        if (!enemigo){
                            tablero[filaB][columnaB] = LIBRE;
                            columnaB--;
                            tablero[filaB][columnaB] = BART;
                        }
                    }else{ // FALSE
                        System.out.println("Fuera de límites!!");
                    }
                    break;
                case "s","S":
                    resp = comprobarLimites(filaB+1);
                    if(resp==true){
                        System.out.println("Movimiento permitido");
                        boolean enemigo = comprobarEnemigo(filaB+1, columnaB);
                        if (!enemigo){
                            tablero[filaB][columnaB] = LIBRE;
                            filaB++;
                            tablero[filaB][columnaB] = BART;
                        }
                    }else{ // FALSE
                        System.out.println("Fuera de límites!!");
                    }
                    break;
                case "d","D":
                    resp = comprobarLimites(columnaB+1);
                    if(resp==true){
                        System.out.println("Movimiento permitido");
                        boolean enemigo = comprobarEnemigo(filaB, columnaB+1);
                        if (!enemigo){
                            tablero[filaB][columnaB] = LIBRE;
                            columnaB++;
                            tablero[filaB][columnaB] = BART;
                        }
                    }else{ // FALSE
                        System.out.println("Fuera de límites!!");
                    }
                    break;
            }
            imprimirTablero();
        }while(vidas> 0 && tablero[9][9]!=BART);
    }
}