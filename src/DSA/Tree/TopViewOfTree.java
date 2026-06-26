package DSA.Tree;

import java.util.*;

public class TopViewOfTree {
    /**
     *You are given the root of a binary tree, and your task is to return its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
     * Note:
     * Return the nodes from the leftmost node to the rightmost node.
     * If multiple nodes overlap at the same horizontal position, only the topmost (closest to the root) node is included in the view.
     */
    static void main() {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node( 40);
        root.left.right = new Node(60);
        root.right.left = new Node(90);
        root.right.right = new Node(100);

        System.out.println(topView(root));
    }

    static ArrayList<Integer> topView(Node root) {

        Map<Integer, Integer> map = new HashMap<>();

        int min = 0, max = 0;

        Queue<Integer> column = new LinkedList<>();
        Queue<Node> nodeQueue = new LinkedList<>();

        column.offer(0);
        nodeQueue.offer(root);

        while(!nodeQueue.isEmpty()){
            Node node  = nodeQueue.poll();
            int col = column.poll();

            if (!map.containsKey(col)){
                map.put(col, node.data);
            }

            min = Math.min(col, min);
            max = Math.max(col, max);

            if(node.left != null){
                nodeQueue.offer(node.left);
                column.offer(col - 1);
            }

            if(node.right != null){
                nodeQueue.offer(node.right);
                column.offer(col + 1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = min; i <= max; i++){
            res.add(map.get(i));
        }
        return res;
    }
}
