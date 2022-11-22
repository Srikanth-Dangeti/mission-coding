package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *  https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public static List<String> generateValidParentheses(int n)
    {
        ArrayList<String> generatedParen = new ArrayList<String>();
        generateParenthesesUtil(generatedParen, "", n, n);
        return generatedParen;
    }
    public static void generateParenthesesUtil(ArrayList<String> result, String generated, int open, int close)
    {
        if(open== 0 && close == 0)
        {
            result.add(generated);
            return;
        }

        if(open != 0)
        {
            generateParenthesesUtil(result, generated+"(", open - 1, close);
        }
        if(close > open)
        {
            generateParenthesesUtil(result, generated+")", open, close - 1);
        }

    }
    public static void main(String []args)
    {
        System.out.println(generateValidParentheses(3));
    }
}
