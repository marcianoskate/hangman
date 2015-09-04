package co.cagiral.view.model;

import java.util.Observer;

/**
 * Created by cpalacio on 9/4/2015.
 */
public interface Hangman {

    int getAttempts();

    boolean[] getGuessedLetters();

    String getFormattedSecretWord();

    Iterable<Character> getUsedLetters();

    void guess(String input);

    String getSecretWord();

    void setGuessedLettersPosition(boolean[] guessedPositions);

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);
}
