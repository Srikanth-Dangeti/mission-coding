package dynamicProgramming.DponTrees;

public class MaximumPathSum {
	
	static class Res{
		
		int res = Integer.MIN_VALUE;
	}
	
	static TreeNode root;
	int maxPathSumUtil(TreeNode node, Res rs) 
	{ 
		  
        // Base cases 
        if (node == null) 
            return 0; 
        //if (node.left == null && node.right == null) 
            //return node.val; 
  
        // Find maximum sum in left and right subtree. Also 
        // find maximum root to leaf sums in left and right 
        // subtrees and store them in ls and rs 
        int l = maxPathSumUtil(node.left, rs); 
        int r = maxPathSumUtil(node.right, rs); 
        
        int temp = Math.max(Math.max(l, r)+root.val, root.val);
        int ans = Math.max(temp, l+r+root.val);
        
        rs.res = Math.max(ans, rs.res);
        
        return temp;
        
    } 
	// The main function which returns sum of the maximum 
    // sum path between two leaves. This function mainly 
    // uses maxPathSumUtil() 
    int maxPathSum(TreeNode node) 
    { 
        Res r = new Res(); 
        maxPathSumUtil(root, r); 
        return r.res; 
    }
    
	public static void main(String args[]) 
	{ 
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
