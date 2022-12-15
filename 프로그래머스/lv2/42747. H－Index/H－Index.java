import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
    
        while(true){
            int cnt=0;
            for(int i=0;i<n;i++){
                if(citations[i]>answer) cnt++;
            }
            if(cnt<=answer)   break;
            answer++;
        }
        return answer;
    }
}