import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int answer=0, idx=1;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        int[][] board=new int[land.length][land[0].length];
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<land[0].length;i++){
            for(int j=0;j<land.length;j++){
                if(land[j][i]==1){
                    if(board[j][i]!=0)    continue;
                    Queue<int[]> q=new LinkedList<>();
                    int size=0;
                    board[j][i]=idx;
                    q.offer(new int[]{j,i});
                    
                    while(!q.isEmpty()){
                        int[] t=q.poll();
                        size++;
                        for(int k=0;k<4;k++){
                            int r=t[0]+dr[k];
                            int c=t[1]+dc[k];
                            if(r<0||r>land.length-1||c<0||c>land[0].length-1)   continue;
                            if(board[r][c]!=0||land[r][c]==0)   continue;
                            q.offer(new int[]{r,c});
                            board[r][c]=idx;
                        }   
                    }
                    map.put(idx,size);
                    idx++;
                }
            }
        }
        
        for(int i=0;i<land[0].length;i++){
            boolean[] check=new boolean[map.size()];
            int total=0;
            for(int j=0;j<land.length;j++){
                if(board[j][i]!=0&&!check[board[j][i]-1]){
                    total+=map.get(board[j][i]);
                    check[board[j][i]-1]=true;
                }
            }
            answer=Math.max(answer,total);
        }
        
        return answer;
    }
}