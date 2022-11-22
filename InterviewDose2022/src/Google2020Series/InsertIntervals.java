package Google2020Series;

import java.util.*;

/***
 *  https://www.youtube.com/watch?v=A8NUOmlwOlM
 *  https://leetcode.com/problems/insert-interval/
 */
public class InsertIntervals {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0])
                res.add(interval);
            else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int intervals[][] = {{1, 3}, {6, 9}};
        int newInterval[] = {2, 5};
        insert(intervals, newInterval);



    }
}
