import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int[] nums = Arrays.stream(arr).mapToInt(i->Integer.valueOf(i)).toArray();
        
        Arrays.sort(nums);
        answer+=nums[0]+" "+nums[nums.length-1];
        
        return answer;
    }
}