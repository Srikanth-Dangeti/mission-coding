package Google2020Series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * Time Complexity : O(n) Since one has to visit each TreeNode
 * Space Complexity : O(n) // Either depth, height etc
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class RightViewOfBinaryTree {

    public static List<Integer> righSideView(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        bfs(root, list);

        return list;
    }

    public static void bfs(TreeNode root, List<Integer> list)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++)
            {
                TreeNode curr = queue.poll();
                if(i == 0)
                    list.add(curr.val);

                if(curr.right != null)
                    queue.add(curr.right);

                if(curr.left != null)
                    queue.add(curr.left);
            }
        }

    }

    public static void main(String []args)
    {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(40);

        System.out.println(righSideView(root));
    }
}
