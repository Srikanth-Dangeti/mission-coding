package Google2020Series;

import java.util.LinkedList;
import java.util.Queue;

/***
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
public class LevelOrderTraversalUsingQueue {

    public static void levelOrderTraversalUsingQueue(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return ;

        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode curr = queue.poll();

            System.out.print(curr.val +" ");

            if(curr.left != null)
                queue.add(curr.left);

            if(curr.right != null)
                queue.add(curr.right);
        }
    }

    public static void main(String []args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        levelOrderTraversalUsingQueue(root);
    }
}
