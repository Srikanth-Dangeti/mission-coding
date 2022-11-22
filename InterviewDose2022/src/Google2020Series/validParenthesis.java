package Google2020Series;

import java.util.Stack;

/***
 * https://leetcode.com/problems/valid-parentheses/
 * Time Complexity : O()
 */
public class validParenthesis {

    public static boolean isValid(String parenthesis)
    {
        char [] expression = parenthesis.toCharArray();

        return areParenthesisBalanced(expression);
    }

    public static boolean areParenthesisBalanced(char expression [])
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length; i++)
        {
            if(expression[i] == '(' || expression[i] == '[' || expression[i] == '{')
            {
                stack.push(expression[i]);
            }
            else if(expression[i] == ')' || expression[i] == ']' || expression[i] == '}')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                else if(!isMatching(expression[i], stack.pop()))
                {
                    return false;
                }
            }

        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static boolean isMatching(char left, char right)
    {
        if(left == ')' && right =='(')
            return true;
        else if(left == ']' && right == '[')
            return true;
        else if(left == '}' && right == '{')
            return true;
        else
            return false;
    }
    public static void main(String []args)
    {
        String expression = ")";
        if(isValid(expression))
        {
            System.out.println("Parenthesis is valid");
        }
        else
        {
            System.out.println("Parenthesis is not valid");
        }
    }
}
