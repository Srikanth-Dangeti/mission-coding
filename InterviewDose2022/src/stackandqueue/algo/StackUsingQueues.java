package stackandqueue.algo;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

   static Queue<Integer> q1 = new LinkedList<Integer>();
   static Queue<Integer> q2 = new LinkedList<Integer>();

    public static void push(int num)
    {
        q1.add(num);
    }

    public static int pop()
    {
        if(q1.isEmpty())
        {
            return -1;
        }

        while(q1.size() != 1)
        {
            q2.add(q1.remove());
        }

        int temp = q1.remove();
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;

        return temp;
    }

    public static int top()
    {
        if(q1.isEmpty())
        {
            return -1;
        }

        while(q1.size() != 1)
        {
            q2.add(q1.remove());
        }

        int temp = q1.remove();
        q2.add(temp);

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;

        return temp;

    }

    public static boolean empty()
    {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        //StackUsingQueues myStack = new StackUsingQueues();
        push(1);
        push(2);
        System.out.println("Top element of the stack = "+top()); // return 2
        System.out.println("Popping the element from the stack = "+pop()); // return 2
        System.out.println(empty()); // return False
    }
    
}
