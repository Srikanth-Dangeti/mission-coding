package dynamicProgramming.miscellaneous;

enum Index {
    GOOD, BAD, UNKNOWN
}

public class JumpGame {
	
    public static boolean canJump(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        
        for(int i = 0; i<memo.length; i++)
        	System.out.println(memo[i]);
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
            	 System.out.println("j= "+j);
            	 System.out.println("i="+i);
            	 System.out.println("memo[j]"+memo[j]);
            	 System.out.println("memo[i]"+memo[i]);
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }
    
    public static void main(String []args)
    {
    	int nums[] = {2, 4, 2, 1, 0, 2, 0};
    	
    	System.out.println(canJump(nums));
    }
}