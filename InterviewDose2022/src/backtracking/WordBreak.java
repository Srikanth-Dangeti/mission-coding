package backtracking;

import java.util.*;

/***
 *  Word Break Problem:https://leetcode.com/problems/word-break/
 *  Backtracking Approach: Time Complexity O(2 power(n))
 *  Dynamic Programming Approach : Time Complexity O(n power 3)
 *  Given a string and a dictionary, split this string into multiple words such that
 *  * each word belongs in dictionary.
 *  *
 *  * e.g peanutbutter -> pea nut butter
 *  * e.g Iliketoplay -> I like to play
 *  *
 *  * Solution
 *  * DP solution to this problem
 *  * if( input[i...j] belongs in dictionary) T[i][j] = i
 *  * else{
 *  *     T[i][j] = k if T[i][k-1] != -1 && T[k][j] != -1
 *  *
 *  *https://www.youtube.com/watch?v=2NaaM_z_Jig
 */
public class WordBreak {

    /**
     * Prints all the words possible instead of just one combination.
     * Reference
     * https://leetcode.com/problems/word-break-ii/
     */

    public List<String> wordBreakTopDown(String s, Set<String> wordDict) {
        Map<Integer, List<String>> dp = new HashMap<>();
        int max = 0;
        for (String s1 : wordDict) {
            max = Math.max(max, s1.length());
        }
        return wordBreakUtil(s, wordDict, dp, 0, max);
    }

    private List<String> wordBreakUtil(String s, Set<String> dict, Map<Integer, List<String>> dp, int start, int max) {
        if (start == s.length()) {
            return Collections.singletonList("");
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        List<String> words = new ArrayList<>();
        for (int i = start; i < start + max && i < s.length(); i++) {
            String newWord = s.substring(start, i + 1);
            if (!dict.contains(newWord)) {
                continue;
            }
            List<String> result = wordBreakUtil(s, dict, dp, i + 1, max);
            for (String word : result) {
                String extraSpace = word.length() == 0 ? "" : " ";
                words.add(newWord + extraSpace + word);
            }
        }
        dp.put(start, words);
        return words;
    }

    public String wordBreakDp(String  word, Set<String> dict)
    {
        int t[][] = new int[word.length()][word.length()];

        for(int i = 0; i < t.length; i++)
        {
            for(int j = 0; j < t[i].length; j++)
            {
                t[i][j] = -1;
            }
        }
        return null;
    }


    public static boolean isWordBreakPossible(String sentence, HashSet<String> dictionary)
    {
        int dp[] = new int[sentence.length()];

        for(int i = 0; i < sentence.length(); i++)
        {
            for(int j = 0; j <= i; j++)
            {
                String word = sentence.substring(j, i+1);
                if(dictionary.contains(word))
                {
                    System.out.println(word);
                    if(j > 0)
                    dp[i] += dp[j-1];
                    else
                        dp[i] += 1;
                }
            }
        }

        return dp[sentence.length()-1] > 0;
    }
    public static void main(String[] args) {
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("leet");
        dictionary.add("code");
        /*dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");*/

        String word = "Ihadliketoplay";
        System.out.println("Word Break Problem");
        System.out.println(isWordBreakPossible("leetcode", dictionary));
    }
}
