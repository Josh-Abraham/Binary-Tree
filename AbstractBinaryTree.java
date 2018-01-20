
/**************************
 * 						  *
 *  Second Class: ABT     *
 *                        *
 * 						  *
 **************************/
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

	// Return the Position of the Siblings
	public Position<E> siblings(Position<E> p) {
		// If it is the Root it has no children
		// Binary tree, so at max two children
		// Meaning can only return the opposite child

		Position<E> parent = parent(p);

		if (parent == null) {
			return null; // Case 1: The Root
		}
		if (p == left(parent)) {
			return right(parent);
		} else {
			return left(parent);
		}
	}

	public int numChildren(Position<E> p) {
		// Can Either be 1 or 2 children

		int numOfChildren = 0;
		if (left(p) != null) {
			numOfChildren++;
		}
		if (right(p) != null) {
			numOfChildren++;
		}
		return numOfChildren;
	}

	public Iterable<Position<E>> children(Position<E> p) {
		List<Position<E>> tempList = new ArrayList<Position<E>>(2);
		// The 2 states max Capacity
		if (left(p) != null) {
			tempList.add(left(p));
		}
		if (right(p) != null) {
			tempList.add(right(p));
		}

		return tempList;
	}

	public Iterable<Position<E>> inorder() {
		List<Position<E>> positions = new ArrayList<Position<E>>();

		if (!isEmpty()) {
			inOrder(root(), positions);
		}
		return positions;
	}

	private void inOrder(Position<E> p, List<Position<E>> positions) {
		if (left(p) != null) {
			inOrder(left(p), positions);
		}
		positions.add(p);
		if (right(p) != null) {
			inOrder(right(p), positions);
		}
	}

	public Iterable<Position<E>> positions() {
		return inorder();
	}
}
