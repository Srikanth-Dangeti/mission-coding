package Arrays;

import java.util.Arrays;

public class ArrarysUnionIntersection {
	
	static void printIntersection(int arr1[],int arr2[],int m,int n)
	{
		if(m>n)
		{
			int temp[]=arr1;
			arr1=arr2;
			arr2=temp;
			int temp_var=m;
			m=n;
			n=temp_var;
		}
		
		Arrays.sort(arr1);
		
		for(int i=0;i<n;i++)
		{
			if(Arrays.binarySearch(arr1, arr2[i])>-1)
			{
				System.out.print(arr2[i] + " "); 
			}
		}
		
	}
	static void printUnion(int arr1[], int arr2[], int m, int n) 
	{
		
		if(m>n)
		{
			int temp[]=arr1;
			arr1=arr2;
			arr2=temp;
			int temp_var=m;
			m=n;
			n=temp_var;
		}
		
		Arrays.sort(arr1);
		
		for(int i:arr1)
		{
			System.out.print(i+" ");
		}
		for(int i=0;i<n;i++)
		{
			if(Arrays.binarySearch(arr1,arr2[i])==-1)
			{
				System.out.print(arr2[i]+" ");
			}
		}
	}
	
	public static void main(String []args)
	{
		int arr1[] = {7, 1, 5, 2, 3, 6}; 
        int arr2[] = {3, 8, 6, 20, 7}; 
        
        int m = arr1.length; 
        int n = arr2.length;
        System.out.println("Union of Two arrays");
        printUnion(arr1, arr2, m, n);
        System.out.println();
        System.out.println("Intersection of two arrays is "); 
        printIntersection(arr1, arr2, m, n); 
	}

}
