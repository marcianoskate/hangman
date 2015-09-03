package co.cagiral.service;

/**
 * Created by cpalacio on 9/2/2015.
 */
public interface Hangman {

    String getSecretWord();

    boolean validateGuess(String secretWord, String guess);
}
