package Alltrees;

public class BST {
	
	static Node root;
	public BST()
	{
		root=null;
	}
	
	public static void insert(int key)
	{
		root = insertRec(root, key); 
	}
	public static Node insertRec(Node node,int key)
	{
		if(node==null)
		{
			node=new Node(key);
			return node;
		}
		if(key<node.data)
		{
			node.left=insertRec(node.left, key);
		}
		else if(key>node.data)
		{
			node.right=insertRec(node.right, key);
		}
		
		
		return node;
	}
	public static void inorder(Node node)
	{
		if(node!=null)
		{
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
		
	}
	public static void main(String []args)
	{
		
		insert(50); 
        insert(30); 
        insert(20); 
        insert(40); 
        insert(70); 
        insert(60); 
        insert(80);
		inorder(root);
	}

}
