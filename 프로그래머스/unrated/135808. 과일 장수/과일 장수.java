import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for(int i=1;i<=score.length/m;i++){
            answer+=(score[score.length-m*i]*m);
        }
        return answer;
    }
}