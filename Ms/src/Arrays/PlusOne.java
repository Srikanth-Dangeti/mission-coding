package Arrays;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
public class PlusOne {

public static int[] plusOne(int[] digits) {
        
        if (digits == null) {
            return null;
        }
        
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                
                //System.out.println(digits);
                return digits;
            } else {
                digits[i] = 0;
				// simulate a "carry" by continuing the loop
            }
        }

        // Code reaches here for inputs of all 9s such as [9, 9, 9]
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
            
    }


   public static void main(String []args)
   {
	   int nums[] = {9, 9, 9};
	   
	   int temp[]=plusOne(nums);
	   
	   for(int i =0; i < temp.length; i++)
		   System.out.println(temp[i]);
   }
}
