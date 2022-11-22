package dynamicProgramming.miscellaneous;


public class LongestCommonSubsequence {
	/**
	 * @author srikanth D
	 * Using Recursion
	 */
    public static int lcs(char a[],char[]b,int i,int j)
    {
    	if(i==0||j==0)
    	{
    		return 0;
    	}
    	if(a[i-1]==b[j-1])
    	return	1+lcs(a,b,i-1,j-1);
    	else
    		return Math.max(lcs(a,b,i,j-1),lcs(a,b,i-1,j));
    	
    }
    public static int dpLcs(char a[],char b[],int m,int n)
    {
    	int l[][]=new int[m+1][n+1];
    	
    	for(int i=0;i<=m;i++)
    	{
    		for(int j=0;j<=n;j++)
    		{
    			if(i==0||j==0)
    			{
    				l[i][j]=0;
    			}
    			else if(a[i-1]==b[j-1])
    			{
    				l[i][j]=1+l[i-1][j-1];
    			}
    			else
    				l[i][j]=Math.max(l[i-1][j],l[i][j-1]);
    		}
    	}
    	return l[m][n];
    	
    }
	public static void main(String[] args) {
		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length; 
	  
	    System.out.println("Length of LCS using Recursion is" + " " + lcs( X, Y, m, n ) ); 
	                                  
	    
	    System.out.println("Length of LCS using Dynamic Programming is" + " " + dpLcs( X, Y, m, n ) ); 
                

	}

}
