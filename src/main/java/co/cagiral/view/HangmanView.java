package co.cagiral.view;

import co.cagiral.view.model.drawing.HangmanDrawing;
import co.cagiral.view.state.HangmanClientState;

/**
 * Created by cpalacio on 9/4/2015.
 */
public interface HangmanView {

    String getFilePath();

    void drawHangman(HangmanDrawing hangmanDrawing);

    void displayMessage(String helpMsg);

    void setState(HangmanClientState state);

    void showHelp(String helpMsg);

    void exit();
}
