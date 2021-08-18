class Solution
{
    public:
    
        vector<vector<int>> allPath;
        vector<int> eachPath;

        vector<vector<int>> pathSum(TreeNode* root, int sumTarget)
        {
            findPath(root, sumTarget);

            return allPath;
        }

        // implement dfs
        void findPath(TreeNode* root, int sumTarget)
        {
            if (!root)
                return;

            eachPath.push_back(root->value);
            sumTarget -= root->value;
            
            if (!root->left && !root->right && sumTarget == 0)
                allPath.push_back(eachPath);

            findPath(root->left, sumTarget);
            findPath(root->right, sumTarget);
            eachPath.pop_back();
        }
};