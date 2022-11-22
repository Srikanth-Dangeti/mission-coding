package Arrays;

import java.util.HashMap;

public class SearchElementInSortedRotatedArray {

	public static int search(int a[],int l,int h,int key)
	{
		if(l>h)
			return -1;
		int mid=(l+h)/2;
		if(a[mid]==key)
			return mid;
		
		if(a[l]<=a[mid])
		{
			if(key>=a[l] && key<=a[mid])
			{
				return search(a,l,mid-1,key);
			}
			return search(a,mid+1,h,key);
		}
		
		if(key>=a[mid] && key<=a[h])
			return search(a,mid+1,h,key);
		return search(a,l,mid-1,key);
	}
	
	public static void main(String []args)
	{
		int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3}; 
        int n = arr.length; 
        int key = 8; 
        int i = search(arr, 0, n-1, key); 
        if (i != -1)  
            System.out.println("Index: " + i); 
        else
            System.out.println("Key not found"); 
        Integer intg=Integer.reverse(4);
        System.out.println(intg.intValue());
        HashMap h=new HashMap();
       // h.containsKey(key)
        
	}
}
