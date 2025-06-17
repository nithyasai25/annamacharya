import java.util.LinkedList;
import java.util.Queue;

// Node class
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

// Main class
public class MirrorTree {

    // Method to mirror the binary tree
    public void mirror(Node node) {
        if (node == null)
            return;

        // Swap left and right
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recur for children
        mirror(node.left);
        mirror(node.right);
    }

    // Method for level-order traversal
    public void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }

    public static void main(String[] args) {
        // Build the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        MirrorTree tree = new MirrorTree();

        System.out.println("Level-order before mirroring:");
        tree.levelOrder(root);

        // Mirror the tree
        tree.mirror(root);

        System.out.println("\nLevel-order after mirroring:");
        tree.levelOrder(root);
    }
}
