package DynamicProgramming;

public class LongestCommonSubsequence {
	
	public static void lcs(String x,String y,int m,int n)
	{
		int [][]l=new int[m+1][n+1];
		for(int i=0;i<=m;i++)
		{
			for (int j=0; j<=n; j++) 
			{
				System.out.println(i+" "+j);
				if(i==0||j==0)
				{
					l[i][j]=0;
				}
				else if(x.charAt(i-1)==y.charAt(j-1))
				{
					l[i][j]=l[i-1][j-1]+1;
					
				}
				else
				{
					l[i][j]=Math.max(l[i-1][j],l[i][j-1]);
					
				}
			}
			
		}
		// got the Longest Common Subsequence now will print it.
		System.out.println(l[m][n]);
		int index=l[m][n];
		int temp=index;
		char []lcs=new char[index+1];
		lcs[index]=' ';// termintating character
		int i=m,j=n;
		while(i>0&&j>0)
		{
			if(x.charAt(i-1)==y.charAt(j-1))
			{
				lcs[index-1]=x.charAt(i-1);
				i--;
				j--;
				index--;
				
			}
			else if(l[i-1][j]>l[j][j-1])
			{
				i--;
			}
			else
				j--;
		}
		// Print the lcs 
        System.out.print("LCS of "+x+" and "+y+" is --> "); 
        for(int k=0;k<=temp;k++) 
            System.out.print(lcs[k]); 
		
		
		
	}
	public static void main (String []args)
	{
		String X = "LONGEST"; 
        String Y = "STONE"; 
        int m = X.length(); 
        int n = Y.length(); 
        lcs(X, Y, m, n); 
	}

}
