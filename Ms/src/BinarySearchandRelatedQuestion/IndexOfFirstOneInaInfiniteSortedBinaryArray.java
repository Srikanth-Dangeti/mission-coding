package BinarySearchandRelatedQuestion;

public class IndexOfFirstOneInaInfiniteSortedBinaryArray {
	
	
	// function to find the index of first '1' 
    // binary search technique is applied 
    public static int indexOfFirstOne(int a[],  
                                   int start, int end) 
    { 
    	if(a == null || a.length == 0)
			return -1;
		
		int res = 0;
		System.out.println("2nd");
		int mid = 0;
		while(start <= end)
		{
			  mid = start + end-start/2;
			
			if (a[mid] == 1 &&  
	                (mid == 0 || a[mid - 1] == 0)) 
	                break; 
	       
	            // first '1' lies to the left of 'mid' 
	            else if (a[mid] == 1) 
	                end = mid - 1; 
	       
	            // first '1' lies to the right of 'mid' 
	            else
	                start = mid + 1; 
		}
		
		return mid;
    } 
    
	public static int posOfFirstOne(int arr[]) 
    { 
		System.out.println("1st");
        // find the upper and starter bounds 
        // between which the first '1' would 
        // be present 
        int start = 0, end = 1; 
       
        // as the array is being considered 
        // infinite therefore 'h' index will 
        // always exist in the array 
        while (arr[end] == 0) { 
       
            // starter bound 
            start = end; 
       
            // upper bound 
            end = 2 * end; 
        } 
       
        // required index of first '1' 
        return indexOfFirstOne(arr, start, end); 
    } 
	
	public static void main(String[] args)  
    { 
  
        int arr[] = { 0, 0, 1, 1, 1, 1 }; 
        System.out.println("Index = " +  posOfFirstOne(arr)); 
             
    } 

}
