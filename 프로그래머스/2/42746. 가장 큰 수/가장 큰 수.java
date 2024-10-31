import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb=new StringBuilder();
        PriorityQueue<String> pq=new PriorityQueue<>((o1,o2)->{
            return Integer.valueOf(o2+o1)-Integer.valueOf(o1+o2);
        });
        
        for(int i=0;i<numbers.length;i++)
            pq.offer(String.valueOf(numbers[i]));
        
        while(!pq.isEmpty())
            sb.append(pq.poll());
        
        if(sb.toString().charAt(0)=='0')    return "0";
        return sb.toString();
    }
}