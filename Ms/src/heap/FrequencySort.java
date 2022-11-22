package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class FrequencySort {

	public static void printFrequencySort(int a[], int k)
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
		System.out.println(map);
		 // create a min heap
	    PriorityQueue<Entry<Integer, Integer>> maxHeap 
	                  = new PriorityQueue<>(new Comparator<Entry<Integer, Integer> >() { 
	                    	@Override
	                    	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {


	                            if (o1.getValue() < o2.getValue())
	                            {
	                                return 1;
	                            }
	                            else if (o1.getValue() > o2.getValue())
	                            {
	                                return -1;
	                            }
	                            else if (o1.getValue() == o2.getValue())
	                            {
	                                return o1.getKey().compareTo(o2.getKey());
	                            }
	                            return 0;
	                        }
	                  });
	    
	    
	  //maintain a heap of size k.
	    for (Entry<Integer, Integer> entry : map.entrySet()) {
	    	maxHeap.add(entry);
	    }
	    System.out.print("maxHeap= "+maxHeap);
	    while(maxHeap.size() > 0)
	    {
	    	int elem = maxHeap.peek().getKey();
	    	//System.out.println("elem= "+elem);
	    	int freq = maxHeap.peek().getValue();
	    	//System.out.println("freq= "+freq);
	    	System.out.println();
	    	for (int i = 0; i < freq ; i++)
	    	{
	    		
	    		System.out.print(elem+" ");
	    	}
	    	maxHeap.poll();
	    }
	}
	public static void main(String []args)
	{
		int a[] = {1,1,1,3,2,2,4};
		int k=2;
		
		printFrequencySort(a, k);
	}
}
