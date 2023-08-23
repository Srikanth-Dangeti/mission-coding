package segmentTrees;

import java.util.*;

public class RangeSumQuery {

    /***
     * Tree Construction: O( n )
     * @param st
     * @param arr
     * @param nodeIndex
     * @param leftRange
     * @param rightRange
     */
    public static void buildSegTree(int st[], int arr[], int nodeIndex, int leftRange, int rightRange) {
        if (leftRange > rightRange)
            return;

        if (leftRange == rightRange) {
            st[nodeIndex] = arr[leftRange];
            return;
        }

        int mid = leftRange + (rightRange - leftRange) / 2;

        //left child
        buildSegTree(st, arr, 2 * nodeIndex, leftRange, mid);

        // right child
        buildSegTree(st, arr, 2 * nodeIndex + 1, mid + 1, rightRange);
        //Range Sum
        st[nodeIndex] = st[2 * nodeIndex] + st[2 * nodeIndex + 1];
        //In case of the rangeMinQuery
        //st[nodeIndex] = Math.min(st[2 * nodeIndex], st[2 * nodeIndex + 1]);
    }

    //Query in Range: O( Log n )
    public static int rangeQuery(int leftRange, int rightRange, int st[], int nodeIndex, int start, int end) {
        // NO OverLap case
        if (leftRange > end || rightRange < start)
            return 0;

        if (start >= leftRange && end <= rightRange) {
            return st[nodeIndex];// Total Overlap case
        }

        //partial overlap case

        int mid = start + (end - start) / 2;

        int leftSum = rangeQuery(leftRange, rightRange, st, 2 * nodeIndex, start, mid);

        int rightSum = rangeQuery(leftRange, rightRange, st, 2 * nodeIndex + 1, mid + 1, end);

        return leftSum + rightSum;

    }

    public static void main(String[] args) {
        int n = 6;
        int arr[] = {1, 3, 2, -2, 4, 5};

        int st[] = new int[4 * n + 1];

        int nodeIndex = 1;
        int start = 0, end = n - 1;

        //preprocess step
        buildSegTree(st, arr, nodeIndex, start, end);

        System.out.println(Arrays.toString(st));

        System.out.println("Query is 0-based Index");
        System.out.println("RangeSum(2,4) : "+ rangeQuery(2,4, st, nodeIndex, start, end));
        System.out.println("RangeSum(1,4) : "+ rangeQuery(1,4, st, nodeIndex, start, end));
        System.out.println("RangeSum(3,3) : "+ rangeQuery(3,3, st, nodeIndex, start, end));


    }
}
