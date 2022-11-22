package Oracle;


class Queue{
	int data;
	Queue next;
	public Queue(int d) {
		this.data=d;
		this.next=null;
		
	}
}
public class QueueUsingLInkedList {
	
	static Queue front,rear;
	QueueUsingLInkedList()
	{
		front=rear=null;
	}
	
	static void enqueue(int k)
	{
		Queue temp=new Queue(k);
		if(rear==null)
		{
			front=rear=temp;
			return;
			
		}
		rear.next=temp;
		rear=temp;
		
	}
	
	static  Queue dequeue()
	{
		if(front==null)
		{
			return null;
		}
		Queue temp=front;
		front=front.next;
		
		if(front==null)
		{
			rear=null;
		}
		return temp;
		
	}

	public static void main(String[] args) {
		
		QueueUsingLInkedList q=new QueueUsingLInkedList(); 
        q.enqueue(10); 
        q.enqueue(20); 
        q.dequeue(); 
        System.out.println("Dequeued item is "+ q.dequeue().data);
        q.dequeue(); 
        q.enqueue(30); 
        q.enqueue(40); 
        q.enqueue(50); 
        
        System.out.println("Dequeued item is "+ q.dequeue().data);
		
	}

}
