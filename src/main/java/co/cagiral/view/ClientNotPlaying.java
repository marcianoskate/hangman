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

    }

    @Override
    public void onHelp() {

    }

    @Override
    public void onExit() {

        System.exit(0);
    }
}
