package DoubleColumnarTransposition;
import java.util.Arrays;

public class DoubleColumnarTransposition {

    public static String encrypt(String plainText,String key1, String key2) {
        String temp = DoubleColumnarTransposition.singleEncrypt(plainText,key1);
        //System.out.println(temp);
       // System.out.println("Mesazhi i ekriptuar: ");
        String cipherText = DoubleColumnarTransposition.singleEncrypt(temp,key2);
        System.out.print("Mesazhi i ekriptuar: ");
        return cipherText;
    }
    public static String decrypt(String cipherText, String key1, String key2){
        String temp = DoubleColumnarTransposition.singleDecrypt(cipherText,key2);
        //System.out.println(temp);
        String plainText = DoubleColumnarTransposition.singleDecrypt(temp,key1);
        System.out.print("Mesazhi i dekriptuar: ");
        return plainText;
    }




    public static String singleEncrypt(String plainText,String key){
        int[]keys = DoubleColumnarTransposition.arrayOfLetters(key);

        int col = key.length();
        int row = (plainText.length() +key.length() -1)/key.length();


        char[][] matrica = new char[row][col];
        int pointer = 0;



        for(int i=0;i<row;i++){
            for(int j=0; j<col;j++){

                if(pointer<plainText.length()){
                    matrica[i][j] =plainText.charAt(pointer);

                }else {

                    matrica[i][j] ='0';

                }

                pointer++;

            }
        }

        for (int i = 0; i < matrica.length; i++) {

            // Loop through all elements of current row
            for (int j = 0; j < matrica[i].length; j++)
                System.out.print(matrica[i][j] + " ");

            System.out.println("");
        }
        StringBuilder cipherTextBuilder = new StringBuilder();


        //System.out.println("______________________________");
        //  System.out.println("Mesazhi: ");


        for (int i = 0; i < col; i++) {
            for(int k=0;k<key.length();k++) {
                if(keys[k]==(i+1)) {
                    for (int j = 0; j < row; j++) {

                        if(matrica[j][k] == '0') {
                            // kushti per fill
                            // cipherTextBuilder.append(matrica[j][k]);
                        }else{
                            cipherTextBuilder.append(matrica[j][k]);
                        }

                    }
                }
            }
        }

        //  System.out.println(cipherTextBuilder.toString());
      //  System.out.println("Mesazhi i ekriptuar: ");
        return cipherTextBuilder.toString();

    }



    public static String singleDecrypt(String cypherText,String key){



        int[]keys = DoubleColumnarTransposition.arrayOfLetters(key);


        int col = key.length();
        int row = (cypherText.length() +key.length() -1)/key.length();

        //int row e ka poziten e 0 ku shtohen, 0 shumfish i row

        //Algoritem me gjet sa u kan paddingu
        int numri = 0;
        int temp = cypherText.length();

        while(temp>0){
            temp = temp - key.length();
            numri++;
        }
        int nrPadding = key.length()-(temp+key.length());
        // System.out.println("Numri i paddingut: "+nrPadding);


        //adding the pading that we removed
        char[] cipherArray = cypherText.toCharArray();
        int[] pozitat = new int[nrPadding];
        int point=0;
        // System.out.println("                 Ka mbrri ktu  --");
        for(int i = keys.length-1;i>=(keys.length-nrPadding);i--){
            pozitat[point] = keys[i]*row;
            point++;
        }
        // System.out.println("                 Ka mbrri ktu  --2222222");

        //Mire programi deri ketu.
        // char []cipherArray2 = new char[cipherArray.length+nrPadding];
        //sorton array
        Arrays.sort(pozitat);
        int pozitaKohore = 0;
       /* for(int i=0;i<pozitat.length;i++) {
            System.out.print(pozitat[i] +"  ");

        } */

        //cipherArray = DoubleColumnarTransposition.shtoAnetarNePoziten(cipherArray, 5);
        //System.out.println("Funksioni 1: ");

        for(int i=0;i<pozitat.length;i++) {

            cipherArray = DoubleColumnarTransposition.shtoAnetarNePoziten(cipherArray, pozitat[i]-1);
            //   System.out.println("Iterimi: "+i);

        }

        //System.out.println("                 Ka mbrri ktu  --333333");

        String cipherText = new String(cipherArray);
        // System.out.println("CipherText pas paddingut: "+cipherText);


        char[][] matrica = new char[row][col];
        int pointer = 0;

        for (int i = 0; i < col; i++) {
            for(int k=0;k<key.length();k++) {
                if(keys[k]==(i+1)) {
                    for (int j = 0; j < row; j++) {

                        matrica[j][k] = cipherText.charAt(pointer);
                        pointer++;

                    }
                }
            }
        }
        StringBuilder plainText = new StringBuilder();


        for (int i = 0; i < matrica.length; i++) {

            for (int j = 0; j < matrica[i].length; j++){
                if(matrica[i][j] == '0'){
                    continue;
                }
                plainText.append(matrica[i][j]);
            }

        }

        return plainText.toString();
    }

    public static int [] arrayOfLetters(String key){

        int[] vargu = new int[key.length()];
        char[] oreginal = key.toCharArray();
        char[] stringu = key.toCharArray();

        //sortimi select
        int index;
        for (int i = 0; i < stringu.length; i++) {
            index = i;
            for (int j = i; j < stringu.length; j++) {
                if (stringu[j] < stringu[index]) {
                    index = j;
                }
            }
            char temp = stringu[i];
            stringu[i] = stringu[index];
            stringu[index] = temp;
        }

        for (char ch : stringu) {
            System.out.print(ch + " ");
        }
        System.out.println("");

        for (int k = 0; k < key.length(); k++) {
            for (int j = 0; j < key.length(); j++) {
                if(oreginal[k]==stringu[j]){
                    vargu[k]=j+1;
                }
            }
        }
        for(int x:vargu){
            System.out.print(x+" ");
        }
        System.out.println("");

        return vargu;
    }

    public static char[] shtoAnetarNePoziten(char[] vargu, int index) {
        char[] newVarg = new char[vargu.length + 1];
        int j = 0;
        for (int i = 0; i < newVarg.length; i++) {
            if (i == index) {
                newVarg[i] = '0';
                j++;
            } else {
                newVarg[i] = vargu[i - j];
            }
        }
        return newVarg;
    }
}

