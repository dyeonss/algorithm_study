import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long o = Long.valueOf(p);
        for(int i=0;i<=t.length()-len;i++){
            long cmp = Long.valueOf(t.substring(i,i+len));
            if(cmp<=o)  answer++;
        }
        return answer;
    }
}