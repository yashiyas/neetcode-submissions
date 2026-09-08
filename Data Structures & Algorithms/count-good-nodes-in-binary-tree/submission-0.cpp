/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    int goodNodes(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        int max_value = root->val;

       int ans = dfs(0, max_value, root);
       return ans;

    }

    int dfs(int ans, int max_value, TreeNode* node){
        if(node->val >= max_value){
            ans++;
            max_value = node->val;
        }
        if(node->left != NULL){
            ans = dfs(ans, max_value, node->left);
        }
        if(node->right != NULL){
            ans = dfs(ans, max_value, node->right);
        }
        return ans;
    }
};
