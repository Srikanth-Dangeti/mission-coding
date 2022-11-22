package dynamicProgramming.LCSandAllVariationsQestions;

public class Longestrepeatingsubsequence {

	static int longestrepatingSubSequence( char[] X, char[] Y, int m, int n ) 
	  { 
	    int t[][] = new int[m+1][n+1]; 
	  
	    for (int i=1; i<m+1; i++) 
	    { 
	      for (int j=1; j<n+1; j++) 
	      { 
	        
	        if (X[i-1] == Y[j-1] && i != j) 
	            t[i][j] = t[i-1][j-1] + 1; 
	        else
	            t[i][j] = Math.max(t[i-1][j], t[i][j-1]); 
	      } 
	    } 
	  return t[m][n]; 
	 }
	public static void main(String[] args) 
	{ 
	    //LongestCommonSubsequence lcs = new LongestCommonSubsequence(); 
	    String s1 = "AABEBCDD"; 
	    String s2 =s1;
	    
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length;
	    System.out.println("Length of Longest repating subsequence" + " " + 
	    		longestrepatingSubSequence( X, Y, m, n ) ); 
	 } 
}
