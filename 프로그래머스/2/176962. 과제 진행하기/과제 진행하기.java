import java.util.*;
class Solution {
    public class Work{
        String name;
        int start, playtime;
        public Work(String name, int start, int playtime){
            this.name=name;
            this.start=start;
            this.playtime=playtime;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Work> not=new PriorityQueue<>((o1,o2)->o1.start-o2.start);
        Stack<Work> worked=new Stack<>();
        int cnt=0,time=0;
        
        for(String[] p:plans){
            int start=Integer.valueOf(p[1].substring(0,2))*60+Integer.valueOf(p[1].substring(3));
            not.offer(new Work(p[0],start,Integer.valueOf(p[2])));
        }
        
        Work w=not.poll();
        time=w.start;
        
        while(!not.isEmpty()){
            Work n=not.peek();
            if(time+w.playtime<n.start){
                answer[cnt++]=w.name;

                if(worked.size()>0){
                    time=time+w.playtime;
                    w=worked.pop();
                }
                else{
                    w=not.poll();
                    time=n.start;
                }
            }
            else if(time+w.playtime==n.start){
                answer[cnt++]=w.name;
                time=n.start;
                w=not.poll();
            }
            else if(time+w.playtime>n.start){
                w.playtime-=(n.start-time);
                time=n.start;
                worked.push(w);
                w=not.poll();
            }
        }
        
        while(!worked.isEmpty()){
            answer[cnt++]=w.name;
            w=worked.pop();
        }
        answer[cnt]=w.name;
        return answer;
    }
}