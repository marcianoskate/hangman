package co.cagiral.view;

/**
 * Created by cpalacio on 9/3/2015.
 */
public abstract class HangmanClientState {

    protected final ClientContext context;

    public HangmanClientState(ClientContext context) {

        this.context = context;
    }

    public HangmanClientState(HangmanClientState previousState) {

        this.context = previousState.context;
    }

    public abstract void onStart();

    public abstract void onHelp();

    public abstract void onExit();

    public abstract void guess(String input);
}