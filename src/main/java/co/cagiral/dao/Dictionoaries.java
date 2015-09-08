package co.cagiral.dao;

/**
 * Created by cpalacio on 9/8/2015.
 */
public class Dictionoaries {
    public static WordDictionary getFileDictionary(String filePath) {
        System.out.println("DICT FACTORY: creating File Words from " + filePath);
        return new FileWords(filePath);
    }
}
