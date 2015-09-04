package co.cagiral.view;

import java.io.Console;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class ClientContext {

    public static final String COMMAND_LIST = "Commands: start, help, exit";

    private HangmanClientState state;

    public ClientContext() {

        state = new ClientNotPlaying(this);
        Console console = System.console();

        while (true) {
            System.out.println(COMMAND_LIST);
            String input = console.readLine("hangman: ");

            switch (input) {
                case "help":
                    state.onHelp();
                    break;
                case "start":
                    state.onStart();
                    break;
                case "exit":
                    state.onExit();
                    break;
                default:
                    state.guess(input);
                    break;
            }
        }
    }

    public static void showHelp() {
        System.out.println(COMMAND_LIST);
    }

    public static void startGame() {
        System.out.println("Game Started");
    }


}
