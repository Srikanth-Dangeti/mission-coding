package Sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void bubbleSort(int a[])
	{
		if(a==null||a.length<2)
		{
			return ;
		}
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					
				}
			}
		}
	}
	public static void main(String []agars)
	{
		int[] array = {12, 35, 87, 26, 9, 28, 7}; 
		bubbleSort(array);
		System.out.println("Sorted array: " + Arrays.toString(array));
	}
	
}
