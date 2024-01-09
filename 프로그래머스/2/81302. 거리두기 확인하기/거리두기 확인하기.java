import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        
        for(int i=0;i<places.length;i++){
            answer[i]=1;
            for(int j=0;j<places[i].length;j++){
                for(int k=0;k<places[i][j].length();k++){
                    if(places[i][j].charAt(k)=='P'){
                        Queue<int[]> q=new LinkedList<>();
                        boolean[][] visited=new boolean[5][5];
                        q.offer(new int[]{j,k});
                        visited[j][k]=true;
                        
                        while(!q.isEmpty()){
                            int[] arr=q.poll();
                            for(int d=0;d<4;d++){
                                int nr=arr[0]+dr[d];
                                int nc=arr[1]+dc[d];
                                if(nr<0||nr>4||nc<0||nc>4)  continue;
                                if(visited[nr][nc]||places[i][nr].charAt(nc)=='X'||(Math.abs(nr-j)+(Math.abs(nc-k)))>2)   continue;
                                if(places[i][nr].charAt(nc)=='P'&&((Math.abs(nr-j)+(Math.abs(nc-k)))<=2)){
                                    answer[i]=0;
                                    break;
                                }
                                q.offer(new int[]{nr,nc});
                                visited[nr][nc]=true;
                            }
                        }
                    }
                    if(answer[i]==0)    break;
                }
                if(answer[i]==0)    break;
            }
        }
        return answer;
    }
}