

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

	protected BTNode<E> createNode(String s, BTNode<E> u, BTNode<E> v, BTNode<E> w) {
		return new BTNode<E>(s, u, v, w);
	}

	protected BTNode<E> root = null;
	private int size = 0;

	// Constructor
	public LinkedBinaryTree() {
		// Creates an Empty BT
	}

	protected BTNode<E> validate(Position<E> p) throws IllegalArgumentException {
		// Check type
		// Then cast
		// Check if it is no longer in the tree
		if (!(p instanceof BTNode)) {
			throw new IllegalArgumentException("Not a Valid Position Type");
		}

		BTNode<E> node = (BTNode<E>) p;

		if (node.getParent() == node) {
			throw new IllegalArgumentException("This node is no longer in the tree");
		}
		// Passes both tests, so return
		return node;
	}

	public int size() {
		return size;
	}

	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		// Check if it is valid
		// then return
		BTNode<E> node = validate(p);
		return node.getLeft();
	}

	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		BTNode<E> node = validate(p);
		return node.getRight();
	}

	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		BTNode<E> node = validate(p);
		return node.getParent();
	}

	public Position<E> root() {
		return root;
	}

	public Position<E> addRoot(E e) throws IllegalStateException, IllegalArgumentException {
		if (!(isEmpty())) {
			throw new IllegalStateException("Tree is not empty");
		}
		if (!(e instanceof String)) {
			throw new IllegalArgumentException("Element was not as string");
		}
		String word = (String) e;
		root = createNode(word, null, null, null);
		size = 1;
		return root;
	}

	// P is the parent, trying to add to it child e
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
		BTNode<E> parent = validate(p);
		if (parent.getLeft() != null) {
			throw new IllegalArgumentException("p already has a left child");
		}
		if (!(e instanceof String)) {
			throw new IllegalArgumentException("Element was not as string");
		}
		String word = (String) e;
		BTNode<E> child = createNode(word, parent, null, null);
		child.increaseWordCounter();
		parent.setLeft(child);
		size++;
		return child;
	}

	// P is the Parent, add child to the right
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
		BTNode<E> parent = validate(p);
		if (parent.getRight() != null) {
			throw new IllegalArgumentException("p already has a right child");
		}
		if (!(e instanceof String)) {
			throw new IllegalArgumentException("Element was not as string");
		}
		String word = (String) e;
		BTNode<E> child = createNode(word, parent, null, null);
		child.increaseWordCounter();
		parent.setRight(child);
		size++;
		return child;
	}

	public String set(Position<E> p, E e) throws IllegalArgumentException {
		BTNode<E> node = validate(p);
		String temp = node.element();
		if (!(e instanceof String)) {
			throw new IllegalArgumentException("Element was not as string");
		}
		String word = (String) e;
		node.resetWord(word, node.getWordCounter());
		return temp;
	}

	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
		BTNode<E> node = validate(p);
		if (isInternal(node)) {
			throw new IllegalArgumentException("Not An External Node");
		}

		size = size + (t1.size + t2.size);

		if (!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}

		if (!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t1.root);
			t2.root = null;
			t2.size = 0;
		}
	}

	public String remove(Position<E> p) throws IllegalArgumentException {
		BTNode<E> node = validate(p);

		if (numChildren(p) == 2) {
			throw new IllegalArgumentException("There are 2 Children");
		}
		BTNode<E> child;
		if (left(p) != null) {
			child = node.getLeft();
		} else {
			child = node.getRight();
		}

		if (child != null) {
			child.setParent(node.getParent());
			// Links the child to the grandparent
		}
		if (node == root) {
			root = child;
		} else {
			BTNode<E> parent = node.getParent();
			if (node == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}
		size--;		//Removing 1 element
		String temp = node.element();
		node.resetWord(null, 0);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		return temp;
	}

}
