import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String t: skill_trees){
            char[] arr = t.toCharArray();
            boolean check = true;
            String copy = new String(skill);
            for(char c:arr){
                int idx = copy.indexOf(c);
                if(idx==-1) continue;
                copy = copy.replace(String.valueOf(c), "");
                if(idx!=0){
                    check=false;
                    break;
                }
            }
            if(check)   answer++;
        }
       
        return answer;
    }
}