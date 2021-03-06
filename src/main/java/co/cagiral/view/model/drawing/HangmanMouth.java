package co.cagiral.view.model.drawing;

/**
 * Representation of the HangmanStick.
 *
 * This class is in charge of drawing the Stick where the Hangman will hang
 */
public class HangmanMouth extends HangmanBodyPart {

    @Override
    public String draw() {
        return "n";
    }
}
