package Google2020Series;

/***
 *
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root)
    {
        swap(root);
        return root;
    }

    public TreeNode invertTree2ndMethod(TreeNode root)
    {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.right = invertTree(root.left);
        node.val = root.val;
        node.left = invertTree(root.right);
        return node;
    }

    public void swap(TreeNode curr)
    {
        if(curr == null)
            return;

        swap(curr.left);
        swap(curr.right);

        //swap the childs
        TreeNode temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;
    }

    public static void main(String []args)
    {

    }
}
