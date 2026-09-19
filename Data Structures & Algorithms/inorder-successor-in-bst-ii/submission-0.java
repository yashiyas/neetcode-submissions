/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node == null){
            return null;
        }

        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }

            return node;
        }

        if(node.parent != null && node.parent.left == node){
            return node.parent;
        }

        return solve(node.parent);

        
    }

    private Node solve(Node node){
        if(node == null){
            return null;
        }

        if(node.parent == null){
            return null;
        }

        if(node.parent.left == node){
            return node.parent;
        }

        return solve(node.parent);
    }
}
