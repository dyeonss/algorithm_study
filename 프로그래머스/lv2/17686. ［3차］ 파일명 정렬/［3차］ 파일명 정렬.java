import java.util.*;
class Solution {
    public static class Program implements Comparable<Program>{
        String head;
        int number;
        String name;
        int order;
        public Program(String head, int number, String name, int order){
            this.head = head;
            this.number = number;
            this.name = name;
            this.order = order;
        }
        @Override
        public int compareTo(Program o){
            if(this.head.equals(o.head)){
                if(this.number == o.number) return this.order - o.order;
                return this.number - o.number;
            }   
            return this.head.compareTo(o.head);
        }
    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        int i = 0;
        ArrayList<String> list = new ArrayList<>();
        PriorityQueue<Program> pq = new PriorityQueue<>();
        
        for(String f:files){
            String head = f.split("[0-9]")[0].toLowerCase();
            int len = head.length();
            String version = f.substring(head.length()).split("[^0-9]")[0];
            if(version.length()>5)    version = version.substring(0,5);
            int v = Integer.valueOf(version);
            System.out.println(head+" "+v);
            Program p = new Program(head,v,f,i++);
            pq.offer(p);
        }
        i=0;
        while(!pq.isEmpty()){
            Program p = pq.poll();
            answer[i++]=p.name;
        }
        return answer;
    }
}