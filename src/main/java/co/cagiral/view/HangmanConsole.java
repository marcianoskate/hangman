package co.cagiral.view;

import java.io.Console;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class HangmanConsole implements HangmanView {

    private HangmanClientState state;

    public HangmanConsole() {

        state = new ClientNotPlaying(this);
        Console console = System.console();

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

    public void showHelp(String helpMsg) {
        System.out.println(helpMsg);
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
