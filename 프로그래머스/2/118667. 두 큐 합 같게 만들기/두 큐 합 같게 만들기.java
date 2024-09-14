import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer=0;
        long s1=0, s2=0;
        LinkedList<Integer> q1=new LinkedList<>();
        LinkedList<Integer> q2=new LinkedList<>();
        
        for(int i=0;i<queue1.length;i++){
            s1+=queue1[i];
            s2+=queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        if(s1==s2)  return answer;
        
        while(s1!=s2){
            if(answer>2*(queue1.length+queue2.length)){
                answer=-1;
                break;
            }  
            else if(s1>s2){
                int n=q1.pop();
                q2.offer(n);
                s2+=n;
                s1-=n;
            }
            else if(s1<s2){
                int n=q2.pop();
                q1.offer(n);
                s1+=n;
                s2-=n;
            }
            answer++;
        }
        
        return answer;
    }
}