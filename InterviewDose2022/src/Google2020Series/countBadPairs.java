package Google2020Series;

public class countBadPairs {
    public static long countBadPairs(int[] nums) {

        long count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 1; j < nums.length - 1; j++)
            {
                if(j - i != nums[j] - nums[i])
                {
                    System.out.println("j - i = "+ (j - i));
                    System.out.println("nums[j] - nums[i] = " + (nums[j] - nums[i]));
                    count ++;
                }
            }
        }

        return count;

    }
    public static void main(String[] args) {
        int nums [] = {43,69,66,40,33};
        //int nums [] = {4,1,3,3};

        System.out.println(countBadPairs(nums));
    }
}
