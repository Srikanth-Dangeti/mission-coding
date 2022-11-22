package Alltrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarytreeReverseLevelOrder {
	
	Node root;
	public BinarytreeReverseLevelOrder() {
		
		root=null;
	}
	
	public void reverseLevelOrder(Node root)
	{
		Stack<Node> s=new Stack<Node>();
		Queue<Node> q=new LinkedList<Node>();
		
		q.add(root);
		
		while(!q.isEmpty())
		{
			Node  node=q.poll();
			s.add(node);
			
			if(node.right!=null)
				q.add(node.right);
			
			if(node.left!=null)
				q.add(node.left);
			
		}
		
		while(!s.isEmpty())
		{
			Node temp=s.peek();
			System.out.print(temp.data + " "); 
			s.pop(); 
		}
	}
	
	public static void main(String args[]) {
		BinarytreeReverseLevelOrder tree=new BinarytreeReverseLevelOrder();
	    tree.root= new Node(1); 
        tree.root.left= new Node(2); 
        tree.root.right= new Node(3); 
        tree.root.left.left= new Node(4); 
        tree.root.left.right= new Node(5);
        System.out.println("Level order traversal of binary tree in Reverse Order"); 
        
        tree.reverseLevelOrder(tree.root);
        
	}
	

}
