import java.util.*;
class Solution {
    public static class Pos{
        int r,c,depth;
        public Pos(int r, int c, int depth){
            this.r=r; 
            this.c=c; 
            this.depth=depth;
        }
    }
    public static int [] dr = {-1,1,0,0};
    public static int [] dc = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = -1;
        int rsize=maps.length;
        int csize=maps[0].length;
        boolean [][] visited=new boolean[rsize][csize];
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0,0,1));
        
        while(!q.isEmpty()){
            Pos p = q.poll();
            if(p.r==rsize-1&&p.c==csize-1){
                answer=p.depth;
                break;
            } 
            for(int i=0;i<4;i++){
                int nr = p.r+dr[i];
                int nc = p.c+dc[i];
                if(nr<0||nr>rsize-1||nc<0||nc>csize-1)  continue;
                if(visited[nr][nc]||(maps[nr][nc]==0)) continue;
                q.offer(new Pos(nr,nc,p.depth+1));
                visited[nr][nc]=true;
            }
        }
        return answer;
    }
}