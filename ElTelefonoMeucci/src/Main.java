import java.util.Scanner;

public class Main {
    private static final Scanner lector= new Scanner(System.in);
    private static final String [] símbolos ={"X","I","II","III","IV","V","VI","VII","VIII","IX"};
    public static int formasInterpretar(String telefono, String[] símbolos) {
        int contador = 0;
        for (int i = 0; i < telefono.length(); i++) {
            // Buscamos subcadenas de longitud 1, 2 y 3 que sean números romanos válidos
            for (int len = 1; len <= 3; len++) {
                // Si la subcadena es válida, la contamos como una forma
                if (i + len <= telefono.length()) {
                    String subcadena = telefono.substring(i, i + len);
                    if (esRomano(subcadena, símbolos)) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }
    public static boolean esRomano(String subcadena, String[] símbolos) {
        for (String romano : símbolos) {
            if (romano.equals(subcadena)) {
                return true;  // Si la subcadena es válida, devolvemos true
            }
        }
        return false;  // Si no encontramos coincidencia, devolvemos false
    }

    public static void main(String[] args) {
        System.out.println("¿Cuántos casos de prueba quieres?");
        int casosPrueba = lector.nextInt();
        lector.nextLine();

        for (int cont = 1; cont <= casosPrueba; cont++) {
            System.out.println("Dime un nº de teléfono");
            String telefono = lector.nextLine();
            System.out.println(formasInterpretar(telefono, símbolos));
        }
    }

}


