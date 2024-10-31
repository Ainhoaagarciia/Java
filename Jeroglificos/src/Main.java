import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dame un número entre 1 y 9999999.");
        Scanner lector = new Scanner(System.in);
        int num = lector.nextInt();
        int divisor = 1000000;
        do {
            if (num < divisor) {
                divisor = divisor / 10;
            } else {
                do {
                    if (num >= divisor) {
                        switch (divisor) {
                            case 1000000:
                                System.out.printf("H");
                                break;
                            case 100000:
                                System.out.printf("R");
                                break;
                            case 10000:
                                System.out.printf("D");
                                break;
                            case 1000:
                                System.out.printf("F");
                                break;
                            case 100:
                                System.out.printf("C");
                                break;
                            case 10:
                                System.out.printf("G");
                                break;
                            case 1:
                                System.out.printf("T");
                                break;
                        }
                    }
                    num = num - divisor;
                } while (num >= divisor);
            }
        } while (num != 0);
        lector.close();
    }
}