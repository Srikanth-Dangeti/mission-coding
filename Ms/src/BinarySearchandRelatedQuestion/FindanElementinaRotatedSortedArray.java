package BinarySearchandRelatedQuestion;

public class FindanElementinaRotatedSortedArray {
	
	public static int binarySearch(int a[], int start, int end, int key)
	{
		if(a == null || a.length == 0)
			return 0;
		
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			
			if(key == a[mid])
				return mid;
			
			else if(key < a[mid])
				end = mid - 1;
			else
				start  = mid + 1;
			
		}
		return -1;
	}
	
	public static void main(String []args)
	{
		int a [] = {11, 12, 15, 18, 2, 5, 6, 8};
		int key = 15;
		int index = NoOftimesSortedArrayRotated.noOftimesarrayRotated(a);
		
		int first_index = binarySearch(a, 0, index - 1, key);
		
		int sec_index = binarySearch(a, index + 1, a.length - 1, key);
		
		if(first_index != -1)
			System.out.println("Found at first_index= "+first_index);
		
		if(sec_index != -1)
			System.out.println("Found at sec_index= "+sec_index);
		
		
	}

}
