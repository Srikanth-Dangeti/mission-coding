package Alltrees;

public class BinaryTreeLevelOrderTraversal {

	Node root;
	
	public BinaryTreeLevelOrderTraversal() {
		root=null;
	}
	
	public int height(Node root)
	{
		
		if(root==null)
		{
			return 0;
		}
		else
		{
			int lheight=height(root.left);
			int rheight=height(root.right);
			
			if(lheight>rheight)
				return lheight+1;
			else
			    return rheight+1;
		}
	}
	
	public  void printLevelOrder()
	{
		int h=height(root);
		for(int i=1;i<=h;i++)
		{
			printGivenLevel(root,i);
		}
	}
	
	public void printGivenLevel(Node root,int Level)
	{
		if(root==null)
		{
			return;
		}
		if(Level==1)
		{
			System.out.print(root.data+" ");
		}
		else if(Level>1)
		{
			printGivenLevel(root.left, Level-1);
			printGivenLevel(root.right, Level-1);
		}
			
	}
	
	public static void main(String []args)
	{
		BinaryTreeLevelOrderTraversal tree=new BinaryTreeLevelOrderTraversal();
	    tree.root= new Node(1); 
        tree.root.left= new Node(2); 
        tree.root.right= new Node(3); 
        tree.root.left.left= new Node(4); 
        tree.root.left.right= new Node(5);
        System.out.println("Level order traversal of binary tree is "); 
        
        tree.printLevelOrder(); 


	}
}
