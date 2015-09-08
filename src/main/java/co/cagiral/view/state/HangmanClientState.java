package co.cagiral.view.state;

import co.cagiral.view.console.HangmanConsole;

import java.util.Observer;

/**
 * Definition of methods that any state must provide to the Context
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
