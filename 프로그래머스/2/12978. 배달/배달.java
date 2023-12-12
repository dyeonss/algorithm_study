import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] village = new int[N][N];
        int[] min=new int[N];
        Queue<int[]> q =new LinkedList<>();
        
        for(int i=1;i<N;i++)
            min[i]=Integer.MAX_VALUE;
        
        for(int i=0;i<road.length;i++){
            if(village[road[i][0]-1][road[i][1]-1]==0||(village[road[i][0]-1][road[i][1]-1]!=0&&road[i][2]<village[road[i][0]-1][road[i][1]-1])){
                village[road[i][0]-1][road[i][1]-1]=road[i][2];
                village[road[i][1]-1][road[i][0]-1]=road[i][2];
            }
        }
        
        for(int i=0;i<N;i++){
            if(village[0][i]!=0){
                q.offer(new int[]{i,village[0][i]});    //도착점, 비용
                min[i]=village[0][i];
            }   
        }
        
        while(!q.isEmpty()){
            int[] arr=q.poll();
            for(int i=0;i<N;i++){
                if(village[arr[0]][i]!=0&&(arr[1]+village[arr[0]][i])<min[i]){
                    q.offer(new int[]{i,arr[1]+village[arr[0]][i]});
                    min[i]=arr[1]+village[arr[0]][i];
                } 
            }
        }
        
        for(int i=0;i<N;i++){
            if(min[i]<=K)   answer++;
        }
        
        return answer;
    }
}