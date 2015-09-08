package co.cagiral.main;

import co.cagiral.view.HangmanViewFactory;

/**
 * Main class that gets invoke anytime the game is started.
 * It is in charge of starting the clients.
 */
public class HangmanGame {


    public static boolean exit = false;

    public static void main(String[] args) {

        String filePath = null;
        if (args != null) {

            if (args.length > 0) {

                filePath = args[0];
            }
        }
        HangmanViewFactory.console(filePath);
//        HangmanViewFactory.swing();
    }

}
