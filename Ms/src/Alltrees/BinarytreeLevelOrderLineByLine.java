package Alltrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarytreeLevelOrderLineByLine {
	
	Node root;
	public BinarytreeLevelOrderLineByLine() {
		// TODO Auto-generated constructor stub
		root=null;
	}
	
	public static void levelOrderLinebyLine(Node root)
	{
		if(root==null)
			return;
		Queue<Node> q=new LinkedList<Node>();
		
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty())
		{
			Node curr=q.poll();
			
			if(curr==null)
			{
				if(!q.isEmpty())
				{
					q.add(null);
					System.out.println();
				}
			}
			else
			{
				if(curr.left!=null)
					q.add(curr.left);
				
				if(curr.right!=null)
					q.add(curr.right);
				
				System.out.print(curr.data+" ");
			}
		}
	}
	
	public static void main(String []args)
	{
		BinarytreeLevelOrderLineByLine tree=new BinarytreeLevelOrderLineByLine();
		
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.right.left=new Node(6);
		
		System.out.println("Level order traversal Line by Line");
		
		levelOrderLinebyLine(tree.root);
	}

}
