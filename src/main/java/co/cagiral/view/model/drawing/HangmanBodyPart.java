package co.cagiral.view.model.drawing;

//    /------------|
//	 |            |
//	 |          /~~~\
//	 |          |x x|
//   |          | ! |
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
 * Abstract class that defines the functionality that body parts to be drawn have to meet in order to
 * behave as the Composite Pattern
 */
public abstract class HangmanBodyPart {

	public void add(HangmanBodyPart item) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	public String draw() {
		throw new UnsupportedOperationException("Not Implemented");
	}

	public void addHead(HangmanBodyPart hangmanHead) {

		throw new UnsupportedOperationException("Not Implemented");
	}

	public void addLeftEye(HangmanBodyPart eye) {

		throw new UnsupportedOperationException("Not Implemented");
	}

	public void addRightEye(HangmanBodyPart eye) {

		throw new UnsupportedOperationException("Not Implemented");
	}

	public void addNose(HangmanBodyPart hangmanNose) {

		throw new UnsupportedOperationException("Not Implemented");
	}

	public void addMouth(HangmanBodyPart hangmanMouth){

		throw new UnsupportedOperationException("Not Implemented");
	}

	public void addBody(HangmanBodyPart hangmanBody) {

		throw new UnsupportedOperationException("Not Implemented");
	}

	public void addLeftArm(HangmanBodyPart hangmanLeftArm) {

		throw new UnsupportedOperationException("Not Implemented");
	}

	public void addRightArm(HangmanBodyPart hangmanRightArm) {

		throw new UnsupportedOperationException("Not Implemented");
	}

	public void addLeftLeg(HangmanBodyPart hangmanLeftLeg) {

		throw new UnsupportedOperationException("Not Implemented");
	}

	public void addRightLeg(HangmanBodyPart hangmanRightLeg) {

		throw new UnsupportedOperationException("Not Implemented");
	}
}
