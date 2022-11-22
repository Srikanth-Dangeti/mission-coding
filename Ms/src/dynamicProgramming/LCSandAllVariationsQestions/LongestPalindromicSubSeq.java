package dynamicProgramming.LCSandAllVariationsQestions;

public class LongestPalindromicSubSeq {
 
	public static void main(String[] args) 
	{ 
	    //LongestCommonSubsequence lcs = new LongestCommonSubsequence(); 
	    String s1 = "agbcba"; 
	    StringBuffer sb = new StringBuffer(s1);
	    sb = sb.reverse();
	    String s2 =sb.toString();
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length;
	    System.out.println("Length of LPS " + " " + 
	    		LCSTopDown.lcsTopDown( X, Y, m, n ) ); 
	 } 
}
