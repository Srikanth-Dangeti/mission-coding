package Google2020Series;

/***
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Time Complexity : O(n) where
 * N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
 * Space Complexity: O(n) : This is because the maximum amount of space utilized by the recursion stack would be
 * N since the height of a skewed BST could be
 *
 */
public class LowestCommonAncestorOfBST {

    public TreeNode lowestCommonAncestor(TreeNode node, int n1, int n2)
    {
        if(n1 > node.val && n2 > node.val)
        {
            return lowestCommonAncestor(node.right, n1, n2);
        }
        if(n1 < node.val && n2 < node.val)
        {
            return lowestCommonAncestor(node.left, n1, n2);
        }

        return node;
    }
}
