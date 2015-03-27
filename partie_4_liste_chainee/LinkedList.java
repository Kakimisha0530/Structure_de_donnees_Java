package partie_4_liste_chainee;

import java.util.*;

/**
 * This class represent a LinkedList
 * 
 * @author admin
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T> {
	private Node<T> head;
	private int count = 0;

	/**
	 * Constructs an empty list
	 */
	public LinkedList() {
		head = null;
	}
	
	public int size(){
		return count;
	}

	/**
	 * Returns true if the list is empty
	 *
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Inserts the specified node at the beginning of this list.
	 *
	 */
	public void addFirst(T item) {
		head = new Node<T>(item, head);
		count ++;
	}

	/**
	 * Inserts a new node to the end of this list.
	 *
	 */
	public void addLast(T item) {
		if (isEmpty())
			addFirst(item);
		else {
			Node<T> tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;

			tmp.next = new Node<T>(item, null);
			count ++;
		}
	}

	/**
	 * Returns the first element in the list.
	 *
	 */
	public T peekFirst() {
		if (isEmpty())
			return null;

		return head.data;
	}

	/**
	 * Returns the last element in the list.
	 *
	 */
	public T peekLast() {
		if (isEmpty())
			return null;

		Node<T> tmp = head;
		while (tmp.next != null)
			tmp = tmp.next;

		return tmp.data;
	}

	/**
	 * Returns the data at the specified position in the list.
	 *
	 */
	public T get(int pos) {
		if (isEmpty())
			throw new IndexOutOfBoundsException();

		Node<T> tmp = head;
		for (int k = 0; k < pos; k++)
			tmp = tmp.next;

		if (tmp == null)
			throw new IndexOutOfBoundsException();

		return tmp.data;
	}

	/**
	 * Removes the first element in the list.
	 *
	 */
	public T pop() {
		T tmp = poll();
		if (tmp == null)
			throw new NoSuchElementException();
		count --;
		return tmp;
	}
	
	public T poll(){
		T tmp = peekFirst();
		if(tmp == null)
			return null;
		head = head.next;
		count --;
		return tmp;
	}

	/**
	 * Removes all nodes from the list.
	 *
	 */
	public void clear() {
		head = null;
		count = 0;
	}

	/**
	 * Returns true if this list contains the specified element.
	 *
	 */
	public boolean contains(T x) {
		for (T tmp : this)
			if (tmp.equals(x))
				return true;

		return false;
	}

	/**
	 * Returns a string representation
	 *
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (Object x : this)
			result.append("[" + x + "] ");

		return result.toString();
	}

	/**
	 * Removes the first occurrence of the specified element in this list.
	 *
	 */
	public void remove(T key) {
		if (head == null)
			throw new RuntimeException("cannot delete");

		if (head.data.equals(key)) {
			head = head.next;
			return;
		}

		Node<T> cur = head;
		Node<T> prev = null;

		while (cur != null && !cur.data.equals(key)) {
			prev = cur;
			cur = cur.next;
		}

		if (cur == null)
			throw new RuntimeException("cannot delete");

		// delete cur node
		prev.next = cur.next;
		count --;
	}
	
	/**
	 * Remove the element at the specified index.
	 */
	public T remove(int index){
		T tmp = get(index);
		remove(tmp);
		return tmp;
	}


	/*******************************************************
	 *
	 * The Node class
	 *
	 ********************************************************/
	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	/*******************************************************
	 *
	 * The Iterator class
	 *
	 ********************************************************/

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<T> {
		private Node<T> nextNode;

		public LinkedListIterator() {
			nextNode = head;
		}

		public boolean hasNext() {
			return nextNode != null;
		}

		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T res = nextNode.data;
			nextNode = nextNode.next;
			return res;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}