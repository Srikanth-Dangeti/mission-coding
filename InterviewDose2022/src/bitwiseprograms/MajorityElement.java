package bitwiseprograms;

import java.util.ArrayList;
import java.util.Arrays;

public class MajorityElement {
    /**
     * Boyes and mores algorithm
     * @param array
     * @return
     */
    public static int findMajorityElement(int [] array)
    {
        int count = 0; 
        int candidate = 0; 

        for(int num : array)
        {
            if(count ==0)
            {
                candidate = num;
            }
            count += (candidate == num)? 1 : -1;
        }

        return candidate;
    }
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        
        System.out.println("Below is the Given Array");
        int numberArray[] = {2,2,1,1,1,2,2};

        System.out.println(Arrays.toString(numberArray));

        System.out.println("Majority Element = "+ findMajorityElement(numberArray));

        ArrayList<Integer> list = new ArrayList<>();



    }
}
