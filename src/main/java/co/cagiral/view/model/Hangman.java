package co.cagiral.view.model;

import java.util.Observer;

/**
 * Created by cpalacio on 9/4/2015.
 */
public interface Hangman {

    void guess(String input);

    int getAttempts();

    String getFormattedSecretWord();

    Iterable<Character> getUsedLetters();

    String getSecretWord();

    boolean[] getGuessedLetters();

    void setGuessedLettersPosition(boolean[] guessedPositions);

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);
}
