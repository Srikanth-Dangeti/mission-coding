package BinarySearchandRelatedQuestion;

public class MinimumDifferenceElementinaSortedArray {
	
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
			//System.out.println("mid ="+mid);
			if(key == a[mid])
			{
				return a[mid];
			}
			else if(key < a[mid])
			{
				end = mid - 1;
				System.out.println("end = "+end);
			}
			else
				start = mid + 1;
			
			
		}
		System.out.println("a[start]= "+ a[start]);
		System.out.println("a[end]= "+ a[end]);
		if(Math.abs(a[start] - key) > Math.abs(a[end]))
			return a[start];
		else
			return a[end];
		
	}
	
	public static void main(String []args) 
	{
		int array[] = {1, 3, 8, 10, 15};
        int num = 12;
        
        int index = binarySearchAsc(array, num);
        System.out.println("Element " + num + (index >= 0 ? (" found at index " + index) : " not found!"));
		
	}

}
