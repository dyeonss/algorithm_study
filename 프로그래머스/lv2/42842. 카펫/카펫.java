import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown+yellow;
        int w=0, h=3;   //격자가 되기 위해선 높이는 3부터 가능
        
        while(true){
            if(total%h==0){
                w=total/h;
                if(find(w,h,brown,yellow))  break;
            }
            h++;
        }
        answer[0]=w;
        answer[1]=h;
        return answer;
    }
    public boolean find(int w, int h, int brown, int yellow){
        int btotal = w*2+(h-2)*2;
        if(btotal==brown)   return true;
        return false;
    }
}