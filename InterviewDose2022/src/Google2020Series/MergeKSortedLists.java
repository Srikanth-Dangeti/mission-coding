package Google2020Series;

import java.util.List;
import java.util.PriorityQueue;

/***
 *  https://leetcode.com/problems/merge-k-sorted-lists/solution/
 *
 *  Time complexity : O(N log k)where k is the number of linked lists.
 *
 * The comparison cost will be reduced to O(logk)
 * for every pop and insertion to priority queue.
 * But finding the node with the smallest value just costs O(1)O(1) time.
 * There are N nodes in the final linked list.
 *
 * Space complexity :
 *
 * O(n) Creating a new linked list costs O(n) space.
 * O(k) The code above present applies in-place method
 * which cost O(1) space. And the priority queue
 * (often implemented with heaps) costs O(k)
 * space (it's far less than NN in most situations).
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //Adding all the lists into minHeap

        for(ListNode node: lists)
        {
            while (node != null)
            {
                minHeap.add(node.val);
                node = node.next;
            }
        }

        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        while(!minHeap.isEmpty())
        {
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }

        return temp.next;

    }
    public static void main(String []args)
    {

    }
}
