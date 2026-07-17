package DSA.Tree.binary_tree;

import java.util.ArrayList;

public class InorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(inOrder(root));
    }

    static ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        ans(root, res);
        return res;
    }

    static void ans(Node root, ArrayList<Integer> res){

        if(root == null) return;

        ans(root.left, res);
        res.add(root.data);
        ans(root.right, res);

    }
}
