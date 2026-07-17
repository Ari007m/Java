package DSA.Tree.bnary_search_tree;

public class SearchInBST {

    /**
     * Given the root of a Binary Search Tree and a node value key, return true if the node with value key is present in the BST; otherwise, return false
     */

    static void main() {
//        Node root = new Node(6);
//        root.left = new Node(2);
//        root.right = new Node(8);
//        root.right.left = new Node(7);
//        root.right.right = new Node(9);

        Node root = new Node(16);
        root.left = new Node(12);
        root.right = new Node(18);
        root.left.left = new Node(10);
        root.right.left = new Node(17);
        root.right.right = new Node(19);

        System.out.println(search(root, 14));
    }

    static boolean search(Node root, int key) {

        if(root == null) return false;
        if(root.data == key) return true;

        if(root.data < key){
            return search(root.right, key);
        }
        else{
            return search(root.left, key);
        }
    }
}
