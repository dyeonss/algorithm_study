import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int end=0;
        Arrays.sort(targets,(o1,o2)->o1[1]-o2[1]);
        end=targets[0][1];
        
        for(int i=0;i<targets.length-1;i++){
            if(end>targets[i+1][0]){
            }
            else{
                end=targets[i+1][1];
                answer++;
            }    
        }
            
        return answer+1;
    }
}