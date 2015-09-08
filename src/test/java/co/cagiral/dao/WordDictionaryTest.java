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
        System.out.println(word);
        assertNotNull(word);
        System.out.println("======");
    }

    @Test
    public void file_words_return_word() {

        WordDictionary dictionary = new FileWords();
        String word = dictionary.getWord();
        System.out.println(word);
        assertNotNull(word);
        System.out.println("======");
    }

    @Test
    public void file_words_return_word_using_external_file() {

        WordDictionary dictionary = new FileWords("C:\\workspace\\words.txt");
        String word = dictionary.getWord();
        System.out.println(word);
        assertNotNull(word);
        System.out.println("======");
    }

    @Test
    public void file_words_from_factory_return_word_using_external_file() {

        WordDictionary dictionary = Dictionoaries.getFileDictionary("C:\\workspace\\words.txt");
        String word = dictionary.getWord();
        System.out.println(word);
        assertNotNull(word);
        System.out.println("======");
    }
}
