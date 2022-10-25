import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max=Integer.MIN_VALUE;
        int maxidx = 0;
       
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]>max||sizes[i][1]>max){
                maxidx=i;
                max=sizes[i][0]>max?sizes[i][0]:sizes[i][1];
            }
        }
        
        int m = (max==sizes[maxidx][0])?sizes[maxidx][1]:sizes[maxidx][0];
        for(int i=0;i<sizes.length;i++){
            if(i!=maxidx){
                if(sizes[i][0]>=sizes[i][1]&&sizes[i][1]<=m) continue;
                else if(sizes[i][0]>=sizes[i][1]&&sizes[i][1]>m) m=sizes[i][1];
        
                else if(sizes[i][0]<=sizes[i][1]&&sizes[i][0]<=m)    continue;

                else if(sizes[i][0]<=sizes[i][1]&&sizes[i][0]>m) m=sizes[i][0];
            }
        }

        answer=max*m;
        return answer; 
    }
}