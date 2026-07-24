package DSA.Tree.bnary_search_tree;

public class isBST {

    /**
     * Given the root of a binary tree. Check whether it is a BST or not.
     * A BST is defined as follows:
     * The left subtree of a node contains only nodes with data less than the node's data.
     * The right subtree of a node contains only nodes with data greater than the node's data.
     * Both the left and right subtrees must also be binary search trees.
     */

    static void main() {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        root.right.right = new Node(5);

//        Node root = new Node(2);
//        root.right = new Node(7);
//        root.right.right = new Node(6);
//        root.right.right.right = new Node(9);

//        Node root = new Node(3);
//        root.left = new Node(1);
//        root.right = new Node(5);
//        root.left.left = new Node(1);
//        root.right.left = new Node(4);
//        root.right.right = new Node(7);

        System.out.println(isBST(root));
    }

    static boolean isBST(Node root) {

//        if(root == null) return false;
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean helper(Node root, int min, int max) {

        if(root == null) return true;

        if(root.data <= min || root.data >= max) return false;
        boolean left = helper(root.left, min, root.data);
        boolean right = helper(root.right, root.data, max);

        return left && right;
    }
}
