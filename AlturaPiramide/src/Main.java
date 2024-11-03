import java.util.Scanner;
//Le dices el nº de bloques y te dice cuántos niveles va a tener
public class Main {
    public static void main(String[] args) {
        System.out.println("Dime cuántos bloques quieres utilizar");
        Scanner leer = new Scanner(System.in);

        int bloquesUser = leer.nextInt(); //Inserta los bloques a utilizar, bloques disponibles
        int nivel = 1; //Nivel actual
        int bloquesAcumulados = 1; //Total de bloques usados hasta el momento, comenzando en 1, ya que el primer nivel usa 1 bloque.
        int dimensionBloques = 1; // Controla el tamaño del próximo nivel. Comienza en 1, que es el tamaño del primer nivel.

        while (bloquesUser > bloquesAcumulados) { //se ejecuta mientras bloquesAcumulados sea menor que los bloques disponibles.
            nivel = nivel + 1; //Sube de nivel
            dimensionBloques= dimensionBloques + 2; //Aumenta el lado del cuadrado de bloques para el siguiente nivel, añadiendo 2 filas y 2 columnas
            bloquesAcumulados = bloquesAcumulados + (dimensionBloques*dimensionBloques); //Fila*columna (lo anterior)+1 (el de arriba)
            /* incrementa bloquesAcumulados sumando los bloques necesarios para el siguiente nivel, que es el cuadrado del nuevo multBloques.
            Ej) Si el usuario ingresa bloquesUser = 9:
            Nivel 1: se requiere 1 × 1 = 1 bloque. Total: 1 bloque.
            Nivel 2: se requiere 3×3=9 bloques. Total acumulado: 10 bloques.
            Como bloquesAcumulados (10) es > que bloquesUser (9), el bucle se detiene y se imprime el nivel alcanzado.*/
        }
        System.out.println("Tu pirámide tendrá "+nivel+" niveles");
    }
}
