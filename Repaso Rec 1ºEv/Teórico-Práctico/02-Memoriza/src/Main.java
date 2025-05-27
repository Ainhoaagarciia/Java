import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] palabras = {"sol", "luna", "estrella", "cielo", "mar", "montaña", "río", "nube", "flor", "árbol"};
    private static String[] respuestas = new String[10];

    public static void main(String[] args) {

        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Palabra a memorizar: " + palabras[i]);
            respuestas[i] = palabras[i];

            System.out.print("Escribe todas las palabras memorizadas hasta ahora: ");
            String palabraUsuario = scanner.nextLine();

            // Verificar si la respuesta es correcta
            StringBuilder correctas = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                correctas.append(respuestas[j]).append(" ");
            }
            if (!palabraUsuario.equals(correctas.toString().trim())) {
                System.out.println("¡Incorrecto! La secuencia era: " + correctas.toString().trim());
                System.out.println("Intentalo de nuevo");
                i--;
            } else {
                System.out.println("¡Correcto! Sigue a la siguiente palabra.\n");
            }
        }
        System.out.println("¡Felicidades! Has memorizado todas las palabras correctamente.");
        scanner.close();
    }
}

