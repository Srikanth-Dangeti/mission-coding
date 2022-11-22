package BinarySearchandRelatedQuestion;

public class FindpositionofanelementinanInfiniteSortedArray {

	public static int binarySearch(int a[], int start, int end, int key)
	{
		if(a == null || a.length == 0)
			return 0;
		
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			
			if(key == a[mid]) {
				return mid;
			}
				
			
			else if(key < a[mid])
				end = mid - 1;
			else
				start  = mid + 1;
			
		}
		
		return -1;
	}
	
	static int findPos(int arr[],int key)  
    { 
        int start = 0;
        int end = 1;
        while(key > arr[end])
        {
        	start = end;
        	
        	end = 2 * end;
        }
  
        // at this point we have updated low 
        // and high indices, thus use binary  
        // search between them 
        return binarySearch(arr, start, end, key); 
    } 
	
	public static void main(String[] args)  
    { 
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,  
                            100, 130, 140, 160, 170}; 
        int ans = findPos(arr,10); 
          
        if (ans==-1) 
            System.out.println("Element not found"); 
        else
            System.out.println("Element found at index " + ans); 
    } 
}
