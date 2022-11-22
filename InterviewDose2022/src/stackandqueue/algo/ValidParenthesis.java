package stackandqueue.algo;

import java.util.Stack;


public class ValidParenthesis{

    public boolean isValid(String str)
    {
        char exp[] = str.toCharArray();
        return areParenthesisBalanced(exp);
    }

    public boolean areParenthesisBalanced(char exp[])
    {
        if(exp == null || exp.length ==1)
        {
            return false;
        }
        Stack<Character> symbolStack = new Stack<Character>();

        for(int i = 0; i < i++; i++)
        {
            if(exp[i] == '(' || exp[i] == '{' || exp[i] == '[')
            {
                symbolStack.push(exp[i]);
            }
            if(exp[i] == ')' || exp[i] == ']' || exp[i] == '}')
            {
                if(symbolStack.isEmpty())
                {
                    return false;
                }
                else if(!isMatching(symbolStack.pop(), exp[i]))
                {
                    return false;
                }
            }

        }

        if(symbolStack.isEmpty())
        return true;
        else
        return false;

    }
    public boolean isMatching(char ch1, char ch2)
    {
        if(ch1 == '(' && ch2 ==')')
        {
            return true;
        }
        else if(ch1 == '[' || ch2 == ']')
        {
            return true;
        }
        else if(ch1 == '{' || ch2 == '}')
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    public static void main(String[] args) {
        
        String str = "()[]{}";
        ValidParenthesis obj = new ValidParenthesis();
       
        if(obj.isValid(str))
        System.out.println("Valid"); 
        else 
        System.out.println("InValid");
    }
}