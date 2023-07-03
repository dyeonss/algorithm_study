import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        HashMap<String,Integer> t = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        String[] todayStr = today.split("\\.");
        int todayD = Integer.valueOf(todayStr[0])*12*28+Integer.valueOf(todayStr[1])*28+Integer.valueOf(todayStr[2]);
        
        for(String s: terms)
            t.put(s.substring(0,1),Integer.valueOf(s.substring(2)));
        
        for(int i=0;i<privacies.length;i++){
            String[] date = privacies[i].substring(0,10).split("\\.");
            String type = privacies[i].substring(11,12);
            int year = Integer.valueOf(date[0]);
            int month = Integer.valueOf(date[1]);
            int day = Integer.valueOf(date[2]);
            int plus = t.get(type);
           
            int after = year*12*28+(month+plus)*28+day;
            if(after<=todayD)            
                result.add(i+1);
        }
        
        answer = result.stream().mapToInt(i->i).toArray();
        return answer;
    }
}