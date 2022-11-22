package dynamicProgramming.LCSandAllVariationsQestions;

// P. Minimum number of deletion in a string to make it a palindrome
public class Minnoofdelinstrinmakepalindrome {

	public static void main(String []args)
	{
		String s1 = "agbcba";
		StringBuilder sb = new StringBuilder(s1);
		sb =sb.reverse();
		String s2 = sb.toString();
		char X[] = s1.toCharArray();
		char Y[] = s2.toCharArray();
		int m = X.length;
		int n = Y.length;
		
		int len = LCSTopDown.lcsTopDown(X, Y, m, n);
		System.out.println("Lenght of the LPS = "+ len);
		
		System.out.println("Minimum No of deletion required to convert a string to a Palindrom = "+ (m-len));
	}
}
