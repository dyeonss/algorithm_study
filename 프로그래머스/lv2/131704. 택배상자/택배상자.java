import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        LinkedList<Integer> main = new LinkedList<Integer>();
        Stack<Integer> sub = new Stack<Integer>();
        HashMap<Integer,Boolean> in = new HashMap<>();
        int idx=0, n=order.length;
       
        for(int i=1;i<=n;i++){
            main.offer(i);
        }   
   
        while(idx<n){
            if(!main.isEmpty()&&main.peek()==order[idx]){
                main.poll();
                idx++;
                answer++;
            }
            else if(sub.size()>0&&(order[idx]==sub.peek())){
                int s=sub.peek();
                sub.pop();
                in.remove(s);
                idx++;
                answer++;
            }
            else if(!main.isEmpty()&&main.peek()!=order[idx]&&in.get(order[idx])==null){
                int m=main.poll();
                sub.push(m);
                in.put(m, true);
            }
            else if(!main.isEmpty()&&main.peek()!=order[idx]&&sub.size()>0&&sub.peek()!=order[idx])
                break;
        }
        return answer;
    }
}