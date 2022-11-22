package bitwiseprograms;

import java.util.HashMap;

public class SingleNumber2 
{
	public static int singleNumber(int []nums) 
	{
		int first = 0;
		int second  = 0;
		
		for(int i  = 0; i < nums.length; i++)
		{
			System.out.println(first ^ nums[i]);
			System.out.println("~second = "+ ~second);
			first = (first ^ nums[i] & (~second));
			
			second = (second ^ nums[i] & (~first));
		}
		
		return first;
	}

	public static void main(String[]args)
	{
		int nums [] = {2,2,2,3};
		System.out.println(singleNumber(nums));
	}

}
