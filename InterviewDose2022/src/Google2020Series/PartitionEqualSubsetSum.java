package Google2020Series;

import com.sun.deploy.security.SelectableSecurityManager;

/**
 * This problem is similar to 0/1 knapsack Problem
 * //code is similar to subset sum problem
 * Time Complexity :
 * O(m⋅n), wherem is thesubSetSum, and n is the number of array elements. We iteratively fill the array of size
 * m⋅n.
 * Space Complexity :O(m⋅n) , where n is the number of array elements and m is the subSetSum
 * subSetSum. We are using a 2 dimensional array dp of size m⋅n
 */
public class PartitionEqualSubsetSum {

    public static boolean canPartition(int []nums)
    {
        int total = 0;
        for(int i = 0; i < nums.length; i++)
        {
            total += nums[i];
        }

        if(total %2 != 0)
            return false;

        int target = total / 2;

        boolean [][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;

        subsetSum(nums, target, dp);

        return dp[nums.length][target];
    }

    private static void subsetSum(int[] nums, int target, boolean[][] dp) {
        for(int i = 1; i < nums.length + 1; i++)
        {
            for (int j = 1; j < target + 1; j++)
            {
                if(nums[i - 1] <= j)
                {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];

                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

    public static void main(String[] args) {

        int  nums[]   = {1,5,11,5};

        if(canPartition(nums))
        {
            System.out.println("The array can be partitioned");
        }
        else
        {
            System.out.println("The can not be partitioned");
        }

    }
}
