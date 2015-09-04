package co.cagiral.view;

import java.util.Observable;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class ClientNotPlaying extends HangmanClientState {

    public ClientNotPlaying(ClientContext context) {

        super(context);
    }

    public ClientNotPlaying(HangmanClientState state) {
        super(state);
    }

    @Override
    public void onStart() {

        context.startGame();
        context.setState(new ClientPlaying(this));
    }

    @Override
    public void onHelp() {

        context.showHelp();
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
