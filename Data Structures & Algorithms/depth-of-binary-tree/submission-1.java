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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        Map<TreeNode, Integer> heightMap = new HashMap();

        int lHeight = getHeight(root.left, heightMap);
        int rHeight = getHeight(root.right, heightMap);

        return 1+Math.max(lHeight, rHeight);
    }

    private int getHeight(TreeNode node, Map<TreeNode, Integer> heightMap){
        if(node == null){
            return 0;
        }

        if(heightMap.containsKey(node)){
            return heightMap.get(node);
        }

        int lHeight = getHeight(node.left, heightMap);
        int rHeight = getHeight(node.right, heightMap);

        int height = 1+Math.max(lHeight, rHeight);
        heightMap.put(node, height);
        return height;
    }
}
