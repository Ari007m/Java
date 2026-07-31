package DSA.Tree.bnary_search_tree;

import java.util.ArrayList;

public class FindPreSuc {

    /**
     * You are given the root of a BST and an integer key.
     * You need to find the inorder predecessor and successor of the given key. If either predecessor or successor is not found, then set it to NULL.
     * Note: In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor.
     */

    static void main() {
//
//        Node root = new Node(50);
//        root.left = new Node(30);
//        root.right = new Node(70);
//        root.left.left = new Node(20);
//        root.left.right = new Node(40);
//        root.right.left = new Node(60);
//        root.right.right = new Node(80);
//
//        int key = 65;

        Node root = new Node(8);
        root.left = new Node(1);
        root.right = new Node(9);
        root.left.right = new Node(4);
        root.right.right = new Node(10);
        root.left.right.left = new Node(3);
        int key = 8;

        ArrayList<Node> res = optimisedFinding(root, key);

        System.out.println("Predecessor: " +
                (res.get(0) != null ? res.get(0).data : "null"));

        System.out.println("Successor: " +
                (res.get(1) != null ? res.get(1).data : "null"));
    }

    static Node minLimit;
    static Node maxLimit;
    static ArrayList<Node> findPreSuc(Node root, int key) {
        minLimit = null;
        maxLimit = null;
        helper(root, key);

        ArrayList<Node> res = new ArrayList<>();
        res.add(minLimit);
        res.add(maxLimit);

        return res;
    }

    static void helper(Node root, int key) {
        if (root == null) return;

        if(root.data == key){
            helper(root.left, key);
            helper(root.right, key);
        }

        if(root.data < key) {
            minLimit = root;
            helper(root.right, key);
        }

        if(root.data > key) {
            maxLimit = root;
            helper(root.left, key);
        }

    }

    static ArrayList<Node> optimisedFinding(Node root, int key){

        Node pre = null;
        Node suc = null;
        Node cur = root;

        while (cur != null){

            if(cur.data < key){
                pre = cur;
                cur = cur.right;
            }
            else if (cur.data > key){
                suc = cur;
                cur = cur.left;
            }
            else {
                if(cur.left != null){
                    Node temp = cur.left;
                    while (temp.right != null){
                        temp = temp.right;
                    }
                    pre = temp;
                }

                if(cur.right != null){
                    Node temp = cur.right;
                    while (temp.left != null){
                        temp = temp.left;
                    }
                    suc = temp;
                }
                break;
            }
        }

        ArrayList<Node> res = new ArrayList<>();
        res.add(pre);
        res.add(suc);

        return res;
    }
}
