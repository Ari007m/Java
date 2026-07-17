package DSA.Tree.binary_tree;

public class MaxDiffBtwNodeAndAncestor {

    /**
     * Given a root  binary tree,
     * you need to find the maximum value which you can get by subtracting the value of node B from the value of node A,
     * where A and B are two nodes of the binary tree and A is an ancestor of B.
     */

    static void main() {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(1);

//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.right.right = new Node(7);

        System.out.println(maxDiff(root));
    }

    static int res;

    static int maxDiff(Node root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    static int helper(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        if (root.left == null && root.right == null) {
            return root.data;
        }

        int leftMin = helper(root.left);
        int rightMin = helper(root.right);

        int minChild = Math.min(leftMin, rightMin);

        if (minChild != Integer.MAX_VALUE) {
            res = Math.max(res, root.data - minChild);
        }

        return Math.min(root.data, minChild);
    }
}
