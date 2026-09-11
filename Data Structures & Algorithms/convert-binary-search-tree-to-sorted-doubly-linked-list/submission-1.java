/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node prev = null;
    public Node treeToDoublyList(Node root) {

        if(root == null){
            return root;
        }
       
        inorder(root);

        Node head = root;

        while(head.left != null){
            head = head.left;
        }

        head.left = prev;
        prev.right = head;

        return head;

        
    }

    private void inorder(Node node){
        if(node == null){
            return;
        }

        inorder(node.left);
        node.left = prev;
        if(prev != null){
            prev.right = node;
        }
        prev = node;
        inorder(node.right);

    }
}
