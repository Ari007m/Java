package DSA.Tree.bnary_search_tree;

public class getCount {

    /**
     * Given a Binary Search Tree (BST) and a range l-h (inclusive),
     * your task is to return the number of nodes in the BST whose value lie in the given range.
     */

    static void main() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(50);
        root.left.left = new Node(1);
        root.right.left = new Node(40);
        root.right.right = new Node(100);

        System.out.println(getCount(root, 10, 100));


    }

    static int getCount(Node root, int l, int h) {

        if (root == null) return 0;
        int count = 0;
        if (l <= root.data && h >= root.data) count = 1;

        if (root.data > l) {
            count += getCount(root.left, l, h);
        }

        if (root.data < h) {
            count += getCount(root.right, l, h);
        }

        return count;
    }
}
