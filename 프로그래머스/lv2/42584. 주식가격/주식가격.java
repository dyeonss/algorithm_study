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
                int j = i+1;
                for(;j < prices.length;j++){
                    if(prices[i] > prices[j]){
                        break;
                    }
                }
                answer[i] = j - i;
            }
        }

        return answer;
    }
}