package co.cagiral.view.model;

import co.cagiral.service.HangmanService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cpalacio on 9/4/2015.
 */
public class HangmanImpl implements Hangman {

    private final HangmanService service;
    private String secretWord;
    private boolean[] correctLetters;
    private Map<Character, Boolean> usedLetters = new HashMap<>();
    private int attempts = 10;

    public HangmanImpl(String secretWord, HangmanService service) {
        this.service = service;
        this.secretWord = secretWord;
        this.correctLetters = new boolean[secretWord.length()];
    }

    @Override
    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    @Override
    public void guess(String input) {

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
        boolean found = service.validateGuess(this.secretWord, input);
        if (found) {
            System.out.println("\tCorrect!");
            correctLetters = service.getGuessedPositions(secretWord, input.charAt(0), correctLetters);
        } else {
            System.out.println("\tIncorrect!");
            failedAttempt();
        }
    }

    private void failedAttempt() {
        attempts--;
    }

    @Override
    public void getAttempts() {

    }

    @Override
    public String getFormattedSecretWord() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            builder.append(" ").append(correctLetters[i] ? secretWord.charAt(i) : "_").append(" ");
        }
        return builder.toString();
    }

    @Override
    public Iterable<Character> getUsedLetters() {
        return usedLetters.keySet();
    }
}
