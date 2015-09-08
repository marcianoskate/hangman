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
        Builder builder = new Builder();

        if (attempts > 10 || attempts < 0) {
            throw new RuntimeException("The number of attempts must be between 0 and 10");
        }

        if (attempts <= 9) {
            builder.withHead();
        }
        if (attempts <= 8) {
            builder.withLeftEye();
        }
        if (attempts <= 7) {
            builder.withRightEye();
        }
        if (attempts <= 6) {
            builder.withNose();
        }
        if (attempts <= 5) {
            builder.withMouth();
        }
        if (attempts <= 4) {
            builder.withBody();
        }
        if (attempts <= 3) {
            builder.withLeftArm();
        }
        if (attempts <= 2) {
            builder.withRightArm();
        }
        if (attempts <= 1) {
            builder.withLeftLeg();
        }
        if (attempts <= 0) {
            builder.withRightLeg();
        }
        return builder.build();
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

        public Builder withRightEye() {
            drawing.addRightEye(new HangmanEye());
            return this;
        }

        public Builder withNose() {
            drawing.addNose(new HangmanNose());
            return this;
        }

        public Builder withMouth() {
            drawing.addMouth(new HangmanMouth());
            return this;
        }

        public Builder withBody() {
            drawing.addBody(new HangmanBody());
            return this;
        }

        public Builder withLeftArm() {
            drawing.addLeftArm(new HangmanLeftArm());
            return this;
        }

        public Builder withRightArm() {
            drawing.addRightArm(new HangmanRightArm());
            return this;
        }

        public HangmanDrawing build() {
            return new HangmanDrawing(this);
        }

        public Builder withLeftLeg() {
            drawing.addLeftLeg(new HangmanLeftLeg());
            return this;
        }

        public Builder withRightLeg() {
            drawing.addRightLeg(new HangmanRightLeg());
            return this;
        }
    }
}
