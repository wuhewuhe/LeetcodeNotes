package LinkedList;

import java.util.NoSuchElementException;

public class DesignDoubleLinkedList<E> {
	class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

	private Node<E> first, last;
	private int size;

	public DesignDoubleLinkedList() {
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E getFirst() {
		final Node<E> f = first;
		if (f == null)
			throw new NoSuchElementException();
		return f.item;
	}

	public E getLast() {
		final Node<E> l = last;
		if (l == null)
			throw new NoSuchElementException();
		return l.item;
	}

	public void addFirst(E element) {
		final Node<E> f = first;
		final Node<E> newNode = new Node<>(null, element, f);
		first = newNode;
		if (f == null) {
			last = newNode;
		} else {
			f.prev = newNode;
		}
		size++;
	}

	public void addLast(E element) {
		final Node<E> l = last;
		final Node<E> newNode = new Node<>(l, element, null);
		last = newNode;
		if (l == null) {
			first = newNode;
		} else {
			l.next = newNode;
		}
	}

	public void add(E e) {
		addLast(e);
	}

	E unlink(Node<E> x) {
		// assert x != null;
		final E element = x.item;
		final Node<E> next = x.next;
		final Node<E> prev = x.prev;

		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			x.prev = null;
		}

		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}

		x.item = null;
		size--;
		return element;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (Node<E> x = first; x != null; x = x.next) {
				if (x.item == null) {
					unlink(x);
					return true;
				}
			}
		} else {
			for (Node<E> x = first; x != null; x = x.next) {
				if (o.equals(x.item)) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		DesignDoubleLinkedList<Integer> d = new DesignDoubleLinkedList<Integer>();
		d.addFirst(1);
		d.addLast(2);
		d.add(3);
		d.addFirst(0);
	}
}
