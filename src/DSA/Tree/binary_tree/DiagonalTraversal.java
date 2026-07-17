package DSA.Tree.binary_tree;

import java.util.*;

public class DiagonalTraversal {

    /**
     * Given a Binary Tree, return the diagonal traversal of the binary tree.
     * Consider lines of slope -1 passing between nodes. Given a Binary Tree, return a single list containing all diagonal elements in a binary tree belonging to same line.
     * If the diagonal element are present in two different subtrees then left subtree diagonal element should be taken first and then right subtree.
     */

    static void main() {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);

        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        System.out.println(diagonal(root));
    }

    private static ArrayList<Integer> diagonal(Node root) {

        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        helper(root, map, 0);

        ArrayList<Integer> res = new ArrayList<>();
        for(ArrayList<Integer> one : map.values()){
            res.addAll(one);
        }

        return res;
    }

    private static void helper(Node node, Map<Integer, ArrayList<Integer>> map, int diagonal){

        if(node == null) return;

        if (!map.containsKey(diagonal)) map.put(diagonal, new ArrayList<>());
        map.get(diagonal).add(node.data);

        helper(node.left, map,diagonal + 1);
        helper(node.right, map, diagonal);
    }
}
