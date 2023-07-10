import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> result = new HashMap<>();
        String[] mbti = {"R","T","C","F","J","M","A","N"};
        
        for(String m: mbti)
            result.put(m,0);
        
        for(int i=0;i<choices.length;i++){
            String l = survey[i].substring(0,1);
            String r = survey[i].substring(1,2);
            if(choices[i]<=3){
                result.put(l,result.get(l)+(4-choices[i]));
            }
            else if(choices[i]>=5){
                result.put(r,result.get(r)+choices[i]-4);
            }
        }
        
        answer+=(result.get("R")>=result.get("T"))?"R":"T";
        answer+=(result.get("C")>=result.get("F"))?"C":"F";
        answer+=(result.get("J")>=result.get("M"))?"J":"M";
        answer+=(result.get("A")>=result.get("N"))?"A":"N";
        
        return answer;
    }
}