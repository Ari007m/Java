package DSA.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class DistanceOfNode {

    /**
     * Given a binary tree, a target node in the binary tree, and an integer value k, find all the nodes that are at a distance k from the given target node.
     * No parent pointers are available.
     * You have to return the list in sorted order.
     * The tree will not contain duplicate values.
     */

    static void main() {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Node target = root.left;
        int k = 2;

//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//
//        Node target = root.right;
//        int k = 1;


        System.out.println(KDistanceNodes(root, target.data, k));

    }

    static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Node, Node> parent = new HashMap<>();
        Queue<Node> visited = new ArrayDeque<>();
        Queue<Node> nodes = new ArrayDeque<>();
        int dis = 0;
        nodes.offer(root);

        while (!nodes.isEmpty()){
            Node node = nodes.poll();

            if(node.left != null){
                nodes.offer(node.left);
                parent.put(node.left, node);
            }

            if(node.right != null){
                nodes.offer(node.right);
                parent.put(node.right, node);
            }
        }

        Node targetNode = findTarget(root, target);

        return res;
    }

    static Node findTarget(Node root, int t){
        if(root == null) return root;
        return root;
    }
}
