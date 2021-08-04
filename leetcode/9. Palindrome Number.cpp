class Solution 
{
    public:
        bool isPalindrome(int x)
        {
            if (x < 0)
                return false;
            
            string nums = to_string(x);
            int left = 0, right = nums.size() - 1;

            while(left < right)
            {
                if (nums[left] != nums[right])
                    return false;
                
                left++;
                right--;
            }
            
            return true;
        }
};