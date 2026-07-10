package DSA.Tree;

public class FindMaxSum {

    /**
     * Given the root of a binary tree, your task is to find the maximum path sum.
     * The path may start and end at any node in the tree.
     */

    static void main() {

//        Node root = new Node(10);
//        root.left = new Node(2);
//        root.right = new Node(10);
//        root.left.left = new Node(20);
//        root.left.right = new Node(1);
//        root.right.right = new Node(-25);
//        root.right.right.left = new Node(3);
//        root.right.right.right = new Node(4);

//        Node root = new Node(-17);
//        root.left = new Node(11);
//        root.right = new Node(4);
//        root.left.left = new Node(20);
//        root.left.right = new Node(-2);
//        root.right.left = new Node(10);

        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(5);
        root.right.right = new Node(-2);

        System.out.println(findMaxSum(root));
    }

    static int max = 0;

    static int findMaxSum(Node root) {

        max = Integer.MIN_VALUE;
        if(root == null) return  0;
        helper(root);
        return max;
    }

    static int helper(Node root){
        if(root == null) return  0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        max = Math.max(max, root.data + left + right);

        return root.data + Math.max(left, right);
    }
}
