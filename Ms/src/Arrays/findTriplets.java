package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class findTriplets {

	public static void findTriplets(int a[],int n)
	{
		boolean found = false; 
		  
	    // sort array elements 
	    Arrays.sort(a); 
	    List<List<Integer>> al=new ArrayList();
	    for (int i=0; i<n-1; i++) 
	    { 
	        // initialize left and right 
		  if(i==0 ||(i>0 && a[i]!=a[i-1]))// to eliminate the duplicate
	        {
				 //System.out.println(i+" Testing");
		        int l = i + 1; 
		        int r = n - 1; 
		        int x = a[i]; 
		       
		        while (l < r) 
		        { 
		            if (x + a[l] + a[r] == 0) 
		            { 
		                // print elements if it's sum is zero 
		                    //System.out.print(x + " "); 
		                    //System.out.print(a[l]+ " "); 
		                    //System.out.println(a[r]+ " "); 
		                    al.add(Arrays.asList(x,a[l],a[r]));
		                    while(l<r && a[l]==a[l+1])
		                    	l++;
		      
		                l++; 
		                r--; 
		                found = true; 
		            } 
		  
		            // If sum of three elements is less 
		            // than zero then increment in left 
		            else if (x + a[l] + a[r] < 0) 
		                l++; 
		  
		            // if sum is greater than zero than 
		            // decrement in right side 
		            else
		                r--; 
		        }
		    }
	 
	  } 
	  
	    if (found == false) 
	            System.out.println(" No Triplet Found"); 
	    
	    System.out.println(al);
	}
	
	//Using hashing
	// function to print triplets with 0 sum 
    static void findTripletsUsingHashing(int arr[], int n)  
    { 
        boolean found = false; 
  
        for (int i = 0; i < n - 1; i++)  
        { 
            // Find all pairs with sum equals to 
            // "-arr[i]" 
            HashSet<Integer> s = new HashSet<Integer>(); 
            for (int j = i + 1; j < n; j++)  
            { 
                int x = -(arr[i] + arr[j]); 
                if (s.contains(x))  
                { 
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]); 
                    found = true; 
                }  
                else 
                { 
                    s.add(arr[j]); 
                } 
            } 
        } 
  
        if (found == false) 
        { 
            System.out.printf(" No Triplet Found\n"); 
        } 
    }
    
	public static void main(String []args)
	{
		//int a[] = {-1, 0, 1, 2, -1, -4}; 
		
		int a[]= {-2,0,0,2,2};
	    int n =a.length; 
	    //findTriplets(a, n); 
	    findTripletsUsingHashing(a,n);
	}
}
