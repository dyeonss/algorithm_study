import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; 
        int sum = 0, idx=0;
        Queue<Integer> q = new LinkedList<>();           
        
        while(true){
            if(idx == truck_weights.length) break;
            if(q.size() == bridge_length){
                sum-=q.poll();                
            }
            else if(sum+truck_weights[idx]>weight){
                q.offer(0);
                answer++;              
            }else{
                q.offer(truck_weights[idx]);
                sum+=truck_weights[idx];
                answer++;
                idx++;
            }            
        }
        
        // 9. 마지막 트럭이 다리에 올라간 상태에서 다리의 길이를 더해주면, 모든 트럭이 통과하는데 걸린 시간.
        return answer + bridge_length;
    }
}