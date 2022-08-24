import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos{
		int r;
		int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int R,C;
	static char [][] map;
	static Pos D, S; 
	static Queue<Pos> water;
	static boolean possible;
	static boolean [][] w_visited;
	static boolean [][] h_visited;	
	static int time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		w_visited = new boolean [R][C];
		h_visited = new boolean [R][C];
		water=new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			char [] ch = s.toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j]=ch[j];
				if(map[i][j]=='D') {
					D=new Pos(i,j);
				}
				if(map[i][j]=='S') {
					S=new Pos(i,j);
					h_visited[i][j]=true;
				}
				if(map[i][j]=='*') {
					water.offer(new Pos(i,j));
					w_visited[i][j]=true;
				}
			}
		}	
		bfs();
		System.out.println(possible?time:"KAKTUS");
	}
	
	static int [] dr= {-1,0,1,0};
	static int [] dc= {0,1,0,-1};
	private static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(S);
		while (true) {
			// 물 이동
			Queue<Pos> next = new LinkedList<>();
			while (!water.isEmpty()) {
				Pos wcur = water.poll();
				for (int i = 0; i < 4; i++) {
					int nr = wcur.r + dr[i];
					int nc = wcur.c + dc[i];

					if (check(nr, nc) && !w_visited[nr][nc]&&(map[nr][nc] != 'X' && map[nr][nc] != 'D')) {
						next.offer(new Pos(nr, nc));
						w_visited[nr][nc]=true;
					}
				}
			}
			water.addAll(next);
			next.clear();
			
			while (!q.isEmpty()) {
				Pos scur = q.poll();
				if (scur.r == D.r && scur.c == D.c) {
					possible = true;
					return;
				}
				if (map[scur.r][scur.c] == '*')
					continue;
				for (int i = 0; i < 4; i++) {
					int nr = scur.r + dr[i];
					int nc = scur.c + dc[i];

					if (check(nr, nc) &&!h_visited[nr][nc]&& (map[nr][nc] == '.' || map[nr][nc] == 'D')) {
						h_visited[nr][nc]=true;
						next.offer(new Pos(nr, nc));
					}
				}
			}
			q.addAll(next);
			time++;
			
			for (int i = 0; i < water.size(); i++) {
				Pos p = water.poll();
				map[p.r][p.c]='*';
				water.offer(p);
			}
			
			if(water.size()==0&&q.size()==0) return;
			
		}
	}
	private static boolean check(int r, int c) {
		return r>=0&&r<R&&c>=0&&c<C;
	}
}
