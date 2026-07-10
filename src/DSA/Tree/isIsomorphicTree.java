package DSA.Tree;

public class isIsomorphicTree {

    /**
     * Given the roots of two binary trees, determine whether the trees are isomorphic to each other.
     * Return true if the two trees are isomorphic; otherwise, return false.
     * Note:
     * Two trees are called isomorphic if one can be obtained from another by a series of flips, i.e. by swapping left and right children of several nodes.
     * Any number of nodes at any level can have their children swapped. Two empty trees are isomorphic.
     * For example, the following two trees are isomorphic with the following subtrees flipped: 2 and 3, NULL and 6, 7 and 8.
     */

    static void main() {

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.left.right.left = new Node(7);
        root1.left.right.right = new Node(8);

        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.left.right = new Node(6);
        root2.right.left = new Node(4);
        root2.right.right = new Node(5);
        root2.right.right.left = new Node(8);
        root2.right.right.right = new Node(7);

//        Node root1 = new Node(1);
//        root1.left = new Node(2);
//        root1.right = new Node(3);
//        root1.left.left = new Node(4);
//
//        Node root2 = new Node(1);
//        root2.left = new Node(3);
//        root2.right = new Node(2);
//        root2.right.right = new Node(4);

//        Node root1 = new Node(1);
//        root1.left = new Node(2);
//        root1.right = new Node(3);
//        root1.left.left = new Node(4);
//
//        Node root2 = new Node(1);
//        root2.left = new Node(3);
//        root2.right = new Node(2);
//        root2.left.left = new Node(4);

        System.out.println(isIsomorphic(root1, root2));

    }

    static boolean isIsomorphic(Node root1, Node root2) {

        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if (root1.data != root2.data) return false;

        boolean same = isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);
        boolean flip = isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);

        return same || flip;
    }
}
