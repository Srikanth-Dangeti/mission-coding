package dynamicProgramming.knacpsack01;

import java.util.Arrays;

public class KnapsackTopDown {

	
	public static int knapsackTopDown(int wt[], int val[], int w, int n)
	{
		int t[][] = new int [n+1][w+1];
		
		/*for(int i = 0; i< n+1; i++)
			for(int j = 0; j< w+1; j++)
			{
				if(i ==0 || j ==0)
					t[i][j] = 0;
			}*/
		
		for(int i = 1; i < n+1; i++)
		{
			for(int j = 1; j < w+1; j++)
			{
				if (wt[i-1] <= j)
				{
					t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
				}
				else
				{
					t[i][j] = t[i-1][j];
				}
					
			}
		}
			
			
			return t[n][w];
	}
	
	public static void main(String [] args)
	{
		int wt [] = {1, 3, 4, 5};
		int val[] = {1, 4, 5, 7};
		
		int w =7;
		int n=val.length;
		// this filing should be knowing
		/*
		 * for( int [] a : dp) { Arrays.fill(a, -1); }
		 */
		System.out.println("Knapsack Dynamic programming using Top Down");
		System.out.println(knapsackTopDown(wt, val, w, n));
	}
}
