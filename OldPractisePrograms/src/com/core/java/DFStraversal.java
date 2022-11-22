package com.core.java;

public class DFStraversal {
     Node root;

    DFStraversal() {
        root = null;
    }

    public static void main(String[] args) {
        DFStraversal tree = new DFStraversal();

        tree.root            = new Node(1);
        tree.root.left       = new Node(2);
        tree.root.right      = new Node(3);
        tree.root.left.left  = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }

    void printInorder() {
        printInorder(root);
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    void printPostorder() {
        printPostorder(root);
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    void printPreorder() {
        printPreorder(root);
    }

    void printPreorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}


class Node {
    int  data;
    Node left, right;

    Node(int d) {
        this.data = d;
        left      = right = null;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
