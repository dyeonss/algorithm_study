import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int [][] map;
    static class Pos{
        int r,c;
        int num;
        public Pos(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
    static List<Pos> whole;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N=Integer.parseInt(br.readLine());
            map=new int [N][N];
            whole=new ArrayList<>();
            res=0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                    if(map[i][j]>=6&&map[i][j]<=10){    //웜홀
                        whole.add(new Pos(i,j,map[i][j]));
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]==0){
                        start(i,j);
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int dir,nr,nc;
    private static void start(int r, int c) {
        for (int i = 0; i < 4; i++) {
            play(r,c,i);
        }
    }

    static int [] dr={-1, 1, 0, 0};
    static int [] dc={0, 0, -1, 1};
    private static void play(int sr, int sc, int i) {   //dir 진행방향
        int r=sr;
        int c=sc;
        dir=i;
        int score=0;
        while(true){
            nr=r+dr[dir];
            nc=c+dc[dir];

            if(nr<0||nr>N-1||nc<0||nc>N-1){
                if(dir==0||dir==1)  dir=(dir==0)?1:0;
                if(dir==2||dir==3)  dir=(dir==2)?3:2;
                nr=r;
                nc=c;
                score++;
            }
            if(map[nr][nc]>=1&&map[nr][nc]<=5){
                block(map[nr][nc]);
                score++;
            }
            if(map[nr][nc]>=6&&map[nr][nc]<=10){
                findwhole(nr,nc,map[nr][nc]);
            }
            r=nr;
            c=nc;

            if(map[r][c]==-1||(r==sr&&c==sc)) {
                res=Math.max(res,score);
                break;
            }
        }
    }

    private static void findwhole(int r, int c, int value) {
        for (int i = 0; i < whole.size(); i++) {
            Pos p=whole.get(i);
            if(p.num==value&&(p.r!=r||p.c!=c)){
                nr=p.r;
                nc=p.c;
                return;
            }
        }
    }

    private static void block(int bidx) {
        switch (dir){
            case 0:
                if(bidx==1||bidx==4||bidx==5){
                    if(dir==0||dir==1)  dir=(dir==0)?1:0;
                    if(dir==2||dir==3)  dir=(dir==2)?3:2;
                }
                else if(bidx==2)    dir=3;
                else if(bidx==3)    dir=2;
                break;
            case 1:
                if(bidx==2||bidx==3||bidx==5){
                    if(dir==0||dir==1)  dir=(dir==0)?1:0;
                    if(dir==2||dir==3)  dir=(dir==2)?3:2;
                }
                else if(bidx==1)    dir=3;
                else if(bidx==4)    dir=2;
                break;
            case 2:
                if(bidx==3||bidx==4||bidx==5){
                    if(dir==0||dir==1)  dir=(dir==0)?1:0;
                    if(dir==2||dir==3)  dir=(dir==2)?3:2;
                }
                else if(bidx==1)    dir=0;
                else if(bidx==2)    dir=1;
                break;
            case 3:
                if(bidx==1||bidx==2||bidx==5){
                    if(dir==0||dir==1)  dir=(dir==0)?1:0;
                    if(dir==2||dir==3)  dir=(dir==2)?3:2;
                }
                else if(bidx==3)    dir=1;
                else if(bidx==4)    dir=0;
                break;
        }
    }
}