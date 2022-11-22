package Google2020Series;

import java.util.*;

/***
 * https://neetcode.io/
 * Time Complexity : O(nlogn)//Sorting for the iteration O(n)
 * Space Complexity :
 */
public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        int intervalsRemoved = 0;

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        int[] intervalFirst = intervals[0];
        System.out.println(Arrays.deepToString(intervals));
        for (int i = 1; i < intervals.length; i++) {
            if (firstIntervalWithinSecond(intervalFirst, intervals[i]))
            {
                //mark first interval to be removed
                intervalsRemoved++;
                // determine which interval to remove
                //remove the interval that ends last
                System.out.println("intervalFirst[1] = "+ intervalFirst[1]+"  "+"intervals[i][1] = "+ intervals[i][1]);
                System.out.println();
                if(intervalFirst[1] > intervals[i][1])
                {

                    intervalFirst = intervals[i];
                }

            }
            else {
                intervalFirst = intervals[i];
            }
        }


        return intervalsRemoved;
    }

    public static  boolean firstIntervalWithinSecond(int[] intervalFirst, int[] intervalSecond) {
        return intervalSecond[0] < intervalFirst[1];
    }

    public static void main(String[] args) {

       int intervals [][]= {{1,2},{2,3},{3,4},{1,3}};

        System.out.println(eraseOverlapIntervals(intervals));

    }
}
