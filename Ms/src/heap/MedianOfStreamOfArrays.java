package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfStreamOfArrays {
	private PriorityQueue<Integer> minHeap, maxHeap;

	MedianOfStreamOfArrays() 
	{
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    void add(int num) 
    {
        if (minHeap.size() == maxHeap.size()) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    double getMedian() 
    {
    	if (maxHeap.isEmpty())
    		return 0;
    	int lsize = maxHeap.size();
        int rsize = minHeap.size();
        if(lsize > rsize)  //Return top of maxheap for odd no of elements
            return Double.valueOf(maxHeap.peek());
        else    //Else return avg of top of maxheap and minheap
        	return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
	
	public static void main(String []args)
	{
		
		MedianOfStreamOfArrays med = new MedianOfStreamOfArrays();
		
		med.add(5);
		System.out.println(med.getMedian());
		med.add(7);
		System.out.println(med.getMedian());
		med.add(8);
		System.out.println(med.getMedian());
		med.add(10);
		System.out.println(med.getMedian());
		
	}

}
