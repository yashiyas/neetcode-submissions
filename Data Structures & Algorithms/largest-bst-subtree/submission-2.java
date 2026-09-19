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

    int ans = 1;

    public int largestBSTSubtree(TreeNode root) {

        if(root == null){
            return 0;
        }

        solve(root);

        return ans;
        
    }

    private BSTNode solve(TreeNode node){
        if(node == null){
            return new BSTNode(true, Integer.MIN_VALUE, Integer.MAX_VALUE,0);
        }
        if(node.left == null && node.right == null){
            return new BSTNode(true, node.val, node.val,1);
        }
        BSTNode left = solve(node.left);
        BSTNode right = solve(node.right);

        if(!left.isBST || !right.isBST){
            // cant' be a BST as child is not a BST
            return new BSTNode();
        }

        if(node.val > left.maxVal && node.val < right.minVal){
            int currSize = 1+left.size+right.size;
            ans = Math.max(ans, currSize);
            return new BSTNode(true, Math.max(right.maxVal,node.val), Math.min(left.minVal,node.val), currSize);
        }
        return new BSTNode();
    }

    class BSTNode{
        boolean isBST;
        int maxVal;
        int minVal;
        int size;

        BSTNode(boolean isBST, int val1, int val2, int size){

            this.isBST = isBST;
            this.maxVal = val1;
            this.minVal = val2;
            this.size = size;

        }

        BSTNode(){

        }
    }
}
