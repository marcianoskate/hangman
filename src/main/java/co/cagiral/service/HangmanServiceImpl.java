package co.cagiral.service;

import co.cagiral.dao.WordDictionary;
import co.cagiral.view.model.Hangman;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class HangmanServiceImpl implements HangmanService {

    private final WordDictionary wordDictionary;

    public HangmanServiceImpl(WordDictionary dictionary) {
        this.wordDictionary = dictionary;
    }

    @Override
    public String getSecretWord() {

        return wordDictionary.getWord();
    }

    @Override
    public boolean validateGuess(Hangman model, String guess) {

        boolean result = validateGuess(model.getSecretWord(), guess);
        if (result) {

            if (guess.length() == 1) {

                model.setGuessedLettersPosition(getGuessedPositions(model.getSecretWord(), guess.charAt(0), model.getGuessedLetters()));
            }
        }
        return result;
    }

    @Override
    public boolean[] getGuessedPositions(String secretWord, char guess, boolean[] previousState) {

        boolean[] result = previousState.clone();
        char[] asArray = secretWord.toCharArray();
        for (int i = 0; i < asArray.length; i++) {
            if (asArray[i] == guess) {
                result[i] = true;
            }
        }
        return result;
    }

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
