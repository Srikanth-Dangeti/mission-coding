package Alltrees.BinarySerachTrees;

public class BinarySearchTreeInsertionAndSearch {
	/* Class containing left and right child of current node and key value*/
    class Node { 
        int key; 
        Node left, right; 
  
        public Node(int item) { 
            key = item; 
            left = right = null; 
        } 
    } 
  
    // Root of BST 
    static Node root; 
  
    // Constructor 
    BinarySearchTreeInsertionAndSearch() {  
        root = null;  
    } 
  
    // This method mainly calls insertRec() 
    void insert(int key) { 
       root = insertRec(root, key); 
    } 
      
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) { 
  
        /* If the tree is empty, return a new node */
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        /* return the (unchanged) node pointer */
        return root; 
    } 
  
    // This method mainly calls InorderRec() 
    void inorder()  { 
       inorderRec(root); 
    } 
  
    // A utility function to do inorder traversal of BST 
    void inorderRec(Node root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.println(root.key); 
            inorderRec(root.right); 
        } 
    } 
  
    void preorder(Node root)
    {
    	if(root != null) {
    		System.out.println(root.key);
    		preorder(root.left);
    		preorder(root.right);
    		
    	}
    }
    
    void postorder(Node root)
    {
    	if(root != null)
    	{
    		postorder(root.left);
    		postorder(root.right);
    		System.out.println(root.key);
    	}
    }
    
    // Driver Program to test above functions 
    public static void main(String[] args) { 
    	BinarySearchTreeInsertionAndSearch tree = new BinarySearchTreeInsertionAndSearch(); 
  
        /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */
        tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
  
        // print inorder traversal of the BST 
        tree.inorder(); 
        System.out.println("preOrder= ");
        tree.preorder(root);
        System.out.println("PostOrder =");
        tree.postorder(root);
    } 
}
