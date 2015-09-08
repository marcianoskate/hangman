package co.cagiral.view.model.drawing;

/**
 * Client that knows how to interact with the different body parts of the Hangman.
 * Based on the Attempts remaining it builds a HangmanDrawing that the view can
 * use to display.
 */
public class HangmanDrawing {

    private final HangmanBodyPart drawing;

    private HangmanDrawing(HangmanBodyPart bodyParts) {
        this.drawing = bodyParts;
    }

    public HangmanDrawing(Builder builder) {

        this.drawing = builder.drawing;
    }

    public void draw() {
        this.drawing.draw();
    }

    public static HangmanDrawing getHangmanDrawing(int attempts) {
        return new HangmanDrawing(new HangmanStick());
    }

    public static class Builder {

        HangmanBodyPart drawing;

        public Builder() {
            drawing = new HangmanStick();
        }

        public Builder withHead() {
            drawing.addHead(new HangmanHead());
            return this;
        }

        public Builder withLeftEye() {
            drawing.addLeftEye(new HangmanEye());
            return this;
        }

        public HangmanDrawing build() {
            return new HangmanDrawing(this);
        }
    }
}
