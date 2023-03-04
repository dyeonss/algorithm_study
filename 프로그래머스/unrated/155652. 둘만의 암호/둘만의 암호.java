import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        boolean [] isExist = new boolean[26];
        
        for(int i=0;i<skip.length();i++){
            isExist[skip.charAt(i)-'a']=true;
        }
        
        for(int i=0;i<s.length();i++){
            int idx=0, plus=0;
            while(idx<index){
                plus++;       

                if(isExist[(s.charAt(i)-'a'+plus)%26]==false)    idx++; //skip에 포함된 문자인 경우
                
            }
            answer+=(char)((s.charAt(i)+plus-'a')%26+'a');
        }
            
        return answer;
    }
}