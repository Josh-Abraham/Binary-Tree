

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {

	public boolean isInternal(Position<E> p) {
		return (numChildren(p) > 0);
		// Returns true if p which is an elment, if it has more than 0 children
	}

	public boolean isExternal(Position<E> p) {
		return (numChildren(p) == 0);
	}

	public boolean isRoot(Position<E> p) {
		return (p == root());
	}

	public boolean isEmpty() {
		return size() == 0;
	}
	
	
	public Iterator<E> iterator() {
		Iterable<Position<E>> positions = positions();
		List<E> elements = new ArrayList<E>(size());
		for (Position<E> p : positions) {
			elements.add(p.getElement());
		}
		return elements.iterator();
	}

}
