package TrieandRelatedQuestions;

import java.util.ArrayList;

import TrieandRelatedQuestions.Trie.TrieNode;

public class WordBreakUsingTrie {
	
	static final int ALPHABET_COUNT = 26;
	
	static TrieNode root;
	//static ArrayList<String> list = new ArrayList<>();
	
	public static void insert(String word)
	{
		
		TrieNode temp = root;
		
		for(int i = 0; i < word.length(); i++)
		{
			int index = word.charAt(i)-'a';
			
			if(temp.children[index]== null)
			{
				temp.children[index] = new TrieNode();
			}
			
			temp = temp.children[index];
		}
		temp.isEndOfWord = true;
	}
	
	public static boolean search(String word)
	{
		TrieNode temp = root;
		
		for(int i = 0; i < word.length(); i++)
		{
			int index = word.charAt(i)-'a';
			if(temp.children[index]== null)
				return false;
			
			temp = temp.children[index];
		}
		
		return (temp!=null && temp.isEndOfWord);
	}
	
	// Returns true if string can be segmented
	// into space separated words, otherwise 
	// returns false
	
	public static boolean wordBreak(String word, TrieNode root)
	{
		System.out.println(word);
		int size = word.length();
		if(size == 0)
		{
			return true;
		}
		
		// Try all prefixes of lengths from 1 to size
		for(int i = 1; i <= size; i++)
		{
			boolean flag = search(word.substring(0, i)) ;
			if(flag)
				//list.add(word.substring(0,i));
			if(search(word.substring(0, i)) && wordBreak(word.substring(i, size), root))
			{
				return true;
			}
		}
		
		return false;
	}
	
	// Driver code
	public static void main(String []args)
	{
	    /*String dictionary[] = { "mobile", "samsung",
	                            "sam", "sung", "ma",
	                            "mango", "icecream", 
	                            "and", "go", "i", "like",
	                            "ice", "cream" };*/
		
		String dictionary[] = {"cats", "cat", "and", "sand", "dog"};
	                              
	    int n = dictionary.length;
	    root = new TrieNode();
	  
	    // Construct trie
	    for(int i = 0; i < n; i++)
	        insert(dictionary[i]);
	  
	    System.out.print(wordBreak("catsanddog", root) ? "Yes\n" : "No\n");
	    //System.out.println(list);
	    System.out.print(wordBreak("ilikesamsung", root) ? "Yes\n" : "No\n");
	    /*System.out.print(wordBreak("iiiiiiii", root) ?  "Yes\n" : "No\n");
	    System.out.print(wordBreak("", root) ? "Yes\n" : "No\n");
	    System.out.print(wordBreak("ilikelikeimangoiii", root) ?  "Yes\n" : "No\n");
	    System.out.print(wordBreak("samsungandmango", root) ?  "Yes\n" : "No\n");
	    System.out.print(wordBreak("samsungandmangok", root) ? "Yes\n" : "No\n");*/
	}
	

}
