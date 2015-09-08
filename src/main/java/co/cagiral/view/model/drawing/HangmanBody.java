package co.cagiral.view.model.drawing;

/**
 * Representation of the HangmanStick.
 *
 * This class is in charge of drawing the Stick where the Hangman will hang
 */
public class HangmanBody extends HangmanBodyPart {

    private HangmanBodyPart leftArm;
    private HangmanBodyPart rightArm;
    private HangmanBodyPart leftLeg;
    private HangmanBodyPart rightLeg;

    @Override
    public void addLeftArm(HangmanBodyPart hangmanLeftArm) {
        this.leftArm = hangmanLeftArm;
    }

    @Override
    public void addRightArm(HangmanBodyPart hangmanRightArm) {
        this.rightArm = hangmanRightArm;
    }

    @Override
    public void addLeftLeg(HangmanBodyPart hangmanLeftLeg) {
        this.leftLeg = hangmanLeftLeg;
    }

    @Override
    public void addRightLeg(HangmanBodyPart hangmanRightLeg) {
        this.rightLeg = hangmanRightLeg;
    }

    @Override
    public String draw() {
        StringBuilder stick = new StringBuilder();

        stick.append(" |            |").append("\n"); //neck
        if (rightArm != null) {
            stick.append(rightArm.draw());
        } else if (leftArm != null) {
            stick.append(leftArm.draw());
        } else {

            stick
                    .append(" |            |").append("\n")
                    .append(" |            |").append("\n")
                    .append(" |            |").append("\n")
                    .append(" |            |").append("\n")
            ;
        }

        if (rightLeg != null) {
            stick.append(rightLeg.draw());
        } else if (leftLeg != null) {
            stick.append(leftLeg.draw());
        } else {

            stick
                    .append(" |             ").append("\n")
                    .append(" |             ").append("\n")
                    .append(" |             ").append("\n")
                    .append(" |             ").append("\n")
                    .append("===")
            ;
        }
        stick.append(" |             ").append("\n")
                .append("==="); // Pedestal

        return stick.toString();
    }

}
