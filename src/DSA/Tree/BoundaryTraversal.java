package DSA.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryTraversal {
    public static void main(String[] args) {
//
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//        root.left.right.left = new Node(8);
//        root.left.right.right = new Node(9);

        Node root = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(3);
        root.right.right = new Node(4);

        System.out.println(boundaryTraversal(root));
    }

    static ArrayList<Integer> boundaryTraversal(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        if (root == null) return res;  // empty list
        if (root.left == null && root.right == null) {
            res.add(root.data);
            return res;
        }

        res.add(root.data);

        if(root.left != null){
            leftBoundary(root.left, res);
        }
        leafBoundary(root, res);
        if(root.right != null){
            rightBoundary(root.right, res);
        }
        return res;
    }

    static void leftBoundary(Node root, ArrayList<Integer> res){

        if(root.left == null && root.right == null) return;

        res.add(root.data);
        leftBoundary(((root.left == null) ? root.right : root.left), res);
    }

    static void leafBoundary(Node root, ArrayList<Integer> res){

        if(root == null) return;

        if(root.left == null && root.right == null){
            res.add(root.data);
        }

        leafBoundary(root.left, res);
        leafBoundary(root.right, res);
    }

    static void rightBoundary(Node root, ArrayList<Integer> res){

        if(root.left == null && root.right == null) return;


        rightBoundary(((root.right == null) ? root.left : root.right), res);
        res.add(root.data);
    }
}