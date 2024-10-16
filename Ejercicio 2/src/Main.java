//Matriz 10x10 nº aleatorios
import java.util.Random;
public class Main {
    static Random aleatorio= new Random(); //SDK= Fábrica de objetos
    public static int generarAleatorio(int semilla){
        int numAle= aleatorio.nextInt(semilla);
        return numAle;
    }
    public static void main(String[] args) {
        int [][] arrayNumAleatorio= new int[10][10]; //Dimensión
        for (int i = 0; i < arrayNumAleatorio.length; i++) { //Llega hasta longitud del array
            for (int j = 0; j < arrayNumAleatorio.length ; j++) {
                arrayNumAleatorio[i][j]= generarAleatorio(10);
            }
        }
        for (int i = 0; i < arrayNumAleatorio.length; i++) {
            for (int j = 0; j < arrayNumAleatorio.length; j++) {
                System.out.print(arrayNumAleatorio[i][j] + " ");
            }
            System.out.println("");
        }

        }
    }