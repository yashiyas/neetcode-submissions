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
    int diameterOfBinaryTree(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        int lheight = height(root->left);
        int rheight = height(root->right);
        int rd = diameterOfBinaryTree(root->right);
        int ld = diameterOfBinaryTree(root->left);
        return max(lheight + rheight , max(rd, ld));
    }

    int height(TreeNode* node){
        if(node == NULL){
            return 0;
        }
        return 1+max(height(node->right), height(node->left));
    }
};
