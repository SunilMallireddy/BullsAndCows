package bullscows;

import java.util.Scanner;

public class BullsAndCows {
    static Scanner obj = new Scanner(System.in);

    public static int calBullsAndCows(String secretCode, String input) {
        int cows = 0;
        int bulls = 0;
        if (secretCode.equals(input)){
            bulls = secretCode.length();
        } else {
            for (int i = 0; i < secretCode.length(); i++) {
                if(input.charAt(i) == secretCode.charAt(i)){
                    bulls++;
                } else if (secretCode.indexOf(input.charAt(i))>0){
                    cows++;

                }
            }
        }
        printGrade(cows,bulls,secretCode);
        return bulls;


    }

    public static void playGame(){
        System.out.println("Please, enter the secret code's length:");
        String s = ReadConsole.readNumbers();
        if(s.equals("Invalid"))
            return;
        int number = ReadConsole.stringToInt(s);
        System.out.println("Input the number of possible symbols in the code:");
        s = ReadConsole.readNumbers();
        if(s.equals("Invalid"))
            return;
        int noOfSymbols = ReadConsole.stringToInt(s);
        if(number == 0) {
            System.out.printf("Error: it's not possible to generate a code with a " +
                    "length of %d .\n",number);
            return;
        }
        if(noOfSymbols < number) {
            System.out.printf("Error: it's not possible to generate a code with a " +
                    "length of %d with %d unique symbols.\n",number,noOfSymbols);
            return;
        } else if(noOfSymbols > 36) {
            System.out.printf("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).\n");
            return;
        }
        int bulls =0;
        String secretNumber=GenRandomNumber.genRandomNumber(number, noOfSymbols);
        if(!secretNumber.equals("invalid")) {
            GenRandomNumber.secretCodeMessage(number,noOfSymbols);
            int turn = 1;
            while (bulls != number) {
                System.out.printf("Turn %d:", turn);
                String input = obj.next();
                bulls = BullsAndCows.calBullsAndCows(secretNumber, input);
                turn++;
            }
            System.out.println("Congratulations! You guessed the secret code.\n");
        }
    }

    public static void printGrade(int cows, int bulls, String secretCode) {
        String s= "The secret code is "+secretCode;
        if(cows != 0 && bulls != 0)
            System.out.printf("Grade: %d bull(s) and %d cow(s).\n",bulls,cows);
        else if (cows != 0)
            System.out.printf("Grade: %d cow(s).\n",cows);
        else if (bulls != 0)
            System.out.printf("Grade: %d bull(s).\n",bulls);
        else
            System.out.printf("Grade: None.\n");
    }
}
