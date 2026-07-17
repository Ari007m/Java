package DSA.Tree.binary_tree;

import java.util.*;

public class DistanceOfNode {

    /**
     * Given a binary tree, a target node in the binary tree, and an integer value k, find all the nodes that are at a distance k from the given target node.
     * No parent pointers are available.
     * You have to return the list in sorted order.
     * The tree will not contain duplicate values.
     */

    static void main() {

//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//
//        Node target = root.left;
//        int k = 2;

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node target = root.right;
        int k = 1;


        System.out.println(KDistanceNodes(root, target.data, k));

    }

    static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Node, Node> parent = new HashMap<>();
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.offer(root);

        Node targetNode = null;

        while (!nodes.isEmpty()){
            Node node = nodes.poll();

            if(node.data == target){
                targetNode = node;
            }

            if(node.left != null){
                nodes.offer(node.left);
                parent.put(node.left, node);
            }

            if(node.right != null){
                nodes.offer(node.right);
                parent.put(node.right, node);
            }
        }

        if(targetNode == null) return new ArrayList<>();
        HashSet<Node> visited = new HashSet<>();

        nodes.offer(targetNode);
        visited.add(targetNode);

        int level = 0;

        while (!nodes.isEmpty()){
            int size = nodes.size();
            if(level == k) {
                for (Node node : nodes){
                    res.add(node.data);
                }
                break;
            }
            for(int i = 0; i < size; i++){
                Node node = nodes.poll();

                if(node.left != null && !visited.contains(node.left)){
                    nodes.offer(node.left);
                    visited.add(node.left);
                }

                if(node.right != null && !visited.contains(node.right)){
                    nodes.offer(node.right);
                    visited.add(node.right);
                }

                if(parent.containsKey(node) && !visited.contains(parent.get(node))){
                    nodes.offer(parent.get(node));
                    visited.add(parent.get(node));
                }
            }
            level++;
        }
        Collections.sort(res);
        return res;
    }
}
