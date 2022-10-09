import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N,M,R,C,L,res;
    static int [][] map;
    static  Queue<Pos> q;
    static boolean [][] visited;
    static class Pos{
        int r,c,time;
        public Pos(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time= time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            R=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            L=Integer.parseInt(st.nextToken());
            map=new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < M; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            res=0;
            bfs();
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    private static void bfs() {
        q = new LinkedList<>();
        visited=new boolean[N][M];
        q.offer(new Pos(R,C,1));
        visited[R][C]=true;
        while(!q.isEmpty()){
            Pos p = q.poll();
            if(p.time>L){
                break;
            }
            res++;

            int ternal=map[p.r][p.c];

            switch (ternal){
                case 1:
                    for (int i = 0; i < 4; i++) {
                        put(p.r,p.c,p.time,i);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        put(p.r,p.c,p.time,i);
                    }
                    break;
                case 3:
                    for (int i = 2; i < 4; i++) {
                        put(p.r,p.c,p.time,i);
                    }
                    break;
                case 4:
                    for (int i = 0; i < 4; i=i+3) {
                        put(p.r,p.c,p.time,i);;
                    }
                    break;
                case 5:
                    for (int i = 1; i < 4; i=i+2) {
                        put(p.r,p.c,p.time,i);
                    }
                    break;
                case 6:
                    for (int i = 1; i < 3; i++) {
                        put(p.r,p.c,p.time,i);
                    }
                    break;
                case 7:
                    for (int i = 0; i < 3; i=i+2) {
                        put(p.r,p.c,p.time,i);
                    }
                    break;
            }
        }
    }

    private static void put(int r,int c, int time, int i) {
        int nr = r+dr[i];
        int nc = c+dc[i];
        if(check(nr,nc)&&!visited[nr][nc]&&map[nr][nc]!=0&&connect(map[nr][nc],i)){
            visited[nr][nc]=true;
            q.offer(new Pos(nr,nc,time+1));
        }
    }

    private static boolean connect(int back, int dir) {
        switch (dir){
            case 0:
                return back==1||back==2||back==5||back==6;
            case 1:
                return back==1||back==2||back==4||back==7;
            case 2:
                return back==1||back==3||back==4||back==5;
            case 3:
                return back==1||back==3||back==6||back==7;
        }
        return false;
    }

    private static boolean check(int r, int c) {
        return r>=0&&r<N&&c>=0&&c<M;
    }
}