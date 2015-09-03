package co.cagiral.dao;

import co.cagiral.service.HangmanImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class Hangman {

    private co.cagiral.service.Hangman instance;
    private final String secretWord = "fuzzy";

    @Before
    public void init() {

        instance = new HangmanImpl();
    }

    @Test
    public void valid_letter_returns_true() {

        assertTrue(instance.validateGuess(secretWord, "z"));
    }
}
