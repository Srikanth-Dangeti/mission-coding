package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KclosetNumbers {

	class Pair 
	{ 
	    Integer key; 
	    Integer value; 
	      
	    public Pair(Integer key, Integer value) 
	    {
	        this.key = key; 
	        this.value = value; 
	    } 
	    public Integer getKey() 
	    { 
	        return key; 
	    } 
	    public void setKey(Integer key) 
	    { 
	        this.key = key; 
	    } 
	    public Integer getValue() 
	    { 
	        return value; 
	    } 
	    public void setValue(Integer value) 
	    { 
	        this.value = value; 
	    } 
	} 
	public static void printKclosest(int[] arr, int n, 
            int x, int k)  
	{ 
	
	// Make a max heap.  
	PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() { 
	public int compare(Pair p1, Pair p2) 
	{ 
		 return p2.getValue().compareTo( 
                 p1.getValue()); 
	} 
  }); 
	
	for(int i = 0; i < arr.length; i++)
	{
		pq.add(new KclosetNumbers(). new Pair(arr[i],Math.abs(arr[i] - x)));
		if(pq.size() > k)
		{
			pq.poll();
		}
	}
	
	// Print contents of heap.  
	while(!pq.isEmpty()) 
	{ 
	  System.out.print(pq.poll().getKey() + " "); 
	}
	
	}
	
	public static void main(String []args)
	{
		int arr[] = { -10, -50, 20, 17, 80 };  
	    int x = 20, k = 2;
	    printKclosest(arr, arr.length, x, k);
	    
	    long i = 80;
	    
	    System.out.println(i == 80L);
	}
}
