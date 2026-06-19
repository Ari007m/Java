package DSA.Tree;

import java.util.*;

public class VerticalTraversal {

    /**
     * Given the root of a Binary Tree, find the vertical traversal of the tree starting from the leftmost level to the rightmost level.
     * Note: If there are multiple nodes passing through a vertical line, then they should be printed as they appear
     * in level order traversal of the tree.
     */

    static void main() {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.right = new Node(8);
        root.right.left.right = new Node(9);
        root.right.right.right = new Node(10);
        root.left.right.right.left = new Node(11);

        System.out.println(verticalOrder(root));
    }

    static ArrayList<ArrayList<Integer>> verticalOrder(Node root){

        if (root == null) return new ArrayList<>();

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int minCol = 0, maxCol = 0;

        // Queue for nodes
        Queue<Node> nodeQueue = new LinkedList<>();
        // Queue for columns
        Queue<Integer> colQueue = new LinkedList<>();

        nodeQueue.offer(root);
        colQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            int col = colQueue.poll();

            // Create list for this column if not exists
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }

            // Add node value to its column (in level order)
            map.get(col).add(node.data);

            // Update min and max column
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            // Push left child with col-1
            if (node.left != null) {
                nodeQueue.offer(node.left);
                colQueue.offer(col - 1);
            }

            // Push right child with col+1
            if (node.right != null) {
                nodeQueue.offer(node.right);
                colQueue.offer(col + 1);
            }
        }

        // Build result from minCol to maxCol
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int col = minCol; col <= maxCol; col++) {
            result.add(map.get(col));
        }

        return result;
    }
}
