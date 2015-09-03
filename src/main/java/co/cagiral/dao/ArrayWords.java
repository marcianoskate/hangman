package co.cagiral.dao;

import java.util.Random;

/**
 * Created by cpalacio on 9/2/2015.
 */
public class ArrayWords implements WordDictionary {

    public static String[] words = {
            "abaciscus",
            "abacist",
            "aback",
            "abactinal",
            "abactinally",
            "abaction",
            "abactor",
            "abaculus",
            "abacus",
            "Abadite",
            "abaff",
            "abaft",
            "abaisance",
            "abaiser",
            "abaissed",
            "abalienate",
            "abalienation",
            "abalone"
    };

    @Override
    public String getWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}
