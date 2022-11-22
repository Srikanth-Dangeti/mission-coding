package dynamicProgramming.LCSandAllVariationsQestions;

public class LCSRecusive {

	public static int lcsRecursive(char[] X, char[] Y, int n, int m)
	{
		if(n == 0 || m == 0)
		{
			return 0;
		}
		if(X[n-1] == Y[m-1])
		{
			return 1+lcsRecursive(X, Y, n-1, m-1);
		}
		else
			return Math.max(lcsRecursive(X, Y, n-1, m), lcsRecursive(X, Y, n, m-1));
			
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
	  
	    System.out.println("Length of LCS is" + " " + 
	                                  lcsRecursive( X, Y, m, n ) ); 
	  } 
}
