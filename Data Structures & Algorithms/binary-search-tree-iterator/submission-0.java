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

    int curr;
    List<Integer> inorderList;


    public BSTIterator(TreeNode root) {
        inorderList = new ArrayList();
        curr = 0;

        inorderList.add(-1);

        ArrayDeque<TreeNode> aq = new ArrayDeque();
        TreeNode curr = root;

        if(root != null){
            while(curr != null || !aq.isEmpty()){
                if(curr != null){
                    aq.push(curr);
                    curr = curr.left;
                }
                else{
                    TreeNode top = aq.pop();
                    inorderList.add(top.val);
                    curr = top.right;
                }
            }
        }
    }
    
    public int next() {
        int val =  inorderList.get(curr+1);
        curr++;
        return val;
        
    }
    
    public boolean hasNext() {

        return (curr < (inorderList.size() - 1));
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */