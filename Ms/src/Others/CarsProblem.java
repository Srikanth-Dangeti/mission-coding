package Others;

import java.util.*;

public class CarsProblem {
	
public static int[] solution(String []cars) 
  {
        
        int result [] = new int[cars.length];
        
        for (int i = 0; i < cars.length; i++) 
        {
            
            for (int j = 0; j < cars.length; j++) 
            {
                if (i != j) 
                {
                    String carI = cars[i];
                    String carJ = cars[j];
                    int maxDiff = 0;
                    for (int k = 0; k < carI.length(); k++) 
                    {
                        if (carI.charAt(k) != carJ.charAt(k)) 
                        {
                            maxDiff++;
                        }
                    }
                    if (maxDiff < 2) {
                        result[i]++;
                    }
                }
            }
        }
        return result;
    }
    
    
    public static void main(String []args)
    {
    	String [] str = { "100","110", "010", "011","100"};
    	
    	int a[] = solution(str);
    	System.out.println(Arrays.toString(a));
    }

}
