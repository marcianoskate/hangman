package co.cagiral.view;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class ClientNotPlaying extends HangmanClientState {

    public ClientNotPlaying(ClientContext context) {

        super(context);
    }

    @Override
    public void onStart() {

        context.startGame();
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

        new ClientPlaying(this);
    }
}
