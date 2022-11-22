package Oracle;
class Node{
	int data;
	Node left,right,nextright;
	Node(int d)
	{
		this.data=d;
		left=right=nextright=null;
	}
}
public class ConnecttheNodesAtSameLevel {
	
	static Node root;
	ConnecttheNodesAtSameLevel()
	{
		root=null;
	}
	static void connect(Node node)
	{
		node.nextright=null;
		connectRecur(node);
		
	}
	static void connectRecur(Node node)
	{
		if(node==null)
			return;
		
		if(node.left!=null)
		{
			node.left.nextright=node.right;
		}
		if(node.right!=null)
		{
			node.right.nextright=(node.nextright!=null)?node.nextright.left:null;
		}
		connectRecur(node.left);
		connectRecur(node.right);
		
	}
	public static void  main(String []args)
	{
		
		root =new Node(10);
		root.left=new Node(12);
		root.right=new Node(14);
		root.left.left=new Node(123);
		root.left.right=new Node(43);
		root.right.left=new Node(333);
		connect(root);
		System.out.println("Following are populated nextright pointers in "+ "the tree" + "(-1 is printed if there is no nextright)"); 
                
        int a = root.nextright != null ? root.nextright.data : -1; 
        System.out.println("nextright of " + root.data + " is " + a); 
        
               
        int b = root.left.nextright != null ?   root.left.nextright.data : -1; 
                                   
        System.out.println("nextright of " + root.left.data + " is "+ b); 
                
        int c = root.right.nextright != null ?  root.right.nextright.data : -1; 
                                   
        System.out.println("nextright of " + root.right.data + " is "+ c); 
                
        int d = root.left.left.nextright != null ?  root.left.left.nextright.data : -1; 
                              
        System.out.println("nextright of " + root.left.left.data + " is " + d); 
               
		
	}

}
