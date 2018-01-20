
public interface BinaryTree<E> extends Tree<E> {
	
	//Returns positions, or null if it doesn't exist
	
	Position<E> left(Position<E> p) throws IllegalArgumentException;
	Position<E> right(Position<E> p) throws IllegalArgumentException;
	Position<E> siblings(Position<E> p) throws IllegalArgumentException;
}
