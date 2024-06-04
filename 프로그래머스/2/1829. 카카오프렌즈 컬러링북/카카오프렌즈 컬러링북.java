import java.util.*;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        int[] answer = new int[2];
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&picture[i][j]!=0){
                    visited[i][j]=true;
                    q.offer(new int[]{i,j});
                    int size=0;
                    numberOfArea++;
                    
                    while(!q.isEmpty()){
                        int[] loc=q.poll(); 
                        size++;
                        
                        for(int k=0;k<4;k++){
                            int r=loc[0]+dr[k];
                            int c=loc[1]+dc[k];
                            if(r<0||r>m-1||c<0||c>n-1)  continue;
                            if(visited[r][c]||picture[r][c]!=picture[loc[0]][loc[1]])   continue;
                            visited[r][c]=true;
                            q.offer(new int[]{r,c});
                        }
                    }
                    maxSizeOfOneArea=Math.max(maxSizeOfOneArea,size);
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }
}