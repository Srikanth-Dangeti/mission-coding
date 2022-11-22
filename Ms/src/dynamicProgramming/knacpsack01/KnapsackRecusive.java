package dynamicProgramming.knacpsack01;

/**
 * Time Complexity :
 * Space Complexity:
 */
public class KnapsackRecusive {

	public static int knapsack(int wt[], int val[], int w, int n)
	{
		//Base cond
		if(n == 0 || w == 0)
			return 0;
		
		if(wt[n-1] <= w)
		{
			return Math.max(val[n-1]+knapsack(wt, val, w-wt[n-1], n-1) , knapsack(wt, val, w, n-1));
		}
		else
			return knapsack(wt, val, w, n-1);
	}
	
	public static void main(String []args) 
	{
		
		int wt[]=new int[] {1, 3, 4, 5};
		int val[]=new int[] {1, 4, 5, 7};
		int w=7;
		int n=val.length;
		
		System.out.println("Knapsack problem solution using Recursion");
		System.out.println(knapsack(wt, val, w, n));
	}
}
