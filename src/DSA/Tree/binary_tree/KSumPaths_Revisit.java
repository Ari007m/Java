package DSA.Tree.binary_tree;

import java.util.HashMap;

public class KSumPaths_Revisit {

    /**
     * Given the root of a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k.
     * Note: A path can start and end at any node within the tree but must always move downward (from parent to child).
     */

    static void main() {

        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.right.right = new Node(2);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.left.right.right = new Node(1);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        System.out.println(countAllPaths(root2, 3));

    }

    static int count = 0;
    static int countAllPaths(Node root, int k) {

        if (root == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, k, 0, map);
        return count;
    }

    static void helper(Node root, int k, int runningSum, HashMap<Integer, Integer> map){
        if(root == null) return;

        runningSum += root.data;
        count += map.getOrDefault(runningSum - k, 0);
        map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);

        helper(root.left, k ,runningSum, map);
        helper(root.right, k, runningSum, map);

        map.put(runningSum, map.get(runningSum) - 1);
    }
}
