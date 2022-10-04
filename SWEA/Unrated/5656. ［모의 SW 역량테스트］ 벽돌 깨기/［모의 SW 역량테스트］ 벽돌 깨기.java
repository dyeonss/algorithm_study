import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
    static int N,H,W,min;
    static class Point{
        int r,c, cnt;
        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());
            W=Integer.parseInt(st.nextToken());
            H=Integer.parseInt(st.nextToken());
            int [][] map=new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min= Integer.MAX_VALUE;
            go(map,0);
            System.out.println("#"+tc+" "+min);
        }
    }

    private static boolean go(int[][] map, int cnt) { 
        int result = getRemain(map);
        if(result==0) {
            min=result;
            return true;
        }
        if(cnt==N){
            if(min>result)  min=result;
            return  false;
        }
        int[][] newMap=new int[H][W];
        for (int c = 0; c < W; c++) {
            int r=0;
            while(r<H&&map[r][c]==0)    ++r;

            if(r==H)
                continue;
            else{
                copy(map,newMap);
                boom(newMap,r,c);
                down(newMap);
                if(go(newMap,cnt+1))    return true;
            }
        }
        return false;
    }
    private static int getRemain(int[][] map) {
        int result=0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j]>0) result++;
            }
        }
        return result;
    }
    static List<Integer> list = new ArrayList<>();
    private static void down(int[][] map) {
        for (int c = 0; c < W; c++) {
            list.clear();
            for (int r = H-1; r >= 0 ; r--) {
                if(map[r][c]>0){
                    list.add(map[r][c]);
                    map[r][c]=0;
                }
            }
            int nr = H-1;
            for (int a:list) {
                map[nr--][c]=a;
            }
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    private static void boom(int[][] map, int r, int c) {
        Queue<Point> q = new ArrayDeque<Point>();
        if(map[r][c]>1) {
            q.offer(new Point(r, c, map[r][c]));
        }
        map[r][c]=0;  

        while (!q.isEmpty()){
            Point p = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = p.r;
                int nc = p.c;
                for (int i = 1; i < p.cnt; i++) { 
                    nr+=dr[d];
                    nc+=dc[d];
                    if(nr>=0&&nr<H&&nc>=0&&nc<W&&map[nr][nc]>0){
                        if(map[nr][nc]>1) {
                            q.offer(new Point(nr, nc, map[nr][nc]));
                        } 
                        map[nr][nc]=0;
                    }
                }
            }
        }
    }
    private static void copy(int[][] map, int[][] newMap) {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                newMap[r][c]=map[r][c];
            }
        }
    }
}