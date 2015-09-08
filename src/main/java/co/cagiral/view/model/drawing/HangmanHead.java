package co.cagiral.view.model.drawing;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of the HangmanStick.
 *
 * This class is in charge of drawing the Stick where the Hangman will hang
 */
public class HangmanHead extends HangmanBodyPart {

    private HangmanBodyPart leftEye;
    private HangmanBodyPart rightEye;
    private HangmanBodyPart nose;
    private HangmanBodyPart mouth;

    @Override
    public void addLeftEye(HangmanBodyPart eye) {
        this.leftEye = eye;
    }

    @Override
    public void addRightEye(HangmanBodyPart eye) {
        this.rightEye = eye;
    }

    @Override
    public void addNose(HangmanBodyPart hangmanNose) {
        this.nose = hangmanNose;
    }

    @Override
    public void addMouth(HangmanMouth hangmanMouth) {
        this.mouth = hangmanMouth;
    }

    @Override
    public String draw() {
        StringBuilder stick = new StringBuilder();
        stick
                .append(" |          /~~~\\").append("\n")
                .append(" |          |").append(eye(leftEye)).append(" ").append(eye(rightEye)).append("|").append("\n")
                .append(" |          | ").append(aNose(this.nose)).append(" |").append("\n")
                .append(" |          \\_").append(aMouth(this.mouth)).append("_/").append("\n")
        ;
        return stick.toString();
    }

    private String eye(HangmanBodyPart leftEye) {
        return leftEye == null ? " " : leftEye.draw();
    }

    private String aNose(HangmanBodyPart nose) {
        return nose == null ? " " : nose.draw();
    }

    private String aMouth(HangmanBodyPart mouth) {
        return mouth == null ? "_" : mouth.draw();
    }
}
