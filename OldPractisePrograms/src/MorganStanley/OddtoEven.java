package MorganStanley;

import java.util.Arrays;

public class OddtoEven {
	static void makeEven(String stra)
	{
		int n=stra.length();
		int even=Integer.MAX_VALUE,index = 0;
		char str[]=stra.toCharArray();
		//System.out.println('0');
		//System.out.println('4');
		for (int i = 0; i < n - 1; i++) { 
			  
	        // Find the even number 
	        if ((str[i]) % 2 == 0) { 
	            even = (str[i]); 
	            index = i; 
	        } 
	  
	        // Check if current even is equal to 
	        // or less than the odd number 
	        if (even <= (str[n - 1])) 
	            break; 
	    } 
	  
	    // Return original string if there is no 
	    // even value 
	    if (even == Integer.MAX_VALUE) 
	        System.out.println(stra); 
	  
	    // Swap even and odd value 
	    //swap(str[index], str[n - 1]); 
	    
	    	char ch=str[index];
	    	str[index]=str[n-1];
	    	str[n-1]=ch;
	    	
	  System.out.println(Arrays.toString(str));
	     
		
	}
	//static void swap(char )
	public static void main(String []args)
	{
		String Str="1235785";
		makeEven(Str);
				

	}
	
	
}
