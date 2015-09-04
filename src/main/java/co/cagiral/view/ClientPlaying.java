package co.cagiral.view;

import co.cagiral.dao.ArrayWords;
import co.cagiral.dao.WordDictionary;
import co.cagiral.service.Hangman;
import co.cagiral.service.HangmanImpl;

import java.util.regex.Pattern;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class ClientPlaying extends HangmanClientState {

    private final Hangman service = new HangmanImpl(new ArrayWords());
    private String secretWord;

    public ClientPlaying(HangmanClientState prevState) {
        super(prevState);


        while (secretWord == null || HangmanProperties.isReserved(secretWord)) {

            secretWord = service.getSecretWord();
        }
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

        System.out.println("\tguessed: " + input);
        boolean found = service.validateGuess(secretWord, input);
        if (found) {
            System.out.println("\tCorrect!");
        } else {
            System.out.println("\tIncorrect!");
        }
    }

    @Override
    public String getLabel() {
        return "guess the word: " + formattedSecretWord() + " \n\t:";
    }

    private String formattedSecretWord() {
        return "_ _ _ _ _";
    }
}
