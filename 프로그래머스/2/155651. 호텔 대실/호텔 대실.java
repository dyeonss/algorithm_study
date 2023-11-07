import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Arrays.sort(book_time,(t1,t2)->{
            String[] str1=t1[0].split(":");
            String[] str2=t2[0].split(":");
            int start1=Integer.valueOf(str1[0]+str1[1]);
            int start2=Integer.valueOf(str2[0]+str2[1]);
            return start1-start2;
        });
        
        for(int i=0;i<book_time.length;i++){
            String[] s1=book_time[i][0].split(":");
            String[] s2=book_time[i][1].split(":");
            int start=Integer.valueOf(s1[0])*60+Integer.valueOf(s1[1]);
            int end=Integer.valueOf(s2[0])*60+Integer.valueOf(s2[1]);
            
            if(pq.size()==0){
                pq.offer(end);
                continue;
            }
            if(pq.peek()+10<=start){
                pq.poll();
                pq.offer(end);
            }
            else
                pq.offer(end);
        }
        
        return pq.size();
    }
}