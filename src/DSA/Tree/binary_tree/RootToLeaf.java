package DSA.Tree.binary_tree;

import java.util.ArrayList;

public class RootToLeaf {

    /**
     * Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.
     * Note: The paths should be returned such that paths from the left subtree of any node are listed first, followed by paths from the right subtree.
     */

    static void main() {

        // Tree 1: [1, 2, 3, 4, 5, N, N]
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        // Tree 2: [1, 2, 3]
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        // Tree 3: [10, 20, 30, 40, 60, N, N]
        Node root3 = new Node(10);
        root3.left = new Node(20);
        root3.right = new Node(30);
        root3.left.left = new Node(40);
        root3.left.right = new Node(60);

        System.out.println(paths(root1));
    }

    static ArrayList<ArrayList<Integer>> paths(Node root) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, res, new ArrayList<>());
        return res;
    }

    static void helper(Node root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp){

        if(root == null) return;
        temp.add(root.data);
        if(root.left == null && root.right == null) res.add(new ArrayList<>(temp));

        helper(root.left, res, temp);
        helper(root.right, res, temp);

        temp.removeLast();
    }
}
