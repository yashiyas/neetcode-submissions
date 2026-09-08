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
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if(subRoot == NULL){
            return true;
        }
        queue<TreeNode*> q;
        q.push(root);

        while(!q.empty()){
            TreeNode* top = q.front();
            if(top->val == subRoot->val){
                if(checkIfSubRoot(top, subRoot)){
                    return true;
                }
            }
            q.pop();
            if(top->left != NULL){
                q.push(top->left);
            }
            if(top->right != NULL){
                q.push(top->right);
            }
        }
        return false;
        
    }

    bool checkIfSubRoot(TreeNode* node, TreeNode* subNode){
        if(subNode == NULL && node == NULL){
            return true;
        }
        if(node == NULL || subNode == NULL){
            return false;
        }
        return node->val == subNode->val && checkIfSubRoot(node->left, subNode->left) && checkIfSubRoot(node->right, subNode->right);
    }
};
