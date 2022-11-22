package com.core.java;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderwithQueue {
	
	Node root;
	LevelOrderwithQueue()
	{
		root=null;
	}
	
	void printLevelOrder() 
	{
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
			
			
		}
	}
	public static void main(String args[]) 
    {
       
		LevelOrderwithQueue tree_level = new LevelOrderwithQueue();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
 
        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
	

}
