import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String t: skill_trees){
            char[] arr = t.toCharArray();
            boolean[] learn = new boolean[skill.length()];
            boolean check = true;
            
            for(char c:arr){
                int idx = skill.indexOf(c);
                //skill에 포함되는 문자인 경우
                if(idx>-1){
                    learn[idx] = true;
                    for(int i=0;i<idx;i++){
                        if(!learn[i]){
                            check = false;
                            break;
                        }
                    }
                }
                if(!check)  break;
            }
            if(check)   answer++;
        }
       
        return answer;
    }
}