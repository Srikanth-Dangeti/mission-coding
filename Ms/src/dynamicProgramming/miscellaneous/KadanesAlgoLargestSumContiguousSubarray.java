package dynamicProgramming.miscellaneous;

public class KadanesAlgoLargestSumContiguousSubarray {

	public static int maxSubArraySum(int a[])
	{
		int size=a.length;
		int max_so_far=0;
		int max_ending_here=0;
		for(int i=0;i<size;i++)
		{
			max_ending_here=max_ending_here+a[i];
			if(max_ending_here<0)
				max_ending_here=0;
			else if(max_so_far<max_ending_here)
				    max_so_far=max_ending_here;
			
		}
		return max_so_far;	
	}
	
	public static void maxSubArraySumWithStartandEnd(int a[])
	{
		int size=a.length;
		int max_so_far=0;
		int max_ending_here=0;
		int s=0;
		int start=0;
		int end=0;
		
		for(int i=0;i<size;i++)
		{
			max_ending_here=max_ending_here+a[i];
			if(max_so_far<max_ending_here)
			{
				max_so_far=max_ending_here;
				start=s;
				end=i;
			}
			
			if(max_ending_here<0)
			{
				max_ending_here=0;
				s=i+1;
			}
		}
		
		System.out.println("Maximum contiguous sum is " + max_so_far); 
		System.out.println();
		System.out.println("Starting index " + start); 
		System.out.println();
		System.out.println("Ending index " + end);
		
	}
	
	public static void main(String[] args) {
		
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		System.out.println("Largest Contigous Sub-array sum "+ 	maxSubArraySum(a));
		System.out.println();
		System.out.println("Largest Contigous sum with start and end points are as below");
		System.out.println();
		maxSubArraySumWithStartandEnd(a);
	}

}
