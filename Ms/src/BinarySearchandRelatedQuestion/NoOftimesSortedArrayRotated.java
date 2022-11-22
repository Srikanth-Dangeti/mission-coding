package BinarySearchandRelatedQuestion;

public class NoOftimesSortedArrayRotated {
	
	
	public static int noOftimesarrayRotated(int a[])
	{
		if(a ==  null || a.length == 0)
			return -1;
		
		int n = a.length;
		int start = 0;
		int end = a.length - 1;
		
		while(start <= end)
		{
			 if(a[start] <= a[end])
			 {
                 return start;
             }
			int mid = start + (end - start)/2;
			System.out.println("mid = "+mid);
			int next = (mid+1)%n;
			int prev = (mid-1+n)%n;
			System.out.println("next = "+next);
			System.out.println("prev = "+prev);
			if(a[mid] <= a[next] && a[mid] <= a[prev])
			{
				return mid;
			}
			if(a[start] <= a[mid])
			{
				start =  mid + 1;
			}
			else if(a[mid] <= a[end]) 
			{
				end =  mid - 1;
			}
		}
		
		
		return -1;
	}
	
	public static void main(String []args)
	{
		int a [] = {11, 12, 15, 18, 2, 5, 6, 8};
		System.out.println("No Of times an Array Roated = "+noOftimesarrayRotated(a));
		
	}

}
