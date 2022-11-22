package Sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void selection(int a[])
	{
		if(a==null||a.length<2)
		{
			return ;
		}
		for(int i=0;i<a.length-1;i++)
		{
			int min_idx = i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]<a[min_idx])	
				{
					min_idx=j;
				}
				
				int temp = a[min_idx];
	            a[min_idx] = a[i];
	            a[i] = temp;	
				
			}
		}
	}
	public static void main(String []args)
	{
		int array[]={12, 35, 87, 26, 9, 28, 7}; 
		selection(array);
		System.out.println("Sorted array: " + Arrays.toString(array));
	}
}
