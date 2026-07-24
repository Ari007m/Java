package DSA.Tree.bnary_search_tree;

public class LargestBst {

    /**
     * You're given a binary tree.
     * Your task is to find the size of the largest subtree within this binary tree that also satisfies the properties of a Binary Search Tree (BST).
     * The size of a subtree is defined as the number of nodes it contains.
     * Note: A subtree of the binary tree is considered a BST if for every node in that subtree, the left child is less than the node, and the right child is greater than the node, without any duplicate values in the subtree.
     */

    static void main() {

        Node root1 = new Node(5);
        root1.left = new Node(2);
        root1.right = new Node(4);
        root1.left.left = new Node(1);
        root1.left.right = new Node(3);

        Node root2 = new Node(6);
        root2.left = new Node(7);
        root2.right = new Node(3);
        root2.left.right = new Node(2);
        root2.right.left = new Node(2);
        root2.right.right = new Node(4);

        System.out.println(largestBst(root2));
    }

    static int largestBst(Node root) {

        if(root == null) return 0;
        return helper(root).size;
    }

    static NodeValue helper(Node root){
        if(root == null) return new NodeValue( 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        if(left.max < root.data && root.data < right.min) {
            return new NodeValue(left.size + right.size + 1, Math.min(root.data, left.min), Math.max(root.data, right.max));
        }

        return new NodeValue( Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

class NodeValue{
    int size, min, max;

    NodeValue(int size, int min, int max) {
        this.size = size;
        this.min = min;
        this.max = max;
    }
}