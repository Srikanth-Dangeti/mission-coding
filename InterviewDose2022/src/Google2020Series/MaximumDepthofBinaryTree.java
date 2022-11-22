package Google2020Series;

/***
 * Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        else
        {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
    public static void main(String []args)
    {

    }
}
