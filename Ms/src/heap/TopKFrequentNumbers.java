package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {

	public static void printtopkfrequentelements(int a[], int k)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i =0; i < a.length; i++)
		{
			if(map.containsKey(a[i]))
			{
				map.put(a[i],map.get(a[i])+1);
			}
			else
				map.put(a[i],1);
		}
		 // create a min heap
	    PriorityQueue<Entry<Integer, Integer>> minHeap 
	                  = new PriorityQueue<>(new Comparator<Entry<Integer, Integer> >() { 
	                    	@Override
	                    	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {


	                            if (o1.getValue() < o2.getValue())
	                            {
	                                return -1;
	                            }
	                            else if (o1.getValue() > o2.getValue())
	                            {
	                                return 1;
	                            }
	                            else if (o1.getValue() == o2.getValue())
	                            {
	                                return o1.getKey().compareTo(o2.getKey());
	                            }
	                            return 0;
	                        }
	                  });
	    
	    
	  //maintain a heap of size k.
	    System.out.println(map);
	    for (Entry<Integer, Integer> entry : map.entrySet()) 
	    {
	        minHeap.add(entry);
	        if (minHeap.size() > k) 
	        {
	            minHeap.poll();
	        }
	    }
	    
	    while(minHeap.size() > 0)
	    {
	    	System.out.println(minHeap.poll().getKey());
	    }
	}
	
	public static void main(String []args)
	{
		int a[] = {1,1,1,3,2,2,4};
		int k=2;
		
		printtopkfrequentelements(a, k);
	}
}
