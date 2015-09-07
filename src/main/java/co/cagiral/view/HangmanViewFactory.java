package co.cagiral.view;

import co.cagiral.view.console.HangmanConsole;

public class HangmanViewFactory {

	public static HangmanView console() {
		return new HangmanConsole();
	}

}
