package Test;

import java.util.Arrays;

//q. list -- > n values 
// 

public class Test {
	
	
	public static boolean find3nums(int [] a)
	{
		
		if(a == null || a.length== 0)
		{
			return false;
		}
		
		for (int i = 0; i < a.length; i++)
            a[i] = a[i] * a[i];
		
		Arrays.sort(a);
		for (int i = a.length - 1; i >= 2; i--) 
		{
			int low = 0;
			int high = i-1;
			
			while (low < high) {
	            
	            if (a[low] + a[high] == a[i])
	                return true;
	
	            
	            if (a[low] + a[high] < a[i])
	                low++;
	            else
	                high--;
	        }
		
		}
		
		
		
		
		
		return false;
		
	}
	
	public static void main(String []args)
	{
		int a[] = {1,2,3,4,5,6,7,8,9};
		
		System.out.println(find3nums(a));
	}
	
}
