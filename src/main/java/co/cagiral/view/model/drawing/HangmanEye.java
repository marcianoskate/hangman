package co.cagiral.view.model.drawing;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of the HangmanStick.
 *
 * This class is in charge of drawing the Stick where the Hangman will hang
 */
public class HangmanEye extends HangmanBodyPart {

    @Override
    public String draw() {
        return "x";
    }
}
