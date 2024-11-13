
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_FILA_TABLERO1 = 10;
    private static final int MAX_COLUMNA_TABLERO1 = 10;
    private static final int MAX_FILA_TABLERO2 = 10;
    private static final int MAX_COLUMNA_TABLERO2 = 10;
    private static char[][] tablero1;
    private static char[][] tablero2;
    private static int filaYoda;
    private static int columnaYoda;
    private static int filaVader;
    private static int columnaVader;
    private static final Random aleatorio=new Random();
    private static int filaAleatoria=-1;
    private static int columnaAleatoria=-1;

    private static void rellenarTablero1() {
        tablero1 = new char[MAX_FILA_TABLERO1][MAX_COLUMNA_TABLERO1];
        for (int i = 0; i < MAX_FILA_TABLERO1; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO1; j++) {
                tablero1[i][j] = 'L';
            }
        }
    }

    private static void rellenarTablero2() {
        tablero2 = new char[MAX_FILA_TABLERO2][MAX_COLUMNA_TABLERO2];
        for (int i = 0; i < MAX_FILA_TABLERO2; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO2; j++) {
                tablero2[i][j] = 'L';
            }
        }
    }

    private static void colocarpersonajes1(char personaje, int numRepeticiones) {
        for (int i = 0; i < numRepeticiones; i++) {
            do {
                filaAleatoria = aleatorio.nextInt(MAX_FILA_TABLERO1);
                columnaAleatoria = aleatorio.nextInt(MAX_COLUMNA_TABLERO1);
            } while (tablero1[filaAleatoria][columnaAleatoria] != 'L');
            tablero1[filaAleatoria][columnaAleatoria] = personaje;
        }
        if (personaje == 'Y') {
            filaYoda=filaAleatoria;
            columnaYoda = columnaAleatoria;
        }
    }

    private static void colocarpersonajes2(char personaje, int numRepeticiones) {
        for (int i = 0; i < numRepeticiones; i++) {
            do {
                filaAleatoria = aleatorio.nextInt(MAX_FILA_TABLERO2);
                columnaAleatoria = aleatorio.nextInt(MAX_COLUMNA_TABLERO2);
            } while (tablero2[filaAleatoria][columnaAleatoria] != 'L');
            tablero2[filaAleatoria][columnaAleatoria] = personaje;
        }
        if (personaje == 'V') {
            filaVader = filaAleatoria;
            columnaVader = columnaAleatoria;
        }
    }

    private static void imprimirTablero1() {
        for (int i = 0; i < MAX_FILA_TABLERO1; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO1; j++) {
                System.out.print(tablero1[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private static void imprimirTablero2() {
        for (int i = 0; i < MAX_FILA_TABLERO2; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO2; j++) {
                System.out.print(tablero2[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        //Rellenar tablero 1 casillas libres
        rellenarTablero1();
        //Rellenar tablero 2 casillas libres
        rellenarTablero2();
        //Colocamos a los personajes en cada tablero
        colocarpersonajes1('Y', 1);
        colocarpersonajes2('V', 1);
        colocarpersonajes1('D', 5);
        colocarpersonajes2('R', 5);
        colocarpersonajes1('M', 5);
        colocarpersonajes2('M', 5);
        colocarpersonajes1('P',5);
        colocarpersonajes2('P',5);
        //Colocar casillas finales
        tablero1[MAX_FILA_TABLERO1 - 1][MAX_COLUMNA_TABLERO1 - 1] = 'F';
        tablero2[MAX_FILA_TABLERO2 - 1][MAX_COLUMNA_TABLERO2 - 1] = 'F';
        //Inicio
        System.out.println("Tablero Jugador 1:");
        imprimirTablero1();
        System.out.println(" ");
        System.out.println("Tablero Jugador 2:");
        imprimirTablero2();
        //Juego
        int vidas = 3;
        Scanner lector = new Scanner(System.in);
        do {
            System.out.println("Dime el desplazamiento que quieres realizar");
            System.out.println("W: Arriba; A: Izquierda; S: Abajo; D: Derecha; Q:Diagonal derecha arriba; E: Diagonal izquierda arriba; R: Diagonal izquierda abajo; B: Diagonal derecha abajo");
            String movimiento = lector.nextLine();
            switch (movimiento) {
                case "W":
                    if ((filaYoda -1) >= 0) {
                        filaYoda--;
                        switch (tablero1[filaYoda][columnaYoda]) {
                            case 'L':
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                tablero1[filaYoda + 1][columnaYoda] = 'L';
                                break;
                            case 'M':
                                filaYoda++;
                                System.out.println("No puedes pasar");
                                break;
                            case 'D':
                                tablero1[filaYoda + 1][columnaYoda] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                vidas--;
                                break;
                            case 'F':
                                tablero1[filaYoda + 1][columnaYoda] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                System.out.println("Has ganado!!");
                                vidas=-1;
                                break;
                            case 'P':
                                tablero1[filaYoda + 1][columnaYoda]= 'L';
                                tablero1[filaYoda][columnaYoda]= 'Y';
                        }
                    } else {
                        System.out.println("Límites del tablero");
                    }
                    break;
                case "A":
                    if ((columnaYoda -1) >= 0) {
                        columnaYoda--;
                        switch (tablero1[filaYoda][columnaYoda]) {
                            case 'L':
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                tablero1[filaYoda][columnaYoda + 1] = 'L';
                                break;
                            case 'M':
                                columnaYoda++;
                                System.out.println("No puedes pasar");
                                break;
                            case 'D':
                                tablero1[filaYoda][columnaYoda + 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                vidas--;
                                break;
                            case 'F':
                                tablero1[filaYoda][columnaYoda + 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                System.out.println("Has ganado!!");
                                vidas=-1;
                                break;
                            case 'P':
                                tablero1[filaYoda][columnaYoda+1]= 'L';
                                tablero1[filaYoda][columnaYoda]= 'Y';
                        }
                    } else {
                        System.out.println("Límites del tablero");
                        break;
                    }
                case "S":
                    if ((filaYoda +1) >= 0) {
                        filaYoda++;
                        switch (tablero1[filaYoda][columnaYoda]) {
                            case 'L':
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                tablero1[filaYoda - 1][columnaYoda] = 'L';
                                break;
                            case 'M':
                                filaYoda++;
                                System.out.println("No puedes pasar");
                                break;
                            case 'D':
                                tablero1[filaYoda - 1][columnaYoda] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                vidas--;
                                break;
                            case 'F':
                                tablero1[filaYoda - 1][columnaYoda] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                System.out.println("Has ganado!!");
                                vidas=-1;
                                break;
                            case 'P':
                                tablero1[filaYoda - 1][columnaYoda]= 'L';
                                tablero1[filaYoda][columnaYoda]= 'Y';
                        }
                    } else {
                        System.out.println("Límites del tablero");
                    }
                    break;
                case "D":
                    if ((columnaYoda +1) >= 0) {
                        columnaYoda++;
                        switch (tablero1[filaYoda][columnaYoda]) {
                            case 'L':
                                tablero1[filaYoda][columnaYoda - 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                break;
                            case 'M':
                                columnaYoda--;
                                System.out.println("No puedes pasar");
                                break;
                            case 'D':
                                tablero1[filaYoda][columnaYoda - 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                vidas--;
                                break;
                            case 'F':
                                tablero1[filaYoda][columnaYoda - 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                System.out.println("Has ganado!!");
                                vidas=-1;
                                break;
                            case 'P':
                                tablero1[filaYoda][columnaYoda-1]= 'L';
                                tablero1[filaYoda][columnaYoda]= 'Y';
                        }
                    } else {
                        System.out.println("Límites del tablero");
                        break;
                    }
                case "Q":
                    if ((filaYoda -1) >=0 && (columnaYoda -1) >= 0) {
                        filaYoda--;
                        columnaYoda--;
                        switch (tablero1[filaYoda][columnaYoda]) {
                            case 'L':
                                tablero1[filaYoda + 1][columnaYoda + 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                break;
                            case 'M':
                                filaYoda++;
                                columnaYoda++;
                                System.out.println("No puedes pasar");
                                break;
                            case 'D':
                                tablero1[filaYoda + 1][columnaYoda + 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                vidas--;
                                break;
                            case 'F':
                                tablero1[filaYoda + 1][columnaYoda + 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                System.out.println("Has ganado!!");
                                vidas=-1;
                                break;
                            case 'P':
                                tablero1[filaYoda + 1][columnaYoda+1]= 'L';
                                tablero1[filaYoda][columnaYoda]= 'Y';
                        }
                    } else {
                        System.out.println("Límites del tablero");
                        break;
                    }
                case "E":
                    if ((filaYoda-1) >=0 && (columnaYoda+1) >= 0) {
                        filaYoda--;
                        columnaYoda++;
                        switch (tablero1[filaYoda][columnaYoda]) {
                            case 'L':
                                tablero1[filaYoda + 1][columnaYoda - 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                break;
                            case 'M':
                                tablero1[filaYoda + 1][columnaYoda - 1] = 'Y';
                                tablero1[filaYoda][columnaYoda] = 'M';
                                break;
                            case 'D':
                                tablero1[filaYoda + 1][columnaYoda - 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                vidas--;
                                break;
                            case 'F':
                                tablero1[filaYoda + 1][columnaYoda - 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                System.out.println("Has ganado!!");
                                vidas=-1;
                                break;
                            case 'P':
                                tablero1[filaYoda + 1][columnaYoda-1]= 'L';
                                tablero1[filaYoda][columnaYoda]= 'Y';
                        }
                    } else {
                        System.out.println("Límites del tablero");
                        break;
                    }
                case "R":
                    if ((filaYoda+1) >=0 && (columnaYoda-1) >= 0) {
                        filaYoda++;
                        columnaYoda--;
                        switch (tablero1[filaYoda][columnaYoda]) {
                            case 'L':
                                tablero1[filaYoda - 1][columnaYoda + 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                break;
                            case 'M':
                                tablero1[filaYoda - 1][columnaYoda + 1] = 'Y';
                                tablero1[filaYoda][columnaYoda] = 'M';
                                break;
                            case 'D':
                                tablero1[filaYoda - 1][columnaYoda + 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                vidas--;
                                break;
                            case 'F':
                                tablero1[filaYoda - 1][columnaYoda + 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                System.out.println("Has ganado!!");
                                vidas=-1;
                                break;
                            case 'P':
                                tablero1[filaYoda - 1][columnaYoda +1]= 'L';
                                tablero1[filaYoda][columnaYoda]= 'Y';
                        }
                    } else {
                        System.out.println("Límites del tablero");
                        break;
                    }
                case "B":
                    if ((filaYoda+1) >=0 && (columnaYoda+1) >= 0) {
                        filaYoda++;
                        columnaYoda++;
                        switch (tablero1[filaYoda][columnaYoda]) {
                            case 'L':
                                tablero1[filaYoda - 1][columnaYoda - 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                break;
                            case 'M':
                                tablero1[filaYoda - 1][columnaYoda - 1] = 'Y';
                                tablero1[filaYoda][columnaYoda] = 'M';
                                break;
                            case 'D':
                                tablero1[filaYoda - 1][columnaYoda - 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                vidas--;
                                System.out.println("Te quedan "+vidas+"vidas");
                                break;
                            case 'F':
                                tablero1[filaYoda - 1][columnaYoda - 1] = 'L';
                                tablero1[filaYoda][columnaYoda] = 'Y';
                                System.out.println("Has ganado!!");
                                vidas=-1;
                                break;
                        }
                    } else {
                        System.out.println("Límites del tablero");
                        break;
                    }
                default:
                    break;
            }
            imprimirTablero1();
        }while (vidas > 0) ;

        if (vidas==-0) {
            System.out.println("Has Perdido!!");
        } else if (vidas==-1) {
            System.out.println("Has ganado!!");
        }
    }
}