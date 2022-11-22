package Google2020Series;

/***
 * Number of Zero-Filled Subarrays
 * Given an integer array nums, return the number of subarrays filled with 0.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,0,0,2,0,0,4]
 * Output: 6
 * Explanation:
 * There are 4 occurrences of [0] as a subarray.
 * There are 2 occurrences of [0,0] as a subarray.
 * There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */
public class ZeroFilledSubArrays {


    public long zeroFilledSubArray(int []nums)
    {
        long noOfSubArrays = 0;
        long noOfZeros = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] ==  0)
            {
                noOfZeros ++;
            }
            else
            {
                if(noOfZeros > 0)
                {
                    noOfSubArrays += (noOfZeros * (noOfZeros + 1))/2;
                    noOfZeros = 0;
                }
            }
        }

        //Handle the case of end of the Error
        noOfSubArrays += (noOfZeros * (noOfZeros + 1))/2;

        return noOfSubArrays;
    }

    public static void main(String []args)
    {
        //int nums[] = {1,3,0,0,2,0,0,4};
        //int nums[] = {0,0,0,2,0,0};
        int nums[] = {2,10,2019};

        System.out.println(new ZeroFilledSubArrays().zeroFilledSubArray(nums));


    }
}
