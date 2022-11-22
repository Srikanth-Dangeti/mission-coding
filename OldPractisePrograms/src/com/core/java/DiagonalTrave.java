package com.core.java;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTrave {
	
	static Node root;
	
	DiagonalTrave()
	{
		root=null;
	}
	static void diagonalPrint(Node root)
	{
		if(root==null)
		return ;
		Queue<Node> q=new LinkedList<Node>();
		
		q.add(root);
		q.add(null);
		while(!q.isEmpty())
		{
			Node p=q.poll();
			
			if(p==null)
			{
				System.out.println();
				q.add(null);
				p=q.poll();
				if(p==null)
				break;	
			}
			
			while(p!=null)
			{
				System.out.print(p.data+" ");
				if(p.left!=null)
				{
					q.add(p.left);
				}
				p=p.right;
			}
			
			
			
			
		}
	}
	public static void main(String[] args) {
        
		DiagonalTrave tree=new DiagonalTrave();
		tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(7);
         
        diagonalPrint(root);
    }

}
