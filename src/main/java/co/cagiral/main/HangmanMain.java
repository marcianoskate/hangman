package co.cagiral.main;

import java.io.Console;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class HangmanMain {

    public static boolean exit = false;

    public static void main(String[] args) {

        while (!exit) {

            Console console = System.console();
            String input = console.readLine("Enter input: ");

            System.out.println(input);

            exit = "exit".equalsIgnoreCase(input);
        }
    }
}
