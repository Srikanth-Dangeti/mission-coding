package Arrays;

import java.util.Scanner;

public class josephus {
	
	static int josephNumber(int n,int k)
	{

		if(n==1)
			return 1;
		else
		{
			return (josephNumber(n - 1, k) + k-1)%n+1;
		}
		
		
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number N");
		int n=sc.nextInt();
		System.out.println("Enter the number k");
		int k=sc.nextInt();
		System.out.println("The chosen place is " + josephNumber(n, k));
		
		
	}

}
