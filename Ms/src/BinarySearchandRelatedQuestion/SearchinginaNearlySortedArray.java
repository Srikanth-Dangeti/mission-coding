package BinarySearchandRelatedQuestion;

public class SearchinginaNearlySortedArray {

	
	public static int searchinnearlysorted(int a[], int key)
	{
		if(a ==  null || a.length ==0)
			return -1;
		
		int start = 0;
		int end = a.length - 1;
		
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			
			if(key== a[mid])
			{
				return mid;
			}
			if(mid > start && a[mid -1] == key)
				return (mid-1);
			if(mid < end && a[mid+1] == key)
				return (mid+1);
			if(key < a[mid])
			{
				end = mid - 2;
			}
			else
				start  = mid + 2;
		}

		return -1;
	}
	
	public static void main(String [] args)
	{
		int a[] = {5, 10, 30, 20, 40};
		int key = 20;
		
		System.out.println("Found at index = "+searchinnearlysorted(a, key));
		
	}
}
