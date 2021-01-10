package bullscows;
import java.util.*;

public class GenRandomNumber {

    public static String genRandomNumber(int number, int noOfSymbols){

        Random r = new Random();
        boolean valid = checkValidInput(number);
        String s="Invalid";
        StringBuilder sb = new StringBuilder();

        while( valid && sb.length() < number) {
            int num = (r.nextInt(10));
           if(sb.indexOf(String.valueOf(num))>=0) {
           } else{
               sb.append(num);
           }
           if(sb.length() == number){
               break;
           }
           if(noOfSymbols > 10) {
               char a = (char) (r.nextInt(noOfSymbols - 10) + 'a');
               if (sb.indexOf(String.valueOf(a)) >= 0) {
               } else {
                   sb.append(a);
               }
           }
       }
        s= valid ? String.valueOf(sb) : s;
       return s;
    }


    public static String genPseudoNumber(int number){
        StringBuilder sb = new StringBuilder();
        sb.append(2);
        boolean valid = checkValidInput(number);
        long smallestNumber = (long)Math.pow(10,number-1);
        //System.out.println(smallestNumber);
        long secretCode = 0;
        if(valid) {
            while (sb.length() < number) {
                long pseudoRandomNumber = System.nanoTime();
                for (int i = 0; i < 9; i++) {
                    if (sb.length() < number) {
                        if (sb.indexOf(String.valueOf(pseudoRandomNumber % 10)) < 0) {
                            sb.append(pseudoRandomNumber % 10);
                            if(sb.indexOf("0")==0){
                                sb.delete(0,1);
                            }

                            //System.out.println(sb);
                        }
                    }
                    pseudoRandomNumber = pseudoRandomNumber / 10;
                    // div = div * 10;
                    //secretCode = Integer.valueOf(String.valueOf(sb));
                }


            }
            // System.out.printf("The random secret number is %d",secretCode);
            return String.valueOf(sb);
        } else{
            return "invalidInput";
        }
    }

    public static boolean checkValidInput(int number){
        if (number > 36){
            System.out.printf("Error: can't generate a secret number with a " +
                    "length of %d because there aren't enough unique" +
                    " digits.",number);
            return false;
        } else{
            return true;
        }
    }

    public static void secretCodeMessage(int number, int noOfSymbols){
        char[] a = new char[number];

        Arrays.fill(a, '*');
        String sb = new String(a);
        if(noOfSymbols > 10){

            char end = (char) ('a'+(char)(noOfSymbols-11));
            sb= sb+" (0-9,a-"+end +")";

        } else {
            noOfSymbols--;
            sb = sb+" (0-"+noOfSymbols+")";
        }

        System.out.println("The secret is prepared: "+sb);


    }
}
