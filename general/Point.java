package general;

/**
 * 
 * @author admin
 *
 */

public class Point
{
	private int x,y;
	
	public Point(int x , int y){
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	@Override
	public boolean equals(Object obj)
	{
		Point other = (Point) obj;
		return (obj != null && getClass() == obj.getClass() && x == other.x && y == other.y);
	}

	@Override
	public String toString()
	{
		return "(" + x + "," + y  + ")";
	}
	
	
}
