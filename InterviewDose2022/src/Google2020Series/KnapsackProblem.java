package Google2020Series;

import java.util.Arrays;

public class KnapsackProblem {
    static int dp[][] = new int[1000][1200];

    /**
     * Time Complexity: O(2n).
     * As there are redundant subproblems.
     * Auxiliary Space :O(1) + O(N).
     * As no extra data structure has been used for storing values but O(N)
     * auxiliary stack space(ASS) has been used for recursion stack.
     * @param wt
     * @param val
     * @param w
     * @param n
     * @return
     */
    public static int knapsackRecursive(int wt[], int val[], int w, int n)
    {
        if(n == 0 || w == 0)
        {
            return 0;
        }

        if(wt[n-1] <= w)
        {
            return Math.max(val[n-1] + knapsackRecursive(wt, val, w - wt[n-1], n-1),
                    knapsackRecursive(wt, val, w, n -1));
        }
        else
        {
            return knapsackRecursive(wt, val, w, n - 1);
        }

    }

    /**
     * Time Complexity: O(N*W)
     * Reason: There are N*W states therefore at max ‘N*W’ new problems will be solved.
     * Space Complexity: O(N*W) + O(N)
     * Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*W)).
     * @param wt
     * @param val
     * @param w
     * @param n
     * @return
     */
    public static int knapsackMemoization(int wt[], int val[], int w, int n)
    {
        if(n == 0 || w == 0)
            return 0;

        if(dp[n][w] !=-1)
        {
            return dp[n][w];
        }

        if(wt[n-1] <=w)
        return dp[n][w] = Math.max(val[n-1] + knapsackMemoization(wt, val, w-wt[n-1], n-1), knapsackMemoization(wt, val, w, n-1));

        else
        return dp[n][w] = knapsackMemoization(wt, val, w, n-1);
    }

    /**
     * Time Complexity: O(N*W).
     * where ‘N’ is the number of weight element and ‘W’ is capacity.
     * As for every weight element we traverse through all weight capacities 1<=w<=W.
     * Auxiliary Space: O(N*W).
     * The use of 2-D array of size ‘N*W’.
     * @param wt
     * @param val
     * @param w
     * @param n
     * @return
     */
    public static int knapsackTopDown(int wt[], int val[], int w, int n)
    {
        int t[][] = new int[n+1][w+1];

        for (int i = 1; i < n+1; i++)
        {
            for (int j = 1; j < w + 1; j++)
            {
                if(wt[i-1] <= j)
                {
                    t[i][j] = Math.max(val [i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                }
                else
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][w];
    }

    public static void main(String[] args) {
        int wt[]=new int[] {1, 3, 4, 5};
        int val[]=new int[] {1, 4, 5, 7};
        int w=7;
        int n=val.length;

        System.out.println("Knapsack problem solution using Recursion");
        System.out.println(knapsackRecursive(wt, val, w, n));
        for (int[] a : dp)
        {
            Arrays.fill(a, -1 );
        }
        System.out.println("Knapsack problem solution using Recursion");
        System.out.println(knapsackMemoization(wt, val, w, n));
    }
}
