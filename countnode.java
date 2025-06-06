class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class countnode {

    // Method to count non-leaf nodes
    public int countNonLeafNodes(Node node) {
        if (node == null)
            return 0;

        // If it's a leaf node
        if (node.left == null && node.right == null)
            return 0;

        return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.right);
    }

    public static void main(String[] args) {
        // Build the tree:
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Create object of class
        countnode tree = new countnode();

        // Call the method
        int nonLeaf = tree.countNonLeafNodes(root);
        System.out.println("Number of Non-Leaf Nodes: " + nonLeaf);
    }
}
