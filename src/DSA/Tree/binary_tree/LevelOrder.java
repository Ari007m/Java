package DSA.Tree.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node( 40);
        root.left.right = new Node(50);

        System.out.println(levelOrder(root));

    }

    static ArrayList<Integer> levelOrder(Node root){

        Queue<Node> temp = new LinkedList<>();
        temp.offer(root);
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        while(!temp.isEmpty()){
            int size = temp.size();
            for(int i = 0; i < size; i++){
                if(temp.peek() != null){
                    Node curr = temp.poll();
                    res.add(curr.data);
                    if(curr.left != null) temp.offer(curr.left);
                    // assert temp.peek() != null;
                    if(curr.right != null) temp.offer(curr.right);
                }
            }
        }

        return res;
    }

}
