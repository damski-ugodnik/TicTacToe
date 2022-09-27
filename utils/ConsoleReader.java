package utils;


import java.util.Scanner;
import java.util.regex.Pattern;


public class ConsoleReader {
    private final static Scanner scanner = new Scanner(System.in);

    public static String readString(String inputMessage, Pattern pattern) {
        String input;
        while (true) {
            System.out.print(inputMessage);
            input = scanner.nextLine();
            if (Validator.validateRegex(input, pattern)) {
                return input;
            }
            System.out.println("Bad parameters!");
        }
    }
}
