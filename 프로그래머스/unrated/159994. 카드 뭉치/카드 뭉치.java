import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int idx1=-1, idx2=-1;
        
        List<String> cards1List = Arrays.asList(cards1);
        List<String> cards2List = Arrays.asList(cards2);
        
        for(String g:goal){
            int tmp1 = cards1List.indexOf(g);
            int tmp2 = cards2List.indexOf(g);
            if(tmp1!=-1){
                if(tmp1!=idx1+1)    return "No";
                idx1=tmp1;
            }
            else if(tmp2!=-1){
                if(tmp2!=idx2+1)    return "No";
                idx2=tmp2;
            }
            else    return "No";
        }
  
        return answer;
    }
}