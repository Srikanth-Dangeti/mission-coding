package HashMap;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    
    public static List<List<String>> groupAnagrams(String[] str)
    {
        HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();

        for(int i = 0 ; i < str.length; i++)
        {
            String word = str[i];

            char letters[] = word.toCharArray();

            Arrays.sort(letters);
            String newWord = new String(letters);

            if(hmap.containsKey(newWord))
            {
                hmap.get(newWord).add(word);
            }
            else
            {
                List<String> newList = new ArrayList<String>();
                newList.add(word);
                hmap.put(newWord, newList);
            }

        }


        List<String> list = new ArrayList<String>();
        List<List<String>> result = new ArrayList(list);

        for(String key : hmap.keySet())
        {
            List<String> values = hmap.get(key);
            if(values.size() > 0)
            {
                result.add(values);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String str[] = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(str));

    }
}
