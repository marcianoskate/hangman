package co.cagiral.view.model;

import java.util.Observer;

/**
 * Interface that offers the methods that any implementation of Hangman must offer.
 */
public interface Hangman {

    int getAttempts();

    boolean hasWon();

    boolean[] getGuessedLetters();

    String getMaskedSecretWord();

    Iterable<Character> getUsedLetters();

    void guess(String input);

    String getSecretWord();

    void setGuessedLettersPosition(boolean[] guessedPositions);

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);
}
