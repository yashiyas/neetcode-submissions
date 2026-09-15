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
    public int kthSmallest(TreeNode root, int k) {

        ArrayDeque<TreeNode> stack = new ArrayDeque();

        Set<TreeNode> visited = new HashSet();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            if(top.left != null && !visited.contains(top.left)){
                stack.push(top);
                stack.push(top.left);
                continue;
            }

            visited.add(top);

            k = k-1;
            if(k == 0){
                return top.val;
            }

            if(top.right != null){
                stack.push(top.right);
            }
        }

        return -1;
        
    }
}
