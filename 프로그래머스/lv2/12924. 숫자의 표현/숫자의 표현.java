import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1;i<=n/2;i++){
            int sum = 0, j=i;
            while(sum<=n){
                if(sum==n)  answer++;
                sum+=j;
                j++;
            }
        }
        return answer+1;
    }
}