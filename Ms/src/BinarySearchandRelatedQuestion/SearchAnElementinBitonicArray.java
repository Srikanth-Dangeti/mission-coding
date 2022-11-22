package BinarySearchandRelatedQuestion;

public class SearchAnElementinBitonicArray {
	
	public static int  binarySearchAsc(int a[], int start, int end, int key)
	{
		
		if(a == null || a.length ==0)
		{
			return -1;
		}
		
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			
			if(key == a[mid])
			{
				return mid;
			}
			else if(key < a[mid])
			{
				end = mid - 1;
			}
			else
				start = mid + 1;
			
			
		}
		
		
		return -1;
	}
	
public static int binarySearchDsc(int a[], int start, int end, int key) {
		
		if(a == null || a.length == 0)
		{
			return -1;
		}
		
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			
			if(key == a[mid])
				return mid;
			
			else if(key < a[mid])
			{
				start = mid + 1;
			}
			else
				end = mid -1;
		}
		
		
		return -1;
	}
	public static void main(String []args)
	{
		int a[] = {1, 3, 8, 12, 4, 2};
		
		int key = 4;
		int index = PeakElement.findPeak(a);
		
		int asc_ind = binarySearchAsc(a, 0, index -1, key);
		int des_ind = binarySearchDsc(a, index+1, a.length-1, key);
		
		if(asc_ind != -1)
			System.out.println("Found at Index in increment part= "+ asc_ind);
		
		else if(des_ind != -1)
		{
			System.out.println("Found at Index in descrement part = "+des_ind);
		}
		
	}

}
