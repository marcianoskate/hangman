package co.cagiral.view.model.drawing;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of the HangmanStick.
 *
 * This class is in charge of drawing the Stick where the Hangman will hang
 */
public class HangmanStick extends HangmanBodyPart {

    private List<HangmanBodyPart> bodyParts = new ArrayList<>();

    @Override
    public void add(HangmanBodyPart item) {

        this.bodyParts.add(item);
    }

    @Override
    public String draw() {
        StringBuilder stick = new StringBuilder();
        stick
                .append(" /------------|").append("\n")
                .append(" |            |").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append(" |             ").append("\n")
                .append("===");
        System.out.println(stick.toString());
        return null;
    }
}
