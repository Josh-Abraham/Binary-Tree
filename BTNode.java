
/**************************
 * 						  *
 *  By: Joshua Abraham    *
 *                        *
 * 						  *
 **************************/

public class BTNode<E> implements Position<E> {
	private String word;
	int wordCounter = 0;
	BTNode<E> left, right, parent;

	// u = parent
	// v = left
	// w = right
	public BTNode(String s, BTNode<E> u, BTNode<E> v, BTNode<E> w) {
		word = s;
		word = element();
		parent = u;
		left = v;
		right = w;

	}

	public String element() {
		word = word.toLowerCase();
		String[] words = word.replaceAll("[^a-z]", "").toLowerCase().split("\\s+");
		word = "";
		for (int x = 0; x < words.length; x++) {
			word = word + words[x];
		}
		return word;
	}

	public int getWordCounter() {
		return wordCounter;
	}

	public void increaseWordCounter() {
		wordCounter++;
	}

	public BTNode<E> getLeft() {
		return left;
	}

	public void setLeft(BTNode<E> v) {
		left = v;
	}

	public BTNode<E> getRight() {
		return right;
	}

	public void setRight(BTNode<E> v) {
		right = v;
	}

	public BTNode<E> getParent() {
		return parent;
	}

	public void setParent(BTNode<E> v) {
		parent = v;
	}

	public void resetWord(String input, int newCount) {
		word = input;
		wordCounter = newCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getElement() throws IllegalStateException {
		// TODO Auto-generated method stub
		return (E) word;
	}

}