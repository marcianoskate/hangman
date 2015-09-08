package co.cagiral.view;

import co.cagiral.view.awt.HangmanSwing;
import co.cagiral.view.console.HangmanConsole;

public class HangmanViewFactory {

	public static HangmanView console(String filePath) {
		return new HangmanConsole(filePath);
	}

	public static HangmanView swing() {

		return new HangmanSwing();
	}
}
