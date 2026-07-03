package DSA.Tree;

import java.lang.ref.WeakReference;

public class IsSubTree {

    /**
     * Given two binary trees with roots root1 (for tree T) and root2 (for tree S), each containing at most N nodes.
     * Determine whether tree S is a subtree of tree T.
     * Return true if S is a subtree of T, otherwise return false.
     * Note: A tree S is considered a subtree of T if there exists a node in T such that the subtree rooted at that node is identical to S.
     * Two trees are identical if they have the same structure and the same node values.
     */
    static void main() {

//        Node root1 = new Node(26);
//        root1.left = new Node(10);
//        root1.left.left = new Node(20);
//        root1.left.right = new Node(30);
//        root1.left.left.left = new Node(40);
//        root1.left.left.right = new Node(60);
//
//        Node root2 = new Node(26);
//        root2.left = new Node(10);
//        root2.left.left = new Node(20);
//        root2.left.right = new Node(30);
//        root2.left.left.left = new Node(40);
//        root2.left.left.right = new Node(60);

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.right.left = new Node(4);

        Node root2 = new Node(3);
        root2.left = new Node(4);

        System.out.println(isSubTree(root1, root2));
    }

    static boolean isSubTree(Node root1, Node root2){
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(isSameTree(root1, root2)) return true;
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    static boolean isSameTree(Node r1, Node r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if(r1.data != r2.data) return false;

        return isSameTree(r1.left, r2.left) && isSameTree(r1.right, r2.right);
    }
}
