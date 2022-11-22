package BinarySearchandRelatedQuestion;

public class PeakElement {
	
	public static int findPeak(int a[])
	{
		int start = 0;
		int end = a.length - 1;
		
		while(start <=  end)
		{
			int mid = start + (end - start)/2;
			
			if(mid > 0 && mid < a.length -1)
			{
				if(a[mid] > a[mid - 1] && a[mid] > a[mid + 1])
					return mid;
				else if(a[mid -1] > a[mid])
				{
					end = mid -1;
				}
				else
					start = mid + 1;
			}
			else if(mid == 0)
			{
				if(a[0] > a[1])
					return 0;
				else
					return 1;
			}
			else if(mid == a.length -1)
			{
				if(a[a.length-1] > a[a.length-2])
					return (a.length-1);
			}
		}
		
		
		return -1;
	}
	
	public static void main(String [] args)
	{
		int a[] = { 1,2,1,3,5,6,4 };
		System.out.println("Peak element at index = "+ findPeak(a));
		
	}

}
