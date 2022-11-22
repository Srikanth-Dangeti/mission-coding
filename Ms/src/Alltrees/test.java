package Alltrees;

import java.time.LocalDate;
import java.util.Scanner;

public class test  {
	
	
	
	public static boolean isPrime(int n) 
	{ 
	    // Corner case 
	    if (n <= 1) 
	        return false; 
	  
	    // Check from 2 to n-1 
	    for (int i = 2; i < Math.sqrt(n); i++) 
	        if (n % i == 0) 
	            return false; 
	  
	    return true; 
	}
	
	public static void main(String []l)
	{
		
		String str = "RateSchedulePT";
		for(int i =1 ; i< 1001; i++)
		{
			String res = str+i+", Job cost rate schedule";
			System.out.println(res);
		}
		 
		 
		 
	}

}
