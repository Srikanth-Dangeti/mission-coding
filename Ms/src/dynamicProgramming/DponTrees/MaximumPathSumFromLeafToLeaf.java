package dynamicProgramming.DponTrees;

import dynamicProgramming.DponTrees.MaximumPathSum.Res;

public class MaximumPathSumFromLeafToLeaf {
static class Res{
		
		int val = Integer.MIN_VALUE;
	}
	
	static TreeNode root;
	int maxPathSumUtil(TreeNode node, Res res) 
	{ 
		  
        // Base cases 
        if (node == null) 
            return 0; 
        if (node.left == null && node.right == null) 
            return node.val; 
  
        // Find maximum sum in left and right subtree. Also 
        // find maximum root to leaf sums in left and right 
        // subtrees and store them in ls and rs 
        int ls = maxPathSumUtil(node.left, res); 
        int rs = maxPathSumUtil(node.right, res); 
  
        // If both left and right children exist 
        if (node.left != null && node.right != null) { 
  
            // Update result if needed 
            res.val = Math.max(res.val, ls + rs + node.val); 
  
            // Return maxium possible value for root being 
            // on one side 
            return Math.max(ls, rs) + node.val; 
        } 
  
        // If any of the two children is empty, return 
        // root sum for root being on one side 
        return (node.left == null) ? rs + node.val 
                : ls + node.val; 
    } 
  
    // The main function which returns sum of the maximum 
    // sum path between two leaves. This function mainly 
    // uses maxPathSumUtil() 
    int maxPathSum(TreeNode node) 
    { 
        Res res = new Res(); 
        res.val = Integer.MIN_VALUE; 
        maxPathSumUtil(root, res); 
        return res.val; 
    } 
  
	public static void main(String args[]) { 
		MaximumPathSum tree = new MaximumPathSum(); 
        tree.root = new TreeNode(-15); 
        tree.root.left = new TreeNode(5); 
        tree.root.right = new TreeNode(6); 
        tree.root.left.left = new TreeNode(-8); 
        tree.root.left.right = new TreeNode(1); 
        tree.root.left.left.left = new TreeNode(2); 
        tree.root.left.left.right = new TreeNode(6); 
        tree.root.right.left = new TreeNode(3); 
        tree.root.right.right = new TreeNode(9); 
        tree.root.right.right.right = new TreeNode(0); 
        tree.root.right.right.right.left = new TreeNode(4); 
        tree.root.right.right.right.right = new TreeNode(-1); 
        tree.root.right.right.right.right.left = new TreeNode(10); 
        System.out.println("Max pathSum of the given binary tree is "
                + tree.maxPathSum(root)); 
    }
}
