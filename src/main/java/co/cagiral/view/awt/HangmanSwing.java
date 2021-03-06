package co.cagiral.view.awt;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import co.cagiral.view.HangmanView;
import co.cagiral.view.model.drawing.HangmanDrawing;
import co.cagiral.view.state.HangmanClientState;

public class HangmanSwing implements HangmanView {
	
	public HangmanSwing() {
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(600, 400));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        

        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}

	@Override
	public String getFilePath() {
		return null;
	}

	@Override
	public void drawHangman(HangmanDrawing hangmanDrawing) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void displayMessage(String helpMsg) {

		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void setState(HangmanClientState state) {

		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void showHelp(String helpMsg) {

		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void exit() {
		System.exit(0);
	}
}
