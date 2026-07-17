package DSA.Tree.binary_tree;

import java.util.*;

public class BottomViewOfTree {
    /**
     * Bottom View of Binary Tree
     * Difficulty: MediumAccuracy: 54.18%Submissions: 357K+Points: 4Average Time: 45m
     * You are given the root of a binary tree, and your task is to return its bottom view. The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.
     * Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level order traversal is considered.
     */


    static void main() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node( 4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(bottomView(root));
    }

    private static ArrayList<Integer> bottomView(Node root) {

        if(root == null) return new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        Queue<Integer> column = new LinkedList<>();
        Queue<Node> nodeQueue = new LinkedList<>();

        int min = 0, max = 0;

        column.offer(0);
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()){

            Node node = nodeQueue.poll();
            int col = column.poll();

            map.put(col, node.data);

            min = Math.min(min, col);
            max = Math.max(max,col);

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
