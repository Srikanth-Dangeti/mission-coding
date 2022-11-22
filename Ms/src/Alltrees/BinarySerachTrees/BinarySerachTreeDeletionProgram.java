package Alltrees.BinarySerachTrees;
// Data structure to store a Binary Search Tree node
class TreeNode
{
	int data;
	TreeNode left = null, right = null;

	TreeNode(int data) {
		this.data = data;
	}
}

class BinarySerachTreeDeletionProgram
{
	// Function to perform inorder traversal of the BST
	public static void inorder(TreeNode root)
	{
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	// Helper function to find maximum value node in subtree rooted at ptr
	public static TreeNode maximumKey(TreeNode ptr)
	{
		while (ptr.right != null) {
			ptr = ptr.right;
		}

		return ptr;
	}

	// Recursive function to insert an key into BST
	public static TreeNode insert(TreeNode root, int key)
	{
		// if the root is null, create a new node an return it
		if (root == null) {
			return new TreeNode(key);
		}

		// if given key is less than the root node, recur for left subtree
		if (key < root.data) {
			root.left = insert(root.left, key);
		}
		
		// if given key is more than the root node, recur for right subtree
		else {
			root.right = insert(root.right, key);
		}

		return root;
	}

	// Function to delete node from a BST
	public static TreeNode deleteNode(TreeNode root, int key)
	{
		// base case: key not found in tree
		if (root == null) {
			return root;
		}

		// if given key is less than the root node, recur for left subtree
		if (key < root.data) {
			root.left = deleteNode(root.left, key);
		}
		
		// if given key is more than the root node, recur for right subtree
		else if (key > root.data) {
			root.right = deleteNode(root.right, key);
		}

		// key found
		else
		{
			// Case 1: node to be deleted has no children (it is a leaf node)
			if (root.left == null && root.right == null)
			{
				// update root to null
				return null;
			}

			// Case 2: node to be deleted has two children
			else if (root.left != null && root.right != null)
			{
				// find its in-order predecessor node
				TreeNode predecessor = maximumKey(root.left);

				// Copy the value of predecessor to current node
				root.data = predecessor.data;

				// recursively delete the predecessor. Note that the
				// predecessor will have at-most one child (left child)
				root.left = deleteNode(root.left, predecessor.data);
			}

			// Case 3: node to be deleted has only one child
			else
			{
				// find child node
				TreeNode child = (root.left != null)? root.left: root.right;
				root = child;
			}
		}

		return root;
	}

	// main function
	public static void main(String[] args)
	{
		TreeNode root = null;
		int[] keys = { 15, 10, 20, 8, 12, 25 };

		for (int key : keys) {
			root = insert(root, key);
		}

		root = deleteNode(root, 12);
		// System.out.print("1");
		inorder(root);
	}
}