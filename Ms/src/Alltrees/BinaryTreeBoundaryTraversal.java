package Alltrees;

public class BinaryTreeBoundaryTraversal {
	
	Node root;
	public BinaryTreeBoundaryTraversal() {
		// TODO Auto-generated constructor stub
		root=null;
	}
	
	public void printBoundaryLeft(Node node)
	{
		if(node!=null) {
			if(node.left!=null)
			{
				System.out.print(node.data+" ");
				printBoundaryLeft(node.left);
			}
			else if(node.right!=null)
			{
				System.out.print(node.data+" ");
				printBoundaryLeft(node.right);
			}
		}
	}
	
	void printBoundaryRight(Node node) 
    { 
        if (node == null) 
            return; 
  
        if (node.right != null) { 
            // to ensure bottom up order, first call for right 
            // subtree, then print this node 
            printBoundaryRight(node.right); 
            System.out.print(node.data + " "); 
        } 
        else if (node.left != null) { 
            printBoundaryRight(node.left); 
            System.out.print(node.data + " "); 
        } 
        // do nothing if it is a leaf node, this way we avoid 
        // duplicates in output 
    } 
	
	public void printLeaves(Node node)
	{
		if(node!=null)
		{
			printLeaves(node.left);
			if (node.left == null && node.right == null) 
                System.out.print(node.data + " "); 
            printLeaves(node.right); 
		}
	}
	
	public void printBoundary(Node node)
	{
		if(node!=null)
		{
			
			System.out.print(node.data+" ");
			printBoundaryLeft(node.left);
			
			printLeaves(node.left); 
            printLeaves(node.right);
            
            printBoundaryRight(node.right);
		}
	}
	
	public static void main(String []args)
	{
		BinaryTreeBoundaryTraversal tree = new BinaryTreeBoundaryTraversal(); 
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        tree.root.right = new Node(22); 
        tree.root.right.right = new Node(25); 
        tree.printBoundary(tree.root); 
	}

}
