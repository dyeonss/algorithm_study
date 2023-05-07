import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int j=1;
            int cnt = index;
            char tmp=' ';
            
            while(cnt>0){
                tmp = (char)((c+j-'a')%26+97);
                if(skip.indexOf(tmp)==-1){
                    // System.out.println("tmp: "+tmp);
                    cnt--;
                }
                j++;
            }
            // System.out.println(tmp);
            answer+=tmp+"";
        }
        return answer;
    }
}