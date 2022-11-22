package dynamicProgrammingMCM;

public class PalindromePartitioningRecurive {
	
	public static int palindromepartioning(String str, int i, int j)
	{
		if(i >= j)
			return 0;
		
		int min = Integer.MAX_VALUE;
		
		if(isPalindrome(str, i, j) == true)
			return 0;
		
		for(int k = i; k <= j-1; k++)
		{
			int temp = palindromepartioning(str, i, k) + palindromepartioning(str, k+1, j) + 1;
			
			if(temp < min)
			{
				min = temp;
			}
		}
		
		return min;
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
		
		System.out.println("Minimum no of Palindrom partitioning are = "+palindromepartioning(str, 0, str.length()-1));
		
		
	}

}
