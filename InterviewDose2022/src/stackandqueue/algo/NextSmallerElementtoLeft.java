package stackandqueue.algo;

import java.util.*;

public class NextSmallerElementtoLeft {
    
    public static void printNSL(int a[])
    {
        Stack<Integer> s = new Stack<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0 ; i < a.length; i++)
        {
            if(s.size() == 0)
            {
                list.add(-1);
            }
            else if(s.size() > 0 && s.peek() < a[i])
            {
                list.add(s.peek());
            }
            else if(s.size() > 0  && s.peek() >= a[i])
            {
                while(s.size() > 0 && s.peek() >= a[i])
                {
                    s.pop();
                }
                if(s.size() == 0)
                {
                    list.add(-1);
                }
                else
                {
                    list.add(s.peek());
                }
            }
            s.push(a[i]);
        }

        int i = 0 ;
        while(i < a.length)
        {
            System.out.println("Next Smller Element to the left "+a[i]+"-->"+list.get(i));
            i++;
        }
    }
    public static void main(String[]args)
    {
        int a[] = {11, 13, 21, 3};
        printNSL(a);
    }
}
