package co.cagiral.view.console;

import co.cagiral.view.model.drawing.HangmanDrawing;
import co.cagiral.view.state.ClientNotPlaying;
import co.cagiral.view.state.HangmanClientState;
import co.cagiral.view.HangmanView;

import java.io.Console;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class HangmanConsole implements HangmanView {

    private HangmanClientState state;
    private final String filepath;

    public HangmanConsole() {

        this(null);
    }
    
    public HangmanConsole(String filepath) {

        this.filepath = filepath;

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

    @Override
    public void showHelp(String helpMsg) {
        System.out.println("---------------------");
        System.out.println(helpMsg);
        System.out.println("---------------------");
    }

    @Override
    public void setState(HangmanClientState state) {
        this.state = state;
    }

    @Override
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public void drawHangman(HangmanDrawing hangmanDrawing) {

        hangmanDrawing.draw();
    }

    @Override
    public String getFilePath() {
        return filepath;
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
