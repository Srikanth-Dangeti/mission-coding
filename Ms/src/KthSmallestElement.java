import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestElement {

	public static void main(String[]args)
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number of Testcases");
		int t=sc.nextInt();
		System.out.println("Enter the size of the array");
		int n=sc.nextInt();
		Arrays.sort(args);
		String stre="srikanth";
		System.out.println(stre.toUpperCase());
		int a[]=new int [n];
		while(t-->0)
		{
			
			for(int i=0;i<n;i++)
			{
				a[i]=sc.nextInt();
			}
			System.out.println("Please Enter which Smallest Element Required");
			int k=sc.nextInt();
			findKthSmallest(a,k);
		}
		
	}
	public static void findKthSmallest(int a[],int k)
	{
		if(k<a.length)
		{
		 Arrays.sort(a);
		
	     System.out.println("The Kth Smallest Element is = "+a[k-1]);
		}
		else
		{
			System.out.println("Please enter the Number which less than size of Array");
		}
		
	}
}
