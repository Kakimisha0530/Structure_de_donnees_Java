package partie_3_tableau;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class to represent a ArrayList.
 * 
 * @author DIAKITE AICHA
 *
 * @param <T>
 */
public class ArrayList<T> implements Iterable<T>
{
	static final int DEFAULT_CAPACITY = 10;
	private T[] data;
	private int size = 0;

	@SuppressWarnings("unchecked")
	public ArrayList()
	{
		this.data = (T[]) new Object[DEFAULT_CAPACITY];
	}

	/**
	 * This method return the number of elements contained in the list.
	 * 
	 * @return
	 */
	public int size()
	{
		return size;
	}

	/**
	 * this method add a new element to the list after checking and adjusting
	 * the size of the list.
	 * 
	 * @param e
	 *            : the new element to add to the list
	 */
	public void add(T e)
	{
		ensureCapacity();
		data[size] = e;
		size++;
	}

	/**
	 * return the element at the specified index.<br>
	 * Or throw an exception if the given index is out of bounds.
	 * 
	 * @param i
	 * @return
	 */
	public T get(int i)
	{
		if (i >= 0 && i < size)
			return data[i];
		else
			throw new IndexOutOfBoundsException();
	}

	/**
	 * Return the first index of the specified object , or -1 if the object
	 * doesn't exist in the table.
	 * 
	 * @param o
	 *            : the element to search for.
	 * @return
	 */
	public int indexOf(Object o)
	{
		int i = 0;
		while (size > 0 && i < size && !o.equals(data[i]))
			i++;
		return (i < size) ? i : -1;
	}

	/**
	 * Remove the element at the given index.<br>
	 * Or throw an exception if the given index is out of bounds.
	 * 
	 * @param index
	 * @return
	 */
	public T remove(int index)
	{
		if(index >= 0 && index < size){
			T obj = get(index);
			for(int i = index ; i < size ; i++){
				data[i] = (i + 1 < size)?data[i + 1] : null;
			}
			//System.out.println(toString());
			size--;
			return obj;
		}
		else
			throw new IndexOutOfBoundsException();
	}

	/**
	 * Remove the first occurrence of the specified object.
	 * 
	 * @param o : the object to be removed
	 * @return
//	 */
	public boolean remove(Object o)
	{
		if(o != null){
			int i = indexOf(o);
			if(i >= 0){
				remove(i);
			}
			return i >= 0 ;
		}
		
		return false;
	}

	/**
	 * This method check if the capacity of the table is enough to receive new
	 * object.<br>
	 * Else the actual table is replaced by new one with increased size , where
	 * the old one is copied.
	 */
	@SuppressWarnings("unchecked")
	private void ensureCapacity()
	{
		if (size >= data.length)
		{
			T[] temp = data;
			this.data = (T[]) new Object[temp.length + DEFAULT_CAPACITY];
			for (int i = 0; i < temp.length; i++)
				data[i] = temp[i];
		}
	}

	/**
	 * Return a string representing the object
	 */
	public String toString()
	{
		String str = "[";
		for (int i = 0; i < size; i++)
			str += data[i].toString() + ",";
		str = str.substring(0, (str.lastIndexOf(',')));
		str += "]";
		return str;
	}
	
	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<T> {
		private T nextElt;
		private int pos = 0;

		public ArrayListIterator() {
			if(size > 0)
				nextElt = data[pos];
			else
				nextElt = null;
		}

		public boolean hasNext() {
			try {
				get(pos + 1);
			} catch (IndexOutOfBoundsException e) {
				return false;
			}
			return true;
		}

		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T res = nextElt;
			nextElt = get(++pos);
			return res;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}