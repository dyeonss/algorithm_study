class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int idx, widx = 0;
        
        for(idx = 0; idx < nums.size(); idx++){
            if(nums[idx]!=0){
                nums[widx]=nums[idx];
                widx++;
            }
        }
        
        for(; widx<nums.size(); widx++){
            nums[widx]=0;
        }
    }
};