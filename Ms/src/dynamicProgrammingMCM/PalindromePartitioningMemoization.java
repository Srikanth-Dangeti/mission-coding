package dynamicProgrammingMCM;

import java.util.Arrays;

public class PalindromePartitioningMemoization {
	static int t[][] = new int[1000][1000];
	static int left , right;
	public static int palindromepartioningMemoization(String str, int i, int j)
	{
		if(i >= j)
			return 0;
		
		if(t[i][j] != -1)
			return t[i][j];
		int min = Integer.MAX_VALUE;
		
		if(isPalindrome(str, i, j) == true)
			return 0;
		
		for(int k = i; k <= j-1; k++)
		{
			int temp = palindromepartioningMemoization(str, i, k) + palindromepartioningMemoization(str, k+1, j) + 1;
			/*if(t[i][k] != -1)
				left = t[i][k];
			else {
				left = palindromepartioningMemoization(str, i, k);
				t[i][k] = left;
			}
			
			if(t[k+1][j] != -1)
				right = t[i][k];
			else {
				right = palindromepartioningMemoization(str, k+1, j);
				t[k+1][j] = right;
			}
			
			int temp = left + right + 1;
			*/
			
			if(temp < min)
			{
				min = temp;
			}
		}
		t[i][j] = min;
		return t[i][j];
	}
	public static boolean isPalindrome(String str , int i, int j)
	{

		while(i < j)
		{
			if(str.charAt(i) != str.charAt(j))
			{
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
	public static void main(String []args)
	{
		String str= "ababbbabbababa";
		
		for(int a[] : t)
		{
			Arrays.fill(a, -1);
		}
		System.out.println("Minimum no of Palindrom partitioning are = "+palindromepartioningMemoization(str, 0, str.length()-1));
	}

}
