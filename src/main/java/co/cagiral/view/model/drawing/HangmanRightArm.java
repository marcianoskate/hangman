package co.cagiral.view.model.drawing;

/**
 * Created by cpalacio on 9/8/2015.
 */
public class HangmanRightArm extends HangmanBodyPart {

    //
//        //Right Arm
//        System.out.println("|           /|\\");
//        System.out.println("|          / |  \\");
//        System.out.println("|         /  |   \\");

    @Override
    public String draw() {
        StringBuilder stick = new StringBuilder();
        stick
                .append(" |           /|\\").append("\n")
                .append(" |          / | \\").append("\n")
                .append(" |         /  |  \\").append("\n")
                .append(" |            |").append("\n")
                ;

        return stick.toString();
    }
}
