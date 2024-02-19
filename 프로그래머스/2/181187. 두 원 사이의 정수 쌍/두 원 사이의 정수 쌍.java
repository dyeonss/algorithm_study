import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(long x=r2;x>=r1;x--) answer++;
        answer*=4;
        long cnt=0;
        
        for(int x=1;x<=r2;x++){
            int n2=(int)Math.sqrt((long)r2*r2-(long)x*x);
            int n1=(int)Math.ceil(Math.sqrt((long)r1*r1-(long)x*x));
            
            if(n1==0)   cnt+=(n2-n1);
            else cnt+=(n2-n1+1);
        }
        
        answer+=(cnt*4);
        return answer;
    }
}