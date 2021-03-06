class Solution {
    public:
        int maxDepth(TreeNode* root) 
        {
            if (root == NULL) 
                return 0;

            if (root->left == NULL && root->right == NULL)
                return 1;

            if (root->left == NULL)
                return 1 + maxDepth(root->right);

            if (root->right == NULL)
                return 1 + maxDepth(root->left);

            return 1 + max(maxDepth(root->right), maxDepth(root->left));
        }
};