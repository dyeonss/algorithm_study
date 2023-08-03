import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> tmp = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<=25;i++)
            map.put(String.valueOf((char)('A'+i)),i+1);
        
        int idx = 0;
        int value = 26;
        for(int i=0;i<msg.length();i++){
            for(int j=1;j<=msg.length()-i;j++){
                if(map.get(msg.substring(i,i+j))==null){
                    map.put(msg.substring(i,i+j),++value);
                    tmp.add(map.get(msg.substring(i,i+j-1)));
                    i=i+j-2;
                    idx=i+1;
                    break;
                }
            }
        }
      
        tmp.add(map.get(msg.substring(idx,msg.length())));
        answer = tmp.stream().mapToInt(i->i).toArray();
        return answer;
    }
}