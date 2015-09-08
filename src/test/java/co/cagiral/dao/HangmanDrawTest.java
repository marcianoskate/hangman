package co.cagiral.dao;

import co.cagiral.view.model.drawing.*;

/**
 * Created by cpalacio on 9/8/2015.
 */
public class HangmanDrawTest {

    public static void main(String[] args) {

        HangmanBodyPart bodyParts = new HangmanStick();
        System.out.println("*************");
        System.out.println("drawing stick");
        bodyParts.draw();

        System.out.println("************");
        System.out.println("drawing Head");
        bodyParts.addHead(new HangmanHead());
        bodyParts.draw();

        System.out.println("************");
        System.out.println("drawing Head with left eye");
        bodyParts.addLeftEye(new HangmanEye());
        bodyParts.draw();

        System.out.println("************");
        System.out.println("drawing Head with both eyes");
        bodyParts.addRightEye(new HangmanEye());
        bodyParts.draw();

        System.out.println("************");
        System.out.println("drawing Head with a Nose");
        bodyParts.addNose(new HangmanNose());
        bodyParts.draw();

        System.out.println("************");
        System.out.println("drawing Head with a Mouth");
        bodyParts.addMouth(new HangmanMouth());
        bodyParts.draw();
    }
}

