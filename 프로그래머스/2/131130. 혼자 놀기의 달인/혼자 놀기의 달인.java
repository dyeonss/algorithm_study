import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        ArrayList<Integer> box=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        
        for(int i=0;i<cards.length;i++){
            boolean[] visited=new boolean[cards.length];
            ArrayList<String> list=new ArrayList<>();
            int select=cards[i];
            list.add(String.valueOf(cards[i]));
            visited[i]=true;
            
            while(!visited[select-1]){
                list.add(String.valueOf(cards[select-1]));
                visited[select-1]=true;
                select=cards[select-1];
            }
            
            Collections.sort(list);
            
            if(!set.contains(list.toString())){
                set.add(list.toString());
                if(list.size()==cards.length){
                    box.add(0);
                    continue;
                }    
                box.add(list.size());  
            }
        }
        
        box.sort(Collections.reverseOrder());
        if(box.size()>=2)   return box.get(0)*box.get(1);
        
        return box.get(0);
    }
}