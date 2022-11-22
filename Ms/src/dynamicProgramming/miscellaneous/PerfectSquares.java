package dynamicProgramming.miscellaneous;

import java.util.Arrays;
import java.util.Scanner;

//https://leetcode.com/explore/interview/card/top-interview-questions-hard/121/dynamic-programming/863/
public class PerfectSquares {

	public static int numSquares(int n) {
		
	    int max = (int) Math.sqrt(n);
	 
	    System.out.println("max= "+ max);
	    int[] dp = new int[n+1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    
	    for(int i=1; i<=n; i++){
	        for(int j=1; j<=max; j++){
	            if(i==j*j){
	                dp[i]=1;
	            }else if(i>j*j){
	            	System.out.println("i= "+i);
	            	//System.out.println("j*j= "+ j*j);
	            	//System.out.println("i = "+ i);
	            	System.out.println("dp[i] = "+ dp[i]);
	                dp[i]=Math.min(dp[i], dp[i-j*j] + 1);
	                System.out.println("After dp[i]= "+dp[i]);
	            }
	        }
	    }
	 
	    return dp[n];
	}
	
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Number");
		
		int n=sc.nextInt();
		
		System.out.println("The least number of perfect square numbers = "+ numSquares(n));
	}
}
