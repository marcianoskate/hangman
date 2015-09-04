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
        System.out.println(COMMAND_LIST);

        String input;
        while (true) {

            input = console.readLine(state.getLabel()).trim();
            while (input == null || input.isEmpty()) {
                input = console.readLine("try again!\n\t:").trim();
            }

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

    public void showHelp() {
        System.out.println(COMMAND_LIST);
    }

    public void startGame() {
        System.out.println("Game Started");
    }


    public void exit() {
        System.exit(0);
    }

    public HangmanClientState getState() {
        return state;
    }

    public void setState(HangmanClientState state) {
        this.state = state;
    }
}
