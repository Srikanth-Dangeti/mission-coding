package GrabTrees;

class Node{
	int data;
	Node left,right;
	Node(int k)
	{
		this.data=k;
		left=right=null;
	}
}
public class TreeTraversal {
	
	static Node root;
	
	TreeTraversal()
	{
		root=null;
	}
	
	public static void printPreorder(Node node)
	{
		if(node==null)
			return ;
		System.out.print(node.data+" ");
		printPreorder(node.left);
		printPreorder(node.right);
	}
	
	public static void printPostorder(Node node)
	{
		if(node==null)
			return ;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data+" ");
	}
	
	public static void printInorder(Node node)
	{
		if(node==null)
			return;
		printInorder(node.left);
		System.out.print(node.data+" ");
		printInorder(node.right);
	}
	
	public static void main(String []args)
	{
		TreeTraversal tree=new TreeTraversal();
		tree.root=new Node(3);
		tree.root.left=new Node(45);
		tree.root.right=new Node(13);
		tree.root.left.left=new Node(6);
		tree.root.left.right=new Node(4);
		
		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder(root);
		System.out.println();
		System.out.println("PostOrder traversal of binary tree is ");
		tree.printPostorder(root);
		System.out.println();
		System.out.println("Inorder traversal of binary tree is");
		tree.printInorder(root);
		
	}
	

}
