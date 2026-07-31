package DSA.Tree.bnary_search_tree;

import java.util.ArrayList;

public class MergeBST {

    /**
     * You are given the root of two BSTs, you have to merge this two BST and return the in-order traversal of the new BST.
     */

    static void main() {
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(5);

        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(6);

        Node root3 = new Node(8);
        root3.left = new Node(2);
        root3.right = new Node(10);
        root3.left.left = new Node(1);

        Node root4 = new Node(5);
        root4.left = new Node(3);
        root4.left.left = new Node(0);

        System.out.println(merge(root1, root2).stream().toList());

    }

    static ArrayList<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> root1List = new ArrayList<>();
        ArrayList<Integer> root2List = new ArrayList<>();
        helper(root1, root1List);
        helper(root2, root2List);

        int i = 0, j = 0;
        while (i < root1List.size() && j < root2List.size()) {
            if(root1List.get(i) < root2List.get(j)){
                res.add(root1List.get(i++));
            } else {
                res.add(root2List.get(j++));
            }
        }

        while (i < root1List.size()) {
            res.add(root1List.get(i++));
        }

        while (j < root2List.size()) {
            res.add(root2List.get(j++));
        }
        return res;
    }

    static void helper(Node root, ArrayList<Integer> rootList) {

        if(root == null) return;
        helper(root.left, rootList);
        rootList.add(root.data);
        helper(root.right, rootList);
    }
}
