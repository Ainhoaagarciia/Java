import java.util.Random;

public class SopaLetras {
    static String palabras[]= {
            "helada",
            "mesa",
            "patata"
    };
    static char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static char sopaLetras [][] = new char [10][10];
    static char sopaLetrasCopia [][]= new char[10][10];
    static Random aleatorio= new Random();
    static void rellenarMatriz(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int numAleatorio= aleatorio.nextInt(26);
                sopaLetras[i][j]= letras[numAleatorio];
            }
        }
    }
    static void rellenarMatrizCopia(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sopaLetrasCopia[i][j]= '0';
            }
        }
    }
    public static void imprimirMatriz(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <10 ; j++) {
                System.out.print(sopaLetras[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void imprimirMatrizCopia(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <10 ; j++) {
                System.out.print(sopaLetrasCopia[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rellenarMatriz();
        rellenarMatrizCopia();
        imprimirMatriz();
        System.out.println();
        imprimirMatrizCopia();

        for (int i = 0; i < palabras.length; i++) {
            //¿CUÁNTAS PALABRAS HAY EN EL ARRAY?
            //1º) Buscar posición libre
            int filaAleatoria= 0;
            int columnaAleatoria=0;
            //1ª Casilla inicial libre
            do {
                filaAleatoria= aleatorio.nextInt(10);
                columnaAleatoria=aleatorio.nextInt(10);
            }while (sopaLetrasCopia[filaAleatoria][columnaAleatoria]!='0');
            //
            //2º) No superar límites
            //LÍMITE -> DCHA, columna
            if (columnaAleatoria + (palabras[i].length()-1)>10){ //5 + 5
                i--;
            } else {
                boolean isLibre=true;
                int max= columnaAleatoria + (palabras[i].length()-1); //5 + (6-1)=10
                for (int z=columnaAleatoria; z<=max; z++){ //z={5,6,7,8,9,10}
                    if (sopaLetrasCopia[filaAleatoria][z]!= '0'){
                        isLibre=false;
                        break;
                    }
                }
                if (isLibre){ //Puedo empezar a escribir!!
                    int contador=0;
                    for (int z = columnaAleatoria; z <=max ; z++) { //z={5,6,7,8,9,10}
                        sopaLetras[filaAleatoria][z]=palabras[i].charAt(contador); //"helada"
                        sopaLetrasCopia[filaAleatoria][z]=palabras[i].charAt(contador);
                        contador++;
                    }
                }
            }
        }
        System.out.println();
        imprimirMatriz();
        System.out.println();
        imprimirMatrizCopia();
    }
}