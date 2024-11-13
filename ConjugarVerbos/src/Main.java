import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String [] tiemposVerbales= {"A","P","F"};
    private static final Scanner lector= new Scanner(System.in);

    private static void generarConjugacionesAr(String verbo, String tiempo) {
        String raiz = verbo.substring(0, verbo.length() - 2);

        switch (tiempo) {
            case "A": // Presente
                System.out.println("yo " + raiz + "o");
                System.out.println("tú " + raiz + "as");
                System.out.println("él " + raiz + "a");
                System.out.println("nosotros " + raiz + "amos");
                System.out.println("vosotros " + raiz + "áis");
                System.out.println("ellos " + raiz + "an");
                break;
            case "P": // Pasado
                System.out.println("yo " + raiz + "é");
                System.out.println("tú " + raiz + "aste");
                System.out.println("él " + raiz + "ó");
                System.out.println("nosotros " + raiz + "amos");
                System.out.println("vosotros " + raiz + "asteis");
                System.out.println("ellos " + raiz + "aron");
                break;
            case "F": // Futuro
                System.out.println("yo " + raiz + "aré");
                System.out.println("tú " + raiz + "arás");
                System.out.println("él " + raiz + "ará");
                System.out.println("nosotros " + raiz + "aremos");
                System.out.println("vosotros " + raiz + "aréis");
                System.out.println("ellos " + raiz + "arán");
                break;
            default:
                System.out.println("Tiempo no válido.");
        }
    }
    private static void generarConjugacionesEr(String verbo, String tiempo) {
        String raiz = verbo.substring(0, verbo.length() - 2);

        switch (tiempo) {
            case "A": // Presente
                System.out.println("yo " + raiz + "o");
                System.out.println("tú " + raiz + "es");
                System.out.println("él " + raiz + "e");
                System.out.println("nosotros " + raiz + "emos");
                System.out.println("vosotros " + raiz + "éis");
                System.out.println("ellos " + raiz + "en");
                break;
            case "P": // Pasado
                System.out.println("yo " + raiz + "í");
                System.out.println("tú " + raiz + "iste");
                System.out.println("él " + raiz + "ió");
                System.out.println("nosotros " + raiz + "imos");
                System.out.println("vosotros " + raiz + "isteis");
                System.out.println("ellos " + raiz + "ieron");
                break;
            case "F": // Futuro
                System.out.println("yo " + raiz + "eré");
                System.out.println("tú " + raiz + "erás");
                System.out.println("él " + raiz + "erá");
                System.out.println("nosotros " + raiz + "eremos");
                System.out.println("vosotros " + raiz + "eréis");
                System.out.println("ellos " + raiz + "erán");
                break;
            default:
                System.out.println("Tiempo no válido.");
        }
    }
    private static void generarConjugacionesIr(String verbo, String tiempo) {
        String raiz = verbo.substring(0, verbo.length() - 2);

        switch (tiempo) {
            case "A": // Presente
                System.out.println("yo " + raiz + "o");
                System.out.println("tú " + raiz + "es");
                System.out.println("él " + raiz + "e");
                System.out.println("nosotros " + raiz + "imos");
                System.out.println("vosotros " + raiz + "ís");
                System.out.println("ellos " + raiz + "en");
                break;
            case "P": // Pasado
                System.out.println("yo " + raiz + "í");
                System.out.println("tú " + raiz + "iste");
                System.out.println("él " + raiz + "ió");
                System.out.println("nosotros " + raiz + "imos");
                System.out.println("vosotros " + raiz + "isteis");
                System.out.println("ellos " + raiz + "ieron");
                break;
            case "F": // Futuro
                System.out.println("yo " + raiz + "iré");
                System.out.println("tú " + raiz + "irás");
                System.out.println("él " + raiz + "irá");
                System.out.println("nosotros " + raiz + "iremos");
                System.out.println("vosotros " + raiz + "iréis");
                System.out.println("ellos " + raiz + "irán");
                break;
            default:
                System.out.println("Tiempo no válido.");
        }
    }

    public static void main(String[] args) {

        System.out.println("¿Cuántos casos de prueba quieres?");
        int casosPrueba= Integer.parseInt(lector.nextLine());

        for (int i = 0; i < casosPrueba; i++) {
            System.out.println("Dime un verbo para saber su conjugación:");

            String verboUsuario = lector.nextLine();
            System.out.println("Elige uno de estos tiempos verbales: ");
            System.out.println(Arrays.toString(tiemposVerbales));
            String tiempoUsuario = lector.nextLine();

            if (verboUsuario.endsWith("ar")) {
                generarConjugacionesAr(verboUsuario, tiempoUsuario);
            } else if (verboUsuario.endsWith("er")) {
                generarConjugacionesEr(verboUsuario, tiempoUsuario);
            } else if (verboUsuario.endsWith("ir")) {
                generarConjugacionesIr(verboUsuario, tiempoUsuario);
            } else {
                System.out.println("No es un verbo válido");
            }
        }
    }
}