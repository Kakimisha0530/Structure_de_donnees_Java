package partie_3_tableau;

import java.util.Iterator;

import general.Point;

/**
 * Example of use of my ArrayList class
 * 
 * @author admin
 *
 */
public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Point> test = new ArrayList<Point>();
		for (int i = 0; i < 5; i++)
			test.add(new Point(0, i % 2));
		System.out.println(test.size());
		System.out.println(test.get(2));
		
		System.out.println(test.indexOf(new Point(0, 1)));
		
		System.out.println("initial list : " + test);
		
		System.out.print("[");
		Iterator<Point> itr = test.iterator();
		while (itr.hasNext())
			System.out.print(itr.next() + ",");
		System.out.print("]");
		System.out.println();
		
		test.remove(2);
		System.out.println("after removing third element : " + test);
		test.remove(new Point(0, 0));
		System.out.println("after removing the first Point(0,0) : " + test);
	}
}
