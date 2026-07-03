package DSA.Tree;

public class IsSumTree {

    /**
     *Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it is a Sum Tree otherwise, return false.
     * A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree.
     * An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.
     */

    static void main() {
        // Example 1
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(2);

        // Example 2
        Node root2 = new Node(10);
        root2.left = new Node(20);
        root2.right = new Node(30);
        root2.left.left = new Node(10);
        root2.left.right = new Node(10);

        // Example 3
        Node root3 = new Node(25);
        root3.left = new Node(9);
        root3.right = new Node(15);

        System.out.println(isSumTree(root1));
    }

    static boolean isSumTree(Node root) {

        return helper(root) != -1;
    }

    static int helper(Node root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        if(left == -1 || right == -1) return -1;
        if(root.left == null && root.right == null) return root.data;
        if(root.data == (left + right)) return (root.data + right + left);
        else return -1;
    }
}
