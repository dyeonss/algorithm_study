import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        ArrayList<Integer> list=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        
        for(int i=0;i<cards.length;i++){
            boolean[] visited=new boolean[cards.length];
            ArrayList<String> box=new ArrayList<>();
            int select=cards[i];
            box.add(String.valueOf(cards[i]));
            visited[i]=true;
            
            while(!visited[select-1]){
                box.add(String.valueOf(cards[select-1]));
                visited[select-1]=true;
                select=cards[select-1];
            }
            
            Collections.sort(box);
            
            if(!set.contains(box.toString())){
                if(box.size()==cards.length)    list.add(0);
                set.add(box.toString());
                list.add(box.size());
            }
            
        }
        
        Collections.sort(list,Collections.reverseOrder());

        if(list.size()>=2)   return list.get(0)*list.get(1);
        
        return list.get(0);
    }
}