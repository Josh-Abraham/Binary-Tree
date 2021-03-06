
import java.util.Iterator;

public interface Tree<E> extends Iterable<E>{
	Position<E> root();
	Position<E> parent(Position <E> p) throws IllegalArgumentException;
	Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
	
	int numChildren(Position <E> p) throws IllegalArgumentException;
	
	//Checking whether it is a root, internal, or external
	boolean isExternal(Position<E> p) throws IllegalArgumentException;
	boolean isInternal(Position<E> p) throws IllegalArgumentException;
	boolean isRoot(Position<E> p) throws IllegalArgumentException;
	boolean isEmpty();
	
	int size();
	
	Iterator<E> iterator();
	Iterable<Position<E>> positions();
}
