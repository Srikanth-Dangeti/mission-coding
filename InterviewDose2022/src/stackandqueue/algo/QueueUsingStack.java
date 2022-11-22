package stackandqueue.algo;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> s1 ;
    Stack<Integer> s2 ;
    public QueueUsingStack()
    {
        s1 = new Stack();
        s2 = new Stack();  
    }

    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        
        if(s1.isEmpty())
        {
            return -1;
        }
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        int poppedElement = s2.pop();
        while(!s2.isEmpty())
        {
            s1.push(s2.pop());
        }
        return poppedElement;
    }
    
    public int peek() {
        if(s1.isEmpty())
        {
            return -1;
        }
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        int poppedElement = s2.peek();
        while(!s2.isEmpty())
        {
            s1.push(s2.pop());
        }
        return poppedElement;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }


    public static void main(String[] args) {
        QueueUsingStack myqueue = new QueueUsingStack();
        myqueue.push(1);
        myqueue.push(2);
        System.out.println(myqueue.peek());
        System.out.println(myqueue.pop());
        System.out.println(myqueue.empty());
    }

    
}
