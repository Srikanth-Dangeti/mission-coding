package Arrays;

import java.util.Arrays;

/**
 * This Class will sort different colors.
 */
public class SortColors {

    /**
     *  This method will swap the input values.
     * @param nums
     */
    public static void swapNumbers(int nums[], int low , int mid)
    {
        int a = nums[mid];
        nums[mid] = nums[low];
        nums[low] = a;

    }
    public static void sortColorsUsing3Pointers(int nums[])
    {
        int  low = 0, mid = 0, high = nums.length-1;

        while(mid<=high)
        {   
            if(nums[mid] == 0)
            {
                swapNumbers(nums, low, mid);
                mid++;
                low++;
            }
            else if(nums[mid] == 1)
            {
                mid++;
            }
            else{
                swapNumbers(nums, high, mid);
                high --; 
            }


        }
    }
    public static void sortColorsUsingCountingMethod(int nums[])
    {
        int i = 0, count0 = 0, count1 = 0, count2 =0;

        for(int num: nums)
        {
            switch(num)
            {
                case 0: count0++;
                        break;
                case 1: count1++;
                        break;
                case 2: count2++;
                        break;
            }
        }

        while(count0 > 0)
        {
            nums[i++] = 0;
            count0--;
        }

        while(count1 > 0)
        {
            nums[i++] = 1;
            count1--;
        }

        while(count2 > 0)
        {
            nums[i++] =  2;
            count2--;
        }
    }
    public static void main(String[] args) {

        int nums[] = {2, 0 , 1};//{2,0,2,1,1,0};

        System.out.println("Before Sorting the colors  = " + Arrays.toString(nums));

        //sortColorsUsingCountingMethod(nums);
        sortColorsUsing3Pointers(nums);
        System.out.println("After Sorting the colors  = " + Arrays.toString(nums));

    }
    
}
