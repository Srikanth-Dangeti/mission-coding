package dynamicProgramming.miscellaneous;

import java.util.Scanner;

public class shortestSuperSequence {

	public static int shortsupersequence(char []a,char b[],int m,int n)
	{
		int l=LongestCommonSubsequence.dpLcs(a, b, m, n);
		
		return(m+n-l);
		
		
	}
	public static void main(String[] args) {
		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length; 
	    Scanner sc=new Scanner(System.in);
	    String str=sc.next();
	  
	    System.out.println("Length of LCS using Recursion is" + " " + shortsupersequence( X, Y, m, n ) );

	}

}
