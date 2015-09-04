package co.cagiral.view;

import co.cagiral.dao.ArrayWords;
import co.cagiral.service.HangmanService;
import co.cagiral.service.HangmanServiceImpl;
import co.cagiral.view.model.Hangman;
import co.cagiral.view.model.HangmanImpl;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class ClientPlaying extends HangmanClientState {

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

        hangman.guess(input);
    }

    @Override
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append("\n\n=========\n");
        label.append("guess the word: " + hangman.getFormattedSecretWord()).append("\n");
        label.append("so far you've guessed: " + hangman.getUsedLetters()).append("\n");
        label.append("You have ").append(hangman.getAttempts()).append(" attempts remaining\n");
        label.append("\t:");
        return label.toString();
    }

}
