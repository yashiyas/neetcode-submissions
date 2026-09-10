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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList();
        ArrayDeque<TreeNode> stack = new ArrayDeque();

        queue.offer(root);

        while(!queue.isEmpty() || !stack.isEmpty()){
            if(!queue.isEmpty()){
                TreeNode top = queue.poll();
                ans.add(top.val);
                if(top.left != null){
                    queue.offer(top.left);
                }
                if(top.right != null){
                    stack.push(top.right);
                }
            }else {
                TreeNode top = stack.pop();
                ans.add(top.val);
                if(top.left != null){
                    queue.offer(top.left);
                }
                if(top.right != null){
                    stack.push(top.right);
                }
            }
        }

        return ans;
        
    }
}