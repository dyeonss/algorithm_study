import java.util.*;
class Solution {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
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
            System.out.println();
            if(check)   answer[i]=1;
        }
        return answer;
    }
    public boolean distance(String[][] places,int i,int j,int k){
        int r=j, c=k;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[5][5];
        q.offer(new int[]{r,c});
        visited[r][c]=true;

        while(!q.isEmpty()){
            int[] arr=q.poll();

            for(int l=0;l<4;l++){
                int nr=arr[0]+dr[l];
                int nc=arr[1]+dc[l];
                if(nr<0||nr>4||nc<0||nc>4)  continue;
                if(visited[nr][nc]||places[i][nr].charAt(nc)=='X'||(Math.abs(r-nr)+Math.abs(c-nc))>2)  continue;
                if(places[i][nr].charAt(nc)=='P'){
                    return false;
                }
                q.offer(new int[]{nr,nc});
                visited[nr][nc]=true;
            }
        }
        return true;
    }
}