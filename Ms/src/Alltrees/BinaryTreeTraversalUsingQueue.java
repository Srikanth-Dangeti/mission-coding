package Alltrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversalUsingQueue {
	
	Node root;
	
	public BinaryTreeTraversalUsingQueue() {
		root=null;
	}
	
	public void printLevelOrder()
	{
		Queue<Node> q =new LinkedList<Node>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(temp !=null)
			System.out.print(temp.data+" ");
			
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
		q.add(null);
	}
	
	public static void main(String []args)
	{
		BinaryTreeLevelOrderTraversal tree=new BinaryTreeLevelOrderTraversal();
	    tree.root= new Node(1); 
        tree.root.left= new Node(2); 
        tree.root.right= new Node(3); 
        tree.root.left.left= new Node(4); 
        tree.root.left.right= new Node(5);
        System.out.println("Level order traversal using queue of binary tree is "); 
        
        tree.printLevelOrder(); 
		
	}

}
