import java.util.*;
class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        long len=(long)Math.pow(5,n-1), d=(long)Math.pow(4,n-1);
        int count=0, cpn=n;
        
        while(r!=0&&cpn>0){
            count+=(d*((r/len)>2?(r/len)-1:(r/len)));
            
            if((r/len==2&&r%len!=0)||(r/len==3&&r%len==0)){
                break;
            }
            
            cpn--;
            r=r%len;
            d=(long)Math.pow(4,cpn-1);
            len=(long)Math.pow(5,cpn-1);
        }
        
        answer+=count;
        l--;
        count=0;
        len=(long)Math.pow(5,n-1);
        d=(long)Math.pow(4,n-1);
        
        while(l!=0&&n>0){
            count+=(d*((l/len)>2?(l/len)-1:(l/len)));
            
            if((l/len==2&&l%len!=0)||(l/len==3&&l%len==0))
                break;
            
            n--;
            l=l%len;
            d=(long)Math.pow(4,n-1);
            len=(long)Math.pow(5,n-1);
        }
        
        answer-=count;
        return answer;
    }
}