package com.core.java;

public class RotateMatrixBy90 {
	
	static void rotateMatrix(int n,int a[][])
	{
		for (int i=0;i<n/2;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				
				int temp=a[i][j];
				a[i][j]=a[j][n-1-i];
			}
		}
	}
	public static void main(String[]args)
	{
		int a[][]= {
				{1,2,3},
				{4,5,6},
				{7,8,9}};
		
		int n=a.length;
		int k=3/2;
		System.out.println(k);
		
		
					
		
	}

}
