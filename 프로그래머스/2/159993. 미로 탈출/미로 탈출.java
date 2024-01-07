import java.util.*;
class Solution {
    class Pos{
        int r,c,d;
        Pos(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int solution(String[] maps) {
        int answer = 0;
        Queue<Pos> q=new LinkedList<>();
        Pos s=new Pos(0,0,0);
        Pos l=new Pos(0,0,0);
        Pos e=new Pos(0,0,0);
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        boolean[][] visited=new boolean[maps.length][maps[0].length()];
        boolean start=false,end=false;
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)=='S')  s=new Pos(i,j,0);
                else if(maps[i].charAt(j)=='L') l=new Pos(i,j,0);
                else if(maps[i].charAt(j)=='E') e=new Pos(i,j,0);
            }
        }
        
        q.offer(l);
        visited[l.r][l.c]=true;
        
        while(!q.isEmpty()){
            Pos now=q.poll();
            
            if(now.r==s.r&&now.c==s.c){
                answer+=now.d;
                start=true;
            }
            else if(now.r==e.r&&now.c==e.c){
                answer+=now.d;
                end=true;
            }  
            
            for(int i=0;i<4;i++){
                int nr=now.r+dr[i];
                int nc=now.c+dc[i];
                
                if(nr<0||nc<0||nr>maps.length-1||nc>maps[0].length()-1) continue;
                if(visited[nr][nc]||maps[nr].charAt(nc)=='X') continue;
                q.offer(new Pos(nr,nc,now.d+1));
                visited[nr][nc]=true;
            }
        }
        return start&&end?answer:-1;
    }
}