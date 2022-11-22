package Google2020Series;

import java.util.ArrayList;
import java.util.List;

/**
 *  Time Complexity : O(n) in both serialization and deserialization functions,
 *  we visit each node exactly once, thus the time complexity is o(n)
 *  n is the number of nodes, i.e. the size of tree.
 *  Space Complexity : O(n) : in both serialization and deserialization functions,
 *  we keep the entire tree, either at the beginning or at the end, therefore, the space complexity is
 */
public class SerializeAndDeserializeBinaryTree {
    public static int i;
    public static String serialize(TreeNode root)
    {
        List<String> list = new ArrayList<>();
        serializeDFS(root, list);

        return String.join(",", list);
    }
    public static void serializeDFS(TreeNode root, List<String> list)
    {
        if(root == null)
        {
            list.add("N");
            return;
        }

        list.add(root.val+"");
        serializeDFS(root.left, list);
        serializeDFS(root.right, list);
    }

    public  TreeNode deserialize(String data) {
        String [] tokens = data.split(",");

        return deserializeDFS(tokens);
    }

    public TreeNode deserializeDFS(String[] tokens)
    {
        String token = tokens[this.i];
        if(token.equals("N"))
        {
            this.i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(token));
        this.i++;
        root.left = deserializeDFS(tokens);
        root.right = deserializeDFS(tokens);

        return root;


    }



    public static void main(String []args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(serialize(root));
    }
}
