package Arrays;


public class Minimumstepscoversequenceofpoints {
	
	
	class Point{
		
		int x, y;
		Point(int x, int y)
		{
			this.x = x;
			this.y = y;
			
		}
	
	}
	
	public static int shorestPath(Point p1, Point p2)
	{
		
		 // dx is total horizontal 
	    // distance to be covered 
	    int dx = Math.abs(p1.x - p2.x); 
	  
	    // dy is total vertical 
	    // distance to be covered 
	    int dy = Math.abs(p1.y - p2.y); 
	  
	    // required answer is 
	    // maximum of these two 
	    return Math.max(dx, dy); 
	}
	public static int coverPoints(Point sequence[], int n)
	{
		int stepCount = 0;
		
		for(int i =0; i < n -1; i++)
		{
			stepCount += shorestPath(sequence[i],sequence[i+1]);
		}
		return stepCount;
	}
	
	public static void main(String args[]) 
	{ 
	    // arr stores sequence of points 
	    // that are to be visited 
		Minimumstepscoversequenceofpoints A= new Minimumstepscoversequenceofpoints();
		Point arr[] = new Point[4]; 
	    arr[0] = A.new Point(4, 6); 
	    arr[1] = A.new Point(1, 2); 
	    arr[2] = A.new Point(4, 5); 
	    arr[3] = A.new Point(10, 12); 
	  
	    int n = arr.length; 
	    System.out.print(coverPoints(arr, n)); 
	} 
	

}
