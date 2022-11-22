package BinarySearchandRelatedQuestion;

public class BinarySearchDSC {
	
	public static int binarySearchDsc(int a[], int key) 
	{
		
		if(a == null || a.length == 0)
		{
			return -1;
		}
		
		int start = 0;
		int end = a.length - 1;
		
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
	public static void main(String []args) {
		int array[] = { 10, 9, 6, 4, 3, 2, 1 };
        int num = 4;
        
        int index = binarySearchDsc(array, num);
        System.out.println("Element " + num + (index >= 0 ? (" found at index " + index) : " not found!"));
		
	}
	
}
