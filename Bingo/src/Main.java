import java.util.Random;

public class Main {
    private static final int MAX_FILA_TABLERO=3;
    private static final int MAX_COLUMNA_TABLERO=9;
    public static int [][] tablero;
    private static void imprimirTablero() {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
       tablero= new int[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
       Random aleatorio = new Random();

       //Rellenar tablero dentro de los rangos de cada columna
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
        //Imprimimos tablero sin ordenar
        imprimirTablero();
        //Ordenamos las casillas de menor a mayor en cada columna
        for (int columna = 0; columna < MAX_COLUMNA_TABLERO; columna++) { //Recorre las columnas del tablero
            for (int i = 0; i < MAX_FILA_TABLERO-1; i++) { //Recorre cada fila, es -1 porque va a tener que comparar 2 filas, no habrá una 3ra para comparar
                for (int j = 0; j < MAX_FILA_TABLERO -i -1; j++) { //Compara dos filas dentro de la columna, es -i -1 porque conforme i aumenta, nº de filas a comparar disminuye.
                    if (tablero[j][columna] > tablero[j+1][columna]){ //Si el valor en la fila j es mayor que el de la fila siguiente (j + 1), deben intercambiarse.
                        int aux= tablero[j][columna]; //Guardamos el valor de la fila actual en la variable auxiliar
                        tablero[j][columna]= tablero[j+1][columna];//Se almacena en esa fila el valor de la fila siguiente
                        tablero[j+1][columna]= aux; //Asignamos el valor de aux de antes al valor que acabamos de recibir, es decir, pasa a la columna siguiente a la inicial
                        //Ejemplo: Columna 0
                        // [18]
                        // [12]
                        // [14]
                        // j=0 (PRIMERA COMPARACIÓN) aux=18   tablero[0][0]= 12  tablero[1][0]= aux= 18
                        // [12]
                        // [18]
                        // [14]
                        //j=1 (SEGUNDA COMPARACIÓN) aux=18   tablero[0][0]= 14  tablero[1][0]= aux= 18
                        // [12]
                        // [14]
                        // [18]
                    }
                }
            }
        }
        //Imprimir tablero ordenado
        System.out.println(" ");
        System.out.println("Tablero ordenado por columnas:");
        imprimirTablero();
    }
}