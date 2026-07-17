package DSA.Tree.bnary_search_tree;

public class KthLengthBST {
    /**
     * Given the root of a Binary Search Tree (BST) and an integer k,
     * find the k-th largest element in the BST without modifying its structure.
     */

    static void main() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(9);

//        Node root = new Node(10);
//        root.left = new Node(2);
//        root.right = new Node(11);
//        root.left.left = new Node(1);
//        root.left.right = new Node(5);
//        root.left.right.left = new Node(3);
//        root.left.right.right = new Node(6);
//        root.left.right.left.right = new Node(4);

        System.out.println(kthLargest(root, 3));
    }

    static int count;
    static int res;
    static int kthLargest(Node root, int k) {

       count = k;
       res = -1;
       helper(root);
       return res;
    }

    static void helper(Node root){

        if(root == null) return;

        helper(root.right);
        if(count > 0){
            count --;
            if (count == 0){
                res = root.data;
            }
        }
        helper(root.left);
    }
}
