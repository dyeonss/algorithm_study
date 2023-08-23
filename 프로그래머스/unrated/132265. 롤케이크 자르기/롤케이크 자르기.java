import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> roll1 = new HashMap<>();
        HashMap<Integer, Integer> roll2 = new HashMap<>();

        for(int t:topping)
            roll1.put(t,roll1.getOrDefault(t,0)+1);
        
        for(int i=topping.length-1;i>=0;i--){
            if(roll1.size()==roll2.size())  answer++;
            
            int t = topping[i];
            
            roll2.put(t,roll2.getOrDefault(t,0)+1);
            if(roll1.get(t)!=null) roll1.put(t,roll1.get(t)-1);
            if(roll1.get(t)==0)  roll1.remove(t);
        }
        
        return answer;
    }
}