package Alltrees;

//1. BinarySerachTreeDeletionProgram only
//2. Max path through Left Child + BinarySerachTreeDeletionProgram
//3. Max path through Right Child + BinarySerachTreeDeletionProgram
//4. Max path through Left Child + BinarySerachTreeDeletionProgram + Max path through Right Child

public class BinaryTreeMaxPathSum {

	static Node root;
	public int maxPathSum(Node root) {
		int max[] = new int[1]; 
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}
	 
	
	public int calculateSum(Node root, int[] max) {
		if (root == null)
			return 0;
	 
		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);
	 
		int current = Math.max(root.data, Math.max(root.data + left, root.data + right));
	 
		max[0] = Math.max(max[0], Math.max(current, left + root.data + right));
	 
		return current;
	}
	
	
	public static void main(String args[]) { 
		
		BinaryTreeMaxPathSum tree = new BinaryTreeMaxPathSum(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(10); 
        tree.root.left.left = new Node(20); 
        tree.root.left.right = new Node(1); 
        tree.root.right.right = new Node(-25); 
        tree.root.right.right.left = new Node(3); 
        tree.root.right.right.right = new Node(4); 
        System.out.println("maximum path sum is : " + 
                            tree.maxPathSum(root)); 
    } 
}
