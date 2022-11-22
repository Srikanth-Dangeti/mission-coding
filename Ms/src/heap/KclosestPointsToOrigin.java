package heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KclosestPointsToOrigin {

	
	public static int[][] kClosest(int[][] points, int K) {
		 PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() { 
         	@Override
         	public int compare(int a[] , int b[]) 
         	{
         		//System.out.println("a[0] = "+a[0]);
         		//System.out.println("a[1] = "+a[1]);
         		//System.out.println("b[0] = "+b[0]);
         		//System.out.println("b[1] = "+b[1]);
         		int dist = (b[1]*b[1]+b[0]*b[0]) -(a[0]*a[0]+a[1]*a[1]);
         		return dist;
             }
       });
        
		        for(int[] point : points){
		        	System.out.println("point = "+Arrays.toString(point));
		            maxHeap.add(point);
		            if(maxHeap.size() > K)
		                maxHeap.remove();
		        }
		        //System.out.println(Arrays.toString(maxHeap.peek()));
		        int[][] result = new int[K][2];
		       
		        while(K-- > 0){
		            result[K] = maxHeap.poll();
		        }
		        
		        return result;
		    }
	
	public static void main(String []args)
	{
		int a[][] = { {1, 3},
					  {-2, 2},
					  {5, 8},
					  {0, 1}
					};
		
		int k =2;
		
		System.out.println(Arrays.deepToString(kClosest(a, k)));
		
	}
	
}
