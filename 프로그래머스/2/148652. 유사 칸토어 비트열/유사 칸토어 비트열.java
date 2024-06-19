import java.util.*;
class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        answer=countOne(n,r)-countOne(n,l-1);
        
        return answer;
    }
    public int countOne(int n, long l){
        long len=(long)Math.pow(5,n-1), d=(long)Math.pow(4,n-1);
        int count=0;
        
        while(n>0){
            count+=(d*((l/len)>2?(l/len)-1:(l/len)));
            
            if((l/len==2&&l%len!=0)||(l/len==3&&l%len==0)){
                break;
            }
            
            n--;
            l%=len;
            d=(long)Math.pow(4,n-1);
            len=(long)Math.pow(5,n-1);
        }
        
        return count;
    }
}