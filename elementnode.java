// Node class to represent each node of the tree
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

// Main class
public class elementnode {

    // Method to count non-leaf nodes
    public int countNonLeafNodes(Node node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 0;

        return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.right);
    }

    // Method to search for an element in the tree
    public boolean search(Node node, int key) {
        if (node == null)
            return false;

        if (node.data == key)
            return true;

        return search(node.left, key) || search(node.right, key);
    }

    // main method
    public static void main(String[] args) {
        // Manually creating a tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Create object of elementnode class
        elementnode tree = new elementnode();

        // Count non-leaf nodes
        int nonLeaf = tree.countNonLeafNodes(root);
        System.out.println("Number of Non-Leaf Nodes: " + nonLeaf);

        // Search for an element
        int searchValue = 5;
        boolean found = tree.search(root, searchValue);
        System.out.println("Is " + searchValue + " present in the tree? " + found);
    }
}
