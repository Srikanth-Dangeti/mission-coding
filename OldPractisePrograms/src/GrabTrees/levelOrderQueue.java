package GrabTrees;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrderQueue {
	
	static Node root;
	public levelOrderQueue()
	{
		root=null;
	}
	public void levelorderUsingQueue(Node node)
	{
		Queue<Node>q=new LinkedList<Node>();
		if(node==null)
			return;
		q.add(node);
		
		while (!q.isEmpty()) { 
			  
		      Node curr = q.poll(); 
		  
		      System.out.print(curr.data + " "); 
		        // Pushing left child current node 
		        if (curr.left != null) 
		          q.add(curr.left); 
		  
		        // Pushing right child current node 
		        if (curr.right != null) 
		          q.add(curr.right); 
		  
		        
		    }
		
	}
	public static void main(String []args)
	{
		
		levelOrderQueue tree=new levelOrderQueue();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		
		System.out.println("Level order traversal of binary tree is "); 
	       tree.levelorderUsingQueue(root); 
		
	}

}
