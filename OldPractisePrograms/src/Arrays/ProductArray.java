package Arrays;

import java.util.Arrays;

public class ProductArray {
	
	public static void productArray(int a[])
	{
		
		
		Arrays.sort(a);
		
		System.out.print(Arrays.binarySearch(a, 111));
		/*int prod[]=new int[a.length];
		int temp=1;
		for(int i=0;i<a.length;i++)
		{
			temp=temp*a[i];
		}
		for(int i=0;i<a.length;i++)
		{
			prod[i]=temp/a[i];
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.print(prod[i]+" ");
			
		}*/
			
	}
	public static void main(String []args)
	{
		
		int a[]= {2,5,7};
		System.out.println("The product array is : "); 
		productArray(a);
	}

}
