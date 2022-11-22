package Alltrees;

public class ValidateBST {

	Node root;

	// To keep tract of previous node in Inorder Traversal
	Node prev;

	/*
	 * boolean isBST() { prev = null; return isBST(root); }
	 * 
	 * Returns true if given search tree is binary search tree (efficient version)
	 * boolean isBST(BinarySerachTreeDeletionProgram node) { // traverse the tree in inorder fashion and //
	 * keep a track of previous node
	 * 
	 * if (node != null) { System.out.println(node.data); boolean
	 * flag=isBST(node.left); System.out.println("flag value= "+flag); if (!flag)
	 * return false;
	 * 
	 * // allows only distinct values node if(prev!=null)
	 * System.out.println("prev value= "+prev.data); if (prev != null && node.data
	 * <= prev.data ) { System.out.println("prev value= "+prev.data); return false;
	 * 
	 * } prev = node; System.out.println("for right subtree"); return
	 * isBST(node.right); } System.out.println("Test"); return true; }
	 */

	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <= max.
	 */
	boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		System.out.println("value= "+node.data);
		System.out.println("bmin= "+min);
		System.out.println("bmax= "+max);
		if (node.data < min || node.data > max)
		{
			//System.out.println(node.data);
			System.out.println("min= "+min);
			System.out.println("max= "+max);
			System.out.println("inside the condition of min and max constraints");
			return false;
			
		}

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		ValidateBST tree = new ValidateBST();
		tree.root=new Node(-2147483648);
		tree.root.left=new Node(-2147483648);
		/*,2147483648 
		 * tree.root = new BinarySerachTreeDeletionProgram(3); tree.root.left = new BinarySerachTreeDeletionProgram(2); tree.root.right = new
		 * BinarySerachTreeDeletionProgram(5); tree.root.left.left = new BinarySerachTreeDeletionProgram(1); tree.root.left.right = new
		 * BinarySerachTreeDeletionProgram(4);
		 */

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
}
