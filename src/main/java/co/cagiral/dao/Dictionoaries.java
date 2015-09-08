package co.cagiral.dao;

/**
 * Created by cpalacio on 9/8/2015.
 */
public class Dictionoaries {
    public static WordDictionary getFileDictionary(String filePath) {
        if (filePath == null) {
            return new FileWords();
        }
        return new FileWords(filePath);
    }
}
