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
    public int goodNodes(TreeNode root) {

        if(root == null){
            return 0;
        }

        Queue<Pair> queue = new LinkedList();

        queue.offer(new Pair(root, root.val));
        int ans = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Pair top = queue.poll();
                if(top.node.left != null){
                    if(top.max <= top.node.left.val){
                        ans++;
                        queue.offer(new Pair(top.node.left, top.node.left.val));
                    }
                    else {
                        queue.offer(new Pair(top.node.left, top.max));
                    }
                }

                if(top.node.right != null){
                    if(top.max <= top.node.right.val){
                        ans++;
                        queue.offer(new Pair(top.node.right, top.node.right.val));
                    }
                    else {
                        queue.offer(new Pair(top.node.right, top.max));
                    }
                }
            }
        }

        return ans;
        
    }

   class Pair{

    TreeNode node;
    int max;
    Pair(TreeNode node, int max){
        this.node = node;
        this.max = max;
    }
   }
}
