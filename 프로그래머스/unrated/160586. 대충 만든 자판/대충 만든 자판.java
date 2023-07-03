import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0;i<targets.length;i++){
            int cnt=0;
            for(int j=0;j<targets[i].length();j++){
                cnt = match(targets[i].charAt(j),keymap);
                if(cnt==-1){
                    break;
                }
                answer[i]+=cnt;
            }
            if(cnt==-1){
                answer[i]=-1;
                continue;
            }
        }
        return answer;
    }
    public int match(char c, String[] keymap){
        int cnt = Integer.MAX_VALUE;
        
        for(int i=0;i<keymap.length;i++){
            if(keymap[i].contains(String.valueOf(c))){
                cnt = Math.min(cnt, keymap[i].indexOf(c)+1);
            }
        }
        return cnt==Integer.MAX_VALUE?-1:cnt;
    }
}