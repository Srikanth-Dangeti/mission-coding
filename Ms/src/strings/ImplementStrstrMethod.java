package strings;

public class ImplementStrstrMethod {

	public static int strStr(String haystack, String needle) {
        
		// If the needle is larger than the haystack return -1
	        if(haystack.length() < needle.length())
	            return -1;
				
	          // Use the sliding window technique
			  
	        for(int i = 0; i<= (haystack.length() - needle.length()); i++ ) {
	        	System.out.println(haystack.substring(i, i+needle.length()));
	            if(haystack.substring(i, i+needle.length()).equals(needle) )
	                return i;
	        }
	        return -1;
	}
	
	public static void main(String []args)
	{
		String str1="hello";
		String str2="ll";
		System.out.println("Testing ="+str1.substring(0,2));
		System.out.println(strStr(str1, str2));
	}
}
