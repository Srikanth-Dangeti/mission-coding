package Sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static void mergesort(int a[],int low,int high)
	{
		int mid;
		
		
		if(low<high)
		{
			mid=(low+high)/2;
			mergesort(a,low,mid);
			mergesort(a, mid, high);
			simplemerge(a,low,mid,high);
		}
	}
    public static void simplemerge(int a[],int low,int mid,int high)
    {
    	
    	
    }
	public static void main(String []args)
	{
		int[] array = {12, 35, 87, 26, 9, 28, 7};
		mergesort(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
	}

}
