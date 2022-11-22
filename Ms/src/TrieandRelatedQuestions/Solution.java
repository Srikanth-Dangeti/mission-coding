package TrieandRelatedQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public class Trie{
        boolean end;
        Trie[] child;
        Trie(){
            end = false;
            child = new Trie[26];
        }
    }
    public void trieInsert(Trie root,String s){
        for(int i = 0;i<s.length();i++){
            if(root.child[s.charAt(i)-'a'] == null)
                root.child[s.charAt(i)-'a'] = new Trie();
            root = root.child[s.charAt(i)-'a'];
            
        }
        root.end = true;
    }
    public List<String> helper(String s,Trie root)
    {
    	
    	System.out.println(s);
        Trie roottosend = root;
        List<String> cans = new ArrayList<>();
        for(int i = 0;i<s.length() && root != null;i++)
        {
            root = root.child[s.charAt(i)-'a'];
            if(root != null && root.end == true)
            {
            	System.out.println(cans);
                if(i == s.length()-1)
                    cans.add(s);
                else
                {
                    List<String> thisanswer = helper(s.substring(i+1),roottosend);
                    System.out.println(thisanswer);
                    System.out.println(s);
                    for(String append : thisanswer)
                        cans.add(s.substring(0,i+1)+" "+append);
                }
            }
        }
        return cans;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
         for(String word : wordDict){
             trieInsert(root,word);
         }
        return helper(s,root);
    }
    
    
    public static void main(String []args) {
    	String s = "catsanddog";
    		String	wordDict[] = {"cat","cats","and","sand","dog"};
            List<String> al = new ArrayList<String>(Arrays.asList(wordDict));
            Solution sol = new Solution();
    	List list = sol.wordBreak(s,al);
    	System.out.println(list);
    }
}