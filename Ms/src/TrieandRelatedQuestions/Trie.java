package TrieandRelatedQuestions;

public class Trie {
	
	static final int ALPHABET_SIZE = 26;
	
	static class TrieNode{
		
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		
		boolean isEndOfWord;
		
		public TrieNode() {
			isEndOfWord = false;
			for(int i = 0; i < ALPHABET_SIZE; i++)
			{
				children[i] = null;
			}
		}
	}
	
	static TrieNode root;

	public static void insert(String word)
	{
		TrieNode temp = root;
		
		for(int i = 0; i<word.length(); i++)
		{
			int index  = word.charAt(i)-'a'; //'a' == 97
			if(temp.children[index] == null)
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
		for(int i =0 ; i<word.length(); i++)
		{
			int index = word.charAt(i)-'a';
			if(temp.children[index] == null)
			{
				return false;
			}
			temp = temp.children[index];
			
		}
		return (temp!=null && temp.isEndOfWord);
	}
	
	public static void main(String[] args) 
	{
		
		// Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                         "by", "bye", "their"};
       
        String output[] = {"Not present in trie", "Present in trie"};
       
       
        root = new TrieNode();
        
     // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);
        
     // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
          
        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
          
        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
          
        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

	}

}
