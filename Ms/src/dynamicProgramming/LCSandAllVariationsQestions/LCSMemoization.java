package dynamicProgramming.LCSandAllVariationsQestions;

import java.util.Arrays;

public class LCSMemoization {
	static int t[][] = new int[1000][1200];
	
	public static int lcsMemoization(char[] X, char[] Y, int m, int n)
	{
		if(n == 0 || m == 0)
		{
			return 0;
		}
		if(X[m-1] == Y[n-1])
		{
			return t[m][n] = 1+lcsMemoization(X, Y, m-1, n-1);
		}
		else
			return t[m][n] = Math.max(lcsMemoization(X, Y, m-1, n), lcsMemoization(X, Y, m, n-1));
			
	}
	
	public static void main(String[] args) 
	{ 
	    //LongestCommonSubsequence lcs = new LongestCommonSubsequence(); 
	    String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length; 
	    for(int [] a : t)
		{
			Arrays.fill(a, -1);
		}
	    System.out.println("Length of LCS is Using Memoization" + " " + 
	    		lcsMemoization( X, Y, m, n ) ); 
	 } 
}
