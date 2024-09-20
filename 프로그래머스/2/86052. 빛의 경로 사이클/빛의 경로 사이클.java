import java.util.*;
class Solution {
    public int[] solution(String[] grid) {
        int[] answer={};
        ArrayList<Integer> list=new ArrayList<>();
        int r=grid.length, c=grid[0].length();
        boolean[][][] visited=new boolean[r][c][4];
        int[] dr={1,0,-1,0}, dc={0,1,0,-1};
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                for(int k=0;k<4;k++){   //아래 오 위 왼
                    if(!visited[i][j][k]){
                        int len=0;
                        int nr=i,nc=j,d=k;
                        visited[i][j][k]=true;
                        while(true){
                            if(grid[nr].charAt(nc)=='L')
                                d=(d+1)%4;
                            
                            else if(grid[nr].charAt(nc)=='R')
                                d=(d+3)%4;
                            
                            nr=(r+nr+dr[d])%r;
                            nc=(c+nc+dc[d])%c;
                            visited[nr][nc][d]=true;
                            len++;
                            if(nr==i&&nc==j&&d==k)  break;
                        }
                        list.add(len);
                    }
                }
            }
        }
        
        answer=new int[list.size()];
        for(int i=0;i<list.size();i++)    answer[i]=list.get(i);
        Arrays.sort(answer);
        
        return answer;
    }
}