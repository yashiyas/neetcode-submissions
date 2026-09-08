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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode top = queue.poll();
                if(top.val == subRoot.val){
                    if(checkSubTree(top, subRoot)){
                        return true;
                    }
                }
                if(top.left != null){
                    queue.offer(top.left);
                }
                if(top.right != null){
                    queue.offer(top.right);
                }
            }
        }

        return false;

    }

    private Boolean checkSubTree(TreeNode tree, TreeNode subTree){

        Queue<TreeNode> queue = new LinkedList();
        Queue<TreeNode> subQueue = new LinkedList();

        queue.offer(tree);
        subQueue.offer(subTree);

        while(!queue.isEmpty() && !subQueue.isEmpty()){

            int s1 = queue.size();
            int s2 = subQueue.size();
            if(s1 != s2){
                return false;
            }

            for(int i=0; i<s1; i++)

            {TreeNode top1 = queue.poll();
            TreeNode top2 = subQueue.poll();

            if(top1. val != top2.val){
                return false;
            }

            if(top1.left != null){
                queue.offer(top1.left);
            }

            if(top1.right != null){
                queue.offer(top1.right);
            }

            if(top2.left != null){
                subQueue.offer(top2.left);
            }

            if(top2.right != null){
                subQueue.offer(top2.right);
            }}

        }

        return queue.isEmpty() && subQueue.isEmpty(); 
    }

    
    
}
