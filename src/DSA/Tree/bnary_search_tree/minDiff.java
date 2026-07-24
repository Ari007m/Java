package DSA.Tree.bnary_search_tree;

public class minDiff {

    /**
     * Given the root of a Binary Search Tree (BST) and an integer k,
     * find the minimum absolute difference between k and the value of any node in the BST.
     */

    static void main() {

//        Node root = new Node(10);
//        root.left = new Node(2);
//        root.right = new Node(11);
//        root.left.left = new Node(1);
//        root.left.right = new Node(5);
//        root.left.right.left = new Node(3);
//        root.left.right.right = new Node(6);
//        root.left.right.right.right = new Node(4);

        Node root = new Node(8);
        root.left = new Node(1);
        root.right = new Node(9);
        root.left.right = new Node(4);
        root.right.right = new Node(10);
        root.left.right.left = new Node(3);

        System.out.println(minDiff(root, 9));
    }

    static int best;
    static int minDiff(Node root, int k) {
        if (root == null) return -1;
        best = Integer.MAX_VALUE;

        helper(root, k);
        return best;
    }

    static void helper(Node root, int k){
        if(root == null) return;
        if(root.data == k){
            best = 0;
            return;
        }

        int diff = Math.abs(k - root.data);
        best = Math.min(best, diff);

        if(k < root.data){
            helper(root.left, k);
        }
        else{
            helper(root.right, k);
        }
    }
}
