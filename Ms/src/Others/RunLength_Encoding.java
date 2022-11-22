package Others;
// Java program to implement run length encoding

import java.util.TreeMap;

public class RunLength_Encoding {
	
	static TreeMap<String,String> treemap = new TreeMap<>();
	public static String printRLE(String str)
	{
		int n = str.length();
		String res = "";
		for (int i = 0; i < n; i++) {

			// Count occurrences of current character
			int count = 1;
			while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
				count++;
				i++;
			}

			if(count>1)
			{
				res = res+str.charAt(i)+count;
				
			}
			else
			{
				res = res+str.charAt(i);
			}
			
		}
		
	 
		System.out.println(res);
		
		return res;
	}
	
	

	public static void main(String[] args)
	{
		String str = "aabaaa";
		
		String res =printRLE(str);
		int count  =0,k =1;
		for(int i = 0; i<res.length();i++)
		{
			
		}
	}
}
