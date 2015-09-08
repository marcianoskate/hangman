package co.cagiral.view.model.drawing;

//    /------------|
//	 |            |
//	 |          /~~~\
//	 |          |x x|
//	 |          \_~_/
//	 |            |
//	 |           /|\
//	 |          / | \
//	 |         /  |  \
//	 |           / \
//	 |          /   \
//	 |        _/     \_
//	 |
//	===

/**
 * Abstract class that defines the body parts to be drawn as a Composite Pattern
 */
public abstract class HangmanBodyPart {

	public void add(HangmanBodyPart item) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	public String draw() {
		throw new UnsupportedOperationException("Not Implemented");
	}

}
