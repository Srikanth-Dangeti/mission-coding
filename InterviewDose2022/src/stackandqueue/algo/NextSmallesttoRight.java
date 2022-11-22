package stackandqueue.algo;

import java.util.*;

public class NextSmallesttoRight {

    public static void printNSE(int a[])
    {
        Stack<Integer> s = new Stack<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for(int i = a.length-1; i >= 0 ; i--)
        {
            if(s.size() == 0)
            {
                list.add(-1);
            }
            else if(s.size() > 0 && s.peek() < a[i])
            {
                list.add(s.peek());
            }
            else if(s.size() > 0 && s.peek() >= a[i])
            {
                while(s.size() > 0 && s.peek() >=a[i])
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

        int i = a.length -1;
        Collections.reverse(list);
        System.out.println(list);
        while(i >= 0)
        {
            System.out.println("Next Smaller element to the Right "+a[i]+"--->"+list.get(i));
            i--;
        }

        
    }
    public static void main(String []args)
    {
        int a[] = {11, 13, 21, 3};
        printNSE(a);
    }
}
