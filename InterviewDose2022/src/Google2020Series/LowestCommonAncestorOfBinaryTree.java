package Google2020Series;

/***
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Time Complexity : O(n) where
 *  * N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
 *  * Space Complexity: O(n) : This is because the maximum amount of space utilized by the recursion stack would be
 *  * N since the height of a skewed BST could be
 */
public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestor(root, p.val, q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int n1, int n2)
    {
        if(root == null)
            return null;

        if(root.val == n1 || root.val == n2)
        {
            return root;
        }

        TreeNode left_lca = lowestCommonAncestor(root.left, n1, n2);

        TreeNode right_lca = lowestCommonAncestor(root.right, n1, n2);

        if(left_lca !=null && right_lca !=null)
        {
            return root;
        }

        return (left_lca != null) ? left_lca : right_lca;
    }

    public static void main(String [] args)
    {

    }
}
