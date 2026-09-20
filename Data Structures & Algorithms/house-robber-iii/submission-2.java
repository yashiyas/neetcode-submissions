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
    Map<TreeNode, Integer> parentIncluded = new HashMap();
    Map<TreeNode, Integer> parentExcluded = new HashMap();
    int ans = 0;
    public int rob(TreeNode root) {

        

        return solve(root, false);
        
    }

    private int solve(TreeNode node, boolean parent){
        if(node == null){
            return 0;
        }

        if(parent){
            // exclude 
            if(parentIncluded.containsKey(node)){
                return parentIncluded.get(node);
            }

            int excludeNode = solve(node.right, false) + solve(node.left, false);
            parentIncluded.put(node, excludeNode);
            return excludeNode;

        }else{

            if(parentExcluded.containsKey(node)){
                return parentExcluded.get(node);
            }

            int includeNode = node.val + solve(node.right, true) + solve(node.left, true);
            int excludeNode = solve(node.right, false) + solve(node.left, false);

            int curr = Math.max(includeNode, excludeNode);

            parentExcluded.put(node, curr);

            return curr;

        }
    }
}