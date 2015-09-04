package co.cagiral.view;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cpalacio on 9/3/2015.
 */
public class HangmanProperties {

    public static final String START = "start";
    public static final String HELP = "help";
    public static final String EXIT = "exit";

    public static final Set<String> commands = new HashSet<>();

    private HangmanProperties() {

        commands.add(START);
        commands.add(EXIT);
        commands.add(HELP);
    }


    public static boolean isReserved(String word) {

        return commands.contains(word);
    }
}
