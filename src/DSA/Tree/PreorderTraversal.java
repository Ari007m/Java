package DSA.Tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(4);
        root.right = null;

        root.left.left = new Node(4);
        root.left.right = new Node(2);

        System.out.println(List.of(preorder(root)).toString());
    }

    static ArrayList<Integer> preorder(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        ans(root, res);

        return res;
    }

    static void ans(Node root, ArrayList<Integer> arr){
        if(root == null) return;

        arr.add(root.data);
        ans(root.left, arr);
        ans(root.right, arr);
    }
}

