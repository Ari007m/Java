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
        Queue<Integer> noOfCol = new LinkedList<>();
        Queue<Node> nodeQueue = new LinkedList<>();

        int max = 0, min = 0;

        noOfCol.offer(0);
        nodeQueue.offer(root);

        while(!nodeQueue.isEmpty()){
            Node node = nodeQueue.poll();
            int col = noOfCol.poll();

            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }

            map.get(col).add(node.data);
            min = Math.min(col, min);
            max = Math.max(col, max);

            if(node.left != null){
                nodeQueue.offer(node.left);
                noOfCol.offer(col - 1);
            }

            if(node.right != null){
                nodeQueue.offer(node.right);
                noOfCol.offer(col + 1);
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }

        return res;
    }
}
