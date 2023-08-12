import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=prices.length-1;i>=0;i--) stack.push(prices[i]);
        
        int j=1;
        while(!stack.isEmpty()){
            int n = stack.pop();
            int cnt = 0;
            for(int i=j;i<prices.length;i++){
                cnt++;
                if(prices[i]<n) break;
            }
            answer[j-1]=cnt;
            j++;
        }
        
        
        return answer;
    }
}