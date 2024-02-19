import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int x=0;x<=r2;x++){
            int n2=(int)Math.sqrt((long)r2*r2-(long)x*x);
            int n1=(int)Math.ceil(Math.sqrt((long)r1*r1-(long)x*x));
            
            if(n1==0)   answer+=(n2-n1);
            else answer+=(n2-n1+1);
        }
        
        answer*=4;
        return answer;
    }
}