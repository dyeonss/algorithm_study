import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [] dr={-1,-1,-1,0,1,1,1,0};
    static int [] dc={-1,0,1,1,1,0,-1,-1};
    static boolean [][] visited;
    static int [][] map;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int w=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            if(w==0&&h==0)  break;
            map=new int[h][w];
            visited=new boolean[h][w];
            result=0;

            for (int i = 0; i < h; i++) {
                st=new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < w; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j]==1&&!visited[i][j]){
                        bfs(i,j);
                    }
                }
            }
            System.out.println(result);
        }

    }

    private static void bfs(int r, int c) {
        Queue<int[]> q=new LinkedList<>();

        q.offer(new int[]{r,c});
        visited[r][c]=true;

        while (!q.isEmpty()){
            int [] cur=q.poll();

            for (int i = 0; i < 8; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (check(nr, nc, map.length, map[0].length) && !visited[nr][nc]&&map[nr][nc]==1) {
                    visited[nr][nc]=true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        result++;
    }

    private static boolean check(int r, int c,int h, int w) {
        return r>=0&&r<h&&c>=0&&c<w;
    }
}
