import java.util.Scanner;

public class Main {
    private static final Scanner lector= new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("¿Cuántos casos de prueba quieres?");
        int casosPrueba= lector.nextInt();

        for (int i = 0; i < casosPrueba; i++) {
            System.out.println("Dime los huevos que quieres cocer");
            int huevos= lector.nextInt();
            System.out.println("Dime la capacidad en huevos de la olla");

            int capacidadHuevosOlla= lector.nextInt();
            if ((1<huevos&& huevos<=10000) && (1<capacidadHuevosOlla  && capacidadHuevosOlla<=1000)){
                int numCiclos= (huevos+capacidadHuevosOlla-1)/capacidadHuevosOlla;
                int minutosCoccion= numCiclos*10;
                System.out.println("Los minutos de coccion son: "+ minutosCoccion);

            }else if (huevos<=0 || capacidadHuevosOlla<=0){
                System.out.println("Valor no válido");
                break;
            }

        }
    }
}