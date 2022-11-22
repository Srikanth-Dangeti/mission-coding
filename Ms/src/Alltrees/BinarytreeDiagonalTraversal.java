package Alltrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarytreeDiagonalTraversal {
	
	static Node root;
	public BinarytreeDiagonalTraversal() {
		root=null;
	}
	
	public void diagonalPrint(Node root)
	{
		Queue<Node>q=new LinkedList<Node>();
		
		if(root==null)
			return;
		
		q.add(root);
		q.add(null);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			//q.remove();
			if(temp==null)
			{
				if(q.isEmpty())
				{
					return;
				}
				System.out.println();
				q.add(null);
			}
			else
			{
				while(temp!=null) 
				{
					System.out.print(temp.data+" ");
					if(temp.left!=null)
						q.add(temp.left);
					
					temp=temp.right;
				}
			}
				
		}
	}
	
	public static void main(String args[]) 
	{  
		BinarytreeDiagonalTraversal tree=new BinarytreeDiagonalTraversal();
	    root = new Node(8);  
	    root.left = new Node(3);  
	    root.right = new Node(10);  
	    root.left.left =  new Node(1);  
	    root.left.right = new Node(6);  
	    root.right.right = new Node(14);  
	    root.right.right.left = new Node(13);  
	    root.left.right.left = new Node(4);  
	    root.left.right.right = new Node(7);  
	    tree.diagonalPrint(root);  
	}  

}
