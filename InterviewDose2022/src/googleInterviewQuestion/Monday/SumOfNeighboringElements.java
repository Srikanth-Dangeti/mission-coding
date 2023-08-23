package googleInterviewQuestion.Monday;

import java.util.*;

/***
 * Time Complexity : O(M*N)
 * Space Complexity : O(Math.min(M, N))
 */
public class SumOfNeighboringElements {

    public static void sumOfNeighboringElements(int [][]matrix)
    {
        //check the inputs here
        int []prev_row = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++)
        {
            System.out.println("i = " + i);
            int prev_left = 0;
            for(int j = 0; j < matrix[0].length;j++)
            {
                System.out.println();
                int current = 0;
                current += prev_row[j]; // i!=0 check is not needed
                if(i != (matrix.length - 1))
                {
                    current += matrix[i+1][j];
                }
                current += prev_left;

                if(j != (matrix[i].length - 1))
                {
                    current += matrix[i][j+1];
                }

                prev_left = matrix[i][j];
                prev_row[j] = prev_left;
                matrix[i][j] = current;

                System.out.println("j = "+ j);
                System.out.println("prev_left = "+ prev_left);
                System.out.println("prev_row = "+ Arrays.toString(prev_row));
                System.out.println("Matrix = "+ Arrays.deepToString(matrix));
            }
            System.out.println("*************");
        }

    }
    public static void main(String[] args) {

        int matrix[][] = {
                {1, 2, 1},
                {0, 3, 4},
                {0, 6, 4}
        };

        System.out.println(Arrays.deepToString(matrix));
        sumOfNeighboringElements(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
}
