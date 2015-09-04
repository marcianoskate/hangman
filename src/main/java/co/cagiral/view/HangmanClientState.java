package co.cagiral.view;

import co.cagiral.view.console.HangmanConsole;

import java.util.Observer;

/**
 * Created by cpalacio on 9/3/2015.
 */
public abstract class HangmanClientState implements Observer {

    protected final HangmanConsole context;

    public HangmanClientState(HangmanConsole context) {

        this.context = context;
    }

    public HangmanClientState(HangmanClientState previousState) {

        this.context = previousState.context;
    }

    public abstract void onStart();

    public abstract void onHelp();

    public abstract void onExit();

    public abstract void guess(String input);

    public abstract String getLabel();
}
