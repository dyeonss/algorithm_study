import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<want.length;i++)
            map.put(want[i], number[i]);

        for(int i=0;i<=discount.length-10;i++){
            HashMap<String, Integer> tmp = new HashMap<>();
            for(int j=i;j<i+10;j++){
                tmp.put(discount[j],tmp.getOrDefault(discount[j],0)+1);
            }
          
            boolean join = true;
            for(String s: map.keySet()){
                if(tmp.getOrDefault(s,0)<map.get(s)){
                    join = false;
                    break;
                }
            }
            if(join)    answer++;
        }
        
        return answer;
    }
}