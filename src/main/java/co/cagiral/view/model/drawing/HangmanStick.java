package co.cagiral.view.model.drawing;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of the HangmanStick.
 *
 * This class is in charge of drawing the Stick where the Hangman will hang
 */
public class HangmanStick extends HangmanBodyPart {

    private HangmanBodyPart head;

    @Override
    public void addHead(HangmanBodyPart hangmanHead) {
        this.head = hangmanHead;
    }

    @Override
    public void addLeftEye(HangmanBodyPart eye) {
        if (head == null) {
            throw new RuntimeException("Can't add Left Eye without a Head");
        }
        head.addLeftEye(eye);
    }

    @Override
    public void addRightEye(HangmanBodyPart eye) {
        if (head == null) {
            throw new RuntimeException("Can't add Right Eye without a Head");
        }
        head.addRightEye(eye);

    }

    @Override
    public void addNose(HangmanBodyPart hangmanNose) {
        if (head == null) {
            throw new RuntimeException("Can't add Nose without a Head");
        }
        head.addNose(hangmanNose);
    }

    @Override
    public void addMouth(HangmanMouth hangmanMouth) {
        if (head == null) {
            throw new RuntimeException("Can't add Nose without a Head");
        }
        head.addMouth(hangmanMouth);
    }

    @Override
    public String draw() {
        StringBuilder stick = new StringBuilder();
        stick
                .append(" /------------|").append("\n")
                .append(" |            |").append("\n");
        if (head != null) {
            stick.append(head.draw());
        } else {
            stick.append(" |             ").append("\n")
                    .append(" |             ").append("\n")
                    .append(" |             ").append("\n")
            ;
        }

        stick.append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append("===");
        System.out.println(stick.toString());
        return stick.toString();
    }
}
