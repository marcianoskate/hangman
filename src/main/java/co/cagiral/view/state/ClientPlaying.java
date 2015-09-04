package co.cagiral.view.state;

import co.cagiral.dao.ArrayWords;
import co.cagiral.service.HangmanService;
import co.cagiral.service.HangmanServiceImpl;
import co.cagiral.view.HangmanProperties;
import co.cagiral.view.model.Hangman;
import co.cagiral.view.model.HangmanImpl;

import java.util.Observable;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class ClientPlaying extends HangmanClientState {

    public static final String HELP_MSG = "Guess a letter or a word; exit will end the game.";

    private final HangmanService service = new HangmanServiceImpl(new ArrayWords());
    private Hangman hangman;

    public ClientPlaying(HangmanClientState prevState) {
        super(prevState);

        String secretWord = null;
        while (secretWord == null || HangmanProperties.isReserved(secretWord)) {

            secretWord = service.getSecretWord();
        }

        System.out.println("secret word: " + secretWord);
        hangman = new HangmanImpl(secretWord, service);
        hangman.registerObserver(this);
        context.showHelp(HELP_MSG);
    }

    @Override
    public void onStart() {
        System.out.println("Game already Started, type exit to finish");
    }

    @Override
    public void onHelp() {

        context.showHelp(HELP_MSG);
    }

    @Override
    public void onExit() {

        context.setState(new ClientNotPlaying(this));
    }

    @Override
    public void guess(String input) {

        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                System.out.println("No special characters, try again.");
                return;
            }
        }
        hangman.guess(input);

    }

    @Override
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append("guess the word: " + hangman.getMaskedSecretWord()).append("\n");
        label.append("so far you've guessed: " + hangman.getUsedLetters()).append("\n");
        label.append("You have ").append(hangman.getAttempts()).append(" attempts remaining\n");
        label.append("\t:");
        return label.toString();
    }

    /**
     * Observer method executed any time an Observable instance executes the notifyObservers
     * and this Object is registerd as an observer.
     * @param o Object that's being observed
     * @param arg Objects that can be passed as paramter by the Observable instance
     */
    @Override
    public void update(Observable o, Object arg) {

        context.displayMessage("state of observable " + o.hasChanged());
        if (arg != null && arg instanceof String) {
            String msg = (String) arg;
            context.displayMessage(msg);
            context.displayMessage("---------------------");
        }
        if (o == hangman) {
            Hangman hangman = (Hangman) o;

            if (hangman.getAttempts() == 0) {
                System.out.println("-=== GAME OVER ==--");
                context.setState(new ClientNotPlaying(this));
            }

        }
    }
}
