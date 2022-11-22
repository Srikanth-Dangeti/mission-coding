package com.core.java;

public class VerticalTrave {
	
	static Node root;
	VerticalTrave()
	{
		root=null;
	}
	void printBoundaryLeft(Node node)
	{
		if(node!=null)
		{
			if(node.left!=null)
			{
				System.out.print(node.data + " ");
				printBoundaryLeft(node.left);
			}
			else if(node.right!=null)
			{
				System.out.print(node.data + " ");
				printBoundaryLeft(node.right);
			}
		}
	}
	void printBoundaryRight(Node node)
	{
		if(node!=null)
		{
			if(node.right!=null)
			{
				printBoundaryRight(node.right);
				System.out.print(node.data + " ");
			}
			else if(node.left!=null)
			{
				printBoundaryRight(node.left);
				System.out.print(node.data + " ");
			}
		}
	}
	
	void printLeaves(Node node) 
	{
		if(node!=null)
		{
			printLeaves(node.left);
			if(node.left==null&&node.right==null)
			{
				System.out.print(node.data+" ");
			}
		}
	}
	void printBoundary(Node node)
	{
		if(node!=null)
		{
			System.out.print(node.data+" ");
			printBoundaryLeft(node.left);
			
			// Print all leaf nodes
            printLeaves(node.left);
            printLeaves(node.right);
            
            printBoundaryRight(node.right);
		}
	}
	public static void main(String args[]) 
    {
		VerticalTrave tree = new VerticalTrave();
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
