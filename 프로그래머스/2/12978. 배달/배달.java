import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] village=new int[N][N];
        int[] minDist=new int[N];
        LinkedList<int[]> q=new LinkedList<>();
        Arrays.fill(minDist,Integer.MAX_VALUE);
        minDist[0]=0;
        
        
        for(int i=0;i<road.length;i++){
            int d=village[road[i][0]-1][road[i][1]-1];
            village[road[i][0]-1][road[i][1]-1]=Math.min(d==0?Integer.MAX_VALUE:d,road[i][2]);
            village[road[i][1]-1][road[i][0]-1]=Math.min(village[road[i][0]-1][road[i][1]-1],road[i][2]);
        }
        
        for(int i=0;i<village[0].length;i++){
            if(village[0][i]!=0){
                minDist[i]=village[0][i];
                q.offer(new int[]{i,minDist[i]});
            }
        }    

        while(!q.isEmpty()){
            int [] arr=q.poll();
            
            for(int i=0;i<village[arr[0]].length;i++){
                if(village[arr[0]][i]!=0){
                    if(arr[1]+village[arr[0]][i]<minDist[i]){
                        minDist[i]=arr[1]+village[arr[0]][i];
                        q.offer(new int[]{i,minDist[i]});
                    }
                }
            }
        }
        
        for(int i=0;i<N;i++)    if(minDist[i]<=K)   answer++;
        
        return answer;
    }
}