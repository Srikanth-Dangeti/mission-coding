package dynamicProgramming.miscellaneous;

public class Knapsack {
	
	public static int knapsackRecurive(int w,int wt[],int val[],int n) {
		if(n==0||w==0) {
			return 0;
		}
		else if(wt[n-1]>w)
		{
			return knapsackRecurive(w, wt, val, n-1);
		}
		else return Math.max(val[n-1]+knapsackRecurive(w-wt[n-1], wt, val, n-1),knapsackRecurive(w, wt, val, n-1));
	}
	public static int knapsackDynamicProgrraming(int W,int wt[],int val[],int n){
		int i, j; 
	     int K[][] = new int[n+1][W+1]; 
	       
	     // Build table K[][] in bottom up manner 
	     for (i = 0; i <= n; i++) 
	     { 
	         for (j = 0; j <= W; j++) 
	         { 
	             if (i==0 || j==0) 
	                  K[i][j] = 0; 
	             else if (wt[i-1] <= j) 
	                   K[i][j] = Math.max(val[i-1] + K[i-1][j-wt[i-1]],  K[i-1][j]); 
	             else
	                   K[i][j] = K[i-1][j]; 
	         } 
	      } 
	     printSelectedElements(K,wt,val,W); 
	      return K[n][W]; 
		
	}
	public static void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity){
		   System.out.print("Selected weights:");
		   int totalProfit = dp[weights.length-1][capacity];
		   for(int i=weights.length-1; i > 0; i--) {
		     if(totalProfit != dp[i-1][capacity]) {
		       System.out.print(" " + weights[i]);
		       capacity -= weights[i];
		       totalProfit -= profits[i];
		     }
		   }
	}
	public static void main(String []args) {
		int val[]=new int[] {60,100,120};
		int wt[]=new int[] {10,20,30};
		int w=50;
		int n=val.length;
		
		System.out.println("Knapsack pronblem solution using Recursion");
		System.out.println(knapsackRecurive(w, wt, val, n));
		System.out.println("Knapsack problem using Dynamic Programming");
		System.out.println(" ,Total Profit = "+knapsackDynamicProgrraming(w,wt,val,n));
	}

}
