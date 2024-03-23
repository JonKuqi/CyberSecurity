package DoubleColumnarTransposition;

import java.util.Scanner;

public class ConsoleExecute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jep tekstin qe do enkriptoni: ");
        String plainText = scanner.nextLine();

        System.out.println("Jepni qelesin 1: ");
        String key1 = scanner.next();

        System.out.println("Jepe qelesin 2: ");
        String key2 = scanner.next();

        System.out.println("_________________________________");
        String cypherText = DoubleColumnarTransposition.encrypt(plainText,key1,key2);
        System.out.println(cypherText);

        System.out.println("_____________________");
        //System.out.println("Mesazhi i dekriptuar: ");
        System.out.println(DoubleColumnarTransposition.decrypt(cypherText,key1,key2));



    }

}
