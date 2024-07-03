import java.util.*;
class Solution {
    static int nr, nc, dir;
    static int[] dr={1,0,-1,0};
    static int[] dc={0,-1,0,1};    //아래, 왼, 위, 오른
    static int r,c;
    public int[] solution(String[] grid) {
        int[] answer = {};
        ArrayList<Integer> list=new ArrayList<>();
        r=grid.length;
        c=grid[0].length();
        char[][] board=new char[r][c];
        int[] dr={1,0,-1,0};
        int[] dc={0,-1,0,1};    //아래, 왼, 위, 오른
        boolean[][][] visited=new boolean[r][c][4];
        
        for(int i=0;i<grid.length;i++)  board[i]=grid[i].toCharArray();
         
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                for(int k=0;k<4;k++){
                    if(!visited[i][j][k]){
                        int size=0;
                        nr=i;
                        nc=j;
                        dir=k;  //현재 방향(아래, 왼, 위, 오른)

                        while(true){
                            if(visited[nr][nc][dir]){
                                list.add(size);
                                break;
                            }
                         
                            visited[nr][nc][dir]=true;
                            move(board);
                            size++;
                        }
                    }
                }
            }
        }
        answer=new int[list.size()];
        
        for(int i=0;i<list.size();i++)  answer[i]=list.get(i);
        Arrays.sort(answer);
        return answer;
    }
    public void move(char[][] board){
        char ch=board[nr][nc];
        
        if(ch=='L')
            dir=(dir+3)%4;
        else if(ch=='R')
            dir=(dir+1)%4;
        
        nr=(r+nr+dr[dir])%r;
        nc=(c+nc+dc[dir])%c;
    }
}