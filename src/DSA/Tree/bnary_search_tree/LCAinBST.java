package DSA.Tree.bnary_search_tree;

public class LCAinBST {
    /**
     * Given the root of a Binary Search Tree (with all values unique) and two nodes n1 and n2 (n1 != n2).
     * You may assume that both nodes exist in the tree. Find the Lowest Common Ancestor (LCA) of the given two nodes in the BST.
     * Note: LCA between two nodes n1 and n2 is defined as the deepest node that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).
     */

    static void main() {

        Node root1 = new Node(5);
        root1.left = new Node(4);
        root1.right = new Node(6);
        root1.left.left = new Node(3);
        root1.right.right = new Node(7);
        root1.right.right.right = new Node(8);

        Node root2 = new Node(20);
        root2.left = new Node(8);
        root2.right = new Node(22);
        root2.left.left = new Node(4);
        root2.left.right = new Node(12);
        root2.left.right.left = new Node(10);
        root2.left.right.right = new Node(14);

        Node root3 = new Node(2);
        root3.left = new Node(1);
        root3.right = new Node(3);

        System.out.println((LCA(root3, root3.left, root3.right)).data);
    }

    static Node LCA(Node root, Node n1, Node n2) {

        if (root == null) return null;

        int d1 = n1.data;
        int d2 = n2.data;

        if(d1 > d2){
            int temp = d1;
            d2 = d1;
            d1 = temp;
        }

        if(root.data >= d1 && root.data <= d2) return root;

        if(root.data > d2) return LCA(root.left, n1, n2);

        return LCA(root.right, n1, n2);

//        if(root == n1 || root == n2) return root;
//        Node left = null;
//        Node right = null;
//
//        if(root.data > n1.data && root.data > n2.data) {
//            left = LCA(root.left, n1, n2);
//        }
//        else if(root.data < n1.data && root.data < n2.data) {
//            right = LCA(root.right, n1, n2);
//        }
//        else if(root.data < n1.data && root.data > n2.data) {
//            left = LCA(root.left, n1, n2);
//            right = LCA(root.right, n1, n2);
//        }
//        else if(root.data < n2.data && root.data > n1.data) {
//            left = LCA(root.left, n1, n2);
//            right = LCA(root.right, n1, n2);
//        }
//        if(left != null && right != null) return root;
//        return left != null ? left : right;
    }
}
