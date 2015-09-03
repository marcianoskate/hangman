package co.cagiral.dao;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cpalacio on 9/2/2015.
 */
public class WordDictionaryTest {

    @Test
    public void array_words_return_word() {

        WordDictionary dictionary = new ArrayWords();
        String word = dictionary.getWord();
        System.out.print(word);
        assertNotNull(word);
    }
}
