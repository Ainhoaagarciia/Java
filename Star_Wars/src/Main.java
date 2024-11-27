import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_FILA=10;
    private static final int MAX_COLUMNA=10;
    private static final char [][] tablero1= new char[MAX_FILA][MAX_COLUMNA];
    private static final char [][] tablero2= new char[MAX_FILA][MAX_COLUMNA];
    private static final Random aleatorio= new Random();
    private static final Scanner lector= new Scanner(System.in);
    public static int filaAleatoria,columnaAleatoria,filaYoda,columnaYoda,filaVader,columnaVader,vidas1,vidas2;

    private static void rellenarTablero(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                tablero1[i][j]='L';
                tablero2[i][j]='L';
            }
        }
    }
    private static void imprimirTablero1(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print(tablero1[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    private static void imprimirTablero2(){
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print(tablero2[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    private static void asignarPersonajesTablero1(char personajes,int numRepeticiones){
        for (int i = 0; i < numRepeticiones; i++) {
            do {
                filaAleatoria=aleatorio.nextInt(MAX_FILA);
                columnaAleatoria=aleatorio.nextInt(MAX_COLUMNA);
            }while (tablero1[filaAleatoria][columnaAleatoria]!='L');
            tablero1[filaAleatoria][columnaAleatoria]=personajes;
        }
        if (personajes=='Y'){
            filaYoda=filaAleatoria;
            columnaYoda=columnaAleatoria;
        }
    }
    private static void asignarPersonajesTablero2(char personajes,int numRepeticiones){
        for (int i = 0; i < numRepeticiones; i++) {
            do {
                filaAleatoria=aleatorio.nextInt(MAX_FILA);
                columnaAleatoria=aleatorio.nextInt(MAX_COLUMNA);
            }while (tablero2[filaAleatoria][columnaAleatoria]!='L');
            tablero2[filaAleatoria][columnaAleatoria]=personajes;
        }
        if (personajes=='V'){
            filaVader=filaAleatoria;
            columnaVader=columnaAleatoria;
        }
    }
    private static void Jugar(){
        vidas1=3;
        vidas2=3;
        int [][] movimientos = new int[8][2];
        //W
        movimientos[0][0]=-1;
        movimientos[0][1]=0;
        //A
        movimientos[1][0]=0;
        movimientos[1][1]=-1;
        //S
        movimientos[2][0]=1;
        movimientos[2][1]=0;
        //D
        movimientos[3][0]=0;
        movimientos[3][1]=1;
        //Q
        movimientos[4][0]=-1;
        movimientos[4][1]=-1;
        //E
        movimientos[5][0]=-1;
        movimientos[5][1]=1;
        //Z
        movimientos[6][0]=1;
        movimientos[6][1]=-1;
        //C
        movimientos[7][0]=1;
        movimientos[7][1]=1;

        char [] letras={'W','A','S','D','Q','E','Z','C'};
        boolean isFinalizado= false;
        int contador=0;

        while (!isFinalizado && (vidas1>=0 || vidas2>=0)){
            System.out.println("Dime el nº de casillas que te quieres desplazar");
            int numCasillas= lector.nextInt();
            System.out.println("Dime la dirección en la que te quieres desplazar");
            char direccion = lector.next().charAt(0);

            int coordenada=-1;
            for (int i = 0; i < letras.length; i++) {
                if (letras[i]==direccion){
                    coordenada=i;
                    break;
                }
            }

            if (contador%2==0){
                //NUEVA FILA A LA QUE SE MUEVE
                int filaCheck= filaYoda+(movimientos[coordenada][0]*numCasillas);
                if (filaCheck<0){
                    filaCheck=filaCheck+MAX_FILA;
                } else if (filaCheck>=MAX_FILA) {
                    filaCheck=filaCheck-MAX_FILA;
                }
                //NUEVA COLUMNA A LA QUE SE MUEVE
                int columnaCheck=columnaYoda+(movimientos[coordenada][1]*numCasillas);
                if (columnaCheck<0){
                    columnaCheck=columnaCheck+MAX_COLUMNA;
                } else if (columnaCheck>=MAX_COLUMNA) {
                    columnaCheck=columnaCheck-MAX_COLUMNA;
                }

                //SEGÚN LA CASILLA QUE SE ENCUENTRE
                switch (tablero1[filaCheck][columnaCheck]){
                    case 'L':
                        tablero1[filaYoda][columnaYoda]='L';
                        tablero1[filaCheck][columnaCheck]='Y';
                        filaYoda=filaCheck;
                        columnaYoda=columnaCheck;
                        break;
                    case 'D':
                        tablero1[filaYoda][columnaYoda]='L';
                        tablero1[filaCheck][columnaCheck]='Y';
                        filaYoda=filaCheck;
                        columnaYoda=columnaCheck;
                        vidas1--;
                        System.out.println("Has perdido una vida!!, te quedan "+vidas1);
                        break;
                    case 'M':
                        System.out.println("No puedes desplazarte a la posición "+filaCheck+","+columnaCheck);
                        break;
                    case 'P':
                        tablero1[filaYoda][columnaYoda]='L';
                        do {
                            filaAleatoria=aleatorio.nextInt(MAX_FILA);
                            columnaAleatoria=aleatorio.nextInt(MAX_COLUMNA);
                        }while (tablero1[filaAleatoria][columnaAleatoria]!='L');
                        tablero1[filaCheck][columnaCheck]='L';
                        tablero1[filaAleatoria][columnaAleatoria]='Y';
                        break;
                    case 'F':
                        tablero1[filaYoda][columnaYoda]='L';
                        tablero1[filaCheck][columnaCheck]='Y';
                        filaYoda=filaCheck;
                        columnaYoda=columnaCheck;
                        System.out.println("Has ganado!!");
                        vidas1=-1;
                        isFinalizado=true;
                        break;
                }
                System.out.println("Tablero 1:");
                imprimirTablero1();
                System.out.println();
                System.out.println("Tablero 2:");
                imprimirTablero2();
            }else{
                //NUEVA FILA A LA QUE SE MUEVE
                int filaCheck= filaVader+(movimientos[coordenada][0]*numCasillas);
                if (filaCheck<0){
                    filaCheck=filaCheck+MAX_FILA;
                } else if (filaCheck>=MAX_FILA) {
                    filaCheck=filaCheck-MAX_FILA;
                }
                //NUEVA COLUMNA A LA QUE SE MUEVE
                int columnaCheck=columnaVader+(movimientos[coordenada][1]*numCasillas);
                if (columnaCheck<0){
                    columnaCheck=columnaCheck+MAX_COLUMNA;
                } else if (columnaCheck>=MAX_COLUMNA) {
                    columnaCheck=columnaCheck-MAX_COLUMNA;
                }

                //SEGÚN LA CASILLA QUE SE ENCUENTRE
                switch (tablero2[filaCheck][columnaCheck]){
                    case 'L':
                        tablero2[filaVader][columnaVader]='L';
                        tablero2[filaCheck][columnaCheck]='V';
                        filaVader=filaCheck;
                        columnaVader=columnaCheck;
                        break;
                    case 'R':
                        tablero2[filaVader][columnaVader]='L';
                        tablero2[filaCheck][columnaCheck]='V';
                        filaVader=filaCheck;
                        columnaVader=columnaCheck;
                        vidas2--;
                        System.out.println("Has perdido una vida!!, te quedan "+vidas2);
                        break;
                    case 'M':
                        System.out.println("No puedes desplazarte a la posición "+filaCheck+","+columnaCheck);
                        break;
                    case 'P':
                        tablero2[filaVader][columnaVader]='L';
                        do {
                            filaAleatoria=aleatorio.nextInt(MAX_FILA);
                            columnaAleatoria=aleatorio.nextInt(MAX_COLUMNA);
                        }while (tablero2[filaAleatoria][columnaAleatoria]!='L');
                        tablero2[filaCheck][columnaCheck]='L';
                        tablero2[filaAleatoria][columnaAleatoria]='V';
                        break;
                    case 'F':
                        tablero2[filaVader][columnaVader]='L';
                        tablero2[filaCheck][columnaCheck]='V';
                        filaVader=filaCheck;
                        columnaVader=columnaCheck;
                        System.out.println("Has ganado!!");
                        vidas2=-10;
                        isFinalizado=true;
                        break;
                }
                System.out.println("Tablero 2:");
                imprimirTablero2();
                System.out.println();
                System.out.println("Tablero 1:");
                imprimirTablero1();
            }
            if (vidas1 == -1 || vidas2 == -1) {
                System.out.println("Has perdido!! Fin del juego.");
                isFinalizado = true;
            }
            contador++;
        }
    }

    public static void main(String[] args) {
        rellenarTablero();
        asignarPersonajesTablero1('Y',1);
        asignarPersonajesTablero1('D',5);
        asignarPersonajesTablero1('M',5);
        asignarPersonajesTablero1('P',5);
        tablero1[MAX_FILA-1][MAX_COLUMNA-1]='F';
        System.out.println("Tablero 1:");
        imprimirTablero1();
        System.out.println();
        asignarPersonajesTablero2('V',1);
        asignarPersonajesTablero2('R',5);
        asignarPersonajesTablero2('M',5);
        asignarPersonajesTablero2('P',5);
        tablero2[MAX_FILA-1][MAX_COLUMNA-1]='F';
        System.out.println("Tablero 2:");
        imprimirTablero2();
        Jugar();
    }
}