package dynamicProgramming.LCSandAllVariationsQestions;

public class MinimumNoofInseranddeltocoverAtoB {
	
	static int lcsTopDown( char[] X, char[] Y, int m, int n ) 
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
	  return t[m][n]; 
	  } 
	
	static void printMinDelAndInsert(String str1,  
            String str2)  
	{ 
	int m = str1.length(); 
	int n = str2.length(); 
	char[] X=str1.toCharArray(); 
    char[] Y=str1.toCharArray(); 
	int len = lcsTopDown(X, Y, m, n); 
	
	System.out.println("Minimum number of "+ 
	   "deletions = "); 
	System.out.println(m - len); 
	
	System.out.println("Minimum number of "+ 
	   "insertions = ");  
	System.out.println(n - len);  
	} 
	public static void main(String[] args) 
	{ 
	    //LongestCommonSubsequence lcs = new LongestCommonSubsequence(); 
	    String s1 = "heap"; 
	    String s2 = "pea"; 
	  
	    
	    
	    printMinDelAndInsert(s1, s2);  
	    
	 }

}
