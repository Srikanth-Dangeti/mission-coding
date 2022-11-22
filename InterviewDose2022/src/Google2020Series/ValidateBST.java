package Google2020Series;

/**
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
public class ValidateBST {

    public static boolean  isValid(TreeNode root)
    {
        if(root == null)
            return true;

        return isBst(root, null, null);
    }

    public static boolean isBst(TreeNode root, Integer min, Integer max)
    {
        if(root == null)
            return true;

        if((min != null && root.val <= min) || (max != null && root.val >= max))
        {
            return false;
        }

        return isBst(root.left, min, root.val) && isBst(root.right, root.val , max);
    }

    public static void main(String []args)
    {

    }
}
