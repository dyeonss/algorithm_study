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
        ArrayList<Work> not=new ArrayList<>();
        ArrayList<Work> worked=new ArrayList<>();
        int cnt=0,time=0;
        
        for(String[] p:plans){
            int start=Integer.valueOf(p[1].substring(0,2))*60+Integer.valueOf(p[1].substring(3));
            not.add(new Work(p[0],start,Integer.valueOf(p[2])));
        }
        
        not.sort((o1,o2)->o1.start-o2.start);
        Work w=not.remove(0);
        time=w.start;
        while(not.size()>0||worked.size()>0){
            if(not.size()>0){
                Work n=not.get(0);
                if(time+w.playtime<n.start){
                    answer[cnt++]=w.name;
                    
                    if(worked.size()>0){
                        time=time+w.playtime;
                        w=worked.remove(worked.size()-1);
                    }
                    else{
                        w=not.remove(0);
                        time=n.start;
                    }
                }
                else if(time+w.playtime==n.start){
                    answer[cnt++]=w.name;
                    time=n.start;
                    w=not.remove(0);
                }
                else if(time+w.playtime>n.start){
                    w.playtime-=(n.start-time);
                    time=n.start;
                    worked.add(w);
                    w=not.remove(0);
                }
            }
            //멈춰둔 과제만 있는 경우
            else if(not.size()==0&&worked.size()>0){
                answer[cnt++]=w.name;
                w=worked.remove(worked.size()-1);
            }
        }
        answer[cnt]=w.name;
        return answer;
    }
}