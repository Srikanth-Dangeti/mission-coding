package Arrays;

/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class LargestSumContiguousSubarray {

    public static boolean maxSubArraySum(int nums[])
    {
        System.out.println("Inside the other condition");
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0, start = 0, end = 0, s = 0;

        for(int i  = 0; i < nums.length; i++)
        {
            max_ending_here += nums[i];

            if(max_so_far < max_ending_here)
            {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if(max_ending_here < 0)
            {
                max_ending_here = 0;
                s = i+1;
            }
        }

        System.out.println("Maximum contiguous sum is "
                           + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
        return true;
    }

    public static void main(String[] args) {
        
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        boolean callbackStatus = true;
        if(callbackStatus && maxSubArraySum(a))
        {
            System.out.println("Inside the fucting condition");
        }
    }
    
}
