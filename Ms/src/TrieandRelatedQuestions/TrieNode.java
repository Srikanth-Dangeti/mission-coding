package TrieandRelatedQuestions;

public class TrieNode {
	
	TrieNode children[];
	
	boolean isEndOfWord;
	
	public TrieNode() {
		
		children = new TrieNode[26];
		for(int i = 0 ; i<26 ; i++)
		{
			children[i] = null;
		}
		
		isEndOfWord = false;
	}

}
