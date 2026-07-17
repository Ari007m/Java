package DSA.Tree.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertNodeInTree {
    /**
     * Just inserting a Node
     */

    static void main() {
        Node root = new Node(50);

        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        int val = 90;

        Node node = new InsertNodeInTree().insertNode(root, val);

       printTree(node);

    }
//    Node prev = null;
    private Node insertNode(Node root, int val){

        if (root == null) return new Node(val);

        if(val < root.data) root.left = insertNode(root.left, val);
        else root.right = insertNode(root.right, val);
        return root;
    }

    static void printTree(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            System.out.println();
        }
    }
}
