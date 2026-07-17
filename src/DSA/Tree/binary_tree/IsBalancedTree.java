package DSA.Tree.binary_tree;

public class IsBalancedTree {
    /**
     *Given the root of a binary tree, determine if it is height-balanced or not.
     * Note: A binary tree is considered height-balanced if the absolute difference in heights of the left and right subtrees is at most 1 for every node in the tree.
     */

    static void main() {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.left.left = new Node(5);

        System.out.println(isBalanced(root));
    }

    static boolean isBalanced(Node root){
        if(root == null) return true;
        if (Math.abs(findHeight(root.left) - findHeight(root.right)) > 1) return false;
        boolean left =  isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if(!left || !right) return false;
        return true;

    }

    static int findHeight(Node root){
        if (root == null) return 0;
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}
