package Arrays;

import java.util.*;

public class ShuffleRandArrayUsingFisherYates {
	
	public int b[];
	
	public static void randomize(int a[],int n)
	{
		Random rand=new Random();
		
		for(int i=0;i<n;i++)
		{
			int randomindex=rand.nextInt(n);
			System.out.println("Random value= "+randomindex);
			int temp=a[i];
			a[i]=a[randomindex];
			a[randomindex]=temp;
		}
		
		System.out.println(Arrays.toString(a));
	}
	
	public static void randomizeUsingArrayList(int b[],int n)
	{
		
		// this method will not work for int a[];
		Integer[] a = new Integer[]{1, 2, 3, 4};
		List<Integer> l=Arrays.asList(a);
		
		System.out.println(l);
		
		Collections.shuffle(l);
		System.out.println("After shuffling");
		System.out.println(l);
		
				
	}
	
	public static void main(String []args)
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8}; 
        int n = arr.length; 
        randomize (arr, n); 
        System.out.println("Below using Arrayslist");
        randomizeUsingArrayList(arr,n);
	}

}
