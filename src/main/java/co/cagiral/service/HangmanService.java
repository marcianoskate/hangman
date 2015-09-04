package co.cagiral.service;

import co.cagiral.view.model.Hangman;

/**
 * Created by cpalacio on 9/2/2015.
 */
public interface HangmanService {

    String getSecretWord();

    boolean validateGuess(Hangman model, String guess);

    boolean validateGuess(String secretWord, String guess);

    boolean[] getGuessedPositions(String secretWord, char guess, boolean[] previousState);
}
