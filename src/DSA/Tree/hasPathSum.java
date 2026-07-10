package DSA.Tree;

public class hasPathSum {

    /**
     * Given a binary tree and an integer target, check whether there is a root-to-leaf path with its sum as target.
     */

    static void main() {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(4);

        System.out.println(hasPathSum(root, 8));
    }

    static boolean hasPathSum(Node root, int target) {

        if(root == null) return false;

        return helper(root, target);
    }

    static boolean helper(Node root, int target){
        if(root == null) return false;
        if(root.left == null && root.right == null) return target == root.data;

        if(helper(root.left, target - root.data) || helper(root.right, target - root.data)) return true;

        return false;
    }
}
