package dynamicProgramming.LCSandAllVariationsQestions;

public class SequencePatternMatching {

	static boolean sequencePatternMatching( char[] X, char[] Y, int m, int n ) 
	  { 
	    int t[][] = new int[m+1][n+1]; 
	  
	    for (int i=1; i<m+1; i++) 
	    { 
	      for (int j=1; j<n+1; j++) 
	      { 
	        
	        if (X[i-1] == Y[j-1]) 
	            t[i][j] = t[i-1][j-1] + 1; 
	        else
	            t[i][j] = Math.max(t[i-1][j], t[i][j-1]); 
	      } 
	    } 
	    if(X.length == t[m][n])
	    {
	    	return true;
	    }
	    else
	    	return false;
	  } 
	public static void main(String[] args) 
	{ 
	    //LongestCommonSubsequence lcs = new LongestCommonSubsequence(); 
	    String s1 = "AXY"; 
	    String s2 = "ADXCPY"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length;
	    if(sequencePatternMatching(X, Y, m, n))
	    {
	    	System.out.println("Sequence pattern matching is available");
	    }
	    else {
	    	System.out.println("Sequence pattern matching is not available");
	    }
	    	
	    
	 }
}
