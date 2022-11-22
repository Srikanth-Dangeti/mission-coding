package Alltrees;

import java.util.*;

public class RightViewofTree {
	
	static Node root;
	
	public static List<Integer> rightView(Node root)
	{
		List<Integer> list = new ArrayList<>();
		HashMap<Character,Integer> hash= new HashMap<>();

		if(root == null)
			return list;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			
			int size  = q.size();
			
			for(int i =0; i<size ; i++)
			{
				Node current = q.remove();
				if(i ==0)
				{
					list.add(current.data);
				}
				
				if(current.left!=null)
					q.add(current.left);
				if(current.right!=null)
					q.add(current.right);
				
				
					
			}
		}
		
		return list;
		
	}
	
    public static void main(String args[]) 
    { 
        /* creating a binary tree and entering the nodes */
    	RightViewofTree tree = new RightViewofTree(); 
        tree.root = new Node(12); 
        tree.root.left = new Node(10); 
        tree.root.right = new Node(30); 
        tree.root.right.left = new Node(25); 
        tree.root.right.right = new Node(40); 
  
        List l =rightView(root); 
        System.out.println(l);
    }

}
