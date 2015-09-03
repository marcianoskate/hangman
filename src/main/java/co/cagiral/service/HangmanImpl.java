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

        if (1 <= guess.length()) {
            return validateLetter(secretWord, guess);
        } else {
            return validateWord(secretWord, guess);
        }
    }

    private boolean validateLetter(String secretWord, String guess) {
        return false;
    }

    private boolean validateWord(String secretWord, String guess) {
        return false;
    }
}
