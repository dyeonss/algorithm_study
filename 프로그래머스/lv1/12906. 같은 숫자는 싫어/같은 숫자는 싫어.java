import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Deque <Integer> q = new LinkedList<>();
        q.offer(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(q.peekLast()!=arr[i])
                q.offer(arr[i]);
        }
        answer=new int[q.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i]=q.poll();
        }
        return answer;
    }
}