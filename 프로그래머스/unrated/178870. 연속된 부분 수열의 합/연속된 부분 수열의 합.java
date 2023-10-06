import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start=0, end=0;
        int sum=sequence[start];
        
        answer[0]=0;
        answer[1]=sequence.length;
        
        while(end<sequence.length&&start<sequence.length){
            if(sum==k){
                if(end-start<answer[1]-answer[0]){
                    answer[0]=start;
                    answer[1]=end;
                }
                end++;
                if(end<sequence.length)
                    sum+=sequence[end];
            }    
            else if(sum<k){
                end++;
                if(end<sequence.length)
                    sum+=sequence[end];
            }
            else if(sum>k){
                sum-=sequence[start];
                start++;
            }
            
            
        }
        
        return answer;
    }
}