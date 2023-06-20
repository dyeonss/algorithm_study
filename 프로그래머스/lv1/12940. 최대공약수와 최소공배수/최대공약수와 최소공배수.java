import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n,m);
        int div = 0;
        for(int i=1;i<=min;i++){
            if(n%i==0&&m%i==0)  div=i;
        }
        
        answer[0]=div;
        answer[1]=n*m/div;
        return answer;
    }
}