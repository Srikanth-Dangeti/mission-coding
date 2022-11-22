package Google2020Series;

/***
 * Time complexity: O(n).
 *
 * We store the maximum heights upto a point using 2 iterations of O(n) each.
 * We finally update ans using the stored values in O(n).
 * Space complexity: O(n) extra space.
 *
 * Additional O(n) space for left_max and right_max arrays than in
 */
public class TrappingRainWater {
    public static int getTrappedWater(int nums[])
    {
        int maxl[] = new int[nums.length];

        int maxr[] = new int[nums.length];

        maxl[0] = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            maxl[i] = Math.max(maxl[i - 1], nums[i]);
        }

        maxr[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--)
        {
            maxr[i] = Math.max(maxr[i+1], nums[i]);
        }
        int totalWaterTrapped = 0;

        for (int i = 0; i < nums.length; i++)
        {
            totalWaterTrapped += Math.min(maxl[i], maxr[i]) - nums[i];
        }

        return totalWaterTrapped;
    }
    public static void main(String []args)
    {
        int a[] = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println("Rain water in the Area of = "+ getTrappedWater(a));

    }
}
