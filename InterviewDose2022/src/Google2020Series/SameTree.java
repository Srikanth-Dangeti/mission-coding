package Google2020Series;

/***
 * https://leetcode.com/problems/same-tree/submissions/
 * Time complexity : O(N)O(N), where N is a number of nodes in the tree, since one visits each node exactly once.
 *
 * Space complexity : O(N)O(N) in the worst case of completely unbalanced tree, to keep a recursion stack.
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;

        if(p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
