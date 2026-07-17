package DSA.Tree.binary_tree;

import java.util.ArrayList;

public class PostOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(19);

        root.left = new Node(10);
        root.right = new Node(8);
        root.left.left = new Node( 11);
        root.left.right = new Node(13);

        System.out.println(postOrder(root));
    }

    static ArrayList<Integer> postOrder(Node root){

        ArrayList<Integer> res = new ArrayList<>();
        ans(root, res);
        return res;
    }

    static void ans(Node root, ArrayList<Integer> res){

        if(root == null) return;

        ans(root.left, res);
        ans(root.right, res);
        res.add(root.data);
    }
}
