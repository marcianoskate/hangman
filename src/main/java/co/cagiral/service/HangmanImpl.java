package co.cagiral.service;

import co.cagiral.dao.ArrayWords;
import co.cagiral.dao.WordDictionary;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class HangmanImpl implements Hangman {

    private final WordDictionary wordDictionary;

    public HangmanImpl() {
        this.wordDictionary = new ArrayWords();
    }

    @Override
    public String getSecretWord() {

        return wordDictionary.getWord();
    }

    @Override
    public boolean validateGuess(String secretWord, String guess) {

        if (secretWord == null) {
            throw new IllegalArgumentException("Secret word can't be null");
        }
        if (guess == null || guess.isEmpty()) {
            throw new IllegalArgumentException("The guess can't be null or empty");
        }

        guess = guess.trim();

        if (1 == guess.length()) {
            return validateLetter(secretWord, guess.charAt(0));
        } else {
            return validateWord(secretWord, guess);
        }
    }

    /**
     * Validates that the guess is a letter that belongs to the secretWord.
     * It assumes that both parameters have been validated and are not null.
     * @param secretWord The word that the player has to guess
     * @param guess The letter that the player input
     * @return True if the letter belongs to the word, false otherwise
     */
    private boolean validateLetter(String secretWord, char guess) {

        return secretWord.indexOf(guess) >= 0 ;
    }

    /**
     * Validates that the guess is the secretWord.
     * It assumes thaty both parameters have been validated and are not null.
     * @param secretWord The word that the player has to guess
     * @param guess The word that the player input
     * @return True if the let
     */
    private boolean validateWord(String secretWord, String guess) {
        return secretWord.equalsIgnoreCase(guess);
    }
}
