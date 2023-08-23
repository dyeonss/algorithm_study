import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> all = new HashSet<>();
        HashMap<Integer, Integer> roll1 = new HashMap<>();
        HashMap<Integer, Integer> roll2 = new HashMap<>();
        int idx = 0;
        
        for(int t: topping) all.add(t);
        
        for(int t:topping){
            if(roll1.size()==all.size()/2)  break;
            roll1.put(t,roll1.getOrDefault(t,0)+1);
            idx++;
        }
        
        for(int i=idx;i<topping.length;i++)
            roll2.put(topping[i],roll2.getOrDefault(topping[i],0)+1);
        
        
        for(int i=idx;i<topping.length;i++){
            if(roll1.size()==roll2.size())  answer++;
            
            int t = topping[i];
            roll1.put(t,roll1.getOrDefault(t,0)+1);
            if(roll2.get(t)!=null) roll2.put(t,roll2.get(t)-1);
            if(roll2.get(t)==0)  roll2.remove(t);
        }
        
        return answer;
    }
}