package Google2020Series;
import java.util.*;

/***
 * Time complexity : O(n). In worst case, only two scans of the whole array are needed.
 *
 * Space complexity : O(1). No extra space is used. In place replacements are done.
 *
 */
public class NextPermutation {

    public void nextPermutation(int nums[])
    {
        int n = nums.length;
        if(nums.length == 1)
            return ;

        int lastIndex = -1;
        for(int i = 1 ; i < n; i++)
        {
            if(nums[i] > nums[i - 1])
            {
                lastIndex = i;
            }
        }

        // handle the all decreasing elements Array
        if(lastIndex == -1)
        {
            for(int i = 0; i < n/2; i++)
            {
                swap(nums, i, n-1-i);
            }

            return ;
        }

        int index = lastIndex;

        for (int i = lastIndex; i < n; i++)
        {
            if(nums[i] > nums[lastIndex - 1] && nums[i] < nums[lastIndex])
            {
                index = i;
            }
        }

        swap(nums, lastIndex - 1, index);
        Arrays.sort(nums, lastIndex, n);

    }

    public void swap(int nums[], int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String []args)
    {
        int nums[] = {2, 1, 8, 7, 6, 5};

        NextPermutation obj = new NextPermutation();
        obj.nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}
