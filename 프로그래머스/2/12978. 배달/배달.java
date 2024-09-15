import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] village=new int[N][N];
        
        for(int i=0;i<N;i++){
            Arrays.fill(village[i],K+1);
            village[i][i]=0;
        }
        
        for(int i=0;i<road.length;i++){
            village[road[i][0]-1][road[i][1]-1]=Math.min(village[road[i][0]-1][road[i][1]-1],road[i][2]);
            village[road[i][1]-1][road[i][0]-1]=Math.min(village[road[i][1]-1][road[i][0]-1],road[i][2]);
        }
    
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                for(int k=0;k<N;k++)
                    village[j][k]=Math.min(village[j][k],village[j][i]+village[i][k]);
          
        for(int i=0;i<N;i++)    if(village[0][i]<=K) answer++;
        
        return answer;
    }
}