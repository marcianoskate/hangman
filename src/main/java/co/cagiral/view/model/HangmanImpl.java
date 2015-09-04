package co.cagiral.view.model;

import co.cagiral.service.HangmanService;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by cpalacio on 9/4/2015.
 */
public class HangmanImpl implements Hangman {

    private final HangmanService service;
    private String secretWord;
    private boolean[] guessedLettersPosition;
    private Map<Character, Boolean> usedLetters = new LinkedHashMap<>();
    private int attempts = 10;

    public HangmanImpl(String secretWord, HangmanService service) {
        this.service = service;
        this.secretWord = secretWord;
        this.guessedLettersPosition = new boolean[secretWord.length()];
    }

    @Override
    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    @Override
    public void guess(String input) {

        if (attempts == 0) {
            return;
        }

        if (!usedLetter(input)) {

            validateInput(input);
        }
    }

    private boolean usedLetter(String input) {
        if (input.length() == 1) {
            char inputChar = input.charAt(0);
            //check for warning only on letters
            if (usedLetters.containsKey(inputChar)) {
                if (usedLetters.get(inputChar)) {
                    System.out.println("TTY! body part for you!");
                    failedAttempt();
                    return true;
                }
                System.out.println("\u25B3Warning!, already used, try again.");
                usedLetters.put(inputChar, true);
                return true;
            } else {
                usedLetters.put(inputChar, false);
            }
        }
        return false;
    }

    private void validateInput(String input) {
        boolean found = service.validateGuess(this, input);
        if (found) {
            System.out.println("\tCorrect!");
//            guessedLettersPosition = service.getGuessedPositions(secretWord, input.charAt(0), guessedLettersPosition);
        } else {
            System.out.println("\tNot there :D");
            failedAttempt();
        }
    }

    private void failedAttempt() {
        attempts--;
    }

    @Override
    public int getAttempts() {
        return attempts;
    }

    @Override
    public String getFormattedSecretWord() {
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
}
