package co.cagiral.view;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class ClientPlaying extends HangmanClientState {

    public ClientPlaying(HangmanClientState prevState) {
        super(prevState);
    }

    @Override
    public void onStart() {
        System.out.println("Game already Started, type exit to finish");
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

        System.out.println("\t guessed: " + input);
    }
}
