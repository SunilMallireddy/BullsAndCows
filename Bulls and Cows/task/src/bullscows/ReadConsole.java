package bullscows;

import java.util.Scanner;

public class ReadConsole {
    public static String readNumbers(){
        Scanner obj = new Scanner(System.in);
        String s = obj.nextLine();
        if(s.matches("\\d+"))
            return s;
        System.out.printf("Error: \"%s\" isn't a valid number.\n",s);
        return "Invalid";
    }

    public static int stringToInt(String s) {
        return Integer.parseInt(s);
    }


}
