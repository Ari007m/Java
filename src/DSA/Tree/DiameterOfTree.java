package DSA.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class DiameterOfTree {

    /**
     * Given the root of a binary tree, your task is to find the diameter of the binary tree.
     * The diameter of a binary tree is defined as the number of edges on the longest path between any two nodes.
     * Note that this path may or may not pass through the root of the tree.
     */
    static void main() {
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(9);

        System.out.println(findDiameter(root));
    }

    private static int findDiameter(Node root){
        Queue<Node> nodeQueue = new ArrayDeque<>();
        int size = 0;
        if (root == null) return size;
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()){
            int size1 = nodeQueue.size();

            for(int i = 0; i < size1; i++){
                Node node = nodeQueue.poll();

                if(node.left != null){
                    nodeQueue.offer(node.left);
                }

                if(node.right != null){
                    nodeQueue.offer(node.right);
                }
            }

            size = Math.max(size1, size);
        }

        return size;
    }
}
