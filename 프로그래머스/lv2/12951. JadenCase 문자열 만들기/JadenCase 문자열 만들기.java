import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] sArr = s.toLowerCase().split(" ");
        
        for(String str:sArr){
            if(str.equals("")){
                answer.append(" ");
                continue;
            }  
            answer.append(str.substring(0,1).toUpperCase());
            answer.append(str.substring(1,str.length()));
            answer.append(" ");
        }
        
        if(s.substring(s.length()-1,s.length()).equals(" ")) return answer.toString();
        answer.delete(answer.length()-1, answer.length());
        return answer.toString();
    }
}