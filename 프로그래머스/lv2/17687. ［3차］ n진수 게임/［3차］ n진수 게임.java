import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int start = 0;
        String num = Integer.toString(start,n);
        int idx = 0;
        int order = 0;
  
        while(t>0){
            String str = num.substring(idx,idx+1).toUpperCase();
            
            if(order%m==p-1){
                answer.append(str);
                t--;
            }
            
            idx++;
            order++;
            
            if(idx==num.length()){    
                idx=0;
                start++;
                num = Integer.toString(start,n);
            }
        }
        
        return answer.toString();
    }
}