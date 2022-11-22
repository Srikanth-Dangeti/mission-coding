package dynamicProgramming.miscellaneous;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
//	public static void LIS(int X[])
//	{
//		int parent[]= new int[X.length]; //Tracking the predecessors/parents of elements of each subsequence.
//		int increasingSub[]= new int[X.length + 1]; //Tracking ends of each increasing subsequence.
//		int length = 0; //Length of longest subsequence.
//		
//		for(int i=0; i<X.length; i++)
//		{
//			//Binary search
//			int low = 1;
//			System.out.println("length= "+length);
//			int high = length;
//			while(low <= high)
//			{
//				System.out.println("i= "+i);
//				System.out.println("low= "+low);
//				System.out.println("high= "+high);
//				int mid = (int) Math.ceil((low + high)/2);
//				System.out.println("mid= "+mid);
//				if(X[increasingSub[mid]] < X[i])
//					low = mid + 1;
//				else
//					high = mid - 1;
//			}
//			
//			int pos = low;
//			//update parent/previous element for LIS
//			parent[i] = increasingSub[pos-1];
//			//Replace or append
//			increasingSub[pos] =  i;
//			
//			//Update the length of the longest subsequence.
//			if(pos > length)
//				length=pos;
//		}
//		
//		//Generate LIS by traversing parent array
//		int LIS[] = new int[length];
//		int k 	= increasingSub[length];
//		for(int j=length-1; j>=0; j--)
//		{
//			LIS[j] =  X[k];
//			k = parent[k];
//		}
//		
//		
//		for(int i=0; i<length; i++)
//		{
//			System.out.println(LIS[i]);
//		}
//	
//		
//	}
    public static int lengthOfLIS(int[] nums) 
    {
    	
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
        	//System.out.println("num= "+ num);
        	//System.out.println("len= "+ len);
            int i = Arrays.binarySearch(dp, 0, len, num);
            //System.out.println("i again= "+ i);
            if (i < 0) {
                i = -(i + 1);
                System.out.println("i= "+i);
            }
            dp[i] = num;
            if (i == len) {
            	//System.out.println("inside len++");
                len++;
            }
        }
        return len;
        
    }
    
	public static void main(String args[])
	{
		//int X[] = {3,1,5,0,6,4,9};
		int X[] = {2,1,3,1,6,2};
		//LIS(X);
		//String temp="sdfasdfd";
		//String res = "ressfdas";
		//System.out.println("srik"+temp+res);
		System.out.println(lengthOfLIS(X));
	}
}