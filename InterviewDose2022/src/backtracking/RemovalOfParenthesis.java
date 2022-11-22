package backtracking;

import java.util.HashSet;
import java.util.Stack;

/***
 * https://www.youtube.com/watch?v=Cbbf5qe5stw&t=18s
 */
public class RemovalOfParenthesis {


    public static int getMin(String str)
    {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);

            if(ch == '(')
            {
                stack.push('(');
            }
            else if(ch == ')')
            {
                if(stack.size() == 0)
                {
                    stack.push(')');
                }
                else if(stack.peek() == ')')
                {
                    stack.push(')');
                }
                else if(stack.peek() == '(')
                {
                    stack.pop();
                }
            }
        }

        return stack.size();
    }

    public static void dfs(String str, int mra, HashSet<String> result)
    {
        for(int i = 0; i < str.length(); i++)
        {
            System.out.println("mra ="+ mra);
            if(mra == 0)
            {
                System.out.println(str);
                int mrnow = getMin(str);
                System.out.println("mrnow = "+ mrnow);
                if(mrnow == 0)
                {
                    if(!result.contains(str))
                    {
                        System.out.println(str);
                        result.add(str);
                    }

                }
                return;
            }
            String left = str.substring(0,i);
            String right = str.substring(i+1);



            dfs(left + right, mra - 1, result);
        }
    }


    public static void main(String []args)
    {
       /* String s1 = "()())()";
        String s2 = "(a)())()";*/
        String s3 =  ")(";

        dfs(s3, getMin(s3), new HashSet<String>());



    }
}
