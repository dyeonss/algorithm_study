import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int i=0,j=0;
        
        for(String s: goal){
            boolean flag = false;
            if(i<cards1.length&&cards1[i].equals(s)){
                flag=true;
                i++;
            }
            else if(j<cards2.length&&cards2[j].equals(s)){
                flag=true;
                j++;
            }
            if(!flag){
                return "No";
            }
        }
        return "Yes";
    }
}