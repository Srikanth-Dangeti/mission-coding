package Google2020Series;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Time Complexity : O(4 power n /n * squareroot n)
 * Each valid sequence has at most n steps during the backtracking procedure.
 * Space Complexity: O(4 power n /n * squareroot n)
 * as described above, and using O(n)O(n) space to store the sequence.
 */
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {

        ArrayList<String> generatedParenthesis=new ArrayList<>();
        dfs(generatedParenthesis,"",n,n);
        return generatedParenthesis;

    }

    public static void dfs(List<String> generatedParenthesis, String generated, int open, int close)
    {
        if(open == 0 && close == 0)
        {
            generatedParenthesis.add(generated);
            return ;
        }

        if(open != 0)
        {
            dfs(generatedParenthesis, generated + "(", open - 1, close);
        }

        if(close > open)
        {
            dfs(generatedParenthesis, generated + ")", open, close - 1);
        }
    }

    public static void main(String []args)
    {
        int n = 3;

        System.out.println(generateParenthesis(n));
    }
}
