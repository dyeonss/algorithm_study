import java.util.*;
class Solution {
    public int[] solution(String[] grid) {
        ArrayList<Integer> answer=new ArrayList<>();
        boolean[][][] visited=new boolean[grid.length][grid[0].length()][4];
        int[] dr_l={0,-1,0,1}, dc_l={1,0,-1,0};
        int[] dr_r={0,1,0,-1}, dc_r={-1,0,1,0};
        int[] dr_s={1,0,-1,0}, dc_s={0,1,0,-1};
        
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                for(int k=0;k<4;k++){   //아래 오 위 왼
                    if(!visited[i][j][k]){
                        int len=0;
                        int r=i,c=j,d=k;
                        visited[i][j][k]=true;
                        while(true){
                            if(grid[r].charAt(c)=='L'){
                                r+=dr_l[d];
                                c+=dc_l[d];
                                d=(d+1)%4;
                            }
                            else if(grid[r].charAt(c)=='R'){
                                r+=dr_r[d];
                                c+=dc_r[d];
                                d=(d+3)%4;
                            }
                            else{
                                r+=dr_s[d];
                                c+=dc_s[d];
                            }
                            if(r<0) r=visited.length-1;
                            if(r>=visited.length)   r=0;
                            if(c<0) c=visited[0].length-1;
                            if(c>=visited[0].length)    c=0;
    
                            visited[r][c][d]=true;
                            len++;
                            if(r==i&&c==j&&d==k)  break;
                        }
                        answer.add(len);
                    }
                }
            }
        }
        answer.sort((o1,o2)->o1-o2);
        return answer.stream().mapToInt(i->i).toArray();
    }
}