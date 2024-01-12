import java.util.*;
class Solution {
    public class Coor{
        int r,c,d;
        public Coor(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int solution(String[] board) {
        int answer = -1;
        boolean[][] visited=new boolean[board.length][board[0].length()];
        Queue<Coor> q= new LinkedList<>();
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                if(board[i].charAt(j)=='R'){
                    q.offer(new Coor(i,j,0));
                    visited[i][j]=true;
                    break;
                }
            }
        }
        
        while(!q.isEmpty()){
            Coor c=q.poll();

            if(board[c.r].charAt(c.c)=='G'){
                answer=c.d;
                break;
            }
            
            for(int i=0;i<4;i++){
                int nr=c.r;
                int nc=c.c;
                int pr,pc;
                if((nr+dr[i])<0||(nr+dr[i])>board.length-1||(nc+dc[i])<0||(nc+dc[i])>board[0].length()-1)    continue;
                
                while(true){
                    pr=nr;
                    pc=nc;
                    nr=pr+dr[i];
                    nc=pc+dc[i];
                    if(nr<0||nr>board.length-1||nc<0||nc>board[0].length()-1)   break;
                    if(board[nr].charAt(nc)=='D')   break;
                }
                
                if(visited[pr][pc])   continue;
                
                q.offer(new Coor(pr,pc,c.d+1));
                visited[pr][pc]=true;
            }
        }
        return answer;
    }
}