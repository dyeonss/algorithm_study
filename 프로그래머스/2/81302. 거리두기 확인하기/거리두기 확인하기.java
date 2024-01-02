import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i=0;i<places.length;i++){
            boolean check=true;
            for(int j=0;j<places[i].length;j++){
                for(int k=0;k<places[i][j].length();k++){
                    if(places[i][j].charAt(k)=='P'){
                        if(!distance(places,i,j,k)){
                            check=false;
                            break;
                        }   
                    }
                }
                if(!check)  break;
            }
            if(check)   answer[i]=1;
        }
        return answer;
    }
    public boolean distance(String[][] places,int idx,int r,int c){
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[5][5];
        
        q.offer(new int[]{r,c});
        visited[r][c]=true;

        while(!q.isEmpty()){
            int[] arr=q.poll();

            for(int i=0;i<4;i++){
                int nr=arr[0]+dr[i];
                int nc=arr[1]+dc[i];
                if(nr<0||nr>4||nc<0||nc>4)  continue;
                if(visited[nr][nc]||places[idx][nr].charAt(nc)=='X'||(Math.abs(r-nr)+Math.abs(c-nc))>2)  continue;
                if(places[idx][nr].charAt(nc)=='P') return false;
                
                q.offer(new int[]{nr,nc});
                visited[nr][nc]=true;
            }
        }
        return true;
    }
}