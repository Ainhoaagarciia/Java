import java.util.Random;
import java.util.Scanner;

public class TableroSimpson3 {

    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static char [][] tablero;
    private static int filaBart;
    private static int columnaBart;

    private static void imprimirTablero() {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                // [0,0],[0,1],[0,2],ETC.
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(); // Espacio entre tableros
        System.out.println();
        System.out.println();
    }
    private static void asignarLibreACasilla(char caracter){
        // Rellenar el tablero "L"
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                // [0,0],[0,1],[0,2]...
                tablero[i][j] = caracter;
            }
        }
    }

    private static void asignarPersonajesACasillaLibre (char caracter, int numRepeticiones) {
        // Asignar Personajes
        Random aleatorio = new Random();
        int filaAleatorio = -1;
        int columnaAleatorio = -1;
        for (int i = 0; i < numRepeticiones; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO); // Crea números aleatorios de 0 a 9
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO); // Crea números aleatorios de 0 a 9
            } while (tablero[filaAleatorio][columnaAleatorio] != 'L');
            tablero[filaAleatorio][columnaAleatorio] = caracter;
        }
        if (caracter=='B') {
            filaBart = filaAleatorio;
            columnaBart = columnaAleatorio;
        }
    }

    public static void main(String[] args) {

        // 1º) Inicializar mi matriz tablero
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

        // 2ª) Rellenar el tablero "L"
        asignarLibreACasilla('L');

        imprimirTablero();

        // 3º) Asignar a Bart
        asignarPersonajesACasillaLibre('B', 1);

        imprimirTablero();

        // 4º) Repartir 10 Homers dentro del tablero
        asignarPersonajesACasillaLibre('H', 10);

        imprimirTablero();

        // 5º) Repartir 10 Muros dentro del tablero
        asignarPersonajesACasillaLibre('M', 10);

        imprimirTablero();

        // 6º) Poner la celda final
        tablero[MAX_FILA_TABLERO-1][MAX_COLUMNA_TABLERO-1] = 'F';

        imprimirTablero();

        //7º Desplazamiento de Bart
            //A-->Izquierda
            //S-->Abajo
            //D-->Derecha
            //W-->Arriba
        Scanner lector= new Scanner(System.in); ////se crea un objeto de la clase Scanner llamado lector en este caso, permite leer la entrada del usuario desde la consola.
        //JUGAR
        int vidas=10;
        do {
            System.out.println("Dime el desplazamiento que quieres realizar");
            System.out.println("A-->Izquierda, S--> Abajo, D--> Derecha, W--> Arriba");
            String desplazamiento=lector.nextLine(); //para leer lo que el usuario escribe. El next.line captura lo que el usuario escribe, en este caso el caracter de movimiento, y lo almacenará en desplazamiento
            System.out.println("Desplazamiento=" + desplazamiento);
            //El valor que contiene desplazamiento es evaluado en un switch para determinar qué acción tomar. Dependiendo de si el usuario escribió "A", "S", "D", o "W", el programa decide la dirección en que se moverá Bart.
            switch (desplazamiento){ //Realizará el desplazamiento correspondiente en función de la letra que le digamos.
                case "A": //Izquierda
                    if ((columnaBart-1) >=0 ){ //Para que no se salga del tablero debe estar en un posición igual o mayor a 0, si es -1 por ejemplo se sale y nos iríamos al else
                        columnaBart=columnaBart-1; //Ya lo tenemos en la casilla 0,-1. Se sale del array
                        switch (tablero[filaBart][columnaBart]){ //Según la casilla con la que se encuentre:
                            case 'H':
                                vidas= vidas-1;
                                tablero[filaBart][columnaBart]='B'; //Se rellena la casilla a la que se haya movido con un B
                                tablero[filaBart][columnaBart+1]='L'; //Se rellena la casilla de la que venga con un L
                                System.out.println("Has perdido una vida. Te quedan "+vidas+" vidas");
                                break;
                            case 'M':
                                System.out.println("El muro no te deja desplazarte a esta casilla.");
                                columnaBart=columnaBart + 1; //Si se choca con un muro no puede avanzar así que avanza la casilla pero automáticamente la retrocede, se queda donde estaba
                                break;
                            case 'L':
                                tablero [filaBart][columnaBart] = 'B';
                                tablero [filaBart][columnaBart + 1] = 'L';
                                break;
                            case 'F':
                                tablero [filaBart][columnaBart] = 'B';
                                tablero [filaBart][columnaBart + 1] = 'L';
                                System.out.println("¡Has ganado!");
                                vidas = -1;
                                break;
                        }
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                case "S": //Abajo
                    if ((filaBart+1) >=0 ){
                        filaBart=filaBart+1; //Ya lo tenemos en la casilla 0,-1. Se sale del array
                        switch (tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas= vidas-1;
                                tablero[filaBart][columnaBart]='B';
                                tablero[filaBart-1][columnaBart]='L';
                                System.out.println("Has perdido una vida. Te quedan "+vidas+" vidas");
                                break;
                            case 'M':
                                System.out.println("El muro no te deja desplazarte a esta casilla.");
                                filaBart=filaBart - 1;
                                break;
                            case 'L':
                                tablero [filaBart][columnaBart] = 'B';
                                tablero [filaBart-1][columnaBart] = 'L';
                                break;
                            case 'F':
                                tablero [filaBart][columnaBart] = 'B';
                                tablero [filaBart-1][columnaBart] = 'L';
                                System.out.println("¡Has ganado!");
                                vidas = -1;
                                break;
                        }
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                case "D": //Derecha
                    if ((columnaBart+1) >=0 ){
                        columnaBart=columnaBart+1; //Ya lo tenemos en la casilla 0,-1. Se sale del array
                        switch (tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas= vidas-1;
                                tablero[filaBart][columnaBart]='B';
                                tablero[filaBart][columnaBart-1]='L';
                                System.out.println("Has perdido una vida. Te quedan "+vidas+" vidas");
                                break;
                            case 'M':
                                System.out.println("El muro no te deja desplazarte a esta casilla.");
                                columnaBart=columnaBart - 1;
                                break;
                            case 'L':
                                tablero [filaBart][columnaBart] = 'B';
                                tablero [filaBart][columnaBart - 1] = 'L';
                                break;
                            case 'F':
                                tablero [filaBart][columnaBart] = 'B';
                                tablero [filaBart][columnaBart - 1] = 'L';
                                System.out.println("¡Has ganado!");
                                vidas = -1;
                                break;
                        }
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                case "W":
                    if ((filaBart-1) >=0 ){
                        filaBart=filaBart-1; //Ya lo tenemos en la casilla 0,-1. Se sale del array
                        switch (tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas= vidas-1;
                                tablero[filaBart][columnaBart]='B';
                                tablero[filaBart+1][columnaBart]='L';
                                System.out.println("Has perdido una vida. Te quedan "+vidas+" vidas");
                                break;
                            case 'M':
                                System.out.println("El muro no te deja desplazarte a esta casilla.");
                                filaBart=filaBart + 1;
                                break;
                            case 'L':
                                tablero [filaBart][columnaBart] = 'B';
                                tablero [filaBart+1][columnaBart] = 'L';
                                break;
                            case 'F':
                                tablero [filaBart][columnaBart] = 'B';
                                tablero [filaBart+1][columnaBart] = 'L';
                                System.out.println("¡Has ganado!");
                                vidas = -1;
                                break;
                        }
                    } else {
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                default: //Si no se ingresa uno de los casos anteriores, por defecto el programa dejará de ejecutarse
                    break;
            }
            imprimirTablero();
            //
        } while (vidas>0);
        if (vidas == 0) {
            System.out.println("Te has quedado sin vidas. Has perdido.");
        } else if (vidas == -1) {
            System.out.println("¡Has ganado!");
        }
    }
}