package DSA.Tree.binary_tree;

public class IsSymmetricTree {

    /**
     * Given the root of a binary tree, check whether it is symmetric, i.e., whether the tree is a mirror image of itself.
     * Note: A binary tree is symmetric if the left subtree is a mirror reflection of the right subtree.
     */

    static void main() {

        Node root1 = new Node(10);
        root1.left = new Node(5);
        root1.right = new Node(5);
        root1.left.left = new Node(2);
        root1.right.right = new Node(2);

        Node root2 = new Node(8);
        root2.left = new Node(4);
        root2.right = new Node(4);
        root2.left.right = new Node(6);
        root2.right.right = new Node(6);

        System.out.println(isSymmetric(root1));
    }

    static boolean isSymmetric(Node root) {

        if (root == null) return true;
        return helper(root.left,root.right);
    }

    static boolean helper(Node left, Node right){

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.data != right.data) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
