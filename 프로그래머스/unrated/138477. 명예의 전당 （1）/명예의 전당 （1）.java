import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> sing = new PriorityQueue<>();
        
        for(int i=0;i<score.length;i++){
            sing.add(score[i]);
            if(sing.size()>k)   sing.poll();   
            answer[i]=sing.peek();
        }
        return answer;
    }
}