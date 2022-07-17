package telran.list.model;

import java.util.Iterator;

import telran.list.interfaces.IList;

public class MyLinkedList<E> implements IList<E> {
	private Node<E> first;
	private Node<E> last;
	private int size;

	// O(n)
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			Node<E> node = first;

			@Override
			public boolean hasNext() {
				boolean res = node != null;
				return res;
			}

			@Override
			public E next() {
				E res = node.data;
				node = node.next;
				return res;
			}

		};
	}

	// O(1)
	@Override
	public boolean add(E element) {
		Node<E> newNode = new Node<E>(last, element, null);
		if (last != null) {
			last.next = newNode;
		} else {
			first = newNode;
		}
		last = newNode;
		size++;
		return true;
	}

	// O(1)
	@Override
	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	// O(1)
	@Override
	public int size() {
		return size;
	}

	// O(1)
	@Override
	public boolean add(int index, E element) {
		if (index == size) {
			add(element);
			return true;
		}
		checkIndex(index);
		Node<E> next = getNodeByIndex(index);
		Node<E> prev = getNodeByIndex(index).prev;
		Node<E> node = new Node<E>(prev, element, next);
		if (index == 0) {
			first.prev = node;
			first = node;
		} else {
			prev.next = node;
		}
		// if (index != size - 1) {
		next.prev = node;
		size++;
		// } else {
		// add(element);
		// }
		return true;
	}

	// O(n)
	@Override
	public E get(int index) {
		Node<E> node = getNodeByIndex(index);
		return node.data;
	}

	// O(n)
	private Node<E> getNodeByIndex(int index) {
		checkIndex(index);
		if (size / index > 2) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;

		}
	}
	// O(1)
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}

	}

	// O(n)
	@Override
	public int indexOf(Object o) {
		int index = 0;
		if (o != null) {
			for (Node<E> x = first; x != null; x = x.next, index++) {
				if (o.equals(x.data)) {
					return index;
				}
			}
		} else {
			for (Node<E> x = first; x != null; x = x.next, index++) {
				if (o == x.data) {
					return index;
				}
			}
		}
		return -1;
	}

	// O(n)
	@Override
	public int lastIndexOf(Object o) {
		int index = size - 1;
		if (o != null) {
			for (Node<E> x = last; x != null; x = x.prev, index--) {
				if (o.equals(x.data)) {
					return index;
				}
			}
		} else {
			for (Node<E> x = last; x != null; x = x.prev, index--) {
				if (o == x.data) {
					return index;
				}
			}
		}
		return -1;
	}

	// O(1)
	@Override
	public E remove(int index) {
		Node<E> node = getNodeByIndex(index);
		return unlink(node);
	}

	// O(1)
	private E unlink(Node<E> node) {
		E victim = node.data;
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		if (prev != null) {
			prev.next = next;
			node.prev = null;
		} else {
			first = next;
		}
		if (next != null) {
			next.prev = prev;
			node.next = null;
		} else {
			last = prev;
		}
		node.data = null;
		size--;
		return victim;
	}

	// O(n)
	@Override
	public E set(int index, E element) {
		Node<E> node = getNodeByIndex(index);
		E victim = node.data;
		node.data = element;
		return victim;
	}

	// O(1)
	private static class Node<E> {
		Node<E> prev;
		E data;
		Node<E> next;

		public Node(Node<E> prev, E data, Node<E> next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
	}

}
