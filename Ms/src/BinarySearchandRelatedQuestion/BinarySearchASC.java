package BinarySearchandRelatedQuestion;

public class BinarySearchASC {

	public static int  binarySearchAsc(int a[], int key)
	{
		
		if(a == null || a.length ==0)
		{
			return -1;
		}
		
		int start = 0;
		int end = a.length-1;
		
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
	
	public static void main(String []args) 
	{
		int array[] = { 21, 32, 43, 74, 75, 86, 97, 108, 149 };
        int num = 86;
        
        int index = binarySearchAsc(array, num);
        System.out.println("Element " + num + (index >= 0 ? (" found at index " + index) : " not found!"));
		
	}
	
}
