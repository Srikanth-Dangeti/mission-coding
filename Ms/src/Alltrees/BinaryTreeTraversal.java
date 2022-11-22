package Alltrees;
//DFS Traversal
/*
 * PreOrder
 * PostOrder
 * InOrder
 * 
 */
public class BinaryTreeTraversal {

	static int a[] = new int[100];
	 static Node root;
	BinaryTreeTraversal()
	{
		root=null;
	}
	 static int i =0;
	public static void preOrder(Node node)
	{
		if(node!=null)
			i++;
		if(node==null) {
			i++;
			return;
		}
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void postOrder(Node node)
	{
		if(node==null)
		{
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
	
	public static void inOrder(Node node)
	{
		if(node==null)
			return;
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
		
	}
	
	public static void main(String []args)
	{
		 BinaryTreeTraversal tree=new BinaryTreeTraversal();
		 
		 tree.root=new Node(1);
		 tree.root.left=new Node(2);
		 tree.root.right=new Node(3);
		 tree.root.left.left=new Node(4);
		 tree.root.left.right=new Node(5);
		 
		 System.out.println("DFS traversal starts");
		 System.out.println("Preoder ");
		 tree.preOrder(root);
		 System.out.println();
		 System.out.println("Postorder");
		 tree.postOrder(root);
		 System.out.println();
		 System.out.println("Inorder");
		 tree.inOrder(root);
		 
		 System.out.println("Priyam Method == i = "+ (i-1)/2);
		 
	}
}
