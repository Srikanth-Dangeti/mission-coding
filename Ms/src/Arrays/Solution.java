package Arrays;

import java.util.HashMap;

class Solution {
    public static int firstUniqChar(String s) 
    {
        
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
        	System.out.println(s.charAt(i));
            if(h.containsKey(s.charAt(i)))
            {
                h.put(s.charAt(i),h.get(s.charAt(i))+1);
            }
            else
                h.put(s.charAt(i),1);
        }
        
        System.out.println(h);
        
        for(Character ele:h.keySet())
        {
            if(h.get(ele)==1)
            {
                return s.indexOf(ele);
            }
        }
        return -1;
        
    }
    
    public static void main(String []args)
    {
    	System.out.println(firstUniqChar("leetcode"));
    	char ch[]= {'a'};
    	
    	//System.out.println(s);
    }
}