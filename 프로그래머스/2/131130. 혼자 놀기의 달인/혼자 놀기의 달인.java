import java.util.*;
class Solution {
    public int solution(int[] cards) {
        ArrayList<Integer> box=new ArrayList<>();
        boolean[] visited=new boolean[cards.length];
        
        for(int i=0;i<cards.length;i++){
            if(!visited[i]){
                int cnt=1;
                int select=cards[i];
                visited[i]=true;

                while(!visited[select-1]){
                    visited[select-1]=true;
                    select=cards[select-1];
                    cnt++;
                }
                if(cnt==cards.length)   box.add(0);
                else    box.add(cnt);
            }
        }
        
        box.sort(Collections.reverseOrder());
        if(box.size()>=2)   return box.get(0)*box.get(1);
        
        return 0;
    }
}