package Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class AllPermutationsString {
	public static ArrayList<String> getAllPermutations(String str) {
        
        ArrayList<String> permutations = new ArrayList<String>();
         
        if(str == null || str.length() == 0) {
            permutations.add("");
            return permutations;
        }
         
        char first = str.charAt(0);
        System.out.println("first = "+first);
        String remainingString = str.substring(1);
        System.out.println("value of = "+remainingString);
        ArrayList<String> words = getAllPermutations(remainingString);
       
        System.out.println("Before the for loop");
        System.out.println(words);
        for(String word: words) {
        	System.out.println(word);
            for(int i = 0; i <= word.length(); i++) {
            	System.out.println("inside the loop");
            	System.out.println(first);
                String prefix = word.substring(0, i);
                System.out.println("prefix = "+ prefix);
                String suffix = word.substring(i);
                System.out.println("suffix = "+ suffix);
                //System.out.println("srikanth");
               
                permutations.add(prefix + first + suffix);
            }
        }
        return permutations;
    }
     
    public static void main(String[] args) {
        
    	String s="222";
    	System.out.println(s.length());
        s=""+s;
        System.out.println(s.substring(2,2));
        System.out.println(s.length());
    	String str = "123";
        ArrayList<String> permutations = getAllPermutations(str);
        System.out.println(permutations.toString());
        int a[]= {1,2,3};
        
        
        
    }
}
