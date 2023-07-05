import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> sing = new ArrayList<>();
        
        for(int i=0;i<score.length;i++){
            sing.add(score[i]);
            Collections.sort(sing,Collections.reverseOrder());
            if(i<k-1) answer[i]=sing.get(i);
            else    answer[i]=sing.get(k-1);
        }
        return answer;
    }
}