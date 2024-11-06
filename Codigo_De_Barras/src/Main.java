import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        while (true) {
            String codigo = lector.nextLine().trim();           //Usuario inserta el código sin espacios delante
            if (codigo.equals("0")) break;                      //Para no poder meter 0

            // 1º) LONGITUD DE LA ENTRADA
            int longitud = codigo.length();

            /* 2º) COMPLETAR CON CEROS*/
            boolean esEAN8 = longitud <= 8;                     //Será true cuando cumpla esa condición
            boolean esEAN13 = longitud > 8 && longitud <= 13;
            if (esEAN8) { //En caso de EAN8...
                while (codigo.length() < 8) {
                    codigo = "0" + codigo;                      //Rellena con 0 el código hasta completar las 8 posiciones
                }
            } else if (esEAN13) { //En caso de EAN13...
                while (codigo.length() < 13) {
                    codigo = "0" + codigo;
                }
            }
            /* 3º) SUMA PARES E IMPARES*/
            int sumaImpares = 0; // *3
            int sumaPares = 0;   // *1
            int contPos = 0; //Posición donde se encontrará cada nº

            for (int i = codigo.length() - 2; i >= 0; i--) {                        //Recorro el array de derecha a izquierda (al revés) desde el segundo nº hasta el final
                int digito = Integer.parseInt(String.valueOf(codigo.charAt(i)));    //Nos da el primer nº contenido en la primera posición del array, coge la posición, la pasa a cadena y a nº
                contPos++;                                                          //Posición en la que se encuentra el dígito, irá aumentando cuando vaya recorriendo el array
                if (contPos % 2 == 0) {                                             //Si su posición es par, es decir, al dividir el nº de la posición entre 2, su resto es 0...
                    sumaPares = sumaPares + (digito*1);                             //El nº que haya en esa posición se multiplica por 1
                } else {
                    sumaImpares = sumaImpares + (digito * 3);                       //Si es impar se multiplica por 3
                }
            }
            int sumaPonderada = sumaImpares + sumaPares;

            /* 4º) CALCULAR DÍGITO DE COMPROBACIÓN*/                                //Nº que hay que sumar al resultado anterior para llegar a un valor múltiplo de 10.
            int digitoControlCalculado;
            int resto = sumaPonderada % 10;                                         //obtiene el resto de la división entre 10.
            digitoControlCalculado = (resto == 0) ? 0 : (10 - resto);               //si el resto=0, será 0, sino hará 10- resto, es como un if (){...} : else{...}

            // Verificación del dígito de control
            int digitoControlReal = Integer.parseInt(String.valueOf(codigo.charAt(codigo.length() - 1)));   //Da el valor del primer digito
            boolean controlValido = (digitoControlCalculado == digitoControlReal);                          //Si coinciden el primer digito del usuario y del pais, será valido, true
            // Resultado inicial para el control
            if (controlValido) {
                System.out.print("SI");
            } else {
                System.out.println("NO");
                continue;
            }
            // 5º) IDENTIFICACION DEL PAIS PARA EAN-13
               /*if (esEAN13 && controlValido) {
                   int prefijoPais = Integer.parseInt(codigo.substring(0, 3));
                   if (prefijoPais == 380) System.out.print(" Bulgaria");
                   else if (prefijoPais == 50) System.out.print(" Inglaterra");
                    ...
                   else System.out.print(" Desconocido");
               }*/
            if (esEAN13 && controlValido) {                                                                         //Comprueba que el código es de tipo EAN-13 (longitud de 13 dígitos) y que el dígito de control calculado coincide con el dígito de control real.
                int[] prefijos = {380, 50, 560, 70, 590, 850, 890};                                                 // Los primeros dígitos se usan para identificar al país.
                String[] paises = {"Bulgaria", "Inglaterra", "Portugal", "Noruega", "Polonia", "Cuba", "India"};
                String nombrePais = "Desconocido"; //Si no es de los anteriores
                int prefijoPais = 0;                                                                                //Primeros dígitos del código para poder identificarlo con el país
                for (int i = 0; i < prefijos.length; i++) {                                                         //El bucle se repite una vez por cada prefijo en la lista. En cada iteración, i toma un valor distinto (0, 1, 2...) hasta recorrer todos los prefijos.
                    prefijoPais = Integer.parseInt(codigo.substring(0, (String.valueOf( prefijos[i] )).length()) ); //1º Se busca el prefijo en el array, se pasa a cadena, capta la longitud de dígitos (Ej 380=3).
                    //2ºCodigosubstring...Se extraen los primeros dígitos, corta el array con una longitud igual a la cantidad de dígitos de prefijos[i].(Ej) Codigo.substring(0, 3)
                    //Si codigo es "3801234567890" y prefijos[i] es 380, produce "380".
                    //3º Se pasa a entero el número
                    /*Ejemplo: Si:  codigo = "3801234567890" prefijos[i] = 380   Entonces:

                    1º) String.valueOf(prefijos[i]) convierte 380 a "380".
                    2º) (String.valueOf(prefijos[i])).length() da 3 (la longitud de "380").
                    3º) codigo.substring(0, 3) toma los primeros 3 caracteres de codigo, que son "380".
                    4º) Integer.parseInt("380") convierte "380" en el número entero 380.
                    5º) prefijoPais se asigna con el valor 380.  */

                    if (prefijos[i] == prefijoPais) {
                        nombrePais = paises[i]; ////Si coinciden los prefijos, se almacenará el valor del pais, y sino será el de "Desconocido"
                        break;
                    }
                }
                System.out.print(" " + nombrePais);
            }
            System.out.println();
        }
        lector.close();
    }
}