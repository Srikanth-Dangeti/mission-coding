package stackandqueue.algo;
import java.util.*;
public class NextGreaterElementtoRight{

    public static void printNGE(int []a)
    {
        //writ the base condition here
        if(a == null || a.length == 0)
        {
            System.out.println("No data in the array");
            return ;
        }

        Stack<Integer> s = new Stack<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for(int i = a.length-1; i >= 0; i--)
        {
            if(s.size() ==  0)
            {
                list.add(-1);
            }
            else if(s.size() > 0 && s.peek() > a[i])
            {
                list.add(s.peek());
            }
            else if(s.size() > 0 && s.peek() <= a[i])
            {
                while(s.size() > 0 && s.peek() <= a[i])
                {
                    s.pop();
                }
                if(s.size() == 0)
                {
                    list.add(-1);
                }
                else
                {
                    list.add(a[i]);
                }
            }
            s.push(a[i]);
        }

        int i = a.length -1 ;
        Collections.reverse(list);
        while(i >= 0)
        {
            System.out.println("Next Greater element to the right "+a[i] +"--->"+ list.get(i));
            i--;
        }
    }
    public static void main(String []args)
    {
        int a[] = {11,13,21,3};
        printNGE(a);
        System.out.println("Testing my code in visual studio code");
    }
}