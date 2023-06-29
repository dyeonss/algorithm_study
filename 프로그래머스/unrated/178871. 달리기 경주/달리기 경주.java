import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        int i=0;
        
        for(String p:players)   map.put(p,i++);
        
        for(String c:callings){
            String tmp = "";
            tmp=players[map.get(c)-1];
            players[map.get(c)-1]=players[map.get(c)];
            players[map.get(c)]=tmp;
            map.put(tmp,map.get(c));
            map.put(c, map.get(c)-1);
        }
        answer=Arrays.copyOf(players,players.length);
        return answer;
    }
}