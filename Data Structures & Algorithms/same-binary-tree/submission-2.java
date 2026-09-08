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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }

        if(p==null || q==null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        Queue<TreeNode> queueP = new LinkedList();
        Queue<TreeNode> queueQ = new LinkedList();

        queueP.offer(p);
        queueQ.offer(q);

        while(!queueP.isEmpty()){
            int size = queueP.size();

            for(int i=0; i<size; i++){
                TreeNode currP = queueP.poll();
                TreeNode currQ = queueQ.poll();

                if(currP.left != null || currQ.left != null){
                    if(currQ.left == null || currP.left == null){
                        return false;
                    }
                    if(currP.left.val != currQ.left.val){
                        return false;
                    }
                    queueP.offer(currP.left);
                    queueQ.offer(currQ.left);
                }

                if(currP.right != null || currQ.right != null){
                    if(currQ.right == null || currP.right == null){
                        return false;
                    }
                    if(currP.right.val != currQ.right.val){
                        return false;
                    }
                    queueP.offer(currP.right);
                    queueQ.offer(currQ.right);
                }
            }
        }
        return true;
    }
}
