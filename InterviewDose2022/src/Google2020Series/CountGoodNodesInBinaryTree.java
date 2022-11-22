package Google2020Series;

/***
 *  Time Complexity : O(n)
 *  Space Complexity : O(h)
 */
public class CountGoodNodesInBinaryTree {

    public static int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }

    public static int helper(TreeNode root, int max) {
        if (root == null) return 0;

        int res = root.val >= max ? 1 : 0;

        res += helper(root.left, Math.max(root.val, max));
        res += helper(root.right, Math.max(root.val, max));

        return res;
    }
    public static void main(String[]args)
    {

    }
}
