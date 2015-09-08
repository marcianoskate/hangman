package co.cagiral.view.model.drawing;

/**
 * Created by cpalacio on 9/8/2015.
 */
public class HangmanDrawTest {

    public static void main(String[] args) {

//        byHand();
        usingBuilder();
    }

    private static void usingBuilder() {

        System.out.println("*************");
        System.out.println("drawing 10 attemmpts");
        HangmanDrawing.getHangmanDrawing(10).draw();
        System.out.println("drawing 9 attemmpts");
        HangmanDrawing.getHangmanDrawing(9).draw();
        System.out.println("drawing 8 attemmpts");
        HangmanDrawing.getHangmanDrawing(8).draw();
        System.out.println("drawing 7 attemmpts");
        HangmanDrawing.getHangmanDrawing(7).draw();
        System.out.println("drawing 6 attemmpts");
        HangmanDrawing.getHangmanDrawing(6).draw();
        System.out.println("drawing 5 attemmpts");
        HangmanDrawing.getHangmanDrawing(5).draw();
        System.out.println("drawing 4 attemmpts");
        HangmanDrawing.getHangmanDrawing(4).draw();
        System.out.println("drawing 3 attemmpts");
        HangmanDrawing.getHangmanDrawing(3).draw();
        System.out.println("drawing 2 attemmpts");
        HangmanDrawing.getHangmanDrawing(2).draw();
        System.out.println("drawing 1 attemmpts");
        HangmanDrawing.getHangmanDrawing(1).draw();
        System.out.println("drawing 0 attemmpts");
        HangmanDrawing.getHangmanDrawing(0).draw();
    }

    private static void byHand() {
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

