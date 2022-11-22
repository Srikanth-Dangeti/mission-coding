package Google2020Series;

import java.util.*;

/***
 *  https://leetcode.com/problems/merge-intervals/
 *  Time Complexity : O(nlogn)
 *  Space Complexity : O(longn) or O(n)
 *  If we can sort intervals in place,
 *  we do not need more than constant additional space,
 *  although the sorting itself takes
 * O(logn) space. Otherwise, we must allocate linear
 * space to store a copy of intervals and sort that.
 */

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {

    public static void mergeIntervals(Interval arr[]) {
        if (arr.length <= 0) {
            return;
        }

        Stack<Interval> stack = new Stack<Interval>();

        //Sort the intervals in the increasing order of the start time.

        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        //push the first interval to stack
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            //get the interval from the stack
            Interval top = stack.peek();

            // if the current interval is not overlapping with stack top ,
            //push it to stack
            if (top.end < arr[i].start) {
                stack.push(arr[i]);
            }

            //Otherwise update the ending time of the top if the ending of the current
            //interval is more.

            else if (top.end < arr[i].end) {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }

        }


        //Just to check the arr is sorted or not.
       /* for (Interval i : arr) {
            System.out.println(i.start + " --- " + i.end);
        }*/

        // Print contents of stack
        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty()) {
            Interval t = stack.pop();
            System.out.print("[" + t.start + "," + t.end + "] ");
        }
    }

    public static void main(String[] args) {
        Interval arr[] = new Interval[4];
        /*arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);*/

        arr[0] = new Interval(3, 7);
        arr[1] = new Interval(4, 9);
        arr[2] = new Interval(5, 9);
        arr[3] = new Interval(9, 8);

        mergeIntervals(arr);
    }
}
