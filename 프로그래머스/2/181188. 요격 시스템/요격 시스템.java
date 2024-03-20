import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int val=-1;
        Arrays.sort(targets,(o1,o2)->o1[1]-o2[1]);
        
        for(int[] t:targets){
            if(val<t[0]){
                val=t[1]-1;
                answer++;
            }
        }
        return answer;
    }
}