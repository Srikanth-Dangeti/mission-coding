package Alltrees;

import java.util.LinkedList;
import java.util.Queue;

public class isCompleteTree {
	
	public boolean CompleteTree(TreeNode root) {
	    if(root==null){
	        return true;
	    }
		Queue<TreeNode> queue=new LinkedList<>();
	    queue.add(root);
	    boolean foundNull=false;
	    
	    while(!queue.isEmpty()){
	        
	        int size=queue.size();
	        
	        for(int i=0;i<size;i++){
	                 TreeNode node=queue.poll();
	                 if(node!=null && foundNull){
	                     return false;
	                 }
	                 if(node==null){
	                     foundNull=true;
	                 }
	            
	                 if(node!=null){
	                      queue.add(node.left);
	                      queue.add(node.right);
	                 }
	        }  
	    }
	    
	    return true;
	}
	
	public boolean checkisCompleteTree(TreeNode root)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.offer(root);
		
		boolean hasNull = false;
		
		while(!q.isEmpty())
		{
			TreeNode temp = q.poll();
			
			if(temp.left == null && temp.right!=null)
			{
				return false;
			}
			
			if(temp.left!=null && hasNull)
			{
				return false;
			}
			
			if(temp.left ==null && temp.right == null)
			{
				hasNull = true;
			}
			
			if(temp.left!=null)
			{
				q.offer(temp.left);
			}
			
			if(temp.right!=null)
			{
				q.offer(temp.right);
			}
		}
		
		return true;
	}

}
