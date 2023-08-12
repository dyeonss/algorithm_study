import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int minValue = 10001;
        
        for(int i=prices.length-1; i>=0; i--){
            if(prices[i] <= minValue){
                minValue = prices[i];
                answer[i] = prices.length - i - 1;
            }
            else{
                int idx = i;
                for(int j = i+1;j < prices.length;j++){
                    if(prices[i] > prices[j]){
                        idx = j;
                        break;
                    }
                }
                answer[i] = idx - i;
            }
        }

        return answer;
    }
}