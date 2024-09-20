import java.util.*;
class Solution {
    public int[] solution(String[] grid) {
        int[] answer={};
        ArrayList<Integer> list=new ArrayList<>();
        boolean[][][] visited=new boolean[grid.length][grid[0].length()][4];
        int[] dr={1,0,-1,0}, dc={0,1,0,-1};
        
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                for(int k=0;k<4;k++){   //아래 오 위 왼
                    if(!visited[i][j][k]){
                        int len=0;
                        int r=i,c=j,d=k;
                        visited[i][j][k]=true;
                        while(true){
                            if(grid[r].charAt(c)=='L')
                                d=(d+1)%4;
                            
                            else if(grid[r].charAt(c)=='R')
                                d=(d+3)%4;
                            
                            r=(visited.length+r+dr[d])%visited.length;
                            c=(visited[0].length+c+dc[d])%visited[0].length;
                            visited[r][c][d]=true;
                            len++;
                            if(r==i&&c==j&&d==k)  break;
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