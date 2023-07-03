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
            int plus = t.get(type);
            int year = Integer.valueOf(date[0]);
            int month = Integer.valueOf(date[1])+plus;
            int day = Integer.valueOf(date[2]);
                      
            if(month>12){
                if(month%12==0){
                    year+=month/12-1;
                    month=12;
                }
                else{
                    year+=month/12;
                    month%=12;
                }
            }
            
            int after = Integer.valueOf(year+(month<10?"0":"")+month+(day<10?"0":"")+day);
         
            if(after<=Integer.valueOf(today.replace(".","")))            
                result.add(i+1);
        }
        
        answer = result.stream().mapToInt(i->i).toArray();
        return answer;
    }
}