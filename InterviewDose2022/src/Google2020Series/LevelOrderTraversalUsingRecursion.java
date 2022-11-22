package Google2020Series;

/***
 *  Time Complexity : O(n) Since each node processed once
 *  Space Complexity : O(n) to keep the output structure
 */
public class LevelOrderTraversalUsingRecursion {


    public static int height(TreeNode root)
    {
        if(root == null)
            return 0;

        int left_height = height(root.left);
        int right_height = height(root.right);

        return Math.max(left_height, right_height) + 1;
    }

    public static void printLevelOrder(TreeNode root)
    {
        int h = height(root);

        for(int i = 1; i <=h; i++)
        {
            printGivenLevelOrder(root, i);
            System.out.println();
        }

    }

    public static void printGivenLevelOrder(TreeNode root, int level)
    {
        if(root == null)
            return;

        if(level == 1)
        {
            System.out.print(root.val +" ");
        }
        else
        {
            printGivenLevelOrder(root.left, level -1);
            printGivenLevelOrder(root.right, level-1);
        }
    }
    public static void main(String []args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Level order traversal of binary Tree is ");
        printLevelOrder(root);
    }
}
