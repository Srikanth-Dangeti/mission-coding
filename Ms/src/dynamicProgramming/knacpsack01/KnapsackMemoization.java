package dynamicProgramming.knacpsack01;

import java.util.Arrays;

public class KnapsackMemoization {
	
	static int dp[][] = new int[1000][1200];
	
	public static int knapsackMemoization(int wt[], int val[], int w, int n)
	{
		
		if(n == 0 || w == 0)
			return 0;
		
		if(dp[n][w] != -1)
			return dp[n][w];
		
		if(wt[n-1] <= w)
		{
			return dp[n][w] = Math.max(val[n-1]+knapsackMemoization(wt, val, w-wt[n-1], n-1), knapsackMemoization(wt, val, w, n-1));
		}
		else
			return dp[n][w] = knapsackMemoization(wt, val, w, n-1);
		
		
	}
	
	public static void main(String [] args)
	{
		int wt [] = {1, 3, 4, 5};
		int val[] = {1, 4, 5, 7};
		
		int w =7;
		int n=val.length;
		// this filing should be knowing
		for( int [] a : dp)
		{
			Arrays.fill(a, -1);
		}
		System.out.println("Knapsack problem solution using Memoization");
		System.out.println(knapsackMemoization(wt, val, w, n));
	}

}
