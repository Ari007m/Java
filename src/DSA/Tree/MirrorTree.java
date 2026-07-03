package DSA.Tree;

import java.util.List;
import java.util.stream.Stream;

public class MirrorTree {
    /**
     * Given the root of a binary tree, convert the binary tree to its Mirror tree.
     * Note: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.
     */

    static void main() {
        // Example 1: root = [1, 2, 3, N, N, 4]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);

        // Example 2: root = [1, 2, 3, 4, 5]
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        mirror(root1);
        InsertNodeInTree.printTree(root);
    }

    static void mirror(Node root) {

        if(root == null) return;

        mirror(root.left);
        mirror(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
