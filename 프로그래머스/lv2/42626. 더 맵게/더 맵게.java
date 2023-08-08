import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        boolean check = false;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s:scoville) pq.offer(s);
        
        while(!pq.isEmpty()){
            int a = pq.poll();
            if(a>=K){
                check=true;
                break;
            }
            if(pq.size()==0)    break;
            int b = pq.poll();
            
            int r = a+2*b;
            pq.offer(r);
            answer++;        
        }
        
        if(!check)  answer = -1;
        return answer;
    }
}