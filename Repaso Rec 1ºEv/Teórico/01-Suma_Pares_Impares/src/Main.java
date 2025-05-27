import java.util.Random;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int [] array = new int[10];
    private static int sumaPares = 0;
    private static int sumaImpares= 0;

    public static void main(String[] args) {
        Random aleatorio = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = aleatorio.nextInt(100);
            System.out.print(array[i] + " ") ;
            if (array[i] % 2 == 0){
                sumaPares++;
            }else {
                sumaImpares++;
            }
        }
        System.out.println();
        System.out.println("SumaPares: " + sumaPares);
        System.out.println("SumaImpares: " + sumaImpares);

    }
}