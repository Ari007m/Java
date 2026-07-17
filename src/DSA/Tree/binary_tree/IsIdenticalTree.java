package DSA.Tree.binary_tree;

public class IsIdenticalTree {
    /**
     * Given two binary trees with their root nodes r1 and r2, return true if both of them are identical, otherwise return false.
     * Note: Two trees are identical when they have the same data and the arrangement of the data is also same.
     */

    static void main() {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

//        Node root2 = new Node(1);
//        root2.left = new Node(2);
//        root2.right = new Node(3);
//        root2.left.left = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.right.left = new Node(4);

        System.out.println(isIdentical(root1, root2));
    }

    static boolean isIdentical(Node r1, Node r2) {
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if( r1.data != r2.data) return false;
        return isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
    }
}
