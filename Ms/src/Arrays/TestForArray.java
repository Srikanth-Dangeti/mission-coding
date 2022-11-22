package Arrays;

import java.util.Arrays;

public class TestForArray {

	public static void main(String []args)
	{
		
		/*int i=0,j=0,k=0;
		
		int end=arr1.length-1;
		while(i<end)
		{
			int temp=arr1[i];
			arr1[i]=arr1[end];
			arr1[end]=temp;
			i++;
			end--;
		}*/
		int[] arr1 = {1, 3, 5, 7,0,0};
		int j = arr1.length-1;
		   for (int i = arr1.length - 1; i >= 0; i--) 
		     if (arr1[i] != 0) 
		     { 
		    	 arr1[j] = arr1[i]; 
		        j--; 
		     } 
		System.out.println(Arrays.toString(arr1));
	}
}
