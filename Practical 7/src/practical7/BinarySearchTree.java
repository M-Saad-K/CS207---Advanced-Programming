/**
 * @ Author : Muhammad Saad Khan
 * @ Date : 2025 / 11 / 25
 * @ Title: BinarySearchTree.java
 *
 * **/
package practical7;

import java.util.EmptyStackException;

public class BinarySearchTree<E extends Comparable<E>> {
    private BTNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    // Search for a value in the BST
    public boolean search(E value) {

        return searchRecursive(root, value);
    }

    private boolean searchRecursive(BTNode<E> node, E value) {
  
        // Use of recursion so return method name with parameters
        if (node == null) {
            return false; // There is nothing so you can't find anything
        }
        int currentNode = value.compareTo(node.getValue()); // Since it is a generic and we need it as an int, and as a uni-code int
        // Compares the value and the current node value, if both the same 0
        // If greater, 1, if not -1
        if (currentNode == 0) {
            // If found
            return true;
        } else if (currentNode < 0) {
            return searchRecursive(node.getLeftChild(), value); // Go to the smaller element
        } else {
            return searchRecursive(node.getRightChild(), value); // Go to the larger element
        }
    }

    // Insert a value into the BST
    public void insert(E value) {
        root = insertRecursive(root, value);
    }

    private BTNode<E> insertRecursive(BTNode<E> node, E value) {
       
        // Create a BST, if a root node doesn't exist
        if (node == null) {
            return new BTNode<E>(value, null, null);
        }

        int currentNode = value.compareTo(node.getValue());
        if (currentNode < 0) {
            node.setLeftChild(insertRecursive(node.getLeftChild(), value));
        } else if  (currentNode > 0) {
            node.setRightChild(insertRecursive(node.getRightChild(), value));
        }
        return  node;
    }

    // Delete a value from the BST
    public void delete(E value) {
        root = deleteRecursive(root, value);
    }

    private BTNode<E> deleteRecursive(BTNode<E> node, E value) {

        if (node == null) {
            return null;
        }
        int currentNode = value.compareTo(node.getValue());

        if (currentNode < 0) {
            node.setLeftChild(deleteRecursive(node.getLeftChild(), value)); // Search recursively the left side
        } else if (currentNode > 0) {
            node.setRightChild(deleteRecursive(node.getRightChild(), value)); // Search recursively the right
        } else { // Now done searching, checking how many children in the node

            // If the node has one child or no child
            if(node.getLeftChild() == null){

                return node.getRightChild();
            } else if(node.getRightChild() == null){

                return node.getLeftChild();
            }

            // If has two children
            node.setValue(findMin(node.getRightChild()).getValue());
            node.setRightChild(deleteRecursive(node.getRightChild(), node.getValue()));
        }
        return node;
    }

    // Helper method
    private BTNode<E> findMin(BTNode<E> node) {

        // Set a curr to the current node's left element
        // Recursively call findMin until curr == null
        if  (node.getLeftChild() != null) {
            BTNode<E> curr = node.getLeftChild();
            while (curr.getValue() != null) {
                return findMin(curr);
            }
            return curr;
        } else {
            return node;
        }
    }

    // Method to display the BST (in-order traversal)
    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(BTNode<E> node) {
        if (node != null) {
            inOrderRecursive(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inOrderRecursive(node.getRightChild());
        }
    }

    public static void main(String[] args) {
        // Creating a binary search tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Inserting elements
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(8);

        // Display tree in in-order traversal (should print sorted order)
        System.out.println("In-order Traversal after insertions:");
        bst.inOrderTraversal();
        System.out.println(); // Newline for clarity

        // Searching elements
        System.out.println("Searching for 7: " + bst.search(7)); // Should return true
        System.out.println("Searching for 20: " + bst.search(20)); // Should return false

        // Deleting elements
        System.out.println("Deleting 3 (leaf node)");
        bst.delete(3);
        System.out.println("In-order Traversal after deleting 3:");
        bst.inOrderTraversal();
        System.out.println();

        System.out.println("Deleting 10 (node with two children)");
        bst.delete(10);
        System.out.println("In-order Traversal after deleting 10:");
        bst.inOrderTraversal();
        System.out.println();

        System.out.println("Deleting 15 (node with one child)");
        bst.delete(15);
        System.out.println("In-order Traversal after deleting 15:");
        bst.inOrderTraversal();
        System.out.println();

        // Further test code
        bst.delete(5);
        bst.inOrderTraversal();
    }
}
