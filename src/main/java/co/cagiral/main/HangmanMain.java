package co.cagiral.main;

import java.io.Console;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class HangmanMain {

    public static final String COMMAND_LIST = "Commands: start, help, exit";
    public static boolean exit = false;

    public static void main(String[] args) {

        System.out.println(COMMAND_LIST);
        
    }

    private static void showHelp() {
        System.out.println(COMMAND_LIST);
    }

    private static void startGame() {
        System.out.println("Game Started");
    }
}
