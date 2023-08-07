import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static char[][] paint;
    public static boolean[][] visited;
    public static int N;
    public static int[] dr = {-1,1,0,0};    //상하좌우
    public static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        paint = new char[N][N];
        visited = new boolean[N][N];
        int rgbCount = 0;
        int rbCount = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            paint[i]=s.toCharArray();
        }

        for(int i=0;i<N;i++){
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    rgb(i,j);
                    rgbCount++;
                }
            }
        }

        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    blindness(i,j);
                    rbCount++;
                }
            }
        }

        System.out.println(rgbCount+" "+rbCount);
    }
    public static void rgb(int r, int c){
        LinkedList<int[]> q = new LinkedList<>();

        q.offer(new int[]{r,c});
        visited[r][c]=true;

        while(!q.isEmpty()){
            int[] arr = q.poll();
            char ch = paint[arr[0]][arr[1]];


            for(int k=0;k<4;k++) {
                int nr = arr[0] + dr[k];
                int nc = arr[1] + dc[k];
                if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) continue;
                if ((!visited[nr][nc]) && (paint[nr][nc] == ch)) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
    public static void blindness(int r, int c){
        LinkedList<int[]> q = new LinkedList<>();

        q.offer(new int[]{r,c});
        visited[r][c]=true;

        while(!q.isEmpty()){
            int[] arr = q.poll();
            char ch = paint[arr[0]][arr[1]];

            for(int k=0;k<4;k++) {
                int nr = arr[0] + dr[k];
                int nc = arr[1] + dc[k];
                if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) continue;
                if (!visited[nr][nc] && (((ch=='R'||ch=='G')&&(paint[nr][nc] == 'R'||paint[nr][nc] == 'G'))||ch==paint[nr][nc])) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
