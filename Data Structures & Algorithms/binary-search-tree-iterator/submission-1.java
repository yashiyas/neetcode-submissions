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
class BSTIterator {

    List<Integer> inorder;
    int index;

    public BSTIterator(TreeNode root) {

        this.inorder = new ArrayList();
        inorder.add(-1);
        this.index = 0;

        ArrayDeque<TreeNode> aq = new ArrayDeque();
        TreeNode curr = root;

        while(curr != null || !aq.isEmpty()){
            if(curr == null){
                TreeNode top = aq.pop();
                inorder.add(top.val);
                curr = top.right;
            }
            else{
                aq.push(curr);
                curr = curr.left;
            }
        }
        
    }
    
    public int next() {

        index = index+1;
        return inorder.get(index);

        
    }
    
    public boolean hasNext() {

        return (index < inorder.size()-1);
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */