package dynamicProgramming.LCSandAllVariationsQestions;

public class PrintLCS {
	
	static void printLcsTopDown( char[] X, char[] Y, int m, int n ) 
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
	    
	    int i = m, j = n;
	    String str = "";
	    while(i > 0 && j>0)
	    {
	    	if(X[i-1] == Y[j-1])
	    	{
	    		str =str+X[i-1];
	    		i--;
	    		j--;
	    	}
	    	else {
	    		if(t[i][j-1] > t[i-1][j])
	    		{
	    			j--;
	    		}
	    		else
	    		{
	    			i--;
	    		}
	    	}
	    	
	    }
	    
	    StringBuilder sb = new StringBuilder(str);
	    sb = sb.reverse();
	    str = sb.toString();
	    
	    System.out.println("Printing LCS = "+str);
	    
	  
	  }
	public static void main(String[] args) 
	{ 
	    //LongestCommonSubsequence lcs = new LongestCommonSubsequence(); 
	    String s1 = "acbcf"; 
	    String s2 = "abcdaf"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length;
	    System.out.println("Length of LCS is Using Memoization");
	    printLcsTopDown( X, Y, m, n );
	 }

}
