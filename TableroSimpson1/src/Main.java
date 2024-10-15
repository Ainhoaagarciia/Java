import java.util.Random;

public class Main {
    private static final int MAX_FILA_TABLERO=10;
    private static final int MAX_COLUMNA_TABLERO=10;
    private static char [][] tablero;

    public static void main(String[] args) {
        //1º Inicializo mi matriz tablero
        tablero= new char [MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
        //Tenemos las celdas pero sin valores
        //2º Rellenar el tablero 'L'
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                //[0,0],[0,1]...
                tablero[i][j]= 'L';
            }
        }
        //3º Imprimir tablero
        imprimirTablero();

        //4º Asignar a Bart
        Random aleatorio = new Random();
        int filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO); //Generará nº aleatorios de 0-9
        int columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);

        tablero[filaAleatorio][columnaAleatorio] = 'B';

        //5º Imprimir tablero
        imprimirTablero();
        //6º Repartir 10 Homer dentro del tablero
        int filaAleatorioHomer;
        int columnaAleatorioHomer;
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            do {
                filaAleatorioHomer = aleatorio.nextInt(MAX_FILA_TABLERO); //Generará nº aleatorios de 0-9
                columnaAleatorioHomer = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            }while (tablero[filaAleatorioHomer][columnaAleatorioHomer]!='L');
            //Cuando tablero[filaAleatorioHomer][columnaAleatorioHomer]!='L'
            tablero[filaAleatorioHomer][columnaAleatorioHomer] = 'H';
        }
        //7º Imprimir tablero, Colocar Muros
        imprimirTablero();
        int filaAleatorioMuro;
        int columnaAleatorioMuro;
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            do {
                filaAleatorioMuro = aleatorio.nextInt(MAX_FILA_TABLERO); //Generará nº aleatorios de 0-9
                columnaAleatorioMuro = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            }while (tablero[filaAleatorioMuro][columnaAleatorioMuro]!='L');
            //Cuando tablero[filaAleatorioMuro][columnaAleatorioMuro]!='L'
            tablero[filaAleatorioMuro][columnaAleatorioMuro] = 'M';
        }
        imprimirTablero();
        tablero[MAX_FILA_TABLERO-1][MAX_COLUMNA_TABLERO-1] = 'F'; //Casilla final
        imprimirTablero();
    }

    private static void imprimirTablero (){
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                //[0,0],[0,1]...
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println(""); //Al cambiar de fila saltará
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}