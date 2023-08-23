package Google2020Series;


public class BalancedBinaryTree {
    class TreeNode{
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int val, TreeNode left, TreeNode right)
       {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }
    /*public boolean isBalanced(TreeNode node)
    {
        return  dfs(node).getKey();
    }

    private static Pair<Boolean, Integer> dfs(TreeNode root)
    {
        if(root == null)
        {
            return new Pair<Boolean, Integer>(true, 0);
        }

        Pair<Boolean, Integer> left = dfs(root.left);

        Pair<Boolean, Integer> right = dfs(root.right);

        boolean balanced = left.getKey() && right.getKey() && (Math.abs(left.getValue() - right.getValue()) <= 1);

        return new Pair<Boolean, Integer>(balanced, 1 + Math.max(left.getValue(), right.getValue()));

    }*/


    public static void main(String [] args)
    {

    }
}
