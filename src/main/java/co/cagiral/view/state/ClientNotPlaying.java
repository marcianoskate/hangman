package co.cagiral.view.state;

import co.cagiral.view.console.HangmanConsole;

import java.util.Observable;

/**
 * State that indicates the player hasn't started to play, he's in the initial mode and
 * the program is waiting for a command.
 */
public class ClientNotPlaying extends HangmanClientState {
    public static final String HELP_MSG = "Commands: start, help, exit";

    public ClientNotPlaying(HangmanConsole context) {

        super(context);
        context.showHelp(HELP_MSG);
    }

    public ClientNotPlaying(HangmanClientState state) {
        super(state);
        context.showHelp(HELP_MSG);
    }

    private String getStartMsg() {
        StringBuilder startMsg = new StringBuilder();
        startMsg.append("======================\n")
                .append("-=== Game Started ===-\n")
                .append("======================");
        return startMsg.toString();
    }

    @Override
    public void onStart() {

        context.displayMessage(getStartMsg());
        context.setState(new ClientPlaying(this));
    }

    @Override
    public void onHelp() {

        context.showHelp(HELP_MSG);
    }

    @Override
    public void onExit() {

        context.exit();
    }

    @Override
    public void guess(String input) {

        System.out.println("You must start a game. Type start.");
    }

    @Override
    public String getLabel() {

        return "Hangman: ";
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Client not playing, got a message O_o");
    }
}
