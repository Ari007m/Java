package DSA.Tree.binary_tree;

import java.util.*;

public class MinDisBtw2Nodes {

    /**
     * Given a binary tree with n nodes and two node values a and b, find the minimum distance between them.
     * The distance is defined as the minimum number of edges between the two nodes.
     * It is guaranteed that both nodes exist in the binary tree and all node values are unique.
     */

    static void main() {

//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);

//        int a = 2, b = 3;

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int a = 4, b = 7;

        System.out.println(findDist(root, a, b));
    }

    static int findDist(Node root, int a, int b) {

        HashMap<Node, Node> parent = new HashMap<>();
        Queue<Node> nodeQueue = new ArrayDeque<>();

        nodeQueue.offer(root);

        Node aNode = null;
        Node bNode = null;

        while(!nodeQueue.isEmpty()){
            Node node = nodeQueue.poll();

            if(node.data == a) aNode = node;
            if(node.data == b) bNode = node;

            if(node.left != null){
                parent.put(node.left, node);
                nodeQueue.offer(node.left);
            }

            if(node.right != null){
                parent.put(node.right, node);
                nodeQueue.offer(node.right);
            }
        }

        int dis = 0;
        if(aNode == null || bNode == null) return  0;

        nodeQueue.add(aNode);
        HashSet<Node> visited = new HashSet<>();
        visited.add(aNode);

        while (!nodeQueue.isEmpty()){
            int size = nodeQueue.size();

            for (int i = 0; i < size; i++) {
                Node node = nodeQueue.poll();
                if(node == bNode) return dis;

                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    nodeQueue.offer(node.left);
                }

                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    nodeQueue.offer(node.right);
                }

                if(parent.containsKey(node) && !visited.contains(parent.get(node))){
                    visited.add(parent.get(node));
                    nodeQueue.offer(parent.get(node));
                }

            }
            dis++;
        }

        return dis;
    }
}
