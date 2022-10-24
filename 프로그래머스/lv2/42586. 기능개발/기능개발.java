import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue q = new LinkedList<>();
        List<Integer> work = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<progresses.length;i++){
            q.offer(progresses[i]);
            int b = 100-progresses[i];
            int day = b/speeds[i];
            
            if((progresses[i]+(day*speeds[i]))<100)
                day++;
            
            work.add(day);
        }
        //for(int i=0;i<work.size();i++)  System.out.println(work.get(i));
        int d = work.get(0);
        int cnt = 1;
        for(int i=1;i<work.size();i++){
            if(work.get(i)<=d){
                cnt++;
            }
            else{
                res.add(cnt);
                d=work.get(i);
                cnt=1;
            }
        }
        if(cnt>=1)   res.add(cnt);
        answer=new int[res.size()];
        for(int i=0;i<answer.length;i++)    answer[i]=res.get(i);
        
        return answer;
    }
}