package BinarySearchandRelatedQuestion;

public class FirstAndLastOccurenceOfanElement {

	public static int firstOccurenceOfEle(int a[], int key)
	{
		if(a == null || a.length == 0)
			return -1;
		
		int start  = 0;
		int end = a.length - 1;
		int res =0;
		
		while(start <= end)
		{
			int  mid = start + end-start/2;
			
			if(key ==  a[mid])
			{
				res = mid;
				end = mid - 1;
			}
			else if(key < a[mid])
			{
				end = mid - 1;
				
			}
			else
			{
				start = mid + 1;
			}
		}
		
		return res;
	}
	
	public static int lastOccurenceOfEle(int a[], int key)
	{
		if(a == null || a.length == 0)
			return -1;
		
		int start  = 0;
		int end = a.length - 1;
		int res =0;
		
		while(start <= end)
		{
			int  mid = start + (end-start)/2;
			
			if(key ==  a[mid])
			{
				res = mid;
				start =  mid + 1;
			}
			else if(key < a[mid])
			{
				end = mid - 1;
				
			}
			else
			{
				start = mid + 1;
			}
		}
		
		return res;
	}
	public static void main(String [] args)
	{
		int a [] = {2, 3, 4, 5, 10, 10, 10, 12, 13, 16};
		
		int key = 10;
		int index = firstOccurenceOfEle(a, key);
        System.out.println("Element " + key + (index >= 0 ? (" first occurence at index " + index) : " not found!"));
        
        
        int ind = lastOccurenceOfEle(a, key);
        System.out.println("Element " + key + (ind >= 0 ? (" first occurence at index " + ind) : " not found!"));
	}
}
