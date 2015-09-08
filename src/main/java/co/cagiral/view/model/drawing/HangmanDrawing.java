package co.cagiral.view.model.drawing;

/**
 * Client that knows how to interact with the different body parts of the Hangman.
 * Based on the Attempts remaining it builds a HangmanDrawing that the view can
 * use to display.
 */
public class HangmanDrawing {

    private final HangmanBodyPart bodyParts;

    private HangmanDrawing(HangmanBodyPart bodyParts) {
        this.bodyParts = bodyParts;
    }

    public void draw() {
        this.bodyParts.draw();
    }

    public static HangmanDrawing getHangmanDrawing(int attempts) {
        return new HangmanDrawing(new HangmanStick());
    }
}
