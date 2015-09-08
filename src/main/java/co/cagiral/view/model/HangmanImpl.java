package co.cagiral.view.model;

import co.cagiral.service.HangmanService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * Default implementation of the Hangman.
 */
public class HangmanImpl extends Observable implements Hangman {

    private final HangmanService service;

    /** Message to communicate with the Observer Objects. */
    private Object message;

    private String secretWord;
    private boolean[] guessedLettersPosition;
    private Map<Character, Boolean> usedLetters = new LinkedHashMap<>();
    private int attempts = 10;
    private boolean won = false;

    public HangmanImpl(String secretWord, HangmanService service) {
        this.service = service;
        this.secretWord = secretWord;
        this.guessedLettersPosition = new boolean[secretWord.length()];
    }

    @Override
    public boolean hasWon() {
        return won;
    }

    @Override
    public void guess(String input) {

        if (attempts == 0) {
            return;
        }

        if (!usedLetter(input)) {

            validateInput(input);
        }
        setChanged();
        notifyObservers(getMessage());
    }

    private Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    private boolean usedLetter(String input) {
        if (input.length() == 1) {
            char inputChar = input.charAt(0);
            //check for warning only on letters
            if (usedLetters.containsKey(inputChar)) {
                if (usedLetters.get(inputChar)) {
                    setMessage("I warned you, you lose an attempt");
                    failedAttempt();
                    return true;
                }
                setMessage("Warning!, already used, try again.");
                usedLetters.put(inputChar, true);
                return true;
            } else {
                usedLetters.put(inputChar, false);
            }
        }
        return false;
    }

    private boolean validateInput(String input) {
        boolean found = service.validateGuess(this, input);
        if (found) {
            setMessage("\tCorrect!");
            if (input.length() > 1 || isComplete()) {
                won = true;
            }
        } else {
            setMessage("\tNot there :D");
            failedAttempt();
        }
        return found;
    }

    private boolean isComplete() {
        for (boolean b : guessedLettersPosition) {

            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void failedAttempt() {
        attempts--;
    }

    @Override
    public int getAttempts() {
        return attempts;
    }

    @Override
    public String getMaskedSecretWord() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            builder.append(" ").append(guessedLettersPosition[i] ? secretWord.charAt(i) : "_").append(" ");
        }
        return builder.toString();
    }

    @Override
    public Iterable<Character> getUsedLetters() {
        return usedLetters.keySet();
    }

    @Override
    public String getSecretWord() {
        return secretWord;
    }

    @Override
    public boolean[] getGuessedLetters() {
        return guessedLettersPosition;
    }

    @Override
    public void setGuessedLettersPosition(boolean[] guessedPositions) {
        this.guessedLettersPosition = guessedPositions;
    }

    @Override
    public void registerObserver(Observer observer) {

        this.addObserver(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

        this.removeObserver(observer);
    }
}
