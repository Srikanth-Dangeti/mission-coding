package com.core.java;

public class LevelOrderTrav {
	
	Node root;
	
	LevelOrderTrav()
	{
		root=null;
	}
	void printLevelOrder()
	{
		int h=height(root);
		System.out.println(h);
		System.out.println();
		for(int i=1;i<=h;i++)
		{
			printGivenLevel(root, i);
		}
		
	}
	void printGivenLevel(Node node,int level)
	{
		if(node==null)
		  return;
		if(level==1)
		{
			System.out.println(node.data);
		}
		else if(level>1)
		{
			printGivenLevel(node.left,level-1);
			printGivenLevel(node.right,level-1);
			
		}
	}
	int height(Node node)
	{
		if(node==null)
			return 0;
		else
		{
			int hl=height(node.left);
			int hr=height(node.right);
			
			if(hl>hr)
			return (hl+1);
			else
				return (hr+1);
			
		}
		
	}
	
	public static void main(String []args) {
		
		LevelOrderTrav tree=new LevelOrderTrav();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		System.out.println("Level order traversal of binary tree is ");
	    tree.printLevelOrder();
	}
	
}
