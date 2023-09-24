import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1=0, sum2=0;
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        
        for(int i=0;i<queue1.length;i++){
            sum1+=(long)queue1[i];
            q1.add(queue1[i]);
        }
        for(int i=0;i<queue2.length;i++){
            sum2+=(long)queue2[i];
            q2.add(queue2[i]);
        }
        
        while((sum1!=sum2)&&(answer<(queue1.length+queue2.length)*2)){
            if(sum1>sum2){
                int n=q1.poll();
                q2.add(n);
                sum1-=n;
                sum2+=n;
            }
            else{
                int n=q2.poll();
                q1.add(n);
                sum2-=n;
                sum1+=n;
            }
            answer++;
        }
        
        if(sum1!=sum2)    return -1;
        
        return answer;
    }
}
