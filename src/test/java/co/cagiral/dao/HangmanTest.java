package co.cagiral.dao;

import co.cagiral.service.HangmanServiceImpl;
import co.cagiral.service.HangmanService;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class Hangman {

    @Mocked
    WordDictionary dictionary;

    private HangmanService instance;
    private final String secretWord = "fuzzy";

    @Before
    public void init() {

        instance = new HangmanServiceImpl(dictionary);
    }

    @Test (expected = IllegalArgumentException.class)
    public void null_secret_word_throws_exception() {
        instance.validateGuess(null, "a");
        instance.validateGuess(null, secretWord);
    }

    @Test (expected = IllegalArgumentException.class)
    public void null_guess_throws_exception() {
        instance.validateGuess(secretWord, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void null_values_trhrows_exception() {
        instance.validateGuess(null, null);
    }

    @Test
    public void valid_letter_returns_true() {

        assertTrue(instance.validateGuess(secretWord, "z"));
    }

    @Test
    public void non_valid_letter_returns_false() {

        assertFalse(instance.validateGuess(secretWord, "a"));
    }

    @Test
    public void valid_guess_returns_true() {

        assertTrue(instance.validateGuess(secretWord, secretWord));
    }

    @Test
    public void invalid_guess_returns_false() {
        assertFalse(instance.validateGuess(secretWord, "fuzzyi"));
    }

    @Test
    public void get_word_returns_word() {

        new Expectations() {{
            dictionary.getWord(); result = secretWord;
        }};

        assertEquals(instance.getSecretWord(), secretWord);

        new Verifications() {{

            dictionary.getWord();
        }};
    }
}
