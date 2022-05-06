#include <numeric>
class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int num;
        int leftsum = 0, rightsum = sum;
        int lastnum = 0;
        
        for(int i=0;i<nums.size();i++){
            num = nums[i];
            rightsum = rightsum - num;
            leftsum = leftsum + lastnum;
            
            if(leftsum == rightsum){
                return i;
            }
            lastnum = num;
        }
        return -1;
    }
};