import java.util.Random;
//array de 10 dimensiones con nº aleatorios
public class Main {
    static Random aleatorio= new Random(); //SDK= Fábrica de objetos
    public static int generarAleatorio(int semilla){
        int numAle= aleatorio.nextInt(semilla);
        return numAle;
    }
    public static void main(String[] args) {
        int [] arrayNumAleatorio= new int[10]; //Dimensión
        for (int i = 0; i < arrayNumAleatorio.length; i++) { //Llega hasta longitud del array
            arrayNumAleatorio[i]= generarAleatorio(10);
        }
        for (int i = 0; i < arrayNumAleatorio.length; i++) {
                System.out.print(arrayNumAleatorio[i] + " ");
        }
        System.out.println("");
    }
}