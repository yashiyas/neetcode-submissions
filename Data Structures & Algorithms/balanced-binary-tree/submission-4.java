/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {

        Map<TreeNode, Integer> nodeHeights = new HashMap();

        if(root == null){
            return true;
        }

        ArrayDeque<Pair> aq = new ArrayDeque();

        Pair pair = new Pair(root);

        aq.push(pair);

        while(!aq.isEmpty()){

            Pair curr = aq.pop();

            if(curr.visited){
                int lHeight = getHeight(curr.node.left, nodeHeights);
                int rHeight = getHeight(curr.node.right, nodeHeights);
                if(! (Math.abs(lHeight - rHeight) <= 1)){
                    return false;
                }
            }
            else{
                curr.visited = true;
                aq.push(curr);
                if(curr.node.left != null){
                    Pair left = new Pair(curr.node.left);
                    aq.push(left);
                }
                if(curr.node.right != null){
                    Pair right = new Pair(curr.node.right);
                    aq.push(right);
                }
            }

        }

        return true;




    
        
    }

    class Pair {
        TreeNode node;
        Boolean visited;

        Pair(TreeNode node){
            this.node = node;
            visited = false;
        }
    }

    private int getHeight(TreeNode node, Map<TreeNode, Integer> nodeHeights){
        if(node == null){
            return 0;
        }

        if(nodeHeights.containsKey(node)){
            return nodeHeights.get(node);
        }
        int leftHeight = getHeight(node.left, nodeHeights);
        int rightHeight = getHeight(node.right, nodeHeights);
        int height =  (1+ Math.max(leftHeight, rightHeight));
        nodeHeights.put(node, height);
        return height;
    }
}
