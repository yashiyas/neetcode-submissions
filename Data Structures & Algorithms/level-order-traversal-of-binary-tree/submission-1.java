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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList();

            for(int i=0; i<size; i++){
                TreeNode top = queue.poll();
                level.add(top.val);

                if(top.left != null){
                    queue.offer(top.left);
                }

                if(top.right != null){
                    queue.offer(top.right);
                }
            }

            ans.add(level);
        }

        return ans;
        
    }
}
