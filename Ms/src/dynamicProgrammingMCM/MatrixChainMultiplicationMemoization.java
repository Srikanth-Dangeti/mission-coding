package dynamicProgrammingMCM;

import java.util.Arrays;

public class MatrixChainMultiplicationMemoization {

	static int t[][] = new int[1000][1000];
	public static int mcmmemoization(int a[], int i, int j)
	{
		if(i >= j)
			return 0;
		
		if(t[i][j]!= -1)
			return t[i][j];
			int min = Integer.MAX_VALUE;
		
		for(int k = i; k<=j-1; k++)
		{
			int temp = mcmmemoization(a, i, k)+mcmmemoization(a, k+1, j)+a[i-1]*a[k]*a[j];
			
			if(temp < min)
			{
				min = temp;
			}
		}
		t[i][j]= min;
		return t[i][j];
		
	}
	public static void String(String []args)
	{
		int a[] = { 10, 30, 5, 60 };//{40, 20, 30, 10, 30};
		for(int [] k : t)
		{
			Arrays.fill(k, -1);
		}
		System.out.println("Matrix Chain Multiplication = "+ mcmmemoization(a, 1, a.length-1));
	}
}
