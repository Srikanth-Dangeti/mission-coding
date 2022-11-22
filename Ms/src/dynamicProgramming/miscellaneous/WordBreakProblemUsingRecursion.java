package dynamicProgramming.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblemUsingRecursion {

	private static Set<String> dictionary=new HashSet<String>(); 
	public static void main(String[] args) {
		/*String temp_dictionary[] = {"mobile","samsung","sam","sung",  
                "man","mango","icecream","and",  
                "go","i","like","ice","cream"}; */
		
		
		String temp_dictionary[]= {"scd","rjmowfrx", "jybldbe", "sarcbyne", "dyggxxp" ,"lorel", "nmpa", "qfwkho", "kmcoqhnw","kuewhsqmgb"};

		for(String temp:temp_dictionary)
		{
			dictionary.add(temp);
			
		}
		
		//System.out.println(wordBreak("ilikesamsung")); 
		System.out.println(wordBreak("dyggxxp"));
		/*
		 * System.out.println(wordBreak("iiiiiiii")); System.out.println(wordBreak(""));
		 * System.out.println(wordBreak("ilikelikeimangoiii"));
		 * System.out.println(wordBreak("samsungandmango"));
		 * System.out.println(wordBreak("samsungandmangok"))
		 */;

	}
	public static boolean wordBreak(String word)
	{
		int size=word.length();
		if(size==0)
		{
			return true;
		}
		
		for(int i=1;i<=size;i++) {
			
			/*
			 * System.out.print(word.substring(0,i)+" ");
			 * System.out.print(word.substring(i,size)); System.out.println();
			 */
			if(dictionary.contains(word.substring(0,i)) && wordBreak(word.substring(i, size)))
					{
				/*
				 * System.out.println("Testing Starts here");
				 * System.out.print(word.substring(0,i)+" ");
				 * System.out.print(word.substring(i,size)); System.out.println();
				 */
						return true;
						
					}
		}
		
		
		
		return false;
	}

}
