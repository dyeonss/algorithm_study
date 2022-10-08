import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int N,res;
    static char [][] map;
    static boolean [][] visited;
    static class Pos{
        int r,c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N=Integer.parseInt(br.readLine());
            map=new char[N][N];
            visited=new boolean[N][N];
            res=0;

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                map[i]=s.toCharArray();
            }
            changeMap();

            //요소가 0인 곳부터 체크하기(제일 빨리 퍼짐)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]=='0'&&!visited[i][j]){
                        Queue<Pos> q = new LinkedList<>();
                        q.add(new Pos(i,j));
                        visited[i][j]=true;

                        while (!q.isEmpty()){
                            Pos p=q.poll();
                            if(!visited[p.r][p.c])  res++;
                            visited[p.r][p.c]=true;
                            for (int k = 0; k < 8; k++) {
                                int nr = p.r+dr[k];
                                int nc = p.c+dc[k];
                                if(check(nr,nc)&&!visited[nr][nc]&&map[nr][nc]=='0'){
                                    visited[nr][nc]=true;
                                    q.offer(new Pos(nr,nc));
                                }
                                else if(check(nr,nc)&&!visited[nr][nc]){
                                    visited[nr][nc]=true;
                                }
                            }
                        }
                        res++;
                    }
                }
            }

            //방문하지 않은 곳 체크
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]&&map[i][j]!='*'){
                        visited[i][j]=true;
                        res++;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.print(sb.toString());
    }
    //숫자로 바꾸기
    static int [] dr={-1,-1,-1,0,0,1,1,1};
    static int [] dc={-1,0,1,-1,1,-1,0,1};
    private static void changeMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]=='.'){
                    int cnt=0;
                    for (int k = 0; k < 8; k++) {
                        int nr = i+dr[k];
                        int nc = j+dc[k];
                        if(check(nr,nc)&&map[nr][nc]=='*'){
                            visited[nr][nc]=true;
                            cnt++;
                        }
                    }
                    map[i][j]=(char)(cnt+'0');
                }
            }
        }
    }

    private static boolean check(int r, int c) {
        return r>=0&&r<N&&c>=0&&c<N;
    }
}
