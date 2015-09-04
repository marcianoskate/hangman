package co.cagiral.view;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class ClientContext {

    private HangmanClientState state;

    public ClientContext() {

        state = new ClientNotPlaying(this);
    }
}
