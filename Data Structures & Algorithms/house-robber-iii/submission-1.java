class Solution {

    public int rob(TreeNode root) {

        Map<TreeNode, Integer> parentIncluded = new HashMap<>();
        Map<TreeNode, Integer> parentExcluded = new HashMap<>();

        return solve(root, false, parentIncluded, parentExcluded);
    }

    private int solve(
        TreeNode node,
        boolean isParentIncluded,
        Map<TreeNode, Integer> parentIncluded,
        Map<TreeNode, Integer> parentExcluded
    ) {

        if(node == null){
            return 0;
        }

        if(isParentIncluded){

            if(parentIncluded.containsKey(node)){
                return parentIncluded.get(node);
            }

            // Parent robbed → current cannot be robbed
            int ans =
                solve(node.left, false, parentIncluded, parentExcluded)
                + solve(node.right, false, parentIncluded, parentExcluded);

            parentIncluded.put(node, ans);

            return ans;

        } else {

            if(parentExcluded.containsKey(node)){
                return parentExcluded.get(node);
            }

            // Option 1: rob current
            int include =
                node.val
                + solve(node.left, true, parentIncluded, parentExcluded)
                + solve(node.right, true, parentIncluded, parentExcluded);

            // Option 2: don't rob current
            int exclude =
                solve(node.left, false, parentIncluded, parentExcluded)
                + solve(node.right, false, parentIncluded, parentExcluded);

            int ans = Math.max(include, exclude);

            parentExcluded.put(node, ans);

            return ans;
        }
    }
}