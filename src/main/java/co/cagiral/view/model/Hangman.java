package co.cagiral.view.model;

/**
 * Created by cpalacio on 9/4/2015.
 */
public interface Hangman {

    void setSecretWord(String secretWord);

    void guess(String input);

    int getAttempts();

    String getFormattedSecretWord();

    Iterable<Character> getUsedLetters();

    String getSecretWord();

    boolean[] getGuessedLetters();

    void setGuessedLettersPosition(boolean[] guessedPositions);
}
