package Others;

import java.util.ArrayList;
import java.util.List;

class Solution {
   /* public static int solution(int[] A) {
        if (A.length < 3) {
            return A[0] != A[1] ? 0 : 1;
        }
        int count = 0;
        for (int i = 0; i < A.length - 2 ; i += 2) {
            int a = A[i];
            int b = A[i+1];
            int c = A[i + 2];
            if (!(a - b > 0 && b - c < 0) && !(a - b < 0 && b - c > 0)) {
                count ++;
            }
        }
        return count;
    }*/
    
    
    public static int solution(int[] A) {
        // check if the input array in the correct order
        int count = 0;
        for(int i = 0; i < A.length - 2; i++) 
        {
            if(A[i] < A[i+1]) {
                if(!(A[i+1] > A[i+2])) {
                    count++;
                }
            }
            else if(A[i] > A[i+1]) {
                if(!(A[i+1] < A[i+2]))  {
                    count++;
                }
            }
        }
        
        if(count == 0)
            return count;
        // if false then copy to Arraylist and do the removal
        List<Integer> inputArr = new ArrayList<Integer>();
        for(int item : A) {
            inputArr.add(item);
        }
        return doTheRemoval(inputArr);
    }

    private static int doTheRemoval(List<Integer> inputArr) {
        int count = -1;
        for(int i = 0; i < inputArr.size(); i++) 
        {
            // remove tree sequencely
            inputArr.remove(i);
            // check the rest
            for(int j = 0; j < inputArr.size() - 2; j++) 
            {
                int a = inputArr.get(j);
                int b = inputArr.get(j + 1);
                int c = inputArr.get(j + 2);
                if((a - b < 0 && b - c > 0) || (a - b > 0 && b - c < 0)) 
                {
                    if(count == -1) 
                    {
                        count = 0;
                    }
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void main(String []args)
    {
    	//int a[] = {3,4,5,3,7};
    	//int a[] = {1,2,3,4};
    	int a[] = {1,3,1,2};
    	System.out.println(solution(a));
    }
}
