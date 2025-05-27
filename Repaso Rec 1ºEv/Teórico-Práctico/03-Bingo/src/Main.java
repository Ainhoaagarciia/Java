import java.util.Random;

public class Main {
    private static final int MAX_FILA_TABLERO=3;
    private static final int MAX_COLUMNA_TABLERO=9;
    public static int [][] tablero = new int[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
    private static void imprimirTablero() {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    private static void rellenarTablero() {    //Dentro de los rangos de cada columna
        Random aleatorio= new Random();
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                int min= 10+(j*10); //Rango mínimo de la columna, si j es 0 (1ºa columna), su min será 10
                int max= min+9; //Rango máximo de la columna, si j es 0, su máx será 10+9=19
                tablero[i][j]= aleatorio.nextInt(max-min+1)+min;
                //Nº aleatorio entre 0 y max - min, para la 1ºa columna 19-10+1=10. Nº de 0 a 9.
                //Pero al añadirle el min, empezará desde donde corresponda, en este caso 10 y no desde 0.
                //Quedaría así tablero[i][j] = aleatorio.nextInt(10) + 10, al generar el 0 le sumará los 10.
            }
        }
    }
    private static void ordenarTablero() {  //De menor a mayor
        int cont=0;
        do {
            for (int i = 0; i < MAX_FILA_TABLERO -1; i++) { //Límites, va hasta filas -2 (por ir comparando)
                for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) { //Va hasta columnas -1
                    if (tablero[i][j] > tablero[i + 1][j]) {
                        int aux;
                        aux = tablero[i][j];
                        tablero[i][j] = tablero[i + 1][j];
                        tablero[i + 1][j] = aux;
                    }
                }
            }
            cont++;
        }while (cont < MAX_FILA_TABLERO); //Se repetirá el nº de filas que haya
    }
    public static void main(String[] args) {
        rellenarTablero();
        imprimirTablero();
        ordenarTablero();
        System.out.println(" ");
        System.out.println("Tablero ordenado por columnas: ");
        imprimirTablero();
    }
}