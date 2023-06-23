import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer,-1);
        for(int i=1;i<s.length();i++){
            int idx = s.lastIndexOf(s.charAt(i),i-1);
            answer[i]=idx!=-1?i-idx:-1;
        }
        return answer;
    }
}