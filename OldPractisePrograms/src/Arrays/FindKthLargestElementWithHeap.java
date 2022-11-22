package Arrays;
import java.util.PriorityQueue;

public class FindKthLargestElementWithHeap {

    
    public static int findKthLargest(int[] nums, int k) 
    {
       
    	PriorityQueue<Integer> q =new PriorityQueue<Integer>(k);
    	for(int i:nums)
    	{
    		q.offer(i);
    		if(q.size()>k)
    		{
    			q.poll();
    		}
    	}

        return q.peek();
    }

    public static void main(String args[]) 
    {
        int[] nums = {5,8,6,3,12,3,5,6,4,2,97};
       
        System.out.println(3%10);
        System.out.println(findKthLargest(nums,3));
    }

}