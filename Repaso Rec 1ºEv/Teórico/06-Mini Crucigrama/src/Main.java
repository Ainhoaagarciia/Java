//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        char[][] cruci = {
                {'C', 'A', 'S', 'A', ' ', 'P', 'E', 'R', 'R', 'O'},
                {' ', ' ', 'G', 'A', 'T', 'O', ' ', ' ', ' ', ' '},
                {'S', 'O', 'L', ' ', 'L', 'U', 'N', 'A', ' ', ' '},
                {'M', 'A', 'R', ' ', ' ', 'V', 'I', 'D', 'A', ' '}
        };

        for (int i = 0; i < cruci.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < cruci[i].length; j++) {
                char c = cruci[i][j];

                if (c != ' ') {
                    sb.append(c);  // Acumula letras
                }

                // Si encontramos un espacio o estamos al final
                if (c == ' ' || j == cruci[i].length - 1) {
                    if (sb.length() > 0) {
                        System.out.println("Palabra encontrada: " + sb.toString());
                        sb.setLength(0); // Vaciar el StringBuilder
                    }
                }
            }
        }
    }
}