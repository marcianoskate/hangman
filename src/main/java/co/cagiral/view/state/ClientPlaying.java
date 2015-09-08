package co.cagiral.view.state;

import co.cagiral.dao.ArrayWords;
import co.cagiral.dao.Dictionoaries;
import co.cagiral.dao.FileWords;
import co.cagiral.service.HangmanService;
import co.cagiral.service.HangmanServiceImpl;
import co.cagiral.view.HangmanProperties;
import co.cagiral.view.model.Hangman;
import co.cagiral.view.model.HangmanImpl;
import co.cagiral.view.model.drawing.HangmanDrawing;

import java.util.Observable;

/**
 * State that identifies an user playing the game. It holds all the state of the game's ui
 */
public class ClientPlaying extends HangmanClientState {

    public static final String HELP_MSG = "Guess a letter or a word; exit will end the game.";

    private final HangmanService service;
    private Hangman hangman;

    public ClientPlaying(HangmanClientState prevState) {
        super(prevState);

        System.out.println("Context has the following path: " + context.getFilePath());
        service = new HangmanServiceImpl(Dictionoaries.getFileDictionary(context.getFilePath()));

        String secretWord = null;
        while (secretWord == null || HangmanProperties.isReserved(secretWord)) {

            secretWord = service.getSecretWord();
        }

//        context.displayMessage("secret word: " + secretWord);
        hangman = new HangmanImpl(secretWord, service);
        hangman.registerObserver(this);
        context.drawHangman(HangmanDrawing.getHangmanDrawing(hangman.getAttempts()));
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

        if (arg != null && arg instanceof String) {
            String msg = (String) arg;
            context.displayMessage(msg);
            context.displayMessage("---------------------");
        }
        if (o == hangman) {
        	
            Hangman hangman = (Hangman) o;

            context.drawHangman(HangmanDrawing.getHangmanDrawing(hangman.getAttempts()));
            if (hangman.hasWon()) {
                context.displayMessage("******************");
                context.displayMessage("**** YOU WON! ****");
                context.displayMessage("******************");
                context.displayMessage("The word was: " + hangman.getSecretWord());
                context.setState(new ClientNotPlaying(this));
            }
            if (hangman.getAttempts() == 0) {
                context.displayMessage("-=== GAME OVER ==--");
                context.setState(new ClientNotPlaying(this));
            }

        }
    }
}
