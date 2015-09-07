package co.cagiral.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Verifications;

import org.junit.Before;
import org.junit.Test;

import co.cagiral.service.HangmanService;
import co.cagiral.service.HangmanServiceImpl;
import co.cagiral.view.model.Hangman;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class HangmanTest {

    @Injectable
    WordDictionary dictionary;

    @Mocked
    private Hangman hangmanModel;

    private final String mockedGuess = "Fuzzy";
    private HangmanService service;

    @Before
    public void init() {

        service = new HangmanServiceImpl(dictionary);
    }

    @Test (expected = IllegalArgumentException.class)
    public void null_secret_word_throws_exception() {
    	new Expectations() {{
    		hangmanModel.getSecretWord(); result = null;
    	}};
        service.validateGuess(hangmanModel, "a");
        service.validateGuess(hangmanModel, mockedGuess);
    }

    @Test (expected = IllegalArgumentException.class)
    public void null_guess_throws_exception() {
        service.validateGuess(hangmanModel, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void null_values_trhrows_exception() {
    	new Expectations() {{
    		hangmanModel.getSecretWord(); result = null;
    	}};
        service.validateGuess(hangmanModel, null);
    }

    @Test
    public void valid_letter_returns_true() {

    	new Expectations() {{
    		hangmanModel.getSecretWord(); result = mockedGuess;
    		hangmanModel.getGuessedLetters(); result = new boolean[mockedGuess.length()];
    	}};
        assertTrue(service.validateGuess(hangmanModel, "z"));
    }

    @Test
    public void non_valid_letter_returns_false() {

    	new Expectations() {{
    		hangmanModel.getSecretWord(); result = mockedGuess;
    	}};
        assertFalse(service.validateGuess(hangmanModel, "a"));
    }

    @Test
    public void valid_guess_returns_true() {

    	new Expectations() {{
    		hangmanModel.getSecretWord(); result = mockedGuess;
    	}};
        assertTrue(service.validateGuess(hangmanModel, mockedGuess));
    }
    
    @Test
    public void valid_word_wins() {
    	
    	new Expectations() {{
    		hangmanModel.getSecretWord(); result = mockedGuess;
    	}};
        assertTrue(service.validateGuess(hangmanModel, mockedGuess));
//        assertTrue(hangmanModel.hasWon());
    }

    @Test
    public void invalid_guess_returns_false() {
    	new Expectations() {{
    		hangmanModel.getSecretWord(); result = mockedGuess;
        }};
        assertFalse(service.validateGuess(hangmanModel, "fuzzyi"));
    }

    @Test
    public void get_word_returns_word() {

        new Expectations() {{
            dictionary.getWord(); result = mockedGuess;
        }};

        assertEquals(service.getSecretWord(), mockedGuess);

        new Verifications() {{

            dictionary.getWord();
        }};
    }
}
