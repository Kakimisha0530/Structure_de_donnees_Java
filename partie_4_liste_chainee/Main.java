package partie_4_liste_chainee;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("y");
		list.addFirst("a");
		list.addFirst("k");
		list.addFirst("o");
		System.out.println("SIZE : " + list.size());
		System.out.println(list);

		System.out.println(list.get(0));
		//System.out.println(list.get(4)); // exception

		list.addLast(" ! ");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println();

		list.remove("a");
		list.remove("y");
		System.out.println(list);
		System.out.println("SIZE : " + list.size());
		
		//list.pop();
		System.out.println(list.pop());
		
		//list.poll();
		System.out.println(list.poll());
		
		//list.pop();
		System.out.println(list.poll());
		
		//list.pop();//exception
	}
}
