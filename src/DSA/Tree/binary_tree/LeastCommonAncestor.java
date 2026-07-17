package DSA.Tree.binary_tree;

public class LeastCommonAncestor {
    /**
     * Given the root of a binary tree with all unique values and two nodes value, n1 and n2.
     * Find the lowest common ancestor of the given two nodes.
     * Both node values are always present in the Binary Tree.
     * Note: LCA is the first common ancestor of both the nodes n1 and n2 from bottom of tree.
     */

    static void main() {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);

        System.out.println(lca(root, 7, 8).data);
    }

    static Node lca(Node root, int n1, int n2) {
        if(root == null) return null;

        if(root.data == n1 || root.data == n2) return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left != null && right != null) return root;

        return (left != null) ? left : right;
    }
}
