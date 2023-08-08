import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s:scoville) pq.offer(s);
        
        while(pq.size()>=2){
            int least = pq.poll();
            if(least>=K)    break;
            int second = pq.poll();

            pq.offer(least+2*second);
            answer++;        
        }
        
        if(pq.peek()<K) answer = -1;
        return answer;
    }
}