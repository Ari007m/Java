package DSA.Tree.binary_tree;

import java.util.*;

public class RightViewOfTree {

    /**
     * Given the root of a binary Tree. Return the right view of the binary tree. The right view of a Binary Tree is the set of nodes visible when the tree is viewed from the right side.
     */

    static void main() {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);

        System.out.println(rightView(root));

    }

    private static ArrayList<Integer> rightView(Node root) {
        if (root == null) return new ArrayList<>();

        ArrayList<Integer> res = new ArrayList<>();
        helper(0, root, res);

        return res;
    }

    private static void helper(int level, Node root, ArrayList<Integer> res) {

        if (root == null) return;

        if (res.size() <= level) res.add(root.data);

        helper(level + 1, root.right, res);
        helper(level + 1, root.left, res);
    }
}
