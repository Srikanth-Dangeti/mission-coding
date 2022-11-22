package GrabTrees;

public class LevelOrderTraversal {

	static Node root;
	public LevelOrderTraversal()
	{
		root=null;
	}
	
	public static int height(Node node)
	{
		if(node==null)
			return 0;
		else
		{
			int lheight=height(node.left);
			int rheight=height(node.right);
			if(lheight>rheight)
			{
				return lheight+1;

				
			}
			else
				return rheight+1;
		}
	}
	
	public static void printLevelOrder(Node node)
	{
		int h=height(node);
		//System.out.println("Height is "+ h);
		for(int i=1;i<=h;i++)
		{
			printGivenLevel(node,i);
			System.out.println();
		}
		
		
	}
	
	static void printGivenLevel (Node node ,int level) 
	{
		//System.out.println("Testingn "+node.data);
		if(node==null)
			return ;
		System.out.println(node.data+" ");
		if(level==1)
		{
			System.out.print(node.data+" ");
		}
		else
		{
			//System.out.println("Test"+ node.left.data);
			printGivenLevel(node.left, level-1);
			printGivenLevel(node.right, level-1);
		}
	}
	
	public static void main(String[]args)
	{
		LevelOrderTraversal tree=new LevelOrderTraversal();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		
		System.out.println("Level order traversal of binary tree is "); 
	       tree.printLevelOrder(root); 
	}
	
	
}
