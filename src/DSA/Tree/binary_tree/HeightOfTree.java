package DSA.Tree.binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class HeightOfTree {

    /**
     * Given the root of a binary tree, your task is to find the maximum depth of the tree.
     * Note: The maximum depth or height of the tree is the number of edges in the tree from the root to the deepest node.
     */

    static void main() {
        Node root = new Node(12);
        root.left = new Node(8);
        root.right = new Node(18);
        root.left.left = new Node(5);
        root.left.right = new Node(11);

        System.out.println(findHeightBfs(root));
    }

    private static int findHeight(Node root){

        if( root == null) return -1;

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    private static int findHeightBfs(Node root){
        Queue<Node> nodeQueue = new ArrayDeque<>();
        int count = -1;
        if (root == null) return count;
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()){
            int size = nodeQueue.size();

            for(int i = 0; i < size; i++){
                Node node = nodeQueue.poll();

                if(node.left != null){
                    nodeQueue.offer(node.left);
                }

                if(node.right != null){
                    nodeQueue.offer(node.right);
                }
            }

            count++;
        }

        return count;
    }


}
