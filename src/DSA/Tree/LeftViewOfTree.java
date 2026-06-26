package DSA.Tree;

import java.util.*;

public class LeftViewOfTree {

    /**
     * Given the root of a binary tree. Your task is to return the left view of the binary tree. The left view of a binary tree is the set of nodes visible when the tree is viewed from the left side.
     * Note: If the tree is empty, return an empty list.
     */

    static void main() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node( 4);
        root.left.right = new Node(5);

        System.out.println(leftView(root));
    }

    static ArrayList<Integer> leftView(Node root) {

        if(root == null) return new ArrayList<>();

        ArrayList<Integer> res = new ArrayList<>();
        helper(0, root, res);

        return res;
    }

    static void helper(int level, Node root, ArrayList<Integer> res){

        if(root == null) return;

        if(res.size() <= level) res.add(root.data);

        helper(level + 1, root.left, res);
        helper(level + 1, root.right, res);
    }
}
