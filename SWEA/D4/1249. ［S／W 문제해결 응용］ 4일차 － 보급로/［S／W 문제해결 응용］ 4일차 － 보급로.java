import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    static int N,res;
    static int [][] map;
    static boolean [][] visited;
    static int [][] total;
    static class  Pos {
        int r, c;
        int time;
        public Pos(int r, int c,int time) {
            this.r = r;
            this.c = c;
            this.time=time;
        }
    }
    static PriorityQueue<Pos> pq = new PriorityQueue<>((p1,p2)->Integer.compare(p1.time,p2.time));
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T= Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N=Integer.parseInt(br.readLine());
            res=Integer.MAX_VALUE;
            visited=new boolean[N][N];
            map=new int [N][N];
            total=new int [N][N];
            for (int i = 0; i < N; i++)
                Arrays.fill(total[i],Integer.MAX_VALUE);

            for (int i = 0; i < N; i++) {
                String input=br.readLine();
                for (int j = 0; j < N; j++)
                    map[i][j]=input.charAt(j)-'0';
            }
            findGoal();
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int [] dr = {0, 0, -1, 1};
    static int [] dc = {-1, 1, 0, 0};
    private static void findGoal() {
        pq.clear();
        pq.offer(new Pos(0,0,0));
        visited[0][0]=true;

        while (!pq.isEmpty()){
            Pos p = pq.poll();

            if(p.time>=res) continue;
            if(p.r==N-1&&p.c==N-1){
                res=Math.min(res, p.time);
            }

            for (int i = 0; i < 4; i++) {
                int nr=p.r+dr[i];
                int nc=p.c+dc[i];
                if(check(nr,nc)&&(!visited[nr][nc])&&(p.time+map[nr][nc]<total[nr][nc])){
                    visited[nr][nc]=true;
                    total[nr][nc]=p.time+map[nr][nc];
                    pq.offer(new Pos(nr,nc,total[nr][nc]));
                }
            }
        }
    }
    private static boolean check(int r, int c) {
        return r>=0&&r<N&&c>=0&&c<N;
    }
}