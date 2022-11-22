package dynamicProgramming.miscellaneous;

import java.util.Scanner;

public class NumberOfPathsInMxNMatrix {

	public static  int countPathsRecursive(int m,int n)
	{
		if(m==1||n==1)
		return 1;
		
		return countPathsRecursive(m-1,n)+countPathsRecursive(m,n-1);
	}
	public static int  countPaths(int m,int n)
	{
		int t[][]=new int[m][n];
		for(int i=0;i<m;i++)
			t[i][0]=1;
		for(int j=0;j<n;j++)
			t[0][j]=1;
		
		for(int i=1;i<m;i++)
			for(int j=1;j<n;j++)
			{
				t[i][j]=t[i-1][j]+t[i][j-1];
			}
		
		
		
		return t[m-1][n-1];
	}
	public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the no of rows");
	   int m=sc.nextInt();
	   System.out.println("Enter the no of columns");
	   int n=sc.nextInt();
	   System.out.println("Using Dynamic Programming");
	   System.out.println(countPaths(m,n));
	   System.out.println("Using Recursion");
	   System.out.println(countPathsRecursive(m,n));
	   

	}

}
