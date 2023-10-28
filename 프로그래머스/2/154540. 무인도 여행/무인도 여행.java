import java.util.*;
class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        char[][] board = new char[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            board[i] = maps[i].toCharArray();
        }
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(board[i][j]!='X'&&!visited[i][j]){
                    int eat = 0;
                    Queue<int[]> q =  new LinkedList<>();
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        int[] arr=q.poll();
                        eat+=board[arr[0]][arr[1]]-'0';
                        for(int k=0;k<4;k++){
                            int nr = arr[0]+dr[k];
                            int nc = arr[1]+dc[k];
                            if(nr<0||nr>maps.length-1||nc<0||nc>maps[0].length()-1)   continue;
                            if(board[nr][nc]!='X'&&!visited[nr][nc]){
                                q.offer(new int[]{nr,nc});
                                visited[nr][nc]=true;
                            }
                        }
                    }
                    answer.add(eat);
                }
            }
        }
        int result[] = answer.stream().mapToInt(i->i).toArray();
        if(result.length==0)    result=new int[]{-1};
        Arrays.sort(result);
        return result;
    }
}